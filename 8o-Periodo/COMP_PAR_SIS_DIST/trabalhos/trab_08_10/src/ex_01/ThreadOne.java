package ex_01;

import java.util.stream.IntStream;

public class ThreadOne extends Thread {

    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.printf("%d ", i);
        }
    }
}
