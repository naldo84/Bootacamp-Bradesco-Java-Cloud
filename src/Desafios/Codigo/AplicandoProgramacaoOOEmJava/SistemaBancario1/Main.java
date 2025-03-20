package Desafios.Codigo.AplicandoProgramacaoOOEmJava.SistemaBancario1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Titular: ");
        String titular = sc.nextLine();

        System.out.println("Nro conta: ");
        int numeroConta = sc.nextInt();

        System.out.println("Saldo Inicial: ");
        double saldoInicial = sc.nextDouble();

        Conta conta = new Conta(titular, numeroConta, saldoInicial);

        // Operações de saque e depósito
        System.out.println("Valor do saque: ");
        if (sc.hasNextDouble()) {
            double valorSaque = sc.nextDouble();
            if (!conta.sacar(valorSaque)) {
                System.out.println("Saque invalido: Saldo insuficiente");
                System.out.println("Saldo Atual: " + String.format("%.2f", conta.consultarSaldo()));
                return;
            }
        }

        if (sc.hasNextDouble()) {
            System.out.println("Valor depósito: ");
            double valorDeposito = sc.nextDouble();
            conta.depositar(valorDeposito);
        }

        // Imprime o saldo final atualizado
        System.out.println("Saldo Atualizado: " + String.format("%.2f", conta.consultarSaldo()));

        sc.close(); // Fecha o scanner
    }
}
