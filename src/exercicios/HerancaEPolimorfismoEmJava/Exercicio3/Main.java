package exercicios.HerancaEPolimorfismoEmJava.Exercicio3;

public class Main {
    public static void main(String[] args) {
        RelogioAmericano relogioAmericano = new RelogioAmericano(22, 50, 59);
        RelogioBrasileiro relogioBrasileiro = new RelogioBrasileiro(11, 01, 0);

        System.out.print("EUA: \n");
        relogioAmericano.retornarHora();

        System.out.print("\nBrasil: \n");        
        relogioBrasileiro.retornarHora();
        
    }

}
