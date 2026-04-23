package services;

import models.Tarefa;
import java.util.ArrayList;
import java.util.List;

public class TarefaService {

    private List<Tarefa> tarefas = new ArrayList<>();

    public void cadastrar(Tarefa t) {
        tarefas.add(t);
    }

    public List<Tarefa> listar() {
        return tarefas;
    }
}