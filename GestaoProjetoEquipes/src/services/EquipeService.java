package services;

import models.Equipe;
import java.util.ArrayList;
import java.util.List;

public class EquipeService {

    private List<Equipe> equipes = new ArrayList<>();

    public void cadastrar(Equipe e) {
        equipes.add(e);
    }

    public List<Equipe> listar() {
        return equipes;
    }
}