import java.io.*;
import java.net.Socket;

public class MessageReceiver implements Runnable {

    Node node;

    Socket socket;

    ObjectInputStream in;

    MessageReceiver(Node node, Socket socket) {
        this.node = node;
        this.socket = socket;

        this.in = Utils.getInputStream(socket);
    }

    @Override
    public void run() {

        while (socket.isConnected()) {
            try {
                Object messageFromSocket = in.readObject();
                if (messageFromSocket instanceof Message message) {
                    processMessage(message);
                }
            } catch (IOException e) {
                Utils.closeSocket(socket, in);
            } catch (ClassNotFoundException e) {
                e.fillInStackTrace();
            }
        }
    }

    public void processMessage(Message message) {
        switch (message.type()) {
            case HAND_SHAKE -> handleHandShake(message);
            case REQUEST -> RicartAgrawala.handleRequest(node, message);
            case REPLY -> RicartAgrawala.handleReply(node, message);
        }
    }

    private void handleHandShake(Message message) {
        Utils.print(node.getId(), "recebeu handshake de", message.sender().getId());
        int totalNodes = RicartAgrawala.totalNodes.incrementAndGet();
        Utils.print("Possuo", totalNodes, "nodes");
    }
}
