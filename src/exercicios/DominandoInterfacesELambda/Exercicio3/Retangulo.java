package exercicios.DominandoInterfacesELambda.Exercicio3;

public class Retangulo implements Area{
    private double base;
    private double altura;

    @Override
    public double calcularArea() {

        return base * altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setBase(double base) {
        this.base = base;
    }
}
