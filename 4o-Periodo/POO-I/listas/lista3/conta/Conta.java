package listas.lista3.conta;

public class Conta {
  private String titular;
  private int numero;
  private double saldo;

  public String getTitular() {
    return titular;
  }

  public void setTitular(String titular) {
    this.titular = titular;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }  

  public String printSaldo() {
    return ("Olá "  + titular + ", seu saldo é de: "  + saldo);
  }
}
