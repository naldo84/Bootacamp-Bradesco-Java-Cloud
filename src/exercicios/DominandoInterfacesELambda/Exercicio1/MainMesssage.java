package exercicios.DominandoInterfacesELambda.Exercicio1;

import java.util.Scanner;

public class MainMesssage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mensagem = "";
        int opcao = 0;
        
        Sms sms = new Sms();  
        Email email = new Email();
        RedeSocial redeSocial =  new RedeSocial();
        WhatsApp whatsApp = new WhatsApp();

        System.out.print("\nDigite uma mensagem: ");
        mensagem = scanner.nextLine();

        do {
            System.out.println("1 - SMS");
            System.out.println("2 - E-mail");
            System.out.println("3 - Redes Sociais");
            System.out.println("4 - WhatsApp");
            System.out.print("Escolha uma opção de envio: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:   
                    sms.enviarMsg(mensagem);
                    break;

                case 2:
                    email.enviarMsg(mensagem);
                    break;  

                case 3:
                    redeSocial.enviarMsg(mensagem);
                    break;

                case 4:
                    whatsApp.enviarMsg(mensagem);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    return;

                default:
                System.out.println("Escolha uma opção de envio disponível (0 a 4)");
                    break;
            }

        } while (opcao != 0);
    }
}
