package beecrowd.cifradecesar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {

    ArrayList<String> all = new ArrayList<String>();

    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    for (int i=0; i<n; i++) {
      s.nextLine();
      String msg = s.nextLine();
      int chave = s.nextInt();

      char[] msgCript = new char[50];

      for (int k = 0; k < msg.length(); k++) {
        char aux = msg.charAt(k);

        for (int j = 0; j < chave; j++) {

          if (aux == 'A') {
            aux = 'Z';
            continue;
          }

          aux--;
        }

        msgCript[k] = aux;
      }

      all.add(String.valueOf(msgCript));
    }

    all.forEach(msg -> System.out.print(msg + "\n"));

    s.close();
  }
}