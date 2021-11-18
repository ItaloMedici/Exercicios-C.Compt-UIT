package listas.lista4;

/**
 * Considere, como subclasse da classe Pessoa (desenvolvida no exercício
 * anterior) a classe Fornecedor. Considere que cada instância da classe
 * Fornecedor tem, para além dos atributos que caracterizam a classe Pessoa, os
 * atributos LimiteCredito (correspondente ao crédito máximo atribuído ao
 * fornecedor) e valorDivida (montante da dívida para com o fornecedor).
 * Implemente na classe Fornecedor, para além dos usuais métodos seletores e
 * modificadores, um método ObterSaldoRestante() que devolve quanto ainda se
 * pode comprar à prazo com o fornecedo. Depois de implementada a classe
 * Fornecedor, crie um programa de teste adequado que lhe permita verificar o
 * funcionamento dos métodos implementados na classe Fornecedor e os herdados da
 * classe Pessoa. Os métodos get e set são adequados? O valor da Dívida deve ser
 * alterado ou incrementado? Pense nestas situações neste e nos demais
 * exercícios.
 */

public class Fornecedor extends Pessoa {
  private Double limiteCreditor;
  private Double valorDivida;

  public Fornecedor(String nome, Double limiteCreditor) {
    super(nome);
    this.limiteCreditor = limiteCreditor;
    this.valorDivida = 0d;
  }
  public Fornecedor(String nome, String endereço, String telefone, Double limiteCreditor) {
    super(nome, endereço, telefone);
    this.limiteCreditor = limiteCreditor;
    this.valorDivida = 0d;
  }
  public Double getLimiteCreditor() {
    return limiteCreditor;
  }
  public void setLimiteCreditor(Double limiteCreditor) {
    if (limiteCreditor > 0) {
      this.limiteCreditor = limiteCreditor;
    }
  }
  public Double getValorDivida() {
    return valorDivida;
  }
  public void setValorDivida(Double valorDivida) {
    this.valorDivida += valorDivida;
  }

}
