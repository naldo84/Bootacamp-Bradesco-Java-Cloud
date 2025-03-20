package exercicios.TestesExercicios.Exercicio4;

public abstract class Personagem {
    int vida = 100;

    abstract void atacar();
    abstract void defender();

    protected void mostrarVida() {
        System.out.println("O personagem tem " + vida + " de vida.");
    }

}
