package listas.lista3.conta;

public class TestaConta {
  public static void main(String[] args) {
    Conta conta = new Conta();

    conta.setTitular("jose");
    conta.setNumero(6);
    conta.setSaldo(30.50);

    System.out.println(conta.printSaldo()); 
  }

}
