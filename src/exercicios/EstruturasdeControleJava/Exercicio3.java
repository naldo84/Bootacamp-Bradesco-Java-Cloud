package exercicios.EstruturasdeControleJava;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Exercicio3 {
    public static void main(String[] args) {
        System.out.println("Exercicio 3");

        Scanner scan = new Scanner(System.in);
        int numero1 = 0;
        int numero2 = 0;
        int escolha = 0;
        List<Integer> numeros = new ArrayList<Integer>();

        System.out.print("Digite um número: ");
        numero1 = scan.nextInt();

        do {
            System.out.print("Digite outro número (maior que o primeiro): ");
            numero2 = scan.nextInt();
            if (numero2 > numero1) {
                break;
            }
        } while (true);

        System.out.println("Escolha entre Par ou Ímpar: ");
        System.out.println("1 - Par");
        System.out.println("2 - Ímpar");

        do {
            System.out.print("Escolha: ");
            escolha = scan.nextInt();
            if (escolha == 1 || escolha == 2) {
                break;
            }
        } while (true);

        for (int i = numero1; i <= numero2; i++) {
            if (i % 2 == 0) {
                if (escolha == 1) {
                    numeros.add(i);
                }
            } else {
                if (escolha == 2) {
                    numeros.add(i);
                }
            }
        }
        numeros.sort((a, b) -> Integer.compare(b, a));

        System.out.println("Números selecionados: " + numeros);

        scan.close();
    }
}
