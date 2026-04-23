package models;

import java.util.ArrayList;
import java.util.List;

public class Equipe {

    private String nome;
    private String descricao;
    private List<Usuario> membros = new ArrayList<>();

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public List<Usuario> getMembros() { return membros; }

    public void adicionarMembro(Usuario usuario) {
        membros.add(usuario);
    }

    @Override
    public String toString() {
        return nome;
    }
}