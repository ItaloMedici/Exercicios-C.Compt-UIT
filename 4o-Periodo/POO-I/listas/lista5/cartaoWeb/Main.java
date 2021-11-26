package listas.lista5.cartaoWeb;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    
    ArrayList<CartaoWeb> cartoes = new ArrayList<>();

    Aniversario aniversarioCard = new Aniversario("Italo", LocalDate.parse("2021-09-09"));
    Natal natalCard = new Natal("Medici", 2016);
    DiaDosNamorados namoradosCard = new DiaDosNamorados("Italo", LocalDate.now());

    cartoes.add(aniversarioCard);
    cartoes.add(natalCard);
    cartoes.add(namoradosCard);

    for (CartaoWeb c : cartoes) {
      c.showMessage();
    }
  }
}
