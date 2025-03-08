package exercicios.DominandoInterfacesELambda.Exercicio1;

public class RedeSocial implements Mensagem{

    @Override
    public void enviarMsg(String msg) {
        System.out.println("Mensagem: " + msg);
        System.out.println("Enviado via Rede Social");
    }
}
