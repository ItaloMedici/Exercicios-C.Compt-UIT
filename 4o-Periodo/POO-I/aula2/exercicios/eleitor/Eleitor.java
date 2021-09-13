package aula2.exercicios.eleitor;

/*
 * Crie a classe Eleitor com os atributos idade, sexo, nome e numero do título. Faça um
 * método que retorne se a pessoa é Obrigada, Desobrigada ou impedida de votar. Crie outra
 * classe para testar. 
*/

public class Eleitor {
  private String nome;
  private Short sexo;
  private Integer idade;
  private Integer titulo;

  private final Integer idadeMinima = 16;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public Integer getTitulo() {
    return titulo;
  }

  public void setTitulo(Integer titulo) {
    this.titulo = titulo;
  }

  public Short getSexo() {
    return sexo;
  }

  public void setSexo(Short sexo) {
    if(sexo == 1 || sexo == 0) {
      this.sexo = sexo;
    } else {
      System.out.println("Opção errada! 0 - Feminino / 1 - Masculino");
    }
  }

  // 16 -> 18 -> 65
  public void checarVotacao() {
    if(idade >= 16){
      if(idade >= 18 || idade <= 65) {
        System.out.println("Voto obrigatório!");
      } else {
        System.out.println("Pode votar, porém sem obrigação!");
      }
    } else {
      System.out.println("Não pode votar ainda, aguarde mais " + difAge() + (difAge() > 1 ? " anos." : " ano."));
    }
  }

  public Integer difAge() {
    return idadeMinima - idade;
  }

  public Eleitor() {
    this.nome = "";
    this.idade = 0;
    this.sexo = 0;
    this.titulo = 0;
  }

  public Eleitor(String nome, Short sexo, Integer idade, Integer titulo) {
    this.nome = nome;
    setSexo(sexo);
    setIdade(idade);
    this.titulo = titulo;
  } 
}
