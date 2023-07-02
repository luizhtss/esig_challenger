package io.github.luizhtss.esigchallenger.models.enums;

public enum Prioridade {
    ALTA("Alta"),
    MEDIA("Média"),
    BAIXA("Baixa");

    private final String prioridade;

    Prioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getPrioridadeStr() {
        return prioridade;
    }
}