package aula1510.aluno;

public enum Sexo {
  FEMININO((short) 1, "Feminino"), MASCULINO((short) 0, "Feminino");

  private short sexo;
  private String descricao;

  private Sexo(short sexo, String descricao) {
    this.sexo = sexo;
    this.descricao = descricao;
  }

  public short getValue() {
    return this.sexo;
  }

  public String getDescricao() {
    return this.descricao;
  }
}
