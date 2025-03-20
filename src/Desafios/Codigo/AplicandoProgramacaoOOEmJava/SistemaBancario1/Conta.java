package Desafios.Codigo.AplicandoProgramacaoOOEmJava.SistemaBancario1;

public class Conta {
    // TODO: Implemente os atributos privados para garantir que só podem ser acessados dentro da classe:
    private String titular;
    private int numeroConta;
    private double saldoInicial;
    private double saldo;

    // TODO: Crie o construtor para inicializar os atributos da conta:
    public Conta(String titular, int numeroConta, double saldoInicial) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldoInicial = saldoInicial;
        this.saldo += saldoInicial;
    }

    // TODO: Adicione o método público para consultar o saldo:

    public double consultarSaldo(){
        return getSaldo();
    }

    // TODO: Adicione o método público para realizar saque:
    public boolean sacar(double valor){
        if (valor > saldo){
            return false;
        }

        this.saldo -= valor;
        return true;
    }


    // TODO: Crie o método público para realizar depósito
    public void depositar(double valor){
        this.saldo += valor;
    }


    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }
}
