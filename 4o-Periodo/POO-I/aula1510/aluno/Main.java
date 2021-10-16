package aula1510.aluno;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Crie uma classe de testes que deverá conter um menu para trabalhar com
 * salas e alunos. Adicionando, removendo, retornando o melhor aluno por
 * exemplo, etc.
 */

public class Main {
  static Scanner s = new Scanner(System.in);

  public static void main(String[] args) {
    ArrayList<Sala> salas = new ArrayList<>();

    int option = 0;
    do {
      menuSalas();
      option = s.nextInt();
      handleOptionSalas(option, salas);
    } while (option != 0);

    s.close();
  }

  private static void handleOptionSalas(int option, ArrayList<Sala> salas) {
    String codSala;
    switch(option) {
      case 1:
        System.out.print("Código da sala: ");
        codSala = s.nextLine();
        clearBuffer();

        salas.add(new Sala(codSala));

        System.out.println("Sala " + codSala + " adicionada!");
        break;

      case 2:
        System.out.print("Código da sala a ser removida: ");
        codSala = s.nextLine();

        for (Sala s : salas) {
          if (s.getCodigoSala().equalsIgnoreCase(codSala)) {
            salas.remove(s);
            break;
          }
        }

      case 3:
        
    }
  }

  public static void menuSalas() {
    System.out.print("\n\tESCOLA"
      + "\n1 - Adicionar Sala"
      + "\n2 - Remover Sala"
      + "\n3 - Listar Salas"
      + "\n4 - Entrar na sala" 
      + "\n0 - Sair"
      + "\nR: "
    );
  }

  public static void menuAlunos(String codSala ) {
    System.out.print("\n\tSala" + codSala
      + "\n1 - Adicionar Aluno"
      + "\n2 - Remover Aluno"
      + "\n3 - Listar Alunos"
      + "\n4 - Exibir melhor aluno"
      + "\n5 - Econtrar aluno na sala"
      + "\n6 - Esvaziar sala"
      + "\n0 - Sair"        
      + "\nR: "
    );
  }

  private static void clearBuffer() {
    if (s.hasNextLine()) {
        s.nextLine();
    }
  }
}
