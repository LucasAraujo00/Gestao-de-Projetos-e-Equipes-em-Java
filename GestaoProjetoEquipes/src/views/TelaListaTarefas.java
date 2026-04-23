package views;

import models.Tarefa;
import services.TarefaService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaListaTarefas extends JFrame {

    private TarefaService service;
    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaListaTarefas(TarefaService service) {

        this.service = service;

        setTitle("Tarefas");
        setSize(500, 300);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel();
        modelo.addColumn("Título");
        modelo.addColumn("Projeto");
        modelo.addColumn("Responsável");
        modelo.addColumn("Status");

        tabela = new JTable(modelo);
        add(new JScrollPane(tabela));

        carregar();
    }

    private void carregar() {

        modelo.setRowCount(0);

        for (Tarefa t : service.listar()) {
            modelo.addRow(new Object[]{
                    t.getTitulo(),
                    t.getProjeto().getNome(),
                    t.getResponsavel().getNome(),
                    t.getStatus()
            });
        }
    }
}