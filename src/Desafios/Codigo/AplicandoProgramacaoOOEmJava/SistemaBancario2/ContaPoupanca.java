package Desafios.Codigo.AplicandoProgramacaoOOEmJava.SistemaBancario2;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(double saldo) {
        super(saldo);
    }

    // Implementação do método sacar para Conta Poupança
    @Override
    public void sacar(double valor) {
        // TODO: Implemente a lógica para verificar se o saque é permitido considerando apenas o saldo:
        // Dica: Se saldo >= valor, o saque é permitido.


        exibirSaldo(); // Exibe o saldo atualizado
    }

}
