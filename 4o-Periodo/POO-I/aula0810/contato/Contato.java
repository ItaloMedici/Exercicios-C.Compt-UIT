package aula0810.contato;

/**
 * classe Contato, que deverá ter o nome, o telefone e a cidade da pessoa, id
 * autoincremento e também um booleano ativo. Crie uma classe Testa que possui
 * um arrayList de contatos. Crie um menu para adicionar, remover, listar,
 * listar inativos, ativar contato, bloquear contato, buscar por nome, listar
 * por cidade, limpar agenda. Obs. Listar, listar por cidade e listar por nome
 * só devem exibir os ativos.
 */

public class Contato {
  private static long quantidade = 1;
  private long identificador;
  private String nome;
  private String telefone;
  private String cidade;
  private boolean ativo;

  public Contato(String nome, String telefone, String cidade) {
    this.nome = nome;
    this.cidade = cidade;
    this.telefone = telefone;
    desbloquear();
    identificador += quantidade;
    quantidade++;
  }

  public Contato() {
    nome = "";
    cidade = "";
    telefone = "";
    desbloquear();
  }

  public long getIdentificador() {
    return identificador;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public void bloquear() {
    ativo = false;
  }

  public void desbloquear() {
    ativo = true;
  }

  public boolean isAtivo() {
    return ativo;
  }

  public String formatarTelefone() {
    String telFormatted = telefone;

    telFormatted = telefone.length() == 11
        ? "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 7) + "-" + telefone.substring(7)
        : "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 6) + "-" + telefone.substring(6);

    return telFormatted;
  }

  @Override
  public String toString() {
    return identificador + " - " + nome + ", " + formatarTelefone() + ", " + cidade + " - "
        + (ativo ? "Ativo" : "Bloqueado");
  }

}
