package exercicios.FundamentosLinguagemProgramacao;

import java.util.Scanner;

public class Exercicio4{
    public static void main(String[] args) {
        System.out.println("Exercicio 4");
        Scanner scan = new Scanner(System.in);

        int diferencaIdade = 0;

        System.out.println("Pessoa 1:");
        System.out.print("Nome: ");
        String nomePessoa1 = scan.nextLine();
        System.out.print("Idade: ");
        int idadePessoa1 = scan.nextInt();
        scan.nextLine(); // Consumir a nova linha restante

        System.out.println("\nPessoa 2:");
        System.out.print("Nome: ");
        String nomePessoa2 = scan.nextLine();
        System.out.print("Idade: ");
        int idadePessoa2 = scan.nextInt();

        if (idadePessoa2 > idadePessoa1){
            diferencaIdade = idadePessoa2 - idadePessoa1;
        } else {
            diferencaIdade = idadePessoa1 - idadePessoa2;
        }

        System.out.println("A diferença de idade entre " + nomePessoa1 + " e " + nomePessoa2 + " é de " + diferencaIdade + " anos.");

        scan.close();
    }
}
