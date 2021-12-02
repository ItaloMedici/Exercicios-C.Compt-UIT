package listas.lista6;

import java.util.ArrayList;
import java.util.List;

/**
 * Teste o programa com pelo menos as seguintes operações:

 * Criar um array de pessoas, adicionar várias pessoas de vários tipos. Percorra
 * imprimindo o tipo e o nome da pessoa. Se for um cliente, imprimir também a
 * quantidade produtos adquiridos (instance of)
 * 
 * Criar um array de Prioridade, adicionar várias instancias e mostrar quais
 * estão autenticando.
 */

public class Main {
  public static void main(String[] args) {
    List<Pessoa> lista = new ArrayList<>();

    Engenheiro engenheiro = new Engenheiro("Felipe", "itauna", "E1", 5000d, 23, "0225");

    List<Produto> produtos = new ArrayList<>();
    produtos.add(new Produto("Tenis", 500d));
    produtos.add(new Produto("Blusa", 50d));
    produtos.add(new Produto("Moletom", 250d));

    Cliente cliente = new Cliente("Julio", "itauna", true, produtos);

    Secretaria secretaria = new Secretaria("Antonio", "itauna", "S1", 6500d, Secretaria.INGLES);
    Motorista motorista = new Motorista("Carlos", "itauna", "M1", 2500d, 5);
    Gerente gerente = new Gerente("Maria", "itauna", "G1", 1500d, Gerente.departamentos[1]);

    lista.add(engenheiro);
    lista.add(secretaria);
    lista.add(motorista);
    lista.add(gerente);
    lista.add(cliente);

    for (Pessoa p : lista) {
      System.out.println(p.mostraTipo());

      if (p instanceof Cliente) {
        Cliente aux = (Cliente) p;
        
        for (Produto prod : aux.getProdutos()) {
          System.out.println("\t" + prod.getNome());
        }
      }
    }


    List<Prioridade> prioridades = new ArrayList<>();

    prioridades.add(secretaria);
    prioridades.add(gerente);
    prioridades.add(cliente);

    for (Prioridade p : prioridades) {
      if (p.autenticar()) {
        System.out.println(p.getClass().getSimpleName() + ", esta autenticado"); 
      }
    }
  } 
}
