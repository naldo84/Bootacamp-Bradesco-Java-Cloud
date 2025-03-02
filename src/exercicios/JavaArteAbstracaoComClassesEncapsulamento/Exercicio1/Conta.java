package exercicios.JavaArteAbstracaoComClassesEncapsulamento.Exercicio1;

public class Conta {

    private int agencia;
    private int numero;
    private double saldo;
    private double limiteChequeEspecial;

    public Conta(int agencia, int numero, double saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.limiteChequeEspecial = calcularLimiteChequeEspecial(saldo);
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
        this.limiteChequeEspecial = calcularLimiteChequeEspecial(saldo);
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double calcularLimiteChequeEspecial(double saldo) {
        if (saldo <= 500) {
            return 0;
        } else {
            return saldo * 0.5;
        }
    }   

    public void consultarSaldo() {
        System.out.printf("Saldo: R$ %.2f%n", this.saldo);
    }

    public void consultarLimiteChequeEspecial() {
        System.out.printf("Limite Cheque Especial + Saldo: R$ %.2f%n", (this.saldo + this.limiteChequeEspecial));
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido!");
        } else {
            this.saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso!%n", valor);
        }
    }

    public void sacar(double valor) {
        if (this.saldo + this.limiteChequeEspecial >= valor) {
            this.saldo -= valor;
            
            if (this.saldo < 0) {
                double valorUsadoChequeEspecial = -this.saldo * 0.2;
                this.saldo -= valorUsadoChequeEspecial;
                System.out.println("Taxa de 20% de uso do cheque especial: R$ " + valorUsadoChequeEspecial);
            }
            System.out.printf("Saque de R$ %.2f realizado com sucesso!%n", valor);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void pagarBoleto(double valor) {
        if (this.saldo + this.limiteChequeEspecial >= valor) {
            this.saldo -= valor;

            if (this.saldo < 0) {
                double valorUsadoChequeEspecial = -this.saldo * 0.2;
                this.saldo -= valorUsadoChequeEspecial;
                System.out.println("Taxa de 20% de uso do cheque especial: R$ " + valorUsadoChequeEspecial);
            }
            System.out.printf("Pagamento de boleto de R$ %.2f realizado com sucesso!%n", valor);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void verificarSeUsaChequeEspecial(){
        if (this.saldo < 0) {
            System.out.println("Conta está usando cheque especial!");
        } else {
            System.out.println("Conta não está usando cheque especial!");
        }
    }

}
