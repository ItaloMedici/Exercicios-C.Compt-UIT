package aula2.exercicios.trabalhador;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static Scanner entrada;

  public static void main(String[] args) {
    entrada = new Scanner(System.in);

    List<Trabalhador> dados = new ArrayList<>();

    for(int i=0; i<3; i++) {
      System.out.println("\nMatricula: ");
      String matricula =  entrada.next();

      System.out.println("Nome: ");
      String nome = entrada.next();

      System.out.println("Salário: ");
      Double salario = entrada.nextDouble();

      Trabalhador t = new Trabalhador(matricula, nome, salario);

      dados.add(t);
    }

    for(Trabalhador t : dados) {
      t.printTrabalhador();
    }
  }
}
