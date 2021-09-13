package listas.lista2.Trabalhador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    List<Trabalhador> trabalhadores = new ArrayList<>();
    Scanner s = new Scanner(System.in);
  
    for(int i=0; i<3; i++) {
      System.out.println("\tTrabalhador " + (i+1));
  
      System.out.println("Nome");
      String nome = s.nextLine();
  
      System.out.println("Matricula");
      String matricula = s.nextLine();
  
      System.out.println("Salario");
      Double salario = s.nextDouble();
  
      trabalhadores.add(new Trabalhador(nome, matricula, salario));
    }

    trabalhadores.forEach(t -> System.out.println(t.toString()));

    s.close();
  }
}
