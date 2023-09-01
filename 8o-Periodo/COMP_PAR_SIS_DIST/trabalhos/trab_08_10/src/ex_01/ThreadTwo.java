package ex_01;

public class ThreadTwo extends Thread {

    public void run() {
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.printf("%c ", c);
        }
    }
}
