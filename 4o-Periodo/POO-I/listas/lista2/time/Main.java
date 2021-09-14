package listas.lista2.time;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Time> times = new ArrayList<>();

        for (int i=0; i<2; i++) {

            System.out.println("Nome time");
            String nomeTime = s.nextLine();
    
            System.out.println("Série");
            String serie = s.nextLine();
    
            System.out.println("Numero jogadores");
            Integer numeroJogadores = s.nextInt();

            clearBuffer(s);

            Time timeAux = new Time(nomeTime, serie);
            timeAux.setNumeroJogadores(numeroJogadores); 

            times.add(timeAux);
        }

        times.forEach(t -> System.out.println(t.toString()));

        s.close();
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
