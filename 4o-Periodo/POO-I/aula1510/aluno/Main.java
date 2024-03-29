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

  private static void handleOptionSalas(int option, ArrayList<Sala> salas) {
    String codSala;

    switch(option) {
      case 1:
        System.out.print("Código da sala: ");
        clearBuffer();
        codSala = s.nextLine();

        salas.add(new Sala(codSala));

        System.out.println("Sala " + codSala + " adicionada!");
        break;

      case 2:
        System.out.print("Código da sala a ser removida: ");
        clearBuffer();
        codSala = s.nextLine();

        for (Sala s : salas) {
          if (s.getCodigoSala().equalsIgnoreCase(codSala)) {
            salas.remove(s);
            break;
          }
        }

        System.out.println("Sala não encontrada");
        break;

      case 3:
        for (Sala s : salas) {
          System.out.println(s.listarSala());
        }
        break;

      case 4:
        System.out.print("Código da sala que ira entrar: ");
        clearBuffer();
        codSala = s.nextLine();

        int optionSala = 0;
        do {
          menuAlunos(codSala);
          optionSala = s.nextInt();
          handleOptionAlunos(optionSala, findSala(salas, codSala));
        } while (optionSala != 0);
    }
  }

  public static void menuAlunos(String codSala ) {
    System.out.print("\n\tSala " + codSala
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

  private static void handleOptionAlunos(int optionSala, Sala sala) {
    switch(optionSala) {
      case 1:
        System.out.print("Nome do Aluno: ");
        clearBuffer();
        String nome = s.nextLine();

        short sexo;
        do {
          System.out.print("Sexo do Aluno [ " 
            + Sexo.FEMININO.getValue() + " - " + Sexo.FEMININO.getDescricao() + "/ "
            + Sexo.MASCULINO.getValue() + " - " + Sexo.MASCULINO.getDescricao() + "]");
          sexo = s.nextShort();
        } while (sexo < 0 || sexo > 1);

        Sexo EnumSexo = sexo == Sexo.FEMININO.getValue() ? Sexo.FEMININO : Sexo.MASCULINO;

        System.out.print("Nota do semestre: ");
        Double notaSemestre = s.nextDouble();

        Aluno aluno = new Aluno(nome, EnumSexo, notaSemestre);
        sala.adicionarAluno(aluno);    

        break;
      
      case 2:
        System.out.print("\nRemover aluno por:\n1 - ID\n2 - Nome\n0 - Sair\nR: ");
        short optionRemove = s.nextShort();

        switch (optionRemove) {
          case 1: 
            System.out.print("ID do Aluno: ");
            long idAluno = s.nextLong();

            for (Aluno a : sala.getAlunos()) {
              if (a.getIdentificador().equals(idAluno)) {
                sala.removerAluno(a);
                System.out.println(a.getNome() + ", removido da sala!");
                break;
              }
            }
            System.out.println("Aluno não encontrado na sala!");
            break;

          case 2:
            System.out.print("Nome do Aluno: ");
            clearBuffer();
            String nomeAluno = s.nextLine();

            for (Aluno a : sala.getAlunos()) {
              if (a.getNome().equalsIgnoreCase(nomeAluno)) {
                sala.removerAluno(a);
                System.out.println(a.getNome() + ", removido da sala!");
                break;
              }
            }
            System.out.println(nomeAluno + ", não encontrado na sala!");
            break;

          default:
            break;
        }
        break;

      case 3:
        for (Aluno a : sala.getAlunos()) {
          System.out.println(a.toString());
        }
        break;
      
      case 4:
        Aluno melhorAluno = sala.getMelhorAluno();

        if (melhorAluno != null) {
          System.out.println("Melhor aluno\n" + melhorAluno.toString());
          break;
        }

        System.out.println("Sala vazia");
        break;

      case 5:
        System.out.print("\nEncontrar aluno por:\n1 - ID\n2 - Nome\n0 - Sair\nR: ");
        short optionFind = s.nextShort();

        switch(optionFind) {
          case 1: 
          System.out.print("ID do Aluno: ");
          long idAluno = s.nextLong();

          System.out.println(sala.encontrarAlunoPeloId(idAluno) ? "Aluno esta presente" : "Aluno não encontrado na sala!");

          break;

        case 2:
          System.out.print("Nome do Aluno: ");
          clearBuffer();
          String nomeAluno = s.nextLine();

          System.out.println(sala.encontrarAlunoPeloNome(nomeAluno) ? "Aluno esta presente" : "Aluno não encontrado na sala!");

          break;

        default:
          break;
        }
      break;
      case 6:
        sala.esvaziarSala();
        break;
      
      default:
        break;
    }
  }

  private static Sala findSala(ArrayList<Sala> salas, String codigo) {
    for (Sala s : salas) {
      if (s.getCodigoSala().equalsIgnoreCase(codigo)) {
        return s;
      }
    }
    return null;
  }

  private static void clearBuffer() {
    if (s.hasNextLine()) {
      s.nextLine();
    }
  }
}
