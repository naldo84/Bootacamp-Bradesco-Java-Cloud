package exercicios.FundamentosLinguagemProgramacao;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        System.out.println("Exercicio 3");

        Scanner scan = new Scanner(System.in);

        System.out.print("Digite a base de um retângulo: ");
        int base = scan.nextInt();

        System.out.print("Digite a altura de um retângulo: ");
        int altura = scan.nextInt();

        int area = base * altura;

        System.out.println("A área do retângulo é: " + area);

        scan.close();
    }
}
