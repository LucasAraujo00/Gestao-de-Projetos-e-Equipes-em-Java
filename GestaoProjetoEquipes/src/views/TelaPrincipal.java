package views;

import models.Usuario;
import services.UsuarioService;

import javax.swing.*;

public class TelaPrincipal extends JFrame {

    private UsuarioService service;

    public TelaPrincipal(Usuario usuario, UsuarioService service) {

        this.service = service;

        setTitle("Sistema de Projetos");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblBemVindo = new JLabel("Bem-vindo, " + usuario.getNome());
        lblBemVindo.setBounds(20, 20, 300, 25);
        add(lblBemVindo);

        // BOTÃO CADASTRAR USUÁRIO
        JButton btnCadastrar = new JButton("Cadastrar Usuário");
        btnCadastrar.setBounds(100, 80, 200, 30);
        add(btnCadastrar);

        // BOTÃO LISTAR USUÁRIOS
        JButton btnListar = new JButton("Listar Usuários");
        btnListar.setBounds(100, 120, 200, 30);
        add(btnListar);

        // BOTÃO SAIR
        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(100, 170, 200, 30);
        add(btnSair);

        // AÇÕES
        btnCadastrar.addActionListener(e -> {
            new TelaCadastroUsuario(service).setVisible(true);
        });

        btnListar.addActionListener(e -> {
            new TelaListaUsuarios(service).setVisible(true);
        });

        btnSair.addActionListener(e -> System.exit(0));
    }
}