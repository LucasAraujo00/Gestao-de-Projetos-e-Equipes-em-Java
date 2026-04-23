package views;

import models.Projeto;
import services.ProjetoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaListaProjetos extends JFrame {

    private ProjetoService service;
    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaListaProjetos(ProjetoService service) {

        this.service = service;

        setTitle("Projetos");
        setSize(500, 300);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Status");
        modelo.addColumn("Gerente");

        tabela = new JTable(modelo);
        add(new JScrollPane(tabela));

        carregar();
    }

    private void carregar() {

        modelo.setRowCount(0);

        for (Projeto p : service.listar()) {
            modelo.addRow(new Object[]{
                    p.getNome(),
                    p.getStatus(),
                    p.getGerente().getNome()
            });
        }
    }
}