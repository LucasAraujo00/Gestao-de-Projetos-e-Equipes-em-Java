package views;

import models.Projeto;
import models.Usuario;
import services.ProjetoService;
import services.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class TelaCadastroProjeto extends JFrame {

    private JTextField txtNome, txtDescricao, txtDataInicio, txtDataFim;
    private JComboBox<String> cbStatus;
    private JComboBox<Usuario> cbGerente;

    public TelaCadastroProjeto(ProjetoService projetoService, UsuarioService usuarioService) {

        setTitle("Cadastro de Projeto");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int y = 0;

        // Nome
        gbc.gridx = 0; gbc.gridy = y;
        add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        txtNome = new JTextField();
        add(txtNome, gbc);

        // Descrição
        y++;
        gbc.gridx = 0; gbc.gridy = y;
        add(new JLabel("Descrição:"), gbc);

        gbc.gridx = 1;
        txtDescricao = new JTextField();
        add(txtDescricao, gbc);

        // Status
        y++;
        gbc.gridx = 0; gbc.gridy = y;
        add(new JLabel("Status:"), gbc);

        gbc.gridx = 1;
        cbStatus = new JComboBox<>(new String[]{
                "Planejado", "Em andamento", "Concluído", "Cancelado"
        });
        add(cbStatus, gbc);

        // Gerente
        y++;
        gbc.gridx = 0; gbc.gridy = y;
        add(new JLabel("Gerente:"), gbc);

        gbc.gridx = 1;
        cbGerente = new JComboBox<>();
        for (Usuario u : usuarioService.listar()) {
            cbGerente.addItem(u);
        }
        add(cbGerente, gbc);

        // Data início
        y++;
        gbc.gridx = 0; gbc.gridy = y;
        add(new JLabel("Data Início:"), gbc);

        gbc.gridx = 1;
        txtDataInicio = new JTextField("xx/xx/xxxx");
        add(txtDataInicio, gbc);

        // Data fim
        y++;
        gbc.gridx = 0; gbc.gridy = y;
        add(new JLabel("Data Fim:"), gbc);

        gbc.gridx = 1;
        txtDataFim = new JTextField("xx/xx/xxxx");
        add(txtDataFim, gbc);

        // Botão
        y++;
        gbc.gridx = 0; gbc.gridy = y;
        gbc.gridwidth = 2;

        JButton btnSalvar = new JButton("Salvar");
        add(btnSalvar, gbc);

        btnSalvar.addActionListener(e -> {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                Projeto p = new Projeto();
                p.setNome(txtNome.getText());
                p.setDescricao(txtDescricao.getText());
                p.setStatus(cbStatus.getSelectedItem().toString());
                p.setGerente((Usuario) cbGerente.getSelectedItem());
                p.setDataInicio(sdf.parse(txtDataInicio.getText()));
                p.setDataFimPrevista(sdf.parse(txtDataFim.getText()));

                projetoService.cadastrar(p);

                JOptionPane.showMessageDialog(this, "Projeto cadastrado!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro nas datas!");
            }
        });
    }
}