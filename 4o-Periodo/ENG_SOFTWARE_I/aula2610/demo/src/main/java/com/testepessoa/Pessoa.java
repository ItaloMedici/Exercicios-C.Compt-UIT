package com.testepessoa;

public class Pessoa {
  private String nome;
  private int maxLivros;

  public Pessoa() {
    this.nome = "Nome Desconhecido";
    this.maxLivros = 3;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getMaxLivros() {
    return maxLivros;
  }

  public void setMaxLivros(int maxLivros) {
    this.maxLivros = maxLivros;
  }

  @Override
  public String toString() {
    return this.nome + " (" + this.maxLivros + " livros)";
  }
} 
