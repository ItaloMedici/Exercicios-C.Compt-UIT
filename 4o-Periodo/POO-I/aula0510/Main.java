package aula0510;

/**
 * Crie uma classe TestarAnimais possua um método main para testar as classes
 * criadas. Crie um objeto camelo do tipo Mamífero e atribua os seguintes
 * valores para seus atributos:  Nome: Camelo  Comprimento: 150 cm  Patas: 4
 *  Cor: Amarelo  Ambiente: Terra  Velocidade: 2.0 m/s Crie um objeto tubarao
 * do tipo Peixe e atribua os seguintes valores para seus atributos  Nome:
 * Tubarão  Comprimento: 300 cm  Patas: 0  Cor: Cinzento  Ambiente: Mar 
 * Velocidade: 1.5 m/s  Caracteristica: Barbatanas e cauda Crie um objeto
 * ursocanada do tipo Mamifero e atribua os seguintes valores para seus
 * atributos:  Nome: Urso-do-canadá  Comprimento: 180 cm  Patas: 4  Cor:
 * Vermelho  Ambiente: Terra  Velocidade: 0.5 m/s  Alimento: Mel Chame os
 * método para imprimir os dados de cada um dos objetos criados.
 */

public class Main {
  public static void main(String[] args) {
    Mamifero camelo = new Mamifero("nome", 150f, 4, "Amarelo", "Terra", 2.0f, "carne");
    Peixe tubarao = new Peixe("Tubarão", 300f, 0, "Cinzento", "Mar", 1.5f, "Barbatanas e cauda");
    Mamifero ursocanada = new Mamifero("Urso-do-canadá", 180f, 4, "Vermelho", "Terra", 0.5f, "Mel");


    System.out.println(camelo.dadosMamifero()+"\n");
    System.out.println(tubarao.dadosPeixe()+"\n");
    System.out.println(ursocanada.dadosMamifero());

    System.out.println(camelo.emitirSom());
    System.out.println(tubarao.emitirSom());
    System.out.println(ursocanada.emitirSom());
    
  }
}
