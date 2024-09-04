package view;

import data.PessoaData;
import data.StatusData;
import model.PessoaModel;
import model.StatusModel;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        var pm = new PessoaModel();
        var pd = new PessoaData();
        Scanner sc = new Scanner(System.in);

        do {
            try() {
                System.out.println("# Digite uma opção abaixo: ");
                System.out.println("1. Status");
                System.out.println("2. Pessoa");
                int opcao = sc.nextInt();
                if(opcao == 2) {

                    pm.exibirMenu(sc, pd);
                }

            } catch(Exception ex) {
                System.out.println("Erro em App: "+ex.getMessage());
                ex.printStackTrace();
            }
        } while(sc.nextInt() != 9);

    }
}
