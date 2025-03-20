package exercicios.TestesExercicios.Exercicio5;

public class MainPagamento {
    public static void main(String[] args) {
        CartaoCredito cartaoCredito = new CartaoCredito();
        Pix pix = new Pix();

        cartaoCredito.realizarPagamento(10);
        pix.realizarPagamento(100);
    }

}
