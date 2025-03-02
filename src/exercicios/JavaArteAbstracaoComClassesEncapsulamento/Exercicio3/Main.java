package exercicios.JavaArteAbstracaoComClassesEncapsulamento.Exercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        MaquinaLavar maquina = new MaquinaLavar();
        Pet pet = new Pet();


        //maquina.setNivelShampoo(8);
        //maquina.setNivelAgua(26);
        maquina.setMaquinaLimpa(false);

        do {
            System.out.println("\n========================= OPÇÕES =========================");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer com água");
            System.out.println("3 - Abastecer com shampoo");
            System.out.println("4 - Verificar nivel de água");
            System.out.println("5 - Verificar nivel de shampoo");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - colocar pet na maquina");
            System.out.println("8 - Retirar pet da máquina");
            System.out.println("9 - limpar maquina");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            

            switch (opcao) {
                case 1:
                    maquina.darBanho(pet);
                    break;

                case 2:
                    maquina.abastecerAgua();
                    break;

                case 3:
                    maquina.abastecerShampoo();
                    break;

                case 4:
                    maquina.verificarNivelAgua();
                    break;

                case 5:
                    maquina.verificarNivelShampoo();
                    break;

                case 6:
                    maquina.verificarSeTemPetNoBanho();
                    break;

                case 7:
                    maquina.colocarPetNaMaquina(pet);
                    break;

                case 8:
                    maquina.retirarPetDaMaquina();
                    break;

                case 9:
                    maquina.limparMaquina();
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
