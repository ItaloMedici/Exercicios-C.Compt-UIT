package listas.prova2.produto;

public class Produto {
  private String nome;
  private Double qtdeAtual;
  private Double qtdeMinima;

  public Produto(String nome, Double qtdeAtual, Double qtdeMinima) {
    this();
    setNome(nome);
    setqtdeAtual(qtdeAtual);
    setQtdeMinima(qtdeMinima);;
  }

  public Produto() {
    this.nome = "";
    this.qtdeAtual = 0d;
    this.qtdeMinima = 0d;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    if (nome.trim().length() == 0 || nome == null) return;
    
    this.nome = nome;
  }

  public Double getqtdeAtual() {
    return qtdeAtual;
  }

  public void setqtdeAtual(Double qtdeAtual) {
    if (qtdeAtual < 0) return;
    
    this.qtdeAtual = qtdeAtual;
  }

  public Double getQtdeMinima() {
    return qtdeMinima;
  }

  public void setQtdeMinima(Double qtdeMinima) {
    if (qtdeMinima < 0) return;

    this.qtdeMinima = qtdeMinima;
  }

  public void repor(Double qtdeAtual) {
    if (qtdeAtual < 0) return;

    this.qtdeAtual += qtdeAtual;
  }

  public void retirar(Double qtdeAtual) {
    if (qtdeAtual < 0 || (this.qtdeAtual - qtdeAtual) < 0) return;

    this.qtdeAtual -= qtdeAtual;
  }

  public boolean estaAbaixoDoMinimo() {
    return qtdeAtual < qtdeMinima;
  }
 
  @Override
  public String toString() {
    return nome + " - quantidade atual: " + qtdeAtual + ", quantidade minima: " + qtdeMinima;
  }
  
  
}
