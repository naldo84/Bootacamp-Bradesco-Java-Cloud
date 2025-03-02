package exercicios.JavaArteAbstracaoComClassesEncapsulamento.Exercicio2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        // Instanciando um objeto da classe Carro
        Carro carro = new Carro("Fusca");

        System.out.println("==========================================================");
        System.out.printf("                         %s                            \n", carro.getModelo());
        System.out.println("==========================================================");

        do {
            System.out.println("\n========================= OPÇÕES =========================");
            System.out.println("1 - Ligar o carro");
            System.out.println("2 - Desligar o carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Diminuir velocidade");
            System.out.println("5 - Virar para esquerda/direita");
            System.out.println("6 - Verificar velocidade");
            System.out.println("7 - Trocar marcha");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            

            switch (opcao) {
                case 1:
                carro.ligar();
                    break;

                case 2:
                carro.desligar();
                    break;

                case 3:
                carro.acelerar();
                    break;

                case 4:
                carro.diminuirVelocidade();
                    break;

                case 5:
                carro.virar();    
                    break;

                case 6:
                carro.verificarVelocidade();                 
                    break;

                case 7:
                    carro.trocarMarcha();
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
