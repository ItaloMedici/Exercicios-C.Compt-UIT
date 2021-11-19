package listas.lista4.operario;

import listas.lista4.empregado.Empregado;

/**
 * 
 * 5. Implemente a classe Operario como subclasse da classe Empregado. Um
 * determinado operário tem como atributos, para além dos atributos da classe
 * Pessoa e da classe Empregado, o atributo valorProducao (que corresponde ao
 * valor monetário dos artigos efetivamente produzidos pelo operário) e comissao
 * (que corresponde à porcentagem do valorProducao que será adicionado ao
 * vencimento base do operário). Note que deverá redefinir nesta subclasse o
 * método herdado calcularSalario (o salário de um operário é equivalente ao
 * salário de um empregado usual acrescido da referida comissão). Escreva um
 * programa de teste adequado para esta classe.
 * 
 * @author Italo
 */

public class Operario extends Empregado {
  private Double valorProducao;
  private Double comissao;

  public Operario(String nome, int codigoSetor, Double salarioBase, float porcentagemImposto, Double valorProducao,
      Double comissao) {
    super(nome, codigoSetor, salarioBase, porcentagemImposto);
    this.valorProducao = valorProducao;
    setComissao();
    this.setSalarioBase(salarioBase);
  }

  public Operario(String nome, String endereço, String telefone, int codigoSetor, Double salarioBase,
      float porcentagemImposto, Double valorProducao, Double comissao) {
    super(nome, endereço, telefone, codigoSetor, salarioBase, porcentagemImposto);
    this.valorProducao = valorProducao;
    setComissao();
    this.setSalarioBase(salarioBase + this.comissao);
    
  }

  public Double getValorProducao() {
    return valorProducao;
  }

  public void setValorProducao(Double valorProducao) {
    this.valorProducao = valorProducao;
  }

  public Double getComissao() {
    return comissao;
  }

  private void setComissao() {
    this.comissao = valorProducao / 100;
  }


}
