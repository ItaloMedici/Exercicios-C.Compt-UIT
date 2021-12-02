package listas.lista6;

import java.util.List;

/**
 * Crie a classe Cliente que herda de Pessoa e possui as propriedades: ativo e
 * uma lista de produtos. Crie métodos como adiciona produto, etc.
 */

public class Cliente extends Pessoa implements Prioridade {
  private boolean ativo;
  private List<Produto> produtos;

  public Cliente(String nome, String endereco, boolean ativo, List<Produto> produtos) {
    super(nome, endereco);
    this.ativo = ativo;
    this.produtos = produtos;
  }

  public boolean isAtivo() {
    return ativo;
  }

  public void ativarInativar() {
    this.ativo = !this.ativo;
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }

  public void inserirProduto(Produto produto) {
    produtos.add(produto);
  }

  public void removerProduto(Produto produto) {
    produtos.remove(produto);
  }

  @Override
  public String mostraTipo() {
    return "Cliente";

  }

  @Override
  public boolean autenticar() {
    return ativo;
  }
}
