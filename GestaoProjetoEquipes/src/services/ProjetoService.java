package services;

import models.Projeto;
import java.util.ArrayList;
import java.util.List;

public class ProjetoService {

    private List<Projeto> projetos = new ArrayList<>();

    public void cadastrar(Projeto p) {
        projetos.add(p);
    }

    public List<Projeto> listar() {
        return projetos;
    }
}