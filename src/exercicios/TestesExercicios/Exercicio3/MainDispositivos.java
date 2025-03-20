package exercicios.TestesExercicios.Exercicio3;

import java.util.ArrayList;
import java.util.List;

public class MainDispositivos {
    public static void main(String[] args) {
        List<DispositivoEletronico> dispositivos = new ArrayList<>();
        Computador computador = new Computador();
        Smartphone smartphone = new Smartphone();

        dispositivos.add(computador);
        dispositivos.add(smartphone);

        for (DispositivoEletronico dispositivo : dispositivos) {
            dispositivo.ligar();
            dispositivo.desligar();
        }
    }
}
