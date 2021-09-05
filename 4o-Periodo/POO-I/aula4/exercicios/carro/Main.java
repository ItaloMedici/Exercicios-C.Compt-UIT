import java.util.Scanner;

public class Main {
  static Scanner s = new Scanner(System.in);

  public static void main(String[] args) {
    
    System.out.println("Modelo do Carro: ");
    String modeloCarro = s.nextLine();

    System.out.println("Capacidade do tanque em litros: ");
    Double capacidadeTanque = s.nextDouble();

    System.out.println("Velocidade máxima permitida em Km: ");
    Double velociadeMaxima = s.nextDouble();

    System.out.println("Potência do motor: ");
    Double potenciaCarro = s.nextDouble();

    Carro c1 = new Carro(modeloCarro, capacidadeTanque, velociadeMaxima, potenciaCarro);
    
    menu(c1);
  }  

  public static void menu(Carro carro) {
    int resposta = 1;

    do {
      carro.printCarro();

      System.out.println("\tMenu"
        + "\n1 - Ligar carro" 
        + "\n2 - Desligar carro" 
        + "\n3 - Abastecer" 
        + "\n4 - Acelerar" 
        + "\n5 - Frear" 
        + "\n0 - Sair do Menu" 
        + "\n Resposta: "  
      );
      
      resposta = s.nextInt();
      
      switch (resposta) {
        case 1: 
          carro.ligar();
          break;
        case 2:
          carro.desligar();
          break;
        case 3:
          System.out.println("Quantidade de combustivel: ");
          carro.abastecer(s.nextDouble());
          break;
        case 4:
          carro.acelerar();
          break;
        case 5:
          carro.frear();
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
