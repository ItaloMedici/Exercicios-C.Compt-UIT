package listas.lista2.Boleto;

import java.util.Date;

import utils.FormatterUtil;

/**
 * Crie a classe Boleto com os atributos vencimento, valor, desconto, um
 * booleano se está pago e nome do cliente. Crie um construtor para que todos
 * dados sejam passados no momento da instanciação dos objetos. Crie um método
 * que retorne o valor líquido do boleto. Crie também um método pagar que altera
 * o boleto para pago.
 */

public class Boleto {
  private Date vencimento;
  private Double valor;
  private Double desconto;
  private Boolean pago;
  private String nomeCliente;

  public Date getVencimento() {
    return vencimento;
  }

  private void setVencimento(Date vencimento) {
    this.vencimento = vencimento;
  }

  public Double getValor() {
    return valor;
  }

  private void setValor(Double valor) {
    this.valor = valor;
  }

  public Double getDesconto() {
    return desconto;
  }

  private void setDesconto(Double desconto) {
    this.desconto = desconto;
  }

  public Boolean estaPago() {
    return pago;
  }

  public void pagar() {
    if (pago) return;

    pago = true;
  }

  public String getNomeCliente() {
    return nomeCliente;
  }

  public void setNomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
  }

  public Double getValorLiquido() {
    return valor - desconto;
  }

  @Override
  public String toString() {
    return ""
    + "\nNome Cliente: " + nomeCliente 
    + "\nBoleto: " + (pago ? "Pago" : "Aberto")
    + "\nvalor: " + FormatterUtil.formatarEmReais(valor)
    + "\nVencimento: " + FormatterUtil.dataEmStr(vencimento)
    + "\nDesconto: " + desconto 
    + "\nValor Líquido: " + FormatterUtil.formatarEmReais(getValorLiquido())
    + (vencimento.before(new Date()) && !vencimento.equals(new Date()) ? "\nBoleto vencido" : "") ;
  }

  public Boleto(Date vencimento, Double valor, Double desconto, String nomeCliente) {
    setVencimento(vencimento);
    setValor(valor);
    setDesconto(desconto);
    pago = false;
    this.nomeCliente = nomeCliente;
  } 
}
