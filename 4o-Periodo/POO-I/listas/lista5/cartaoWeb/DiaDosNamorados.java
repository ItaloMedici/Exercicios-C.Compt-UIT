package listas.lista5.cartaoWeb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DiaDosNamorados extends CartaoWeb{

  private LocalDate diaDosNamorados;
  
  public DiaDosNamorados(String destinatario, LocalDate diaDosNamorados) {
    this.diaDosNamorados = diaDosNamorados;
    this.destinatario = destinatario;
  }

  public LocalDate getdiaDosNamorados() {
    return diaDosNamorados;
  }

  public void setdiaDosNamorados(LocalDate diaDosNamorados) {
    this.diaDosNamorados = diaDosNamorados;
  }

  @Override
  public void showMessage() {
    System.out.println(diaDosNamorados.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - Feliz Dia dos Namorados " + destinatario + "!");
   
  }

}
