import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;

    Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        try {
            Utils.print("Server started on:", Utils.SERVER_PORT);

            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                new NodeClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public void closeServer() {
        try {
            if (Utils.isNull(serverSocket)) {
                serverSocket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(Utils.SERVER_PORT);
            Server server = new Server(serverSocket);
            server.startServer();
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }
}
