package aula4.exercicios.celular;

import java.util.Scanner;

public class Main {
  static Scanner s = new Scanner(System.in);

  public static void main(String[] args) {
    // System.out.println("Modelo do Celular: ");
    // String modelo = s.nextLine();

    Celular celular = new Celular("xsxs");
    Celular celular2 = new Celular("xiaomi");
    Celular celular3 = new Celular("lolu");

    System.out.println(Celular.mostraQtdeCelulares());
    System.out.println(celular.idCelular);
    System.out.println(celular2.idCelular);
    System.out.println(celular3.idCelular);

    //menu(celular);
  }

  public static void menu(Celular celular) {
    int resposta = 1;

    do {
      celular.printCelular();

      System.out.println("\tMenu" 
        + "\n1 - Ligar celular" 
        + "\n2 - Desligar celular" 
        + "\n3 - Carregar"
        + "\n4 - Carregar completamente" 
        + "\n5 - Aumentar volume" 
        + "\n6 - Abaixar volume"
        + "\n7 - Jogar Par ou Impar" 
        + "\n8 - Jogar Pedra, Papel e Tesoura " 
        + "\n0 - Sair do Menu"
        + "\n Resposta: ");

      resposta = s.nextInt();

      switch (resposta) {
        case 1:
          celular.ligar();
          break;
        case 2:
          celular.desligar();
          break;
        case 3:
          celular.carregarBateria();
          break;
        case 4:
          celular.carregarCompletamente();
          break;
        case 5:
          celular.aumentarVolume();
          break;
        case 6:
          celular.diminuirVolume();
          break;
        case 7:
          celular.jogarParImpar();
          break;
        case 8:
          System.out.println("\n\tJOGO \nEscolha [0 - Pedra | 1 - Papel | 2 - Tesoura]: ");
          int jogada = s.nextInt();
          celular.jogarPapelTesoura(jogada);
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
