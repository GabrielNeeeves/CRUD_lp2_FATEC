package model;

public class PessoaModel {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String endereco;

    public PessoaModel(){}

    public PessoaModel(int id, String nome, String email, String senha, String tel, String end) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        telefone = tel;
        endereco = end;
    }

    public PessoaModel(String nome, String email, String senha, String tel, String end) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        telefone = tel;
        endereco = end;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
