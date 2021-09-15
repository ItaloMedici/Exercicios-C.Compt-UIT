package listas.lista2.mochila;

public class Main {
    public static void main(String[] args) {
        Mochila mochila = new Mochila("Karga", 10, 20d);
        
        System.out.println(mochila.toString());
        
        mochila.inserirItem(5d);
        mochila.inserirItem(7d);
        
        System.out.println(mochila.toString());
        
        mochila.inserirItem(1d);
        mochila.inserirItem(1d);
        mochila.inserirItem(1d);
        mochila.inserirItem(1d);
        mochila.inserirItem(1d);
        mochila.inserirItem(1d);
        mochila.inserirItem(1d);
        mochila.inserirItem(1d);
        
        System.out.println(mochila.toString());
        
        mochila.inserirItem(7d);
        System.out.println(mochila.toString());
    }
}
