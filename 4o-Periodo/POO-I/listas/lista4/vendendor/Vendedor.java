package listas.lista4.vendendor;

import listas.lista4.empregado.Empregado;

/**
 * 6. Implemente a classe Vendedor como subclasse da classe Empregado. Um
 * determinado vendedor tem como atributos, para além dos atributos da classe
 * Pessoa e da classe Empregado, o atributo valorVendas (correspondente ao valor
 * monetário dos artigos vendidos) e o atributo comissao (porcentagem do
 * valorVendas que será adicionado ao vencimento base do Vendedor). Note que
 * deverá redefinir nesta subclasse o método herdado calcularSalario (o salário
 * de um vendedor é equivalente ao salário de um empregado usual acrescido da
 * referida comissão). Escreva um programa de teste adequado para esta classe.
 */

public class Vendedor extends Empregado {
  private Double valorVendas;
  private Double comissao;

  public Vendedor(String nome, int codigoSetor, Double salarioBase, float porcentagemImposto, Double valorVendas) {
    super(nome, codigoSetor, salarioBase, porcentagemImposto);
    this.valorVendas = valorVendas;
    setComissao();
  }

  public Vendedor(String nome, String endereço, String telefone, int codigoSetor, Double salarioBase,
      float porcentagemImposto, Double valorVendas) {
    super(nome, endereço, telefone, codigoSetor, salarioBase, porcentagemImposto);
    this.valorVendas = valorVendas;
    setComissao();
  }

  public Double getValorVendas() {
    return valorVendas;
  }

  public void setValorVendas(Double valorVendas) {
    this.valorVendas = valorVendas;
  }

  public Double getComissao() {
    return comissao;
  }

  

  public void setComissao() {
    this.comissao = valorVendas / 100;
  }

  @Override
  public Double calcularSalario() {
    return super.calcularSalario() * (1 + comissao); 
  }
}
