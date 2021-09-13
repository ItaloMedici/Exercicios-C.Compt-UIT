package listas.lista2.Trabalhador;

import java.text.DecimalFormat;

/**
 * Crie a classe Trabalhador com os atributos matrícula, nome e salário. Crie
 * uma outra classe com o método main e peça ao usuário para cadastrar 3
 * trabalhadores. Lembre-se que ninguém pode ganhar menos que um salário mínimo.
 */

public class Trabalhador {
  private String nome;
  private String matricula;
  private Double salario;

  private final Double salarioMinimo = 1100d;

  public String getNome() {
    return nome;
  }

  private void setNome(String nome) {
    this.nome = nome;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public Double getSalario() {
    return salario;
  }

  public void setSalario(Double salario) {
    if (salario < salarioMinimo) {
      this.salario = salarioMinimo;
      return;
    }
    this.salario = salario;
  }

  public String getSalarioFormatado() {
    return new DecimalFormat("¤#,##0.00;¤-#,##0.00").format(salario);
  }

  public Trabalhador(String nome, String matricula, Double salario) {
    setNome(nome);
    this.matricula = matricula;
    setSalario(salario);
  }

  @Override
  public String toString() {
    return 
      "\nNome: " + nome 
      + "\nMatricula: " + matricula 
      + "\nSalario: " + getSalarioFormatado(); 
  }
}
