package exercicios.DominandoInterfacesELambda.Exercicio3;

public class Quadrado implements Area {
    private double lado;

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

}
