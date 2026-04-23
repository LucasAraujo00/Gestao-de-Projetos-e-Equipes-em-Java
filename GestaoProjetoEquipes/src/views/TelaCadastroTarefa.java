package views;

import models.Tarefa;
import models.Projeto;
import models.Usuario;
import services.TarefaService;
import services.ProjetoService;
import services.UsuarioService;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class TelaCadastroTarefa extends JFrame {

    private JTextField txtTitulo;
    private JTextField txtDescricao;
    private JTextField txtDataInicio;
    private JTextField txtDataFim;

    private JComboBox<String> cbStatus;
    private JComboBox<Projeto> cbProjeto;
    private JComboBox<Usuario> cbResponsavel;

    private TarefaService tarefaService;
    private ProjetoService projetoService;
    private UsuarioService usuarioService;

    public TelaCadastroTarefa(TarefaService tarefaService,
                              ProjetoService projetoService,
                              UsuarioService usuarioService) {

        this.tarefaService = tarefaService;
        this.projetoService = projetoService;
        this.usuarioService = usuarioService;

        setTitle("Cadastro de Tarefa");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(20, 20, 100, 25);
        add(lblTitulo);

        txtTitulo = new JTextField();
        txtTitulo.setBounds(150, 20, 200, 25);
        add(txtTitulo);

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
        cbStatus.addItem("Pendente");
        cbStatus.addItem("Em execução");
        cbStatus.addItem("Concluída");
        add(cbStatus);

        JLabel lblProjeto = new JLabel("Projeto:");
        lblProjeto.setBounds(20, 140, 100, 25);
        add(lblProjeto);

        cbProjeto = new JComboBox<>();
        cbProjeto.setBounds(150, 140, 200, 25);
        add(cbProjeto);

        for (Projeto p : projetoService.listar()) {
            cbProjeto.addItem(p);
        }

        JLabel lblResponsavel = new JLabel("Responsável:");
        lblResponsavel.setBounds(20, 180, 100, 25);
        add(lblResponsavel);

        cbResponsavel = new JComboBox<>();
        cbResponsavel.setBounds(150, 180, 200, 25);
        add(cbResponsavel);

        for (Usuario u : usuarioService.listar()) {
            cbResponsavel.addItem(u);
        }

        JLabel lblInicio = new JLabel("Data Início:");
        lblInicio.setBounds(20, 220, 100, 25);
        add(lblInicio);

        txtDataInicio = new JTextField("xx/xx/xxxx");
        txtDataInicio.setBounds(150, 220, 200, 25);
        add(txtDataInicio);

        JLabel lblFim = new JLabel("Data Fim:");
        lblFim.setBounds(20, 260, 100, 25);
        add(lblFim);

        txtDataFim = new JTextField("xx/xx/xxxx");
        txtDataFim.setBounds(150, 260, 200, 25);
        add(txtDataFim);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(150, 300, 100, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(e -> salvar());
    }

    private void salvar() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            Tarefa t = new Tarefa();
            t.setTitulo(txtTitulo.getText());
            t.setDescricao(txtDescricao.getText());
            t.setStatus(cbStatus.getSelectedItem().toString());
            t.setProjeto((Projeto) cbProjeto.getSelectedItem());
            t.setResponsavel((Usuario) cbResponsavel.getSelectedItem());
            t.setDataInicioPrevista(sdf.parse(txtDataInicio.getText()));
            t.setDataFimPrevista(sdf.parse(txtDataFim.getText()));

            tarefaService.cadastrar(t);

            JOptionPane.showMessageDialog(this, "Tarefa cadastrada!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro nas datas!");
        }
    }
}