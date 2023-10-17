import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class NodeClient {

    Socket socket;

    NodeClient(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) {
        try {

            String nodeId = "T"+(new Random().nextInt(20));

            Socket socket = new Socket("localhost", Utils.SERVER_PORT);

            Node node = new Node(nodeId);

            new Thread(new MessageSender(node, socket)).start();
            new Thread(new MessageReceiver(node, socket)).start();

            while (Utils.isEquals(node.getState(), EnumState.FREE)) {
                Utils.randomSleep(node.getId());
                RicartAgrawala.requestCriticalZone(node);
            }

        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }
}
