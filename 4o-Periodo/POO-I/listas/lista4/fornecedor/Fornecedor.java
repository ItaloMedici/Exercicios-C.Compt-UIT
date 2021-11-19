package listas.lista4.fornecedor;

import listas.lista4.pessoa.Pessoa;

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
 * 
 * @author Italo
 */

public class Fornecedor extends Pessoa {
  private Double limiteCredito;
  private Double valorDivida;

  public Fornecedor(String nome, Double limiteCredito) {
    super(nome);
    setLimiteCredito(limiteCredito);
    this.valorDivida = 0d;
  }

  public Fornecedor(String nome, String endereço, String telefone, Double limiteCredito) {
    super(nome, endereço, telefone);
    this.limiteCredito = limiteCredito;
    this.valorDivida = 0d;
  }

  public Double getLimiteCredito() {
    return limiteCredito;
  }

  public void setLimiteCredito(Double limiteCredito) {
    if (limiteCredito > 0) {
      this.limiteCredito = limiteCredito;
    }
  }

  public Double getValorDivida() {
    return valorDivida;
  }

  public void setValorDivida(Double valorDivida) {
    if (this.valorDivida + valorDivida > limiteCredito) return;
  
    this.valorDivida += valorDivida;
  }

  public Double obterSaldoRestante() {
    return limiteCredito - valorDivida;
  }

}
