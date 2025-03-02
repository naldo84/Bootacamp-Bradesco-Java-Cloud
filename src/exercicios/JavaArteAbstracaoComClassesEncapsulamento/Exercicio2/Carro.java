package exercicios.JavaArteAbstracaoComClassesEncapsulamento.Exercicio2;

public class Carro {
    private String modelo;
    private boolean ligado;
    private int marcha;
    private int velocidade;

    public Carro(String modelo) {
        this.modelo = modelo;
        this.ligado = false;
        this.marcha = 0;
        this.velocidade = 0;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public void ligar() {
        this.ligado = true;
        System.out.println("Carro ligado");
    }

    public void desligar() {
        if (this.marcha == 0 && this.velocidade == 0) {
            this.ligado = false;
            System.out.println("Carro desligado");
        } else {
            System.out.println("Reduza a marcha e pare o carro antes de desligar");
        }
    }

    public void acelerar() {
        if (this.ligado) {
            if (this.velocidade < 120) {
                this.velocidade++;
                System.out.println("Acelerando...");
            } else {
                System.out.println("Velocidade máxima atingida");
            }
        } else {
            System.out.println("Carro desligado");
        }
    }

    public void diminuirVelocidade() {
        if (this.ligado) {
            if (this.velocidade > 0) {
                this.velocidade--;
            }
            System.out.println("Diminuindo velocidade...");
        } else {
            System.out.println("Carro desligado");
        }
    }

    public void trocarMarcha() {
        velocidade = getVelocidade();
        if (this.ligado) {
            if (velocidade >= 0 && velocidade <= 20) {
                this.marcha = 1;
                System.out.println("Marcha: " + this.marcha);
            } else if (velocidade >= 21 && velocidade <= 40) {
                this.marcha = 2;
                System.out.println("Marcha: " + this.marcha);
            } else if (velocidade >= 41 && velocidade <= 60) {
                this.marcha = 3;
                System.out.println("Marcha: " + this.marcha);
            } else if (velocidade >= 61 && velocidade <= 80) {
                this.marcha = 4;
                System.out.println("Marcha: " + this.marcha);
            } else if (velocidade >= 81 && velocidade <= 100) {
                this.marcha = 5;
                System.out.println("Marcha: " + this.marcha);
            } else if (velocidade >= 101 && velocidade <= 120) {
                this.marcha = 6;
                System.out.println("Marcha: " + this.marcha);
            }
        } else {
            System.out.println("Carro desligado");
        }
    }

    public void virar() {
        if (this.ligado) {
            if (this.velocidade > 0 && velocidade <=40)
            System.out.println("Virando...");
        } else {
            System.out.println("Carro desligado");
        }
    }

    public void verificarVelocidade() {
        if (this.ligado) {
            System.out.println("Velocidade: " + this.velocidade + " km/h");
        } else {
            System.out.println("Carro desligado");
        }
    }
}
