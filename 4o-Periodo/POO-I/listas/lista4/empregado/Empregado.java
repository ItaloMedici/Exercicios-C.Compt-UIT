package listas.lista4.empregado;

import java.text.DecimalFormat;

import listas.lista4.pessoa.Pessoa;

/**
 * 3. Considere, como subclasse da classe Pessoa, a classe Empregado. Considere
 * que cada instância da classe Empregado tem, para além dos atributos que
 * caracterizam a classe Pessoa, os atributos codigoSetor (inteiro), salarioBase
 * (vencimento base) e imposto (porcentagem retida dos impostos). Implemente a
 * classe Empregado com métodos seletores e modificadores e um método
 * calcularSalario. Escreva um programa de teste adequado para a classe
 * Empregado. Existem métodos para realizar aumento de salário? Por valor ou
 * percentual?
 * 
 * @author Italo
 */

public class Empregado extends Pessoa {
  private int codigoSetor;
  private Double salarioBase;
  private float porcentagemImposto;

  public Empregado(String nome, int codigoSetor, Double salarioBase, float porcentagemImposto) {
    super(nome);
    this.codigoSetor = codigoSetor;
    this.salarioBase = salarioBase;
    setPorcentagemImposto(porcentagemImposto);
  }

  public Empregado(String nome, String endereço, String telefone, int codigoSetor, Double salarioBase,
      float porcentagemImposto) {
    super(nome, endereço, telefone);
    this.codigoSetor = codigoSetor;
    this.salarioBase = salarioBase;
    setPorcentagemImposto(porcentagemImposto);
  }

  public int getCodigoSetor() {
    return codigoSetor;
  }

  public void setCodigoSetor(int codigoSetor) {
    this.codigoSetor = codigoSetor;
  }

  public Double getSalarioBase() {
    return salarioBase;
  }

  public void setSalarioBase(Double salarioBase) {
    this.salarioBase = salarioBase;
  }

  public float getImposto() {
    return porcentagemImposto;
  }

  public void setPorcentagemImposto(float porcentagemImposto) {
    if (porcentagemImposto < 100 && porcentagemImposto > 0) {
      this.porcentagemImposto = porcentagemImposto;
    }
  }

  public Double calcularSalario() {
    return salarioBase * (1 - (porcentagemImposto / 100));
  }

  /**
   * Aumenta o salario base por valor
   * 
   * @param valor
   */
  public void aumentarSalarioBase(Double valor) {
    if (valor > 0d && valor != null) {
      this.salarioBase += valor;
    }
  }

  /**
   * Aumenta o salario base por porcentagem
   * 
   * @param porcentagem
   */
  public void aumentarSalarioBase(Float porcentagem) {
    if (porcentagem > 0 && porcentagem != null) {
      this.salarioBase *= ((porcentagem + 100) / 100);
    }
  }

  @Override
  public String toString() {
    return super.toString() 
      + "\nCodigo Setor: " + codigoSetor 
      + ", Salario Base: " + salarioBase 
      + ", Imposto: " + new DecimalFormat("#,##0.00").format(porcentagemImposto) + "%"
      + ", Salario Líquido: " + new DecimalFormat("¤#,##0.00;¤-#,##0.00").format(calcularSalario());
  }

}
