package aula3.pessoa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        for(int i=0; i<2; i++) {
            Scanner e = new Scanner(System.in);

            Pessoa pessoa = new Pessoa();
    
            System.out.println("Digite seu nome: ");
            String nome = e.nextLine();
            pessoa.setNome(nome);

            System.out.println("Digite seu peso: ");
            Double peso = e.nextDouble();
            pessoa.setPeso(peso);

            System.out.println("Digite sua altura: ");
            pessoa.setAltura(e.nextDouble());

            pessoa.setSexo('m');

            System.out.println(pessoa.getIMC());

            e.close();
        }   
    }
}
