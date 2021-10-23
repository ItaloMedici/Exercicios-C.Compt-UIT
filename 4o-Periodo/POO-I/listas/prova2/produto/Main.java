package listas.prova2.produto;

import java.util.Scanner;

public class Main {
  static Scanner s = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Nome da loja: ");
    Loja loja = new Loja(s.nextLine());

    int option = 0;
    do {
      menu();
      option = s.nextInt();
      handleOption(option, loja);
    } while (option != 0);

    s.close();
  }

  public static void menu() {
    System.out.print("\n\tLOJA MENU"
      + "\n1 - Adicionar produto"
      + "\n2 - Remover produto"
      + "\n3 - Mostra produtos"  
      + "\n4 - Mostra produto por nome"
      + "\n5 - Mostra produtos abaixo do minimo"
      + "\n6 - Total de produtos"
      + "\n7 - Selecionar produto"
      + "\n0 - Sair"
      + "\nR: "
    );
  }

  private static void handleOption(int option, Loja loja) {
    switch (option) {
      case 1:
        System.out.print("Nome do Produto: ");
        clearBuffer();
        String nomeProduto = s.nextLine();

        System.out.print("Quantidade Atual: ");
        Double qtdeAtual = s.nextDouble();

        System.out.print("Quantidade Mínima: ");
        Double qtdeMinima = s.nextDouble();

        loja.adicionarProduto(new Produto(nomeProduto, qtdeAtual, qtdeMinima));
        break;

      case 2:
        System.out.print("Nome do Produto: ");
        clearBuffer();

        loja.removerProduto(s.nextLine());
        break;
      
      case 3:
        System.out.println("\n" + loja.mostraQuantidadeProdutos());
        break;
      
      case 4:
        System.out.print("Nome do Produto: ");
        clearBuffer();

        String prod = loja.mostraQuantidadeProdutoEspecifico(s.nextLine());

        System.out.println("\n" + prod);
        break;
      
      case 5:
        System.out.println("\n" + loja.mostraProdutosAbaixoDoMinimo());
        break;
      
      case 6:
        System.out.println("\n" + loja.totalProdutos());
        break;
      
      case 7:
        System.out.print("Nome do Produto: ");
        clearBuffer();
        String produtoToFind = s.nextLine();
        
        Produto auxPedido = null;

        for (Produto p : loja.getProdutos()) {
          if (p.getNome().equalsIgnoreCase(produtoToFind)) {
            auxPedido = p;
          }
        }

        if (auxPedido != null) {
          
          int optionProduto = 0;
          do {
            menuProduto();
            optionProduto = s.nextInt();
            handleOptionProduto(optionProduto, auxPedido);
          } while (optionProduto != 0);
        }

      default:
        break;
    }
  }

  private static void handleOptionProduto(int optionProduto, Produto produto) {
    switch(optionProduto) {
      case 1:
        System.out.print("Quantidade Atual: ");
        Double qtdeAtual = s.nextDouble();

        produto.repor(qtdeAtual);
        break;

      case 2:
        System.out.print("Quantidade para remover: ");
        Double qtdeRemover = s.nextDouble();

        produto.retirar(qtdeRemover);
        break;
      
      default:
        break;
    }
  }

  public static void menuProduto() {
    System.out.print("\n\tPRODUTO MENU"
      + "\n1 - Adicionar quatidade"
      + "\n2 - Remover quatidade"
      + "\n0 - Sair"
      + "\nR: "
    );
  }

  private static void clearBuffer() {
    if (s.hasNextLine()) {
      s.nextLine();
    }
  }
}
