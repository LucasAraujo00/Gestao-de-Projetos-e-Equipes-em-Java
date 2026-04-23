package views;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import models.Usuario;
import services.UsuarioService;

public class TelaListaUsuarios extends JFrame {

    private UsuarioService service;
    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaListaUsuarios(UsuarioService service) {

        this.service = service;

        setTitle("Lista de Usuários");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Login");

        tabela = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20, 20, 440, 150);
        add(scroll);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(50, 200, 120, 30);
        add(btnExcluir);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(250, 200, 120, 30);
        add(btnEditar);

        carregarUsuarios();

        btnExcluir.addActionListener(e -> excluir());
        btnEditar.addActionListener(e -> editar());
    }

    private void carregarUsuarios() {

        modelo.setRowCount(0);

        List<Usuario> usuarios = service.listar();

        for (Usuario u : usuarios) {
            modelo.addRow(new Object[]{
                    u.getNome(),
                    u.getLogin()
            });
        }
    }

    private void excluir() {

        int linha = tabela.getSelectedRow();

        if (linha >= 0) {
            service.remover(linha);
            carregarUsuarios();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Selecione um usuário!");
        }
    }

    private void editar() {

        int linha = tabela.getSelectedRow();

        if (linha >= 0) {

            Usuario u = service.listar().get(linha);

            String novoNome = JOptionPane.showInputDialog("Nome:", u.getNome());
            String novoLogin = JOptionPane.showInputDialog("Login:", u.getLogin());
            String novaSenha = JOptionPane.showInputDialog("Senha:", u.getSenha());

            Usuario novo = new Usuario();
            novo.setNome(novoNome);
            novo.setLogin(novoLogin);
            novo.setSenha(novaSenha);

            service.atualizar(linha, novo);

            carregarUsuarios();

        } else {
            JOptionPane.showMessageDialog(this,
                    "Selecione um usuário!");
        }
    }
}