package aula1510.aluno;

/**
 * Crie uma classe aluno com atributos e métodos a sua escolha, mas que um deles
 * seja a nota do aluno no semestre e outro seja o sexo do aluno, que somente
 * poderá ser Masculino ou Feminino (Você deverá utilizar obrigatoriamente tipos
 * enumerados). 
 *  
 * @author Italo
 */

public class Aluno {
  private Long identificador;
  private String nome;
  private Sexo sexo;
  private Double notaSemestre;
  private static long count = 1;
  
  public Aluno(String nome, Sexo sexo, Double notaSemestre) {
    setIdentificador(count);
    this.nome = nome;
    this.sexo = sexo;
    this.notaSemestre = notaSemestre;
    count++;
  }

  public Long getIdentificador() {
    return identificador;
  }

  private void setIdentificador(Long identificador) {
    this.identificador = identificador;
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

  public Double getNotaSemestre() {
    return notaSemestre;
  }

  public void setNotaSemestre(Double notaSemestre) {
    this.notaSemestre = notaSemestre;
  }

  @Override
  public String toString() {
    return  "ID: " + identificador + ", nome: " + nome + ", sexo: " + sexo.getDescricao() + ", nota: " + notaSemestre;
  }

  
}
