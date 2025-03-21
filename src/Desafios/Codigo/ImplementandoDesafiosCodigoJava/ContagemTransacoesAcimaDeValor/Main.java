package Desafios.Codigo.ImplementandoDesafiosCodigoJava.ContagemTransacoesAcimaDeValor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> transacoes = new ArrayList<>();

        // TODO: Implemente o código para ler as 3 transações:
        // Esses valores representam as transações realizadas.
        // Armazene cada valor no array `transacoes` para processá-los depois.
        transacoes.add(scanner.nextDouble());
        transacoes.add(scanner.nextDouble());
        transacoes.add(scanner.nextDouble());

        // TODO: Realize a leitura do valor mínimo (4ª entrada):
        // Este valor será usado como o critério para contar as transações maiores que ele.
        double valorMinimo = scanner.nextDouble();

        // TODO: Conte as transações maiores que o valor mínimo e verifique se cada
        // valor no array `transacoes`:
        // Caso o valor seja maior que o `valorMinimo`, incrementem o contador.

        int contador = 0;

        for (double transacao : transacoes){
            if (transacao > valorMinimo){
                contador++;
            }
        }

        System.out.println(contador);
    }
}