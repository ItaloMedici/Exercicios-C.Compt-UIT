package listas.lista6;

/**
 * A seguir, crie a classe Engenheiro que herda de Funcionario com as seguintes
 * propriedades, número do CREA;
 */

public class Engenheiro extends Funcionario {
  private int numero;
  private String crea;

  public Engenheiro(String nome, String endereco, String codigo, Double salario, int numero, String crea) {
    super(nome, endereco, codigo, salario);
    this.numero = numero;
    this.crea = crea;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getCrea() {
    return crea;
  }

  public void setCrea(String crea) {
    this.crea = crea;
  }

}
