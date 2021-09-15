package listas.lista2.mochila;

/**
 * Crie a classe mochila que possui os atributos nome, quantidadeItensAtual,
 * quantidadeItensMaxima, pesoAtual, pesoMaximo. Criar um construtor onde é
 * necessário passar o nome da mochila e o peso e quantidade de itens que ela
 * suporta. Deverá existir um método inserir itens onde é passado o peso do item
 * que está sendo inserido. Também deverá ter um método que retorna a situação
 * da atual da mochila. Criar uma classe de teste e testar tentando inserir
 * vários itens na mochila.
 */

public class Mochila {
    private String nome;
    private Integer quantidadeItensAtual;
    private Integer quantidadeItensMaxima;
    private Double pesoAtual;
    private Double pesoMaximo;
    
    public Mochila(String nome, Integer quantidadeItensMaxima, Double pesoMaximo) {
        this.nome = nome;
        setQuantidadeItensMaxima(quantidadeItensMaxima);
        setPesoMaximo(pesoMaximo);
        quantidadeItensAtual = 0;
        pesoAtual = 0d;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeItensAtual() {
        return quantidadeItensAtual;
    }

    private Boolean podeInserirItem(Double pesoItem) {
        return (pesoItem > pesoMaximo 
            || quantidadeItensAtual.equals(quantidadeItensMaxima) 
            || (pesoItem + pesoAtual) > pesoMaximo
        );
    }

    public void inserirItem(Double pesoItem) {
        if (podeInserirItem(pesoItem)) {
            System.out.println("Pesso item maior que o pesso máximo ou mochila cheia");
            return;
        }
        pesoAtual += pesoItem;
        quantidadeItensAtual++;
    }

    public Integer getQuantidadeItensMaxima() {
        return quantidadeItensMaxima;
    }

    private void setQuantidadeItensMaxima(Integer quantidadeItensMaxima) {
        if (quantidadeItensMaxima <= 0) return;
        this.quantidadeItensMaxima = quantidadeItensMaxima;
    }

    public Double getPesoAtual() {
        return pesoAtual;
    }

    public Double getPesoMaximo() {
        return pesoMaximo;
    }

    private void setPesoMaximo(Double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public Boolean isFull() {
        return pesoAtual >= pesoMaximo;
    }

    @Override
    public String toString() {
        return ""
        + "\nNome: " + nome
        + "\nQuantidade de Itens: " + quantidadeItensAtual
        + "\nQuantidade máxima de itens: "+ quantidadeItensMaxima
        + "\nPeso atual " + pesoAtual + "Kg"
        + "\nPeso máximo: " + pesoMaximo + "Kg"
        + (isFull() ? "\nMochila Cheia" : "");
    }
}
