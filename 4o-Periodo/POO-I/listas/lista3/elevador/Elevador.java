package listas.lista3.elevador;

/**
 * Crie uma classe denominada Elevador para armazenar as informações de um
 * elevador dentro de um prédio. A classe deve armazenar o andar atual (térreo =
 * 0), total de andares no prédio, excluindo o térreo, capacidade do elevador, e
 * quantas pessoas estão presentes nele. A classe deve também disponibilizar os
 * seguintes métodos: Inicializa(Construtor): que deve receber como parâmetros a
 * capacidade do elevador e o total de andares no prédio (os elevadores sempre
 * começam no térreo e vazio); Entra: para acrescentar uma pessoa no elevador
 * (só deve acrescentar se ainda houver espaço); Sai: para remover uma pessoa do
 * elevador (só deve remover se houver alguém dentro dele); Sobe: para subir um
 * andar (não deve subir se já estiver no último andar); Desce: para descer um
 * andar (não deve descer se já estiver no térreo); Encapsular todos os
 * atributos da classe (criar os métodos set e get).
 * 
 * Refazer o exercício do elevador da prova para ele não poder subir ou descer
 * sem pessoas dentro do elevador. Modifique as opções para que possa escolher
 * quantos andares subir ou descer e quantas pessoas irão entrar ou sair através
 * de sobrecarga.
 * 
 */

public class Elevador {
  private int totalAndares;
  private int andarAtual;
  private int capacidadeElevador;
  private int nrPessoasNoElevador;

  public Elevador(int totalAndares, int capacidadeElevador) {
    terreo();
    esvaziarElevador();
    setTotalAndares(totalAndares);
    setCapacidadeElevador(capacidadeElevador);
  }

  public void terreo() {
    andarAtual = 0;
  }

  public void esvaziarElevador() {
    nrPessoasNoElevador = 0;
  }

  public void entrarPessoa() {
    if (!temEspaco())
      return;

    nrPessoasNoElevador++;
  }

  public void entrarPessoa(int qtdPessoa) {
    if (!temEspaco())
      return;

    nrPessoasNoElevador++;
  }

  public void sairPessoa() {
    if (nrPessoasNoElevador <= 0)
      return;

    nrPessoasNoElevador--;
  }

  public void sairPessoa(int qtdPessoa) {
    if (nrPessoasNoElevador <= 0)
      return;

    nrPessoasNoElevador -= qtdPessoa;
  }


  public boolean temEspaco() {
    return nrPessoasNoElevador + 1 <= capacidadeElevador;
  }

  public void sobeAndar() {
    if (andarAtual == totalAndares || nrPessoasNoElevador <= 0)
      return;

    andarAtual++;
  }

  public void sobeAndar(int andar) {
    if (andarAtual == totalAndares || nrPessoasNoElevador <= 0 || (andarAtual + andar) > totalAndares)
      return;

    andarAtual += andar;
  }

  public void descerAndar() {
    if (andarAtual == 0 || nrPessoasNoElevador <= 0)
      return;

    andarAtual--;
  }

  public void descerAndar(int andar) {
    if (andarAtual == 0 || nrPessoasNoElevador <= 0 || (andarAtual - andar) < 0)
      return;

    andarAtual -= andar;
  }

  public int getTotalAndares() {
    return totalAndares;
  }

  private void setTotalAndares(int totalAndares) {
    this.totalAndares = totalAndares;
  }

  public int getAndarAtual() {
    return andarAtual;
  }

  public int getCapacidadeElevador() {
    return capacidadeElevador;
  }

  private void setCapacidadeElevador(int capacidadeElevador) {
    this.capacidadeElevador = capacidadeElevador;
  }

  public int getNrPessoasNoElevador() {
    return nrPessoasNoElevador;
  }


  public String status() {
    return "" + "\nAndar Atual: " + andarAtual + "\nNr. Andares: " + totalAndares + "\nNr. Pessoas no Elevador: "
        + nrPessoasNoElevador + "\nCapacidade Elevador: " + capacidadeElevador;
  }
}
