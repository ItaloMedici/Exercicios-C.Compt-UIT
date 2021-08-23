package aula2.exercicios.produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        for(int i=0; i<2; i++){
            System.out.println("\nNome produto: ");
            String nome = s.next();

            System.out.println("Preco de custo: ");
            Double precoCusto = s.nextDouble();

            System.out.println("Preco de Venda: ");
            Double precoVenda = s.nextDouble();

            Produto p1 = new Produto(nome, precoCusto, precoVenda);
            p1.printProduto();
        }
    }
}
