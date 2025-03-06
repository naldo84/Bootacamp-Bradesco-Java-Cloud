package exercicios.HerancaEPolimorfismoEmJava.Exercicio2;

public final class Atendente extends Usuario{
    private double valorEmCaixa;
    private boolean ehAdmistrador = true;

    public Atendente(String nome, String email, String senha) {
            super(nome, email, senha);
            this.valorEmCaixa = 0;
            this.ehAdmistrador = true;
        }
    
        public void incluirValorEmCaixa(double valor){
            this.valorEmCaixa += valor;
        }

        public void consultarValorEmCaixa(){
            System.out.println("O valor em caixa é: " + this.valorEmCaixa);
        }

}