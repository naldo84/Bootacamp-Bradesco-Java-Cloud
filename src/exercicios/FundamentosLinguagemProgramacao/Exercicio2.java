package exercicios.FundamentosLinguagemProgramacao;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        System.out.println("Exercicio 2");

        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o lado do quadrado: ");
        int lado = scan.nextInt();

        int area = lado * lado;

        System.out.println("A área do quadrado é: " + area);

        scan.close();
    }
}
