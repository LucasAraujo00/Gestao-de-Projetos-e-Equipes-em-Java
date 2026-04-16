package views;

import models.Usuario;
import services.UsuarioService;

import javax.swing.*;

public class TelaLogin extends JFrame {

    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private UsuarioService service;

    public TelaLogin(UsuarioService service) {

        this.service = service;

        setTitle("Login");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblLogin = new JLabel("Login:");
        lblLogin.setBounds(20, 20, 80, 25);
        add(lblLogin);

        txtLogin = new JTextField();
        txtLogin.setBounds(100, 20, 150, 25);
        add(txtLogin);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(20, 60, 80, 25);
        add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 60, 150, 25);
        add(txtSenha);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(100, 100, 100, 30);
        add(btnEntrar);

        btnEntrar.addActionListener(e -> login());
    }

    private void login() {

        String login = txtLogin.getText();
        String senha = new String(txtSenha.getPassword());

        Usuario usuario = service.login(login, senha);

        if (usuario != null) {

            new TelaPrincipal(usuario, service).setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this,
                    "Login inválido!");
        }
    }
}