package listas.lista4.administrador;

import listas.lista4.empregado.Empregado;

/**
 * 4. Implemente a classe Administrador como subclasse da classe Empregado. Um
 * determinado administrador tem como atributos, para além dos atributos da
 * classe Pessoa e da classe Empregado, o atributo ajudaDeCusto (ajudas
 * referentes a viagens, estadias, ...). Note que deverá redefinir na classe
 * Administrador o método herdado calcularSalario (o salário de um administrador
 * é equivalente ao salário de um empregado usual acrescido das ajuda de custo).
 * Escreva um programa de teste adequado para esta classe.
 * 
 * @author Italo
 * 
 */

public class Administrador extends Empregado {
  private Double ajudaCusto;

  public Administrador(String nome, int codigoSetor, Double salarioBase, float porcentagemImposto, Double ajudaCusto) {
    super(nome, codigoSetor, salarioBase, porcentagemImposto);
    this.ajudaCusto = ajudaCusto;
  }

  public Administrador(String nome, String endereço, String telefone, int codigoSetor, Double salarioBase,
      float porcentagemImposto, Double ajudaCusto) {
    super(nome, endereço, telefone, codigoSetor, salarioBase, porcentagemImposto);
    this.ajudaCusto = ajudaCusto;
  }

  public Double getAjudaCusto() {
    return ajudaCusto;
  }

  public void setAjudaCusto(Double ajudaCusto) {
    if (ajudaCusto > 0d) {
      this.ajudaCusto = ajudaCusto;
    } 
  }

  @Override
  public Double calcularSalario() {
    return super.calcularSalario() + ajudaCusto;
  }
  
}
