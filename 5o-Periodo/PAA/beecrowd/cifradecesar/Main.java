package beecrowd.cifradecesar;

import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {

    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    for (int i=0; i<n; i++) {
      s.nextLine();
      String msg = s.nextLine();
      int chave = s.nextInt();
      
      System.out.println(criptografar(msg.toUpperCase(), chave));
    }

    s.close();
  }

  public static String criptografar(String msg, int chave) {
    char[] msgCript = new char[50];

    for (int i = 0; i < msg.length(); i++) {
      char aux = (char) msg.charAt(i);

      for (int j = 0; j < chave; j++) {

        if (aux == 'A') {
          aux = 'Z';
          continue;
        }

        aux--;
      }

      msgCript[i] = aux;
    }

    String str = String.valueOf(msgCript);

    return str;
  }
}