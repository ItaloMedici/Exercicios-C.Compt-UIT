package listas.lista4.empregado;

public class testaEmpregado {
  public static void main(String[] args) {
    Empregado emp = new Empregado("italo", "Itauna", "999", 2, 1000d, 42);

    System.out.println(emp.toString());

    emp.aumentarSalarioBase(50f);

    System.out.println(emp.toString());

  }

}
