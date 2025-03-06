package exercicios.HerancaEPolimorfismoEmJava.Exercicio1;

public class Main {
    public static void main(String[] args) {
        Ingresso ingresso = new Ingresso(30, "Harry Potter", "Dublado");
        ingresso.setValor(30);

        IngressoMeia ingressoMeia = new IngressoMeia("Harry Potter", "Dublado");
        
        System.out.println(ingresso.getValor());
        System.out.println(ingressoMeia.getValor());            
    }

}
