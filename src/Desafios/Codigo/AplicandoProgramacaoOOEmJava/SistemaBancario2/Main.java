package Desafios.Codigo.AplicandoProgramacaoOOEmJava.SistemaBancario2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tipoConta = scanner.next();
        scanner.nextLine();
        scanner.nextLine();
        scanner.next();
        double saldoInicial = scanner.nextDouble();

        Conta conta = null;

        // TODO: Implemente a lógica para criar uma instância de ContaCorrente ou
        // ContaPoupanca:
        // Dica: Use um if para verificar o tipo da conta.
        if (tipoConta.equalsIgnoreCase("corrente")) {
            System.out.println("Digite o limite do cheque especial: ");
            double limite = scanner.nextDouble();
            conta = new ContaCorrente(saldoInicial, limite);
        } else if (tipoConta.equalsIgnoreCase("poupanca")) {
            conta = new ContaPoupanca(saldoInicial);
        }

        // TODO: Para Conta Corrente, leia também o limite de cheque especial e crie a
        // instância.

        // TODO: Para Conta Poupança, apenas inicialize a conta com o saldo inicial:

        while (scanner.hasNextDouble()) {
            double valorSaque = scanner.nextDouble();
            conta.sacar(valorSaque);
        }
        scanner.close();
    }
}
