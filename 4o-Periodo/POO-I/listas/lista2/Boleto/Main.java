package listas.lista2.Boleto;

import java.util.Date;

public class Main {
  public static void main(String[] args) {
    Boleto b1 = new Boleto(new Date("2021/05/01"), 2500d, 500d, "Italo");

    System.out.println(b1.toString());

    b1.pagar();

    System.out.println(b1.toString());

  }
}
