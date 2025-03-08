package exercicios.DominandoInterfacesELambda.Exercicio1;

public class Email implements Mensagem {

    @Override
    public void enviarMsg(String msg) {
        System.out.println("Mensagem: " + msg);
        System.out.println("Enviado via E-mail");
    }

}
