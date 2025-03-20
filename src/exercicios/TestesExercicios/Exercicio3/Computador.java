package exercicios.TestesExercicios.Exercicio3;

public class Computador implements DispositivoEletronico {

    @Override
    public void ligar() {
        System.out.println("Computador ligado");
    }

    @Override
    public void desligar() {
        System.out.println("Computador desligado");
    }

}
