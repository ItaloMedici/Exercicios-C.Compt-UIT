package listas.prova3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
  private static Scanner s = new Scanner(System.in);
  private static String file = "listas/prova3/data.txt";

  public static void main(String[] args) {
    int option = 0;
    do {
      menu();
      option = s.nextInt();
      handleOption(option);
    } while (option != 0);
  }

  public static void menu() {
    System.out.print("\n\t MENU" 
      + "\n1 - Adicionar pessoa" 
      + "\n2 - Mostra pessoas"
      + "\n3 - Buscar pessoa por id" 
      + "\n4 - Mostra pessoa acima do peso" 
      + "\n0 - Sair" 
      + "\nR: "
    );
  }

  private static void handleOption(int option) {
    switch (option) {
      case 1:
        System.out.print("Nome da pessoa: ");
        clearBuffer();
        String nome = s.nextLine();

        System.out.print("Altura: ");
        Double altura = s.nextDouble();

        System.out.print("Peso: ");
        Double peso = s.nextDouble();

        Pessoa p = new Pessoa(nome, altura, peso);

        try {
          BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
          bw.write(p.toString() + "\n");
          bw.close();
        } catch (IOException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        break;
      
      case 2:
        try {
          BufferedReader br = new BufferedReader(new FileReader(file));

          while (br.ready()) {
            String row = br.readLine();
            System.out.println(row);
          }
        } catch (FileNotFoundException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        break;

      case 3:
        System.out.print("ID da pessoa: ");
        int idPessoa = s.nextInt();

        try {
          BufferedReader br = new BufferedReader(new FileReader(file));

          while (br.ready()) {
            String row = br.readLine();
            String pessoa[] = row.split(", ");

            if (Integer.parseInt(pessoa[0]) == idPessoa) {
              System.out.println(row);
            }
          }
        } catch (FileNotFoundException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        break;

      case 4:
        try {
          BufferedReader br = new BufferedReader(new FileReader(file));

          while (br.ready()) {
            String row = br.readLine();
            String pessoa[] = row.split(", ");

            String nomeAux = pessoa[1];
            String alt = pessoa[2];
            String pesoAux = pessoa[3];

            Pessoa aux = new Pessoa(nomeAux, Double.parseDouble(alt), Double.parseDouble(pesoAux));
            System.out.println(aux.estaAcimaDoPeso() ? aux.toString() : "");
            
          }
        } catch (FileNotFoundException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        break;

    default:
      break;
    }
  }
  
  private static void clearBuffer() {
    if (s.hasNextLine()) {
      s.nextLine();
    }
  }
}
