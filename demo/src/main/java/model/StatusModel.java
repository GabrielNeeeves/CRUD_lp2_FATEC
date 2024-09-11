package model;

public class StatusModel {

    private int id;
    private String descricao;

    public StatusModel(){}
    public StatusModel(int id, String desc) {
        this.id = id;
        descricao = desc;
    }

    public StatusModel(String desc) {
        descricao = desc;
    }


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
