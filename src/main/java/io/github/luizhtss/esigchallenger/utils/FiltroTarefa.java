package io.github.luizhtss.esigchallenger.utils;

import io.github.luizhtss.esigchallenger.models.enums.Situacao;

import java.util.Date;

public class FiltroTarefa {
    private Long numero;
    private String tituloDescricao;
    private String responsavel;
    private Situacao situacao;
    private Date deadline;

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getTituloDescricao() {
        return tituloDescricao;
    }

    public void setTituloDescricao(String tituloDescricao) {
        this.tituloDescricao = tituloDescricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
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
}
