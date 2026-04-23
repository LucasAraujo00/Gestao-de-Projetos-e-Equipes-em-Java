package models;

import java.util.Date;

public class Projeto {

    private String nome;
    private String descricao;
    private Date dataInicio;
    private Date dataFimPrevista;
    private String status;
    private Usuario gerente;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Date getDataInicio() { return dataInicio; }
    public void setDataInicio(Date dataInicio) { this.dataInicio = dataInicio; }

    public Date getDataFimPrevista() { return dataFimPrevista; }
    public void setDataFimPrevista(Date dataFimPrevista) { this.dataFimPrevista = dataFimPrevista; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Usuario getGerente() { return gerente; }
    public void setGerente(Usuario gerente) { this.gerente = gerente; }

    @Override
    public String toString() {
        return nome;
    }
}