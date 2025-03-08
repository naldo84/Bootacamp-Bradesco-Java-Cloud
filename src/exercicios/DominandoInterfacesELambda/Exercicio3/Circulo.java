package exercicios.DominandoInterfacesELambda.Exercicio3;

public class Circulo implements Area {
    private final double pi = 3.14;
    private double raio;

    

    @Override
    public double calcularArea() {

        return pi  * (this.raio * this.raio);
    }


    public void setRaio(double raio) {
        this.raio = raio;
    }

}
