package exercicios.TestesExercicios.Exercicio4;

public class MainPersonagens {
    public static void main(String[] args) {
        Guerreiro guerreiro = new Guerreiro();
        Mago mago = new Mago();

        guerreiro.defender();
        guerreiro.atacar();
        guerreiro.mostrarVida();


        mago.mostrarVida();
        mago.lancarMagia();
        mago.atacar();
        mago.defender();
        mago.mostrarVida();
        
        
    }

}
