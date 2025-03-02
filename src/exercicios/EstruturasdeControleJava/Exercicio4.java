package exercicios.EstruturasdeControleJava;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Exercicio4 {
    public static void main(String[] args) {
        System.out.println("Exercicio 4");

        Scanner scan = new Scanner(System.in);
        int numeroInicial;
        int numero;
        List<Integer> numList = new ArrayList<>();

        System.out.print("Digite um número inicial: ");
        numeroInicial = scan.nextInt();
        numList.add(numeroInicial);

        while (true) {
            System.out.print("Digite um número: ");
            numero = scan.nextInt();

            if (numero < numeroInicial) {
                continue;
            }

            if (numero % numeroInicial != 0) {
                break;
            }
            
            numList.add(numero);
        }

        System.out.println("Números selecionados: " + numList);
        
        scan.close();
    }
}
