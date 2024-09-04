package model;

import data.PessoaData;

import java.util.Scanner;

public class PessoaModel {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String endereco;

    public PessoaModel(){}

    public PessoaModel(String nome, String email, String senha, String tel, String end) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        telefone = tel;
        endereco = end;
    }

    public PessoaModel(int id, String nome, String email, String senha, String tel, String end) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        telefone = tel;
        endereco = end;
    }

    //EXIBIR Menu
    public void exibirMenu(Scanner sc, PessoaData pd) {
        System.out.println("1. Incluir pessoa");
        System.out.println("2. Excluir pessoa por Id");
        System.out.println("3. Atualizar pessoa");
        System.out.println("4. Pesquisar(1)");
        System.out.println("5. Pesquisar(2)");
        int opcao = sc.nextInt();
        try {
            switch (opcao) {
                case 1:
                    if(pd.incluir(pm)) System.out.println("Pessoa inserida");
                    else System.out.println("Erro ao inserir");
                    break;
                case 2:
                    System.out.println("Digite o ID da Pessoa: ");
                    int id = sc.nextInt();
                    if(pd.excluir(id)) System.out.println("Pessoa excluída");
                    else System.out.println("Erro ao excluir");
                    break;
                case 3:

            }
        } catch(Exception ex) {
            System.out.println("Erro ao executar operação em Pessoa");
        }
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
