package aula5.televisao;

import java.util.Scanner;

public class Main {
  private static Scanner s = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("Marca da Tv: ");
    String marcaTv = s.nextLine();

    System.out.println("Volume Máximo: ");
    Double volumeMaximo = s.nextDouble();

    System.out.println("Quantidade de canais: ");
    Integer quantidadeCanais = s.nextInt();

    Televisao tv = new Televisao(volumeMaximo, quantidadeCanais, marcaTv);
    
    menu(tv);
  }

  public static void menu(Televisao tv) {
    int resposta = 1;

    do {
      System.out.println(tv.toString());

      System.out.println("\tMenu"
        + "\n1 - Ligar televisao" 
        + "\n2 - Desligar televisao" 
        + "\n3 - Subir Canal" 
        + "\n4 - Descer Canal" 
        + "\n5 - Pesquisar Canal" 
        + "\n6 - Aumentar volume" 
        + "\n7 - Abaixar volume" 
        + "\n0 - Sair do Menu" 
        + "\n Resposta: "  
      );
      
      resposta = s.nextInt();
      
      switch (resposta) {
        case 1: 
          tv.ligarTv();
          break;
        case 2:
          tv.desligarTv();
          break;
        case 3:
          tv.subirCanal();
          break;
        case 4:
          tv.descerCanal();
          break;
        case 5:
          System.out.println("Digite o canal");
          Integer canal = s.nextInt();
          tv.procurarCanal(canal);
          break;
        case 6:
          tv.aumentarVolume();
          break;
        case 7:
          tv.abaixarVolume();
          break;
        case 0:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("Opção errada");
          break;
      }
    } while (resposta != 0);
  }
}
