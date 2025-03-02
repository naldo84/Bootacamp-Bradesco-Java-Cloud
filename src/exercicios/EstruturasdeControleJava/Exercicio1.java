package exercicios.EstruturasdeControleJava;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        System.out.println("Exercicio 1");
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o número da tabuada: ");
        int numero = scan.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }

        scan.close();
    }
}
