package listas.lista5.cartaoWeb;

/**
 * Escreva uma classe abstrata chamada CartaoWeb. Essa classe representa todos
 * os tipos de cartões web e conterá apenas um atributo: destinatario (tipo
 * String). Nessa classe você deverá também declarar o método public abstract
 * void showMessage(). Crie classes filhas da classe CartaoWeb: DiaDosNamorados,
 * Natal, Aniversario. Cada uma dessas classes deve conter um método construtor
 * que receba o nome do destinatário do cartão. Cada classe também deve
 * implementar o método showMessage(), mostrando uma mensagem ao usuário com seu
 * nome e que seja específica para a data de comemorativa do cartão. Escreva um
 * programa e no método main crie um array de CartaoWeb. Insira instâncias dos 3
 * tipos de cartões neste array. Após, use um laço for para exibir as mensagens
 * deste cartão chamando o método showMessage().Em que linha(s) acontece
 * polimorfismo nesse código?
 */

public abstract class CartaoWeb {
  protected String destinatario;

  public abstract void showMessage();
}
