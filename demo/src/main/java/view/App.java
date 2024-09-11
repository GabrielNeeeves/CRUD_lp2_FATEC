package view;

import data.Conexao;
import data.PessoaData;
import data.ProdutoData;
import data.StatusData;
import model.PessoaModel;
import model.ProdutoModel;
import model.StatusModel;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        StatusModel smObj = new StatusModel();
        StatusData statusDAO = new StatusData();
        PessoaData pmDAO = new PessoaData();
        ProdutoData prodData = new ProdutoData();
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        do {
           try {
               System.out.println("MENU");
               System.out.println("Escolha uma opção");
               System.out.println("0. Novo Status");
               System.out.println("1. Nova Pessoa");
               System.out.println("2. Pesquisar Status");
               System.out.println("3. Pesquisar Pessoa");
               System.out.println("4. Excluir Status");
               System.out.println("5. Excluir Pessoa");
               System.out.println("6. Atualizar Status");
               System.out.println("7. Atualizar Pessoa");
               System.out.println("8. Listar Status");
               System.out.println("9. Listar Pessoas");
               System.out.println("============");
               System.out.println("10. Listar Produtos");
               System.out.println("11. Incluir Produto");
               System.out.println("12. Atualizar Produto");
               System.out.println("13. Deletar Produto");
               System.out.println("20. Sair");
               opcao = sc.nextInt();

               switch (opcao) {
                   case 0:
                       System.out.println("Digite a situação do Status: ");
                       String sit = sc.next();
                       var novoStatus = new StatusModel(sit);
                       if(statusDAO.incluir(novoStatus)) {
                           System.out.println("Novo Status criado");
                       } else {
                           System.out.println("Erro ao incluir Status");
                       }
                       break;
                   case 1:
                       PessoaModel pm = new PessoaModel("Pedro", "pedrop@gmail.com", "P3dr)0", "(99)3452-9999", "Rua AAA, 435 - Rio Preto");
                       if(pmDAO.incluir(pm)) System.out.println("Salvo");
                       else System.out.println("Erro ao salvar");
                       break;
                   case 2:
                       System.out.println("Digite a Descrição: ");
                       String desc = sc.next();
                       ArrayList<StatusModel> lista = statusDAO.pesquisar(desc);
                       System.out.println("-----");
                       for(StatusModel statusModel : lista) {
                           System.out.println(statusModel.getId() + " - "+statusModel.getDescricao());
                       }
                       break;
                   case 3:
                       System.out.println("Digite o nome a ser pesquisado: ");
                       String nom = sc.next();
                       ArrayList<PessoaModel> listaPessoa = pmDAO.pesquisar(nom);
                       System.out.println("----");
                       for(PessoaModel pmm : listaPessoa)
                           System.out.println(pmm.getId()+" - "+pmm.getNome()+" - "+pmm.getEmail()+" - "+pmm.getSenha()+" - "+pmm.getEndereco()+" - "+pmm.getTelefone());
                       break;
                   case 4:
                       statusDAO.select(Conexao.getConexao());
                       System.out.println("Digite o ID para ser excluído: ");
                       int idDel = sc.nextInt();
                       statusDAO.excluir(idDel);
                       break;
                   case 5:
                       pmDAO.selectPessoas(Conexao.getConexao());
                       System.out.println("Digite o ID da pessoa para excluí-la: ");
                       int idPe = sc.nextInt();
                       pmDAO.excluir(idPe);
                       break;
                   case 6:
                       statusDAO.select(Conexao.getConexao());
                       System.out.println("Digite o ID para atualizá-lo: ");
                       int idSttUpt = sc.nextInt();
                       System.out.println("Nova descrição: ");
                       String novaDesc = sc.next();
                       StatusModel novoStts = new StatusModel(idSttUpt, novaDesc);
                       statusDAO.atualizar(novoStts);
                       break;
                   case 7:
                       pmDAO.selectPessoas(Conexao.getConexao());
                       System.out.println("Selecione o ID para atualizá-lo: ");
                       int idUpt = sc.nextInt();

                       System.out.println("Novo nome: ");
                       var nomeUpt = sc.next();

                       System.out.println("Novo email: ");
                       var emailUpt = sc.next();

                       System.out.println("Novo senha: ");
                       var senhaUpt = sc.next();

                       System.out.println("Novo tel: ");
                       var telUpt = sc.next();

                       System.out.println("Novo end.: ");
                       var endUpt = sc.next();

                       pmDAO.atualizar(new PessoaModel(idUpt, nomeUpt, emailUpt, senhaUpt, telUpt, endUpt));
                       break;
                   case 8:
                       statusDAO.select(Conexao.getConexao());
                       break;
                   case 9:
                       pmDAO.selectPessoas(Conexao.getConexao());
                       break;
                   case 10:
                       prodData.selectProd(Conexao.getConexao());
                       break;
                   case 11:
                       System.out.println("Descrição do Produto: ");
                       String descProd = sc.next();

                       System.out.println("Preço do Produto: ");
                       double precoProd = sc.nextDouble();

                       System.out.println("Quantidade em Estoque: ");
                       int qtd = sc.nextInt();

                       statusDAO.select(Conexao.getConexao());
                       System.out.println("# Status do Produto: ");
                       int sttsProd = sc.nextInt();
                       prodData.incluir(new ProdutoModel(descProd, precoProd, qtd, sttsProd));
                       break;
                   case 12:
                       prodData.selectProd(Conexao.getConexao());
                       System.out.println("Selecione o ID para atualizar: ");
                       int idProdUpt = sc.nextInt();

                       System.out.println("Nova Descrição: ");
                       String descProdUpt = sc.next();

                       System.out.println("Novo Preço: ");
                       double precoProdUpt = sc.nextDouble();

                       System.out.println("Nova Quantidade: ");
                       int qtdProdUpt = sc.nextInt();

                       statusDAO.select(Conexao.getConexao());
                       System.out.println("# Novo Status: ");
                       int idProdSttsUpt = sc.nextInt();

                       ProdutoModel novoProd = new ProdutoModel(idProdUpt, descProdUpt, precoProdUpt, qtdProdUpt, idProdSttsUpt);
                       if(prodData.atualizar(novoProd))
                           System.out.println("Produto atualizado");
                       else System.out.println("Falha ao atualizar");
                       break;
                   case 13:
                       prodData.selectProd(Conexao.getConexao());
                       System.out.println("# Selecione o ID para excluir: ");
                       int idProdDel = sc.nextInt();

                       if(prodData.excluir(idProdDel))
                           System.out.println("Produto excluido");
                       else {
                           System.out.println("Falha ao axcluir Produto");
                       }
                       break;
                   case 20:
                       System.out.println("Saiu");
                       return;
                   default:
                       System.out.println("Opção inválida");
                       break;
               }
           } catch (Exception e) {
               System.out.println("Erro de CRUD: "+e.getMessage());
               e.printStackTrace();
           }
        } while (opcao != 20);

    }
}
