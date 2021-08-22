package aula2.exercicios.trabalhador;

/*
 * Crie a classe Trabalhador com os atributos matrícula, nome e salário. Crie uma outra classe
 * com o método main e peça ao usuário para cadastrar 3 trabalhadores. Lembre-se que ninguém
 * pode ganhar menos que um salário mínimo. 
 */

public class Trabalhador {
  private String matricula;
  private String nome;
  private Double salario;

  private final Double salarioMinimo = 1147d;

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Double getSalario() {
    return salario;
  }

  public void setSalario(Double salario) {
    if(salario >= salarioMinimo) {
      this.salario = salario;
    } else {
      System.out.println("Salário inferior ao salario mínimo.");
    }
  }
  
  public void printTrabalhador() {
    System.out.println(""
      +"\nMatrícula: " + matricula
      +"\nNome: " + nome
      +"\nSalário: R$" + salario
    );
  }

  public Trabalhador() {
    this.matricula = "";
    this.nome = "";
    this.salario = salarioMinimo;
  }

  public Trabalhador(String matricula, String nome, Double salario) {
    this();
    this.matricula = matricula;
    this.nome = nome;
    setSalario(salario);
  }
  
}
