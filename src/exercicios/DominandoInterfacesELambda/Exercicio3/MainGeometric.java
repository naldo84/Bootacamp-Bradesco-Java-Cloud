package exercicios.DominandoInterfacesELambda.Exercicio3;

import java.util.Scanner;

public class MainGeometric {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circulo circulo = new Circulo();
        Quadrado quadrado = new Quadrado();
        Retangulo retangulo = new Retangulo();

        int opcao = 0;
        double raio = 0;
        double lado = 0;
        double base = 0;
        double altura = 0;

        do {
            System.out.println("Calculo da área");
            System.out.println("1 - Quadrado");
            System.out.println("2 - Retangulo");
            System.out.println("3 - Circulo");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o lado do quadrado: ");
                    lado = scanner.nextDouble();
                    quadrado.setLado(lado);
                    System.out.println("Area: " + quadrado.calcularArea());     
                    System.out.println("----------------------------------");  

                    break;

                case 2:
                    System.out.print("Digite a base do retângulo: ");
                    base = scanner.nextDouble();
                    retangulo.setBase(base);

                    System.out.print("Digite a altura do retângulo: ");
                    altura = scanner.nextDouble();                    
                    retangulo.setAltura(altura);

                    System.out.println("Area: " + retangulo.calcularArea());     
                    System.out.println("----------------------------------");  
                    break;
                
                case 3:
                    System.out.print("Digite o raio do círculo: ");
                    raio = scanner.nextDouble();
                    circulo.setRaio(raio);
                    System.out.println("Area: " + circulo.calcularArea());     
                    System.out.println("----------------------------------");  
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;

                default:
                System.out.println("Digite apenas os nros de 0 a 3");
                    break;
            }

        } while (opcao != 0);
    }
}
