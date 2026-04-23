package models;

import java.util.Date;

public class Tarefa {

    private String titulo;
    private String descricao;
    private String status;

    private Date dataInicioPrevista;
    private Date dataFimPrevista;
    private Date dataInicioReal;
    private Date dataFimReal;

    private Projeto projeto;
    private Usuario responsavel;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getDataInicioPrevista() { return dataInicioPrevista; }
    public void setDataInicioPrevista(Date d) { this.dataInicioPrevista = d; }

    public Date getDataFimPrevista() { return dataFimPrevista; }
    public void setDataFimPrevista(Date d) { this.dataFimPrevista = d; }

    public Date getDataInicioReal() { return dataInicioReal; }
    public void setDataInicioReal(Date d) { this.dataInicioReal = d; }

    public Date getDataFimReal() { return dataFimReal; }
    public void setDataFimReal(Date d) { this.dataFimReal = d; }

    public Projeto getProjeto() { return projeto; }
    public void setProjeto(Projeto projeto) { this.projeto = projeto; }

    public Usuario getResponsavel() { return responsavel; }
    public void setResponsavel(Usuario responsavel) { this.responsavel = responsavel; }
}