package exercicios.DominandoInterfacesELambda.Exercicio2;

public class SaudeBemEstar implements Imposto{

    @Override
    public void calcularImposto(double valorProduto) {
        System.out.printf("Valor do produto: R$ %.2f\n",  valorProduto);
        System.out.printf("Imposto: R$ %.2f\n", valorProduto * 0.015);
        System.out.println("---------------------------------\n");
    }

}
