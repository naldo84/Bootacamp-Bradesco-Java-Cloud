package exercicios.HerancaEPolimorfismoEmJava.Exercicio3;

public non-sealed class RelogioAmericano extends Relogio{

    public RelogioAmericano(int hora, int minuto, int segundo) {
        super(hora, minuto, segundo);
    }

    @Override
    public void retornarHora(){
        if (getSegundo() > 59) {
            System.out.println("Segundo inválido");
            return;
        }
        
        if (getMinuto() > 59) {
            System.out.println("Minuto inválido");
            return;
        } 
        
        if (getHora() > 12 && getHora() < 24) {
            System.out.println("Hora: " + (getHora() - 12) + ":" + getMinuto() + ":" + getSegundo() + " PM");
            return;
        } else if (getHora() == 12) {
            System.out.println("Hora: " + getHora() + ":" + getMinuto() + ":" + getSegundo() + " PM");
            return;
        } else if (getHora() == 0) {
            System.out.println("Hora: " + (getHora() + 12) + ":" + getMinuto() + ":" + getSegundo() + " AM");
            return;
        } else if (getHora() == 24) {
            System.out.println("Hora: " + (getHora() - 12) + ":" + getMinuto() + ":" + getSegundo() + " AM");
            return;
        } else if (getHora() > 24) {
            System.out.println("Hora inválida");
            return;
        } else if (getHora() < 12) {
            System.out.println("Hora: " + getHora() + ":" + getMinuto() + ":" + getSegundo() + " AM");
            return;
        } else if (getHora() < 0) {
            System.out.println("Hora inválida");
            return;
        } 
    }   
}
