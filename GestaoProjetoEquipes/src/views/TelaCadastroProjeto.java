package views;

import models.Projeto;
import models.Usuario;
import services.ProjetoService;
import services.UsuarioService;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class TelaCadastroProjeto extends JFrame {

    private JTextField txtNome;
    private JTextField txtDescricao;
    private JTextField txtDataInicio;
    private JTextField txtDataFim;
    private JTextField txtStatus;
    private JComboBox<Usuario> cbGerente;

    private ProjetoService projetoService;
    private UsuarioService usuarioService;

    public TelaCadastroProjeto(ProjetoService projetoService, UsuarioService usuarioService) {

        this.projetoService = projetoService;
        this.usuarioService = usuarioService;

        setTitle("Cadastro de Projeto");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 100, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(150, 20, 200, 25);
        add(txtNome);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(20, 60, 100, 25);
        add(lblDescricao);

        txtDescricao = new JTextField();
        txtDescricao.setBounds(150, 60, 200, 25);
        add(txtDescricao);

        JLabel lblDataInicio = new JLabel("Data Início:");
        lblDataInicio.setBounds(20, 100, 100, 25);
        add(lblDataInicio);

        txtDataInicio = new JTextField("dd/MM/yyyy");
        txtDataInicio.setBounds(150, 100, 200, 25);
        add(txtDataInicio);

        JLabel lblDataFim = new JLabel("Data Fim:");
        lblDataFim.setBounds(20, 140, 100, 25);
        add(lblDataFim);

        txtDataFim = new JTextField("dd/MM/yyyy");
        txtDataFim.setBounds(150, 140, 200, 25);
        add(txtDataFim);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(20, 180, 100, 25);
        add(lblStatus);

        txtStatus = new JTextField();
        txtStatus.setBounds(150, 180, 200, 25);
        add(txtStatus);

        JLabel lblGerente = new JLabel("Gerente:");
        lblGerente.setBounds(20, 220, 100, 25);
        add(lblGerente);

        cbGerente = new JComboBox<>();
        cbGerente.setBounds(150, 220, 200, 25);
        add(cbGerente);

        for (Usuario u : usuarioService.listar()) {
            cbGerente.addItem(u);
        }

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(150, 260, 100, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(e -> salvar());
    }

    private void salvar() {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            Projeto p = new Projeto();
            p.setNome(txtNome.getText());
            p.setDescricao(txtDescricao.getText());
            p.setDataInicio(sdf.parse(txtDataInicio.getText()));
            p.setDataFimPrevista(sdf.parse(txtDataFim.getText()));
            p.setStatus(txtStatus.getText());
            p.setGerente((Usuario) cbGerente.getSelectedItem());

            projetoService.cadastrar(p);

            JOptionPane.showMessageDialog(this, "Projeto cadastrado!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro na data!");
        }
    }
}