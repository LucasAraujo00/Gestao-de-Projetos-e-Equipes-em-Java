package views;

import models.Equipe;
import models.Usuario;
import services.EquipeService;
import services.UsuarioService;

import javax.swing.*;

public class TelaCadastroEquipe extends JFrame {

    private JTextField txtNome;
    private JTextField txtDescricao;
    private JComboBox<Usuario> cbUsuarios;

    private EquipeService equipeService;
    private UsuarioService usuarioService;

    public TelaCadastroEquipe(EquipeService equipeService, UsuarioService usuarioService) {

        this.equipeService = equipeService;
        this.usuarioService = usuarioService;

        setTitle("Cadastro de Equipe");
        setSize(350, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 100, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(120, 20, 180, 25);
        add(txtNome);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(20, 60, 100, 25);
        add(lblDescricao);

        txtDescricao = new JTextField();
        txtDescricao.setBounds(120, 60, 180, 25);
        add(txtDescricao);

        JLabel lblUsuario = new JLabel("Membro:");
        lblUsuario.setBounds(20, 100, 100, 25);
        add(lblUsuario);

        cbUsuarios = new JComboBox<>();
        cbUsuarios.setBounds(120, 100, 180, 25);
        add(cbUsuarios);

        for (Usuario u : usuarioService.listar()) {
            cbUsuarios.addItem(u);
        }

        JButton btnAdicionar = new JButton("Adicionar Membro");
        btnAdicionar.setBounds(80, 140, 180, 25);
        add(btnAdicionar);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(120, 170, 100, 30);
        add(btnSalvar);

        Equipe equipe = new Equipe();

        btnAdicionar.addActionListener(e -> {
            Usuario u = (Usuario) cbUsuarios.getSelectedItem();
            equipe.adicionarMembro(u);
            JOptionPane.showMessageDialog(this, "Membro adicionado!");
        });

        btnSalvar.addActionListener(e -> {
            equipe.setNome(txtNome.getText());
            equipe.setDescricao(txtDescricao.getText());

            equipeService.cadastrar(equipe);

            JOptionPane.showMessageDialog(this, "Equipe cadastrada!");
        });
    }
}