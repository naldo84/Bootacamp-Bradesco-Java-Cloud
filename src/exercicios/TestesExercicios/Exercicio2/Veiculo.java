package exercicios.TestesExercicios.Exercicio2;

public abstract class Veiculo {

    void abastecer() {
        System.out.println("Abastecendo " + this.getClass().getSimpleName());
    }

    protected abstract void mover();
}
