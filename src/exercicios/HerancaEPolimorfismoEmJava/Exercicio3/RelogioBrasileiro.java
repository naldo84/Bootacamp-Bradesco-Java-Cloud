package exercicios.HerancaEPolimorfismoEmJava.Exercicio3;

public non-sealed class RelogioBrasileiro extends Relogio{

    public RelogioBrasileiro(int hora, int minuto, int segundo) {
        super(hora, minuto, segundo);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void retornarHora(){
        if (getSegundo() > 59 || getSegundo() < 0) {
            System.out.println("Segundo inválido");
            return;
        } 
        
        if (getMinuto() > 59 || getMinuto() < 0) {
            System.out.println("Minuto inválido");
            return;
        }

        if (getHora() > 24 || getHora() < 0) {
            System.out.println("Hora inválida");
            return;
        } else if (getHora() >= 0 && getHora() < 12) {
            System.out.println("Hora: " + getHora() + ":" + getMinuto() + ":" + getSegundo() + " AM");
            return;
        } else if (getHora() >= 12 && getHora() <= 23) {
            System.out.println("Hora: " + getHora() + ":" + getMinuto() + ":" + getSegundo() + " PM");
            return;
        } else if (getHora() == 24) {
            System.out.println("Hora: 00:" + getMinuto() + ":" + getSegundo() + " AM");
            return;
        }
    }

}
