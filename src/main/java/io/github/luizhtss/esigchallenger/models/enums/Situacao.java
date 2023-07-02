package io.github.luizhtss.esigchallenger.models.enums;

public enum Situacao {
    EM_ANDAMENTO("Em andamento"),
    CONCLUIDA("Concluída");

    private final String label;

    public String getLabel() {
        return label;
    }

    private Situacao(String label) {
        this.label = label;
    }
}