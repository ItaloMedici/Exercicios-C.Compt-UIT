package listas.lista4.administrador;

public class testaAdmin {
  public static void main(String[] args) {
    Administrador a = new Administrador("italo", "Itauna", "999", 2, 1000d, 0, 100d);

    System.out.println(a.calcularSalario());
  }
}
