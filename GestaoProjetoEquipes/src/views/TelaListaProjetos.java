package views;

import models.Projeto;
import services.ProjetoService;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

public class TelaListaProjetos extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaListaProjetos(ProjetoService service) {

        setTitle("Lista de Projetos");
        setSize(700, 400);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Gerente");
        modelo.addColumn("Status");
        modelo.addColumn("Início");
        modelo.addColumn("Fim");

        tabela = new JTable(modelo);
        add(new JScrollPane(tabela));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // ===== PREENCHER TABELA =====
        for (Projeto p : service.listar()) {

            String inicio = "";
            String fim = "";

            try {
                if (p.getDataInicio() != null)
                    inicio = sdf.format(p.getDataInicio());

                if (p.getDataFimPrevista() != null)
                    fim = sdf.format(p.getDataFimPrevista());

            } catch (Exception e) {
                inicio = "-";
                fim = "-";
            }

            modelo.addRow(new Object[]{
                    p.getNome(),
                    p.getGerente() != null ? p.getGerente().getNome() : "",
                    p.getStatus(),
                    inicio,
                    fim
            });
        }

        // ===== RENDERER COM ÍCONES + CORES =====
        tabela.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {

            @Override
            public java.awt.Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {

                JLabel c = (JLabel) super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                String status = value != null ? value.toString() : "";

                // reset padrão
                c.setForeground(java.awt.Color.BLACK);
                c.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));

                if (status.equalsIgnoreCase("Concluído")) {
                    c.setText("✓ Concluído");
                    c.setForeground(new java.awt.Color(0, 128, 0));

                } else if (status.equalsIgnoreCase("Em andamento")) {
                    c.setText("! Em andamento");
                    c.setForeground(java.awt.Color.ORANGE);

                } else if (status.equalsIgnoreCase("Cancelado")) {
                    c.setText("X Cancelado");
                    c.setForeground(java.awt.Color.RED);

                } else {
                    c.setText(status);
                }

                return c;
            }
        });
    }
}