package listas.lista2.Eleitor;

public class Main {
  public static void main(String[] args) {
    Eleitor eletor1 = new Eleitor("Italo", (short) 1, 10, "24");
    Eleitor eletor2 = new Eleitor("Médici", (short) 0, 20, "ZZZZDSSD");
    
    System.out.println(eletor1.toString());
    System.out.println(eletor2.toString());
  }
}
