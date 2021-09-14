package listas.lista2.time;

/**
 * Crie a classe Time que possua o nome do time, a série que ele joga e o número
 * de jogadores. As séries podem ser de A, B, C, D ouE. O números de jogadores é
 * no máximo 22. Crie um construtor onde seja obrigatório inserir no momento da
 * criação da instância o nome e a série do time. Faça o teste em outra classe
 * cadastrando 2 times.
 */

public class Time {
    private String nomeTime;
    private String serie;
    private Integer numeroJogadores;

    private static Integer numeroMaxJogadores = 22;
    private static String seriesPossiveis = "ABCDE";

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        serie = serie.toUpperCase();

        if (!seriesPossiveis.contains(serie)) {
            System.out.println("Serie errada! Somente A, B, C, D ou E");
            return;
        }

        this.serie = serie;
    }

    public Integer getNumeroJogadores() {
        return numeroJogadores;
    }

    public void setNumeroJogadores(Integer numeroJogadores) {
        if (numeroJogadores > numeroMaxJogadores) {
            System.out.println("Numero maior que o permitido");
            return;
        }
        this.numeroJogadores = numeroJogadores;
    }
    
    public Time() {
        serie = "";
        nomeTime = "";
        numeroJogadores = 0;
    }

    public Time(String nomeTime, String serie) {
        this();
        this.nomeTime = nomeTime;
        setSerie(serie);
    }

    @Override
    public String toString() {
        return "Time [nomeTime=" + nomeTime + ", numeroJogadores=" + numeroJogadores + ", serie=" + serie + "]";
    }     
}
