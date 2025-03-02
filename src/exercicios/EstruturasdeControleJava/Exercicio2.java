package exercicios.EstruturasdeControleJava;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        System.out.println("Exercicio 2");

        Scanner scan = new Scanner(System.in);
        String resultado;

        System.out.print("Nome: ");
        String nome = scan.nextLine();

        System.out.println("Altura: ");
        double altura = scan.nextDouble();

        System.out.println("Peso: ");
        double peso = scan.nextDouble();

        
        double imc = peso / (altura * altura);

        if (imc <= 18.5) {
            resultado = "Abaixo do peso";
        } else if (imc >= 18.6 && imc <= 24.9) {
            resultado = "Peso ideal";      
        } else if (imc >= 25 && imc <= 29.9) {
            resultado = "Levemente acima do peso";
        } else if (imc >= 30 && imc <= 34.9) {
            resultado = "Obesidade Grau I";
        } else if (imc >= 35 && imc <= 39.9) {
            resultado = "Obesidade Grau II (Severa)";
        } else {
            resultado = "Obesidade III (Mórbida)";
        }

        System.out.println("\nIMC de " + nome + ": " + imc);
        System.out.println("Resultado: " + resultado);

        scan.close();
    }
}
