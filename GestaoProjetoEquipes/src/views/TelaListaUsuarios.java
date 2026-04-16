package views;

import models.Usuario;
import services.UsuarioService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TelaListaUsuarios extends JFrame {

    private UsuarioService service;
    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaListaUsuarios(UsuarioService service) {

        this.service = service;

        setTitle("Lista de Usuários");
        setSize(400, 300);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Login");

        tabela = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll);

        carregarUsuarios();
    }

    private void carregarUsuarios() {

        modelo.setRowCount(0); // limpa tabela

        List<Usuario> usuarios = service.listar();

        for (Usuario u : usuarios) {
            modelo.addRow(new Object[]{
                    u.getNome(),
                    u.getLogin()
            });
        }
    }
}