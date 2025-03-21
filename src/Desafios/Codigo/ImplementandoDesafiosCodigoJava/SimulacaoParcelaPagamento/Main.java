package Desafios.Codigo.ImplementandoDesafiosCodigoJava.SimulacaoParcelaPagamento;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double valorTotal = scanner.nextDouble();
        int numeroParcelas = scanner.nextInt();

        double valorParcela = valorTotal / numeroParcelas;

        // TODO: Crie a lógica para verificar se o parcelamento é possível:
        // A condição deve garantir que o valor de cada parcela seja maior ou igual a 1.
        if (numeroParcelas > valorTotal) {
            System.out.println("Parcelamento nao e possivel");
        }

        if (valorParcela >= 1) {
            System.out.printf("Parcela: %.2f%n", valorParcela);
        }

        scanner.close();
    }
}
