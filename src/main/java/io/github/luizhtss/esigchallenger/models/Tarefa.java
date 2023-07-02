package io.github.luizhtss.esigchallenger.models;

import io.github.luizhtss.esigchallenger.models.enums.Prioridade;
import io.github.luizhtss.esigchallenger.models.enums.Situacao;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    @Column(length = 100)
    private String titulo;
    @Column(length = 2048)
    private String descricao;
    private String responsavel;
    private Prioridade prioridade;
    private Situacao situacao;
    private Date deadline;

    public Tarefa() {
        setSituacao(Situacao.EM_ANDAMENTO);
    }

    public long getNumero() {
        return numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public boolean naoConcluida(){
        System.out.println("RESULTADO: " + getSituacao().equals(Situacao.EM_ANDAMENTO));
        return getSituacao().equals(Situacao.EM_ANDAMENTO);
    }
}
