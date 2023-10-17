import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Utils {

    public static final int SERVER_PORT = 12345;

    public static void randomSleep(String id) {
        long sleepTime = (new Random().nextInt(60 - 30) + 30) * 1000;
        print("Thread", id, "dormindo por:", sleepTime / 1000, "segundos");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void print(Object... message) {
        System.out.println(buildString(message));
    }

    public static String buildString(Object... message) {
        return Arrays.stream(message).map(Object::toString).collect(Collectors.joining(" "));
    }

    public static boolean isNull(Object o) {
        return o == null;
    }

    public static boolean isNotNull(Object o) {
        return !isNull(o);
    }

    public static ObjectOutputStream getOutputStream(Socket socket) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            closeSocket(socket, out);
        }

        return out;
    }

    public static ObjectInputStream getInputStream(Socket socket) {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            closeSocket(socket, in);
        }

        return in;
    }

    public static void closeSocket(Socket socket, ObjectInputStream in) {
        closeSocket(socket, null, in);
    }

    public static void closeSocket(Socket socket, ObjectOutputStream out) {
        closeSocket(socket, out, null);
    }

    public static void closeSocket(Socket socket, ObjectOutputStream out, ObjectInputStream in) {
//        try {
//            if (isNotNull(out)) {
//                out.close();
//            }
//            if (isNotNull(in)) {
//                in.close();
//            }
//            if (isNotNull(socket)) {
//                socket.close();
//            }
//        } catch (IOException e) {
//            e.fillInStackTrace();
//        }
    }

    public static Boolean isEquals(Object o1, Object o2) {
        return o1.equals(o2);
    }
}
