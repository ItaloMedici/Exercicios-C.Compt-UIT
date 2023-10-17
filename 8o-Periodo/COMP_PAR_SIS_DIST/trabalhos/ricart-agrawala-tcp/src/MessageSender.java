import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MessageSender implements Runnable {

    Node node;

    Socket socket;

    ObjectOutputStream out;

    MessageSender(Node node, Socket socket) {
        this.node = node;
        this.socket = socket;

        this.out = Utils.getOutputStream(socket);
    }

    @Override
    public void run() {
        try {
            // Hand shake
            out.writeObject(node.getId());
            Utils.print(node.getId(), "enviou handshake para servidor");

            while (socket.isConnected()) {
                Message message = node.getMessageQueue().poll();

                if (Utils.isNotNull(message)) {
                    out.writeObject(message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
//            Utils.closeSocket(socket, out);
        }
    }
}
