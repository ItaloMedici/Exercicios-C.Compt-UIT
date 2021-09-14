package listas.lista2.Eleitor;

/**
 * Crie a classe Eleitor com os atributos idade, sexo, nome e numero do título.
 * Faça um método que retorne se a pessoa é Obrigada, Desobrigada ou impedida de
 * votar. Crie outra classe para testar.
 */

public class Eleitor {
  private Integer idade;
  private String nome;
  private Short sexo;
  private String numeroTitulo;

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

  public String getTitulo() {
    return numeroTitulo;
  }

  public void setnumeroTitulo(String numeroTitulo) {
    this.numeroTitulo = numeroTitulo;
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


  public String checarVotacao() {
    if(idade >= 16){
      if(idade >= 18 && idade <= 65) {
        return("Voto obrigatório!");
      } else {
        return("Pode votar, porém sem obrigação!");
      }
    } else {
      return("Não pode votar ainda, aguarde mais " + difAge() + (difAge() > 1 ? " anos." : " ano."));
    }
  }

  public Integer difAge() {
    return idadeMinima - idade;
  }
    
  @Override
  public String toString() {
    return ""
      + "\nNome: " + nome 
      + "\nIdade: " + idade 
      + "\nNumero titulo: " + numeroTitulo 
      + "\nSexo: " + (sexo == 1 ? "Masculino" : "Feminino") 
      + "\nSituacao: " +  checarVotacao();
  }

  public Eleitor() {
    this.nome = "";
    this.idade = 0;
    this.sexo = 0;
    this.numeroTitulo = "";
  }

  public Eleitor(String nome, Short sexo, Integer idade, String numeroTitulo) {
    this();
    this.nome = nome;
    setSexo(sexo);
    setIdade(idade);
    this.numeroTitulo = numeroTitulo;
  } 
}
