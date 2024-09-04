package view;

import data.PessoaData;
import data.StatusData;
import model.PessoaModel;
import model.StatusModel;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        StatusModel obj = new StatusModel();
//        StatusData DAO = new StatusData();
        var pmDAO = new PessoaData();
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        do {
           try {
               System.out.println("MENU");
               System.out.println("Escolha uma opção");
               System.out.println("1. Nova Pessoa");
               System.out.println("2. Pesquisar Status");
               System.out.println("3. Excluir stts");
               System.out.println("4. Editar stts");
               System.out.println("9. Sair");
               opcao = sc.nextInt();

               switch (opcao) {
                   case 1:
                       PessoaModel pm = new PessoaModel("karl", "karl@gmail.com", "c@kkk3", "(99)9999-9999", "Rua Exemplo, 123 - Rio Preto");
                       if(pmDAO.incluir(pm)) System.out.println("Salvo");
                       else System.out.println("Erro ao salvar");
                       break;
                   case 9:
                       System.out.println("Saiu");
                       return;
                   default:
                       System.out.println("Opção inválida");
                       break;
               }
           } catch (Exception e) {
               System.out.println("Erro de CRUD: "+e.getMessage());
           }
        } while (opcao != 9);

    }
}
