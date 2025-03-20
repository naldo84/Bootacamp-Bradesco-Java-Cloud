package Desafios.Codigo.AplicandoProgramacaoOOEmJava.SistemaBancario2;

public class ContaCorrente extends Conta{
    private double limite;

    public ContaCorrente(double saldo, double limite) {
        super(saldo);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        // TODO: Implemente a lógica para verificar se o saque é permitido considerando o saldo e o limite:
        // Dica: Se saldo - valor >= -limite, o saque é permitido.
        if ((saldo + limite) > valor){
            System.out.printf("Saque realizado %.2f%n", valor);
        }


        exibirSaldo(); // Exibe o saldo atualizado
    }
}
