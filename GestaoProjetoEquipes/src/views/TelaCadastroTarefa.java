package views;

import models.Tarefa;
import models.Projeto;
import models.Usuario;
import services.TarefaService;
import services.ProjetoService;
import services.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class TelaCadastroTarefa extends JFrame {

    private JTextField txtTitulo, txtDescricao, txtDataInicio, txtDataFim;
    private JComboBox<String> cbStatus;
    private JComboBox<Projeto> cbProjeto;
    private JComboBox<Usuario> cbResponsavel;

    public TelaCadastroTarefa(TarefaService tarefaService,
                              ProjetoService projetoService,
                              UsuarioService usuarioService) {

        setTitle("Cadastro de Tarefa");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int y = 0;

        // Título
        gbc.gridx = 0; gbc.gridy = y;
        add(new JLabel("Título:"), gbc);

        gbc.gridx = 1;
        txtTitulo = new JTextField();
        add(txtTitulo, gbc);

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
                "Pendente", "Em execução", "Concluída"
        });
        add(cbStatus, gbc);

        // Projeto
        y++;
        gbc.gridx = 0; gbc.gridy = y;
        add(new JLabel("Projeto:"), gbc);

        gbc.gridx = 1;
        cbProjeto = new JComboBox<>();
        for (Projeto p : projetoService.listar()) {
            cbProjeto.addItem(p);
        }
        add(cbProjeto, gbc);

        // Responsável
        y++;
        gbc.gridx = 0; gbc.gridy = y;
        add(new JLabel("Responsável:"), gbc);

        gbc.gridx = 1;
        cbResponsavel = new JComboBox<>();
        for (Usuario u : usuarioService.listar()) {
            cbResponsavel.addItem(u);
        }
        add(cbResponsavel, gbc);

        // Data início
        y++;
        gbc.gridx = 0; gbc.gridy = y;
        add(new JLabel("Data Início:"), gbc);

        gbc.gridx = 1;
        txtDataInicio = new JTextField("dd/MM/yyyy");
        add(txtDataInicio, gbc);

        // Data fim
        y++;
        gbc.gridx = 0; gbc.gridy = y;
        add(new JLabel("Data Fim:"), gbc);

        gbc.gridx = 1;
        txtDataFim = new JTextField("dd/MM/yyyy");
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

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro nas datas!");
            }
        });
    }
}