package exercicios.DominandoInterfacesELambda.Exercicio2;

import java.util.Scanner;

public class MainImposto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Alimentacao alimentacao = new Alimentacao();
        SaudeBemEstar saudeBemEstar = new SaudeBemEstar();
        Vestuario vestuario = new Vestuario();
        Cultura cultura = new Cultura();

        int opcao = 0;
        double valorProduto = 0;

        do {
            System.out.println("1 - Alimentação");
            System.out.println("2 - Saúde e Bem estar");
            System.out.println("3 - Vestuário");
            System.out.println("4 - Cultura");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            System.out.print("Informe o valor do produto: ");
            valorProduto = scanner.nextDouble();

            switch (opcao) {
                case 1:
                    alimentacao.calcularImposto(valorProduto);
                    break;

                case 2:
                    saudeBemEstar.calcularImposto(valorProduto);
                    break;  

                case 3:
                    vestuario.calcularImposto(valorProduto);
                    break;
                
                case 4:
                    cultura.calcularImposto(valorProduto);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    return;

                default:
                System.out.println("Digite apenas os nros de 0 a 4");
                    break;
            }

        } while (opcao != 0);
    }
}
