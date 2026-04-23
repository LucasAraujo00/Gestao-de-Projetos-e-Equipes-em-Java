package views;

import javax.swing.*;
import models.Usuario;
import services.ProjetoService;
import services.TarefaService;
import services.UsuarioService;

public class TelaPrincipal extends JFrame {

    private UsuarioService service;
    private ProjetoService projetoService;
    private TarefaService tarefaService;

    public TelaPrincipal(Usuario usuario,
                         UsuarioService service,
                         ProjetoService projetoService,
                         TarefaService tarefaService) {

        this.service = service;
        this.projetoService = projetoService;
        this.tarefaService = tarefaService;

        setTitle("Sistema de Projetos");
        setSize(400, 420);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblBemVindo = new JLabel("Bem-vindo, " + usuario.getNome());
        lblBemVindo.setBounds(20, 20, 300, 25);
        add(lblBemVindo);

        // ===== USUÁRIOS =====
        JButton btnCadastrar = new JButton("Cadastrar Usuário");
        btnCadastrar.setBounds(100, 60, 200, 30);
        add(btnCadastrar);

        JButton btnListar = new JButton("Listar Usuários");
        btnListar.setBounds(100, 100, 200, 30);
        add(btnListar);

        // ===== PROJETOS =====
        JButton btnProjeto = new JButton("Cadastrar Projeto");
        btnProjeto.setBounds(100, 140, 200, 30);
        add(btnProjeto);

        JButton btnListarProjeto = new JButton("Listar Projetos");
        btnListarProjeto.setBounds(100, 180, 200, 30);
        add(btnListarProjeto);

        // ===== TAREFAS =====
        JButton btnTarefa = new JButton("Cadastrar Tarefa");
        btnTarefa.setBounds(100, 220, 200, 30);
        add(btnTarefa);

        JButton btnListarTarefa = new JButton("Listar Tarefas");
        btnListarTarefa.setBounds(100, 260, 200, 30);
        add(btnListarTarefa);

        // ===== SAIR =====
        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(100, 310, 200, 30);
        add(btnSair);

        // ===== AÇÕES =====

        // Usuários
        btnCadastrar.addActionListener(e -> {
            new TelaCadastroUsuario(service).setVisible(true);
        });

        btnListar.addActionListener(e -> {
            new TelaListaUsuarios(service).setVisible(true);
        });

        // Projetos
        btnProjeto.addActionListener(e -> {
            new TelaCadastroProjeto(projetoService, service).setVisible(true);
        });

        btnListarProjeto.addActionListener(e -> {
            new TelaListaProjetos(projetoService).setVisible(true);
        });

        // Tarefas
        btnTarefa.addActionListener(e -> {
            new TelaCadastroTarefa(tarefaService, projetoService, service).setVisible(true);
        });

        btnListarTarefa.addActionListener(e -> {
            new TelaListaTarefas(tarefaService).setVisible(true);
        });

        // Sair
        btnSair.addActionListener(e -> System.exit(0));
    }
}