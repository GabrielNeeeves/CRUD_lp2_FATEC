package model;

public class StatusModel {

    private int id;
    private String descricao;

    public StatusModel(){}

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }
}
