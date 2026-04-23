package views;

import models.Equipe;
import services.EquipeService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaListaEquipes extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaListaEquipes(EquipeService service) {

        setTitle("Equipes");
        setSize(500, 300);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Descrição");
        modelo.addColumn("Qtd Membros");

        tabela = new JTable(modelo);
        add(new JScrollPane(tabela));

        for (Equipe e : service.listar()) {
            modelo.addRow(new Object[]{
                    e.getNome(),
                    e.getDescricao(),
                    e.getMembros().size()
            });
        }
    }
}