package listas.prova2.produto;

import java.util.ArrayList;

public class Loja {
  private String nome;
  private ArrayList<Produto> produtos;

  public Loja(String nome) {
    this.nome = nome;
    produtos = new ArrayList<>();
    
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public ArrayList<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(ArrayList<Produto> produtos) {
    this.produtos = produtos;
  }

  public void adicionarProduto(Produto produto) {
    // Evitar adicionar produtos com nomes repetido
    for (Produto p : produtos) {
      if (p.getNome().equalsIgnoreCase(produto.getNome())) {
        System.out.println("Produto com nome repetido! ");
        return;
      }
    }

    produtos.add(produto);
  }

  public void removerProduto(String nomeProduto) {
    for (Produto p : produtos) {
      if (p.getNome().equalsIgnoreCase(nomeProduto)) {
        produtos.remove(p);
        return;
      }
    }
  }

  public String mostraQuantidadeProdutos() {
    if (produtos.isEmpty()) return "Sem produtos!";

    String produtosStr = "";

    for (Produto p : produtos) {
      produtosStr += p.toString() + "\n";
    }

    return produtosStr;
  } 

  public String mostraQuantidadeProdutoEspecifico(String nomeProduto) {
    for (Produto p : produtos) {
      if (p.getNome().equalsIgnoreCase(nomeProduto)) {
        return p.getqtdeAtual() + " quantidades de " + p.getNome();
      }
    }

    return "Produto não encontrado!";
  }

  public String mostraProdutosAbaixoDoMinimo() {
    String produtosStr = "";

    for (Produto p : produtos) {
      if (p.estaAbaixoDoMinimo()) {
        produtosStr += p.toString() + "\n";
      }
    }

    return produtosStr.isEmpty() ? "Nenhum produto abaixo do mínimo" : produtosStr;
  }

  public String totalProdutos() {
    return "Total de " + produtos.size() + " produtos.";
  }

}
