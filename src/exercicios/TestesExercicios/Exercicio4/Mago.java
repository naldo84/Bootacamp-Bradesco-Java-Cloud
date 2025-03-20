package exercicios.TestesExercicios.Exercicio4;

public class Mago extends Personagem implements Magia{

    @Override
    void atacar() {
        System.out.println("Mago atacando...");
    }

    @Override
    void defender() {
        System.out.println("Mago defendendo...");
    }

    @Override
    public void lancarMagia() {
        System.out.println("Mago lança magia...");
    }
}
