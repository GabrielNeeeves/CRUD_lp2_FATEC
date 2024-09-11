package model;

public class ProdutoModel {

    private int id;
    private String descricao;
    private double preco;
    private int quantidade;
    private int status;

    public ProdutoModel(){}

    public ProdutoModel(String descricao, double preco, int quantidade, int stts) {
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.status = stts;
    }

    public ProdutoModel(int id, String descricao, double preco, int quantidade, int stts) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        status = stts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
