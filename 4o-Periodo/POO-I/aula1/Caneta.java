package aula1;

public class Caneta {
    private String marca;
    private Boolean temTinta;
    private String cor;
    private Integer uso;

    public boolean temTinta() {
        return temTinta;
    }

    public void porTinta() {
        if(!temTinta()){
            this.temTinta = true;
            this.zerarUso();
        }
    }

    public void usar(){
        if (uso == 5) {
            temTinta = false;
            return;
        }
        uso++;
    }

    public void zerarUso() {
        uso = 0;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void printCaneta(){
        System.out.println(
            ""
            + "\nMarca: " + marca
            + "\nCor: " + cor
            + "\nTem tinta: " + (temTinta() ? "Sim" : "Não")
            + "\nUso: " + uso
        );
    }

    public Caneta() {
        this.cor = "";
        this.marca = "";
        this.temTinta = true;
        this.uso = 0;
    }

    public Caneta(String marca, String cor) {
        this();
        this.marca = marca;
        this.cor = cor;
    }
}