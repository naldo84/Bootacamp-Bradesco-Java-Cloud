package exercicios.TestesExercicios;

import java.util.ArrayList;
import java.util.List;

public class teste {
    public static void main(String[] args) {
        List<User> listaUsers = new ArrayList<>();

        listaUsers.add(new User("Erinaldo", 35));
        listaUsers.add(new User("Ivete", 30));
        listaUsers.add(new User("Sileide Silva", 40));


        //listaUsers.forEach (user -> System.out.println(user));

        listaUsers.forEach(System.out::println);
    }

    private static void printStringValue(){

    }

}
