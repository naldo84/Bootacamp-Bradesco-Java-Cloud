package exercicios.HerancaEPolimorfismoEmJava.Exercicio1;

public class Ingresso {

    private double valor;
    private String nomeFime;
    private String dublLegend;

    
    public Ingresso(double valor, String nomeFime, String dublLegend) {
        this.valor = valor;
        this.nomeFime = nomeFime;
        this.dublLegend = dublLegend;
    } 


    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getNomeFime() {
        return nomeFime;
    }
    public void setNomeFime(String nomeFime) {
        this.nomeFime = nomeFime;
    }
    public String getDublLegend() {
        return dublLegend;
    }
    public void setDublLegend(String dublLegend) {
        this.dublLegend = dublLegend;
    }
}