package exercicios.DominandoInterfacesELambda.Exercicio1;

public class Sms implements Mensagem{

    @Override
    public void enviarMsg(String msg) {
        System.out.println("Mensagem: " + msg);
        System.out.println("Enviado via SMS");
    }

}
