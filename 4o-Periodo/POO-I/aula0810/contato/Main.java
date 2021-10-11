package aula0810.contato;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  static Scanner s = new Scanner(System.in);
  static ArrayList<Contato> contatos = new ArrayList<>();

  //Constants
  static short ativo = 1;
  static short inativo = 0;

  public static void main(String[] args) {
    Contato c1 = new Contato("Italo", "12345678910", "Itauna");
    Contato c2 = new Contato("Medici", "12345678910", "Itauna");
    Contato c3 = new Contato("Silva", "12345678910", "Itauna");

    contatos.add(c1);
    contatos.add(c2);
    contatos.add(c3);

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
      case 5:
        ativarContato();
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

    System.out.print("\n\tAdicionando novo contato\n");
    System.out.print("Nome: ");
    clearBuffer();
    nome = s.nextLine();

    do {
      // Nr. celular devem possuir 11 digitos (22) 55555-4444
      // Nr. telefone devem possuir 10 digitos (22) 4444-4444
      System.out.print("Telefone: ");
      telefone = s.nextLine();
    } while ( telefone.length() != 11 && telefone.length() != 10 );

    System.out.print("Cidade: ");
    cidade = s.nextLine();

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

    if (aux != null) {
      contatos.remove(aux);
      System.out.println(aux.getNome() + ", removido!");
    } else {
      System.out.println("Contato não encontrado!");
    }
  }

  private static void listarContatos(short ativoInativo) {
    System.out.println("\n\tAGENDA DE " + (ativoInativo == ativo ? "ATIVOS" : "BLOQUADOS"));
    for (Contato c : contatos) {
      if (ativoInativo == ativo && c.isAtivo()) {
        System.out.println(c.toString());
      } else if (ativoInativo == inativo && !c.isAtivo()){
        System.out.println(c.toString());
      }
    }
  }

  private static void ativarContato() {
    int tipoPesquisa = 0;

    System.out.println("\n\nAtivar por: "
      + "\n1 - ID Contato"
      + "\n2 - Nome"
      + "\n3 - Telefone"
      + "\nR.: "
      );

      tipoPesquisa = s.nextInt();

      Contato aux = searchContato(tipoPesquisa);

      if (aux != null && !aux.isAtivo()) {
        int index = contatos.indexOf(aux);
        contatos.get(index).desbloquear();
        System.out.println(aux.getNome() + ", desbloquado!");
      } else {
        System.out.println("Contato não encontrado ou já ativo!");
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

      if (aux != null) {
        int index = contatos.indexOf(aux);
        contatos.get(index).bloquear();
        System.out.println(aux.getNome() + ", bloquado!");
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
    clearBuffer();
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
    clearBuffer();
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

  private static void clearBuffer() {
    if (s.hasNextLine()) {
        s.nextLine();
    }
  }
  
}
