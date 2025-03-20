package exercicios.TestesExercicios.Exercicio1;

public class Cachorro implements Animal{

    @Override
    public void emitirSom() {
        System.out.println("Au au");
    }

    @Override
    public void mover() {
        System.out.println("Correndo");
    }

}
