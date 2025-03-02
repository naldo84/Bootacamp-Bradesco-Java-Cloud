package exercicios.FundamentosLinguagemProgramacao;

import java.time.LocalDate;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        System.out.println("Exercicio 1");
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scan.nextLine();
        System.out.println("Digite seu ano de nascimento: ");
        int anoNascimento = scan.nextInt();

        int idade = LocalDate.now().getYear() - anoNascimento;

        System.out.println("Olá " + nome + ", você tem " + idade + " anos.");

        scan.close();
    }
}
