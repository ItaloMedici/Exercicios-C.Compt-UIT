package listas.lista3.elevador;

public class Main {

  public static void main(String[] args) {
    Elevador elevador = new Elevador(5, 6);
  
    System.out.println(elevador.status()); 
    
    elevador.sobeAndar();
    elevador.sobeAndar();
    elevador.sobeAndar();
    elevador.descerAndar();
    elevador.descerAndar();
    elevador.descerAndar(5);
    
    elevador.entrarPessoa();
    elevador.entrarPessoa();
    
    elevador.sobeAndar(5);
    elevador.sobeAndar(-2);

    System.out.println(elevador.status()); 
  }
}
