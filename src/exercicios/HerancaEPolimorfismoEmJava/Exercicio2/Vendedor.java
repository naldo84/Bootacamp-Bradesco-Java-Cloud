package exercicios.HerancaEPolimorfismoEmJava.Exercicio2;

public final class Vendedor extends Usuario{
    private int qtdeVendas = 0;
    private boolean ehAdmistrador;

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha);
        this.qtdeVendas = 0;
        this.ehAdmistrador = false;
    }


    public void realizarVenda(){
        this.qtdeVendas++;
    }

    public int consultarVendas(){
        return this.qtdeVendas;
    }
    
}
