package exercicios.JavaArteAbstracaoComClassesEncapsulamento.Exercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        Conta naldoC = new Conta(1, 1111, 1000);

        System.out.println("==========================================================");
        System.out.println("|                Bem vindo ao Banco do Naldo             |" );
        System.out.println("==========================================================");

        do {
            System.out.println("\n========================= OPÇÕES =========================");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Consultar Limite Cheque Especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar boleto");
            System.out.println("6 - Verificar se a conta está usando cheque especial");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    naldoC.consultarSaldo();
                    break;

                case 2:
                    naldoC.consultarLimiteChequeEspecial();
                    break;

                case 3:
                    System.out.print("Digite o valor a ser depositado: R$ ");
                    naldoC.depositar(scanner.nextDouble());

                    break;

                case 4:
                    System.out.print("Digite o valor a ser sacado: R$ ");
                    naldoC.sacar(scanner.nextDouble());
                    break;

                case 5:
                    naldoC.consultarSaldo();
                    System.out.println("Digite o valor do boleto: R$ ");
                    naldoC.pagarBoleto(scanner.nextDouble());
        
                    break;

                case 6:
                    naldoC.verificarSeUsaChequeEspecial();
                    break;

                case 0:
                    System.out.println("Saindo...");                
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } while (opcao != 0);

    }

}
