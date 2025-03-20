package exercicios.TestesExercicios.Exercicio5;

public class CartaoCredito implements Pagamento{

    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Realizando pagamento via Cartão de Crédito...");
    }

}
