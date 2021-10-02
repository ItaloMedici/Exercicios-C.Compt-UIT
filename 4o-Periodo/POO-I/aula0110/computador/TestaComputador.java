package aula0110.computador;

import java.util.Scanner;

public class TestaComputador {
  static double qtdRamPermitida = 512;
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    Computador[] computadores = new Computador[3]; 

    for (int i=0; i<3; i++) {
      System.out.println("\nComputador nr " +  (i+1));

      System.out.print("Tamanho do HD em Gb: ");
      double tamanhoHD = s.nextDouble();

      System.out.print("Tamanho da RAM em Mb: ");
      double tamanhoRAM = s.nextDouble();

      System.out.print("Numero de processadores: ");
      int numeroProcessadores = s.nextInt(); 

      System.out.print("Nome do fabricante: ");
      String fabricante = s.next();

      computadores[i] = new Computador(tamanhoHD, tamanhoRAM, numeroProcessadores, fabricante);
    }

    for (Computador c : computadores ) {
      if (c.getTamanhoRAM() >= qtdRamPermitida) {
        System.out.println(c.toString());
      }
    }

    s.close();
  }
}
