package aula0810.contatinho;

import java.util.ArrayList;
import java.util.Scanner;

public class Contatinho {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    ArrayList<String> contatinhos = new ArrayList<>();

    int op = 0;

    do {
      System.out.println("\n\t---MENU---"
        + "\n0 - Sair"
        + "\n1 - Inserir contato"
        + "\n2 - Remover contato"
        + "\n3 - Mostrar quantidade da lista"
        + "\n4 - Listar todos os contatos");

      op = entrada.nextInt();

      switch (op) {
        case 1:
          System.out.println("Informe o nome que deseja adicionar");
          contatinhos.add(entrada.next());
          break;

        case 2:
          System.out.println("Informe o nome que deseja remover");
          contatinhos.remove(entrada.next());
          break;

        case 3:
          System.out.println("Totoal de: " + contatinhos.size() + " contatinhos!");
          break;

        case 4:
          int i=0; 
          for (String contato : contatinhos) {
            System.out.printf("\n%d - %s", i, contato);
            i++;
          } 
          break;
      }
    } while (op != 0);

    entrada.close();
  }
}
