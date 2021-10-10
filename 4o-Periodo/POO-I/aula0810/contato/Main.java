package aula0810.contato;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  static Scanner s = new Scanner(System.in);
  static ArrayList<Contato> contatos = new ArrayList<>();
  private static int length;

  public static void main(String[] args) {
    int option = 0;
    do {
      menu();
      option = s.nextInt();
      handleOption(option);
    } while (option != 0);

    s.close();
  }

  public static void menu() {
    System.out.print("\n\tCONTATOS MENU"
      + "\n1 - Adicionar"
      + "\n2 - Remover"
      + "\n3 - Listar"
      + "\n4 - Listar INATIVOS"  
      + "\n5 - Ativar contato"
      + "\n6 - Bloquear contato"
      + "\n7 - Pesquisar por nome"
      + "\n8 - Listar por cidade"
      + "\n9 - Limpar agenda"
      + "\n0 - Sair"
      + "\nR: "
    );
  }

  private static void handleOption(int option) {
    final short ativo = 1;
    final short inativo = 0;

    switch (option) {
      case 0: 
        break;
      case 1:
        createContato();
        break;
      case 2: 
        removerContato();
        break;
      case 3:
        listarContatos(ativo);
        break;
      case 4: 
        listarContatos(inativo);
        break;
      case 6:
        bloquearContato();
        break;
      case 7:
        pesquisarPorNome();
        break;
      case 8:
        listarPorCidade(); 
        break;
      case 9:
        limparAgenda();
        break;
      default:
        break;
    }
  }

  private static void createContato() {
    String nome, telefone, cidade = "";

    System.out.print("\n\tAdicionando novo contato");
    System.out.print("Nome: ");
    nome = s.nextLine();

    do {
      // Nr. celular devem possuir 11 digitos (22) 55555-4444
      // Nr. telefone devem possuir 10 digitos (22) 4444-4444
      System.out.print("Telefone: ");
      telefone = s.nextLine();
    } while ( telefone.length() != 11 && telefone.length() != 10 );

    System.out.print("Cidade: ");
    nome = s.nextLine();

    contatos.add(new Contato(nome, telefone, cidade));
  }

  private static void removerContato() {
    int tipoPesquisa = 0;

    System.out.println("\n\nRemover por: "
      + "\n1 - ID Contato"
      + "\n2 - Nome"
      + "\n3 - Telefone"
      + "\nR.: "
      );
    tipoPesquisa = s.nextInt();

    Contato aux = searchContato(tipoPesquisa);

    if (!aux.equals(null)) {
      contatos.remove(aux);
    } else {
      System.out.println("Contato não encontrado!");
    }
  }

  private static void listarContatos(short ativoInativo) {
    for (Contato c : contatos) {
      if (ativoInativo == 1 && c.isAtivo()) {
        System.out.println(c.toString());
      } else if (ativoInativo == 0 && !c.isAtivo()){
        System.out.println(c.toString());
      }
    }
  }

  private static void bloquearContato() {
    int tipoPesquisa = 0;

    System.out.println("\n\nBloquear por: "
      + "\n1 - ID Contato"
      + "\n2 - Nome"
      + "\n3 - Telefone"
      + "\nR.: "
      );

      tipoPesquisa = s.nextInt();

      Contato aux = searchContato(tipoPesquisa);

      if (!aux.equals(null)) {
        int index = contatos.indexOf(aux);
        contatos.get(index).bloquear();
      } else {
        System.out.println("Contato não encontrado!");
      }
  }

  private static void pesquisarPorNome() {
    int byName = 2;
    Contato aux = searchContato(byName);
    System.out.println(aux.toString());
  }

  private static void listarPorCidade() {
    System.out.print("\nNome Cidade: ");
    String cidade = s.nextLine();

    for (Contato c : contatos) {
      if (c.getCidade().equalsIgnoreCase(cidade)) {
        System.out.println(c.toString());
      }
    }
  }

  private static void limparAgenda() {
    contatos.clear();
  }

  private static Contato searchContato(int tipoPesquisa) {
    Contato contato = null;
    switch (tipoPesquisa) {
      case 1:
        contato = getContatoById();
        break;

      case 2: 
        contato = getContatoByname();
        break;
      
      case 3: 
        contato = getContatoByTelefone();
        break;
    }
    return contato;
  }

  private static Contato getContatoById() {
    System.out.print("\nID Contato: ");
    long id = s.nextLong();

    for (Contato c : contatos) {
      if (c.getIdentificador() == id) {
        return c;
      }
    }

    return null;
  }

  private static Contato getContatoByname() {
    System.out.print("\nNome Contato: ");
    String nome = s.nextLine();

    for (Contato c : contatos) {
      if (c.getNome().equalsIgnoreCase(nome)) {
        return c;
      }
    }

    return null;
  }

  private static Contato getContatoByTelefone() {
    System.out.print("\nTelefone: ");
    String telefone = s.nextLine();

    for (Contato c : contatos) {
      if (c.getTelefone().equalsIgnoreCase(telefone)) {
        return c;
      }
    }

    return null;
  }

}
