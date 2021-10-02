package aula2409.moeda;

/**
 * Crie uma classe moeda e métodos estáticos que convertem de real para dólar e
 * de dólar para real baseados em atributos com valores das moedas da própria
 * classe. Teste esta classe utilizando os métodos sem necessitar instanciar
 * objetos.
 */

public class Moeda {
  public static Double cotacaoDolar = 5.34d;

  public static Double dolarParaReal(Double real) {
    return real / cotacaoDolar;
  }

  public static Double realParaDolar(Double dolar) {
    return dolar * cotacaoDolar;
  }
}
