package listas.lista5.cartaoWeb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aniversario extends CartaoWeb {

  private LocalDate diaComemorativo;

  public Aniversario(String destinatario, LocalDate diaComemorativo) {
    this.diaComemorativo = diaComemorativo;
    this.destinatario = destinatario;
  }

  public LocalDate getDiaComemorativo() {
    return diaComemorativo;
  }

  public void setDiaComemorativo(LocalDate diaComemorativo) {
    this.diaComemorativo = diaComemorativo;
  }

  @Override
  public void showMessage() {
    System.out.println(diaComemorativo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - Feliz Aniversário "
        + destinatario + "!");
  }

}
