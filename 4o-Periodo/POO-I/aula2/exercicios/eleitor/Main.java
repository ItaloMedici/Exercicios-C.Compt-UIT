package aula2.exercicios.eleitor;

public class Main {
  public static void main(String[] args) {
    Eleitor e = new Eleitor("Italo", (short) 1, 10, 24);
    e.checarVotacao();
  }
}
