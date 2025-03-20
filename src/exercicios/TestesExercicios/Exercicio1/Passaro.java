package exercicios.TestesExercicios.Exercicio1;

public class Passaro implements Animal{

    @Override
    public void emitirSom() {
        System.out.println("Piu piu");
    }

    @Override
    public void mover() {
        System.out.println("Voando");
    }

}
