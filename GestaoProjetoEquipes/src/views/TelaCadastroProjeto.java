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

    private JComboBox<String> cbStatus;
    private JComboBox<Usuario> cbGerente;

    private ProjetoService projetoService;
    private UsuarioService usuarioService;

    public TelaCadastroProjeto(ProjetoService projetoService, UsuarioService usuarioService) {

        this.projetoService = projetoService;
        this.usuarioService = usuarioService;

        setTitle("Cadastro de Projeto");
        setSize(400, 300);
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

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(20, 100, 100, 25);
        add(lblStatus);

        cbStatus = new JComboBox<>();
        cbStatus.setBounds(150, 100, 200, 25);
        cbStatus.addItem("Planejado");
        cbStatus.addItem("Em andamento");
        cbStatus.addItem("Concluído");
        cbStatus.addItem("Cancelado");
        add(cbStatus);

        JLabel lblGerente = new JLabel("Gerente:");
        lblGerente.setBounds(20, 140, 100, 25);
        add(lblGerente);

        cbGerente = new JComboBox<>();
        cbGerente.setBounds(150, 140, 200, 25);
        add(cbGerente);

        for (Usuario u : usuarioService.listar()) {
            cbGerente.addItem(u);
        }

        JLabel lblInicio = new JLabel("Data Início:");
        lblInicio.setBounds(20, 180, 100, 25);
        add(lblInicio);

        txtDataInicio = new JTextField("xx/xx/xxxx");
        txtDataInicio.setBounds(150, 180, 200, 25);
        add(txtDataInicio);

        JLabel lblFim = new JLabel("Data Fim:");
        lblFim.setBounds(20, 210, 100, 25);
        add(lblFim);

        txtDataFim = new JTextField("xx/xx/xxxx");
        txtDataFim.setBounds(150, 210, 200, 25);
        add(txtDataFim);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(150, 240, 100, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(e -> salvar());
    }

    private void salvar() {
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

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro nas datas!");
        }
    }
}