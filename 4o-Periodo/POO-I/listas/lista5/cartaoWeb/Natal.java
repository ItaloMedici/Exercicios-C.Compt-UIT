package listas.lista5.cartaoWeb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Natal extends CartaoWeb {
  
  private LocalDate dataNatal;
  
  public Natal(String destinatario, int ano) {
    setDataNatal(ano);
    this.destinatario = destinatario;
  }

  public LocalDate getDataNatal() {
    return dataNatal;
  }

  public void setDataNatal(int ano) {
    this.dataNatal = LocalDate.of(ano, 12, 25);
    
  }

  @Override
  public void showMessage() {
    System.out.println(dataNatal.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - Feliz Natal " + destinatario + "!");
   
  }

  
}
