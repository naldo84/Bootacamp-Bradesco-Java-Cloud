package exercicios.HerancaEPolimorfismoEmJava.Exercicio1;

public class IngressoMeia extends Ingresso{
    
    public IngressoMeia(String nomeFime, String dublLegend) {
        super(15, nomeFime, dublLegend); //totalmente errado
    }
    
    @Override
    public double getValor() {
        return super.getValor() / 2;
    }
}
