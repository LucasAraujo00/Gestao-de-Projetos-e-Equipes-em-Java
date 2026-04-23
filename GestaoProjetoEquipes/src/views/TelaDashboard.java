package views;

import services.UsuarioService;
import services.ProjetoService;
import services.TarefaService;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class TelaDashboard extends JFrame {

    public TelaDashboard(UsuarioService usuarioService,
                         ProjetoService projetoService,
                         TarefaService tarefaService) {

        setTitle("Dashboard");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        int totalUsuarios = usuarioService.listar().size();
        int totalProjetos = projetoService.listar().size();
        int totalTarefas = tarefaService.listar().size();

        int emAndamento = 0;
        int concluidos = 0;
        int atrasados = 0;

        Date hoje = new Date();

        for (var p : projetoService.listar()) {

            if (p.getStatus().equalsIgnoreCase("em andamento")) {
                emAndamento++;
            }

            if (p.getStatus().equalsIgnoreCase("concluido")) {
                concluidos++;
            }

            if (p.getDataFimPrevista() != null &&
                p.getDataFimPrevista().before(hoje) &&
                !p.getStatus().equalsIgnoreCase("concluido")) {

                atrasados++;
            }
        }

        // ===== LABELS =====

        JLabel lblUsuarios = new JLabel("Usuários: " + totalUsuarios);
        lblUsuarios.setBounds(30, 30, 300, 25);
        lblUsuarios.setFont(new Font("Arial", Font.BOLD, 16));
        lblUsuarios.setForeground(Color.BLUE);
        add(lblUsuarios);

        JLabel lblProjetos = new JLabel("Projetos: " + totalProjetos);
        lblProjetos.setBounds(30, 70, 300, 25);
        lblProjetos.setFont(new Font("Arial", Font.BOLD, 16));
        lblProjetos.setForeground(Color.BLACK);
        add(lblProjetos);

        JLabel lblTarefas = new JLabel("Tarefas: " + totalTarefas);
        lblTarefas.setBounds(30, 110, 300, 25);
        lblTarefas.setFont(new Font("Arial", Font.BOLD, 16));
        lblTarefas.setForeground(Color.DARK_GRAY);
        add(lblTarefas);

        JLabel lblAndamento = new JLabel("Em andamento: " + emAndamento);
        lblAndamento.setBounds(30, 150, 300, 25);
        lblAndamento.setFont(new Font("Arial", Font.BOLD, 16));
        lblAndamento.setForeground(Color.ORANGE);
        add(lblAndamento);

        JLabel lblConcluidos = new JLabel("Concluídos: " + concluidos);
        lblConcluidos.setBounds(30, 190, 300, 25);
        lblConcluidos.setFont(new Font("Arial", Font.BOLD, 16));
        lblConcluidos.setForeground(new Color(0, 128, 0));
        add(lblConcluidos);

        JLabel lblAtrasados = new JLabel("Atrasados: " + atrasados);
        lblAtrasados.setBounds(30, 230, 300, 25);
        lblAtrasados.setFont(new Font("Arial", Font.BOLD, 16));
        lblAtrasados.setForeground(Color.RED);
        add(lblAtrasados);
    }
}