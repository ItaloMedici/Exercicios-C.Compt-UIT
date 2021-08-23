package aula2.exercicios.pessoa;

public class TestaPessoa {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Italo", "Itauna", "37998726264");
        Pessoa p2 = new Pessoa("Jose", "Belo Horizonte", "319994265798");

        p1.printPessoa();
        p2.printPessoa();
    }
}
