package aula2.src;
import java.util.Scanner;

public class Main {
  static public void main(String[] args) throws Exception{
    Scanner entrada = new Scanner(System.in);

    Honda civic = new Honda(50d, 200d, 4, 1.6d, "Civic R", 2022, "FFFFFFF", 57000d, "08/07/2021", false);
    Honda city = new Honda();

/*     System.out.println("Modelo do carro: "); 
    city.setModelo(entrada.next());
    
    System.out.println("Ano: "); 
    city.setAno(entrada.nextInt());
    
    System.out.println("Placa :"); 
    city.setPlaca(entrada.next());
    
    System.out.println("Valor de Compra: "); 
    city.setValor(entrada.nextDouble());
    
    System.out.println("Condição do carro [1 - Novo/0 - Usado]: "); 
    city.setCondicao(entrada.nextInt() == 1 ? false : true);

    System.out.println("Capacidade do tanque: "); 
    city.setCapacidadeTanque(entrada.nextDouble());

    System.out.println("Quantidade de combustível atual: "); 
    city.abastecer(entrada.nextDouble());

    System.out.println("Quantidade de portas: "); 
    city.setNumeroPortas(entrada.nextInt()); */

    civic.imprimirHonda();
    
    civic.ligar();
    civic.acelerar(13d);
    civic.acelerar(7d);
    civic.acelerar(25d);
    civic.imprimirCarro();
    
    civic.ligar();
    civic.abastecer(60d);
    civic.imprimirCarro();
    
    civic.acelerar(13d);
    civic.imprimirCarro();
    



  }
}
