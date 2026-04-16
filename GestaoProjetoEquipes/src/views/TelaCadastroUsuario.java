package views;

import models.Usuario;
import services.UsuarioService;

import javax.swing.*;

public class TelaCadastroUsuario extends JFrame {

    private JTextField txtNome;
    private JTextField txtLogin;
    private JTextField txtSenha;

    private UsuarioService service;

    public TelaCadastroUsuario(UsuarioService service) {

        this.service = service;

        setTitle("Cadastro de Usuário");
        setSize(300, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 80, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(100, 20, 150, 25);
        add(txtNome);

        JLabel lblLogin = new JLabel("Login:");
        lblLogin.setBounds(20, 60, 80, 25);
        add(lblLogin);

        txtLogin = new JTextField();
        txtLogin.setBounds(100, 60, 150, 25);
        add(txtLogin);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(20, 100, 80, 25);
        add(lblSenha);

        txtSenha = new JTextField();
        txtSenha.setBounds(100, 100, 150, 25);
        add(txtSenha);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 150, 100, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(e -> salvar());
    }

    private void salvar() {

        Usuario usuario = new Usuario();
        usuario.setNome(txtNome.getText());
        usuario.setLogin(txtLogin.getText());
        usuario.setSenha(txtSenha.getText());

        service.cadastrar(usuario);

        JOptionPane.showMessageDialog(this,
                "Usuário cadastrado com sucesso!");

        txtNome.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
    }
}