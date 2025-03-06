package exercicios.HerancaEPolimorfismoEmJava.Exercicio2;

public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Naldo", "naldo@teste.com.br", "123456");
        Vendedor vendedor = new Vendedor("João", "joao@teste.com.br", "112233");
        Atendente atendente = new Atendente("Maria", "maria@teste.com.br", "123123");

        System.out.println("Acessos - " + gerente.getClass().getSimpleName());
        System.out.println(gerente.realizarLogin("naldo@teste.com.br", "123"));
        System.out.println(gerente.realizarLogin("naldo@teste.com.br", "123456"));

        
    }

}
