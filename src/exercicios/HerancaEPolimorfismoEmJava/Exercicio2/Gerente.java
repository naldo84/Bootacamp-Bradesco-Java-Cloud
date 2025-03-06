package exercicios.HerancaEPolimorfismoEmJava.Exercicio2;

public final class Gerente extends Usuario {
    private boolean ehAdmistrador;

    public Gerente(String nome, String email, String senha) {
        super(nome, email, senha);
        this.ehAdmistrador = true;
    }

    private void gerarRelatorio() {
        System.out.println("Gerando relatório");
    }

    public void consultarVendas() {
        System.out.println("Consultando vendas");
    }
}
