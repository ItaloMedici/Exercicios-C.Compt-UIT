import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class NodeClientHandler extends Thread {

    private static ArrayList<NodeClientHandler> nodesHandlers = new ArrayList<>();

    private Socket socket;

    private ObjectOutputStream out;

    private ObjectInputStream in;

    private String nodeId;

    NodeClientHandler(Socket socket) {
        try {
            this.socket = socket;

            this.out = Utils.getOutputStream(socket);
            this.in = Utils.getInputStream(socket);

            handleInitialHandShake();

        } catch (IOException e) {
            e.fillInStackTrace();

            removeNodeClientHandler();
            Utils.closeSocket(socket, in);
        } catch (ClassNotFoundException e) {
            e.fillInStackTrace();
        }
    }

    public void handleInitialHandShake() throws IOException, ClassNotFoundException {
        this.nodeId = (String) in.readObject();

        nodesHandlers.add(this);
        Utils.print(nodeId, "enviou handshake");
        Utils.print("Prente:", nodesHandlers.size(), "nodes");

        if (nodesHandlers.size() > 1) {

            broadcastMessage(new Message(new Node(nodeId), null, EnumMessageType.HAND_SHAKE, null));

            Utils.print("Servidor enviou handshake de", nodeId, "para todos");

            for (NodeClientHandler nodeHandler : nodesHandlers) {
                try {
                    if (!Utils.isEquals(nodeHandler.nodeId, nodeId)) {
                        Utils.print("Servidor esta enviando handshake de", nodeHandler.nodeId, "para", nodeId);

                        Message handShake = new Message(new Node(nodeHandler.nodeId), nodeId, EnumMessageType.HAND_SHAKE, null);
                        this.out.writeObject(handShake);
                    }
                } catch (IOException e) {
                    removeNodeClientHandler();
                    Utils.closeSocket(socket, in);
                    e.fillInStackTrace();
                }
            }
        }

    }

    public void run() {
        while (socket.isConnected()) {
            try {
                Object data = in.readObject();

                if (data instanceof Message message) {
                    Utils.print("Servidor recebeu mensagem de", message.sender().getId(), "do tipo", message.type());

                    if (!Utils.isNull(message.nodeReceiver())) {
                        directMessage(message);
                    } else {
                        broadcastMessage(message);
                    }
                }
            } catch (IOException e) {
                removeNodeClientHandler();
                Utils.closeSocket(socket, in);
                e.fillInStackTrace();
                break;
            } catch (ClassNotFoundException e) {
                e.fillInStackTrace();
            }
        }
    }

    public void broadcastMessage(Message message) {
        for (NodeClientHandler nodeHandler : nodesHandlers) {
            try {
                if (!Utils.isEquals(nodeHandler.nodeId, nodeId)) {
                    nodeHandler.out.writeObject(message);
                }
            } catch (IOException e) {
                removeNodeClientHandler();
                Utils.closeSocket(socket, in);
                e.fillInStackTrace();
            }
        }
    }

    public void directMessage(Message message) {
        for (NodeClientHandler nodeHandler : nodesHandlers) {
            try {
                if (Utils.isEquals(nodeHandler.nodeId, message.nodeReceiver())) {
                    nodeHandler.out.writeObject(message);
                }
            } catch (IOException e) {
                removeNodeClientHandler();
                Utils.closeSocket(socket, in);
                e.fillInStackTrace();
            }
        }
    }

    public void removeNodeClientHandler() {
        nodesHandlers.remove(this);
    }
}
