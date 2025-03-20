package exercicios.TestesExercicios.Exercicio5;

public class Pix implements Pagamento{

    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Realizando pagamento via Pix");
    }

}
