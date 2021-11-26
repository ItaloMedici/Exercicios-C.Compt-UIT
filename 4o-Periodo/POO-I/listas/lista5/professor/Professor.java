package listas.lista5.professor;

import java.time.LocalDate;

/**
 * Criar a classe professor com atributos matricula, nome, sexo, dataNascimento,
 * dataContrato. Além dos métodos get e set, deverá conter um método que retorne
 * a quantidade de anos que falta para o professor se aposentar que deverá
 * considerar que para aposentar deve-se ter 65 anos de idade e 35 de atuação
 * para homens e 60 anos de idade e 30 de atuação para mulheres. Criar o método
 * abstrato salário que retorna quanto o professor recebe.
 * 
 * Criar a classe professor Dedicação Exclusiva que herda de professor e recebe
 * um salário fixo;
 * 
 * Criar a classe professor Horista que recebe um valor por hora trabalhada;
 * 
 * Criar a classe professor Visitante que herda de horista e tem o nome da
 * faculdade que ele está vinculado.
 * 
 * Criar a classe testaProfessor que contem uma coleção de professores. Insira
 * professores de todos os tipos e percorra esta coleção mostrando o nome e
 * salário de cada um deles.
 */

public abstract class Professor {
  private String matricula;
  private String nome;
  private Sexo sexo;
  private LocalDate dataNascimento;
  private LocalDate dataContrato;

  public Professor(String matricula, String nome, Sexo sexo, LocalDate dataNascimento, LocalDate dataContrato) {
    this.matricula = matricula;
    this.nome = nome;
    this.sexo = sexo;
    this.dataNascimento = dataNascimento;
    this.dataContrato = dataContrato;
  }

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

  public Sexo getSexo() {
    return sexo;
  }

  public void setSexo(Sexo sexo) {
    this.sexo = sexo;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public LocalDate getDataContrato() {
    return dataContrato;
  }

  public void setDataContrato(LocalDate dataContrato) {
    this.dataContrato = dataContrato;
  }

  public int getIdade() {
    return LocalDate.now().compareTo(dataNascimento);
  }

  public int getAnosDeTrabalho() {
    return LocalDate.now().compareTo(dataContrato);
  }

  public int getQuantiadesAnosParaAposentar() {
    int quantidade;
    int calcAnosTrabalho = 35 - getAnosDeTrabalho();
    int calcIdade = 65 - getIdade();

    quantidade = calcIdade > calcAnosTrabalho ? calcIdade : calcAnosTrabalho;

    if (Sexo.FEMININO.equals(this.sexo)) {
      quantidade -= 5;
    }

    return quantidade;
  }

  public abstract int getSalario();

}
