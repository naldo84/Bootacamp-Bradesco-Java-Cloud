package Desafios.Codigo.AplicandoProgramacaoOOEmJava.SistemaBancario2;

public abstract class Conta {
    protected double saldo;

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public abstract void sacar(double valor);


    public void exibirSaldo() {
        System.out.printf("Saldo Atual: %.2f%n", saldo);
    }
}
