package views;

import services.UsuarioService;
import services.ProjetoService;
import services.TarefaService;

import javax.swing.*;
import java.awt.*;

public class TelaDashboard extends JFrame {

    private int emAndamento = 0;
    private int concluidos = 0;
    private int cancelados = 0;

    public TelaDashboard(UsuarioService usuarioService,
                         ProjetoService projetoService,
                         TarefaService tarefaService) {

        setTitle("Dashboard");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ===== CONTAGEM =====
        for (var p : projetoService.listar()) {

            if (p.getStatus().equalsIgnoreCase("Em andamento")) {
                emAndamento++;
            } else if (p.getStatus().equalsIgnoreCase("Concluído")) {
                concluidos++;
            } else if (p.getStatus().equalsIgnoreCase("Cancelado")) {
                cancelados++;
            }
        }

        // ===== TOPO (INFORMAÇÕES) =====
        JPanel painelInfo = new JPanel(new GridLayout(3,1));

        JLabel lbl1 = new JLabel("Projetos em andamento: " + emAndamento);
        JLabel lbl2 = new JLabel("Projetos concluídos: " + concluidos);
        JLabel lbl3 = new JLabel("Projetos cancelados: " + cancelados);

        lbl1.setFont(new Font("Arial", Font.BOLD, 14));
        lbl2.setFont(new Font("Arial", Font.BOLD, 14));
        lbl3.setFont(new Font("Arial", Font.BOLD, 14));

        painelInfo.add(lbl1);
        painelInfo.add(lbl2);
        painelInfo.add(lbl3);

        add(painelInfo, BorderLayout.NORTH);

        // ===== GRÁFICO =====
        add(new PainelGrafico(), BorderLayout.CENTER);
    }

    // ===== CLASSE DO GRÁFICO =====
    class PainelGrafico extends JPanel {

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int total = emAndamento + concluidos + cancelados;
            if (total == 0) return;

            int largura = 200;
            int altura = 200;

            int x = (getWidth() - largura) / 2;
            int y = 40;

            int anguloInicio = 0;

            // Em andamento (laranja)
            int angulo1 = (int) Math.round(360.0 * emAndamento / total);
            g.setColor(Color.ORANGE);
            g.fillArc(x, y, largura, altura, anguloInicio, angulo1);
            anguloInicio += angulo1;

            // Concluído (verde)
            int angulo2 = (int) Math.round(360.0 * concluidos / total);
            g.setColor(new Color(0, 150, 0));
            g.fillArc(x, y, largura, altura, anguloInicio, angulo2);
            anguloInicio += angulo2;

            // Cancelado (vermelho)
            int angulo3 = 360 - anguloInicio;
            g.setColor(Color.RED);
            g.fillArc(x, y, largura, altura, anguloInicio, angulo3);

            // ===== LEGENDA =====
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 13));

            int legendaX = x;
            int legendaY = y + altura + 30;

            g.drawString("! Em andamento: " + emAndamento, legendaX, legendaY);
            g.drawString("✓ Concluído: " + concluidos, legendaX, legendaY + 20);
            g.drawString("X Cancelado: " + cancelados, legendaX, legendaY + 40);
        }
    }
}