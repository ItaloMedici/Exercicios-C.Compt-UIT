import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class RicartAgrawala {
    private final static int NUM_WORKERS = 4;
    private static LinkedBlockingQueue<Message> messageQueue = new LinkedBlockingQueue<>(NUM_WORKERS * 2);
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < NUM_WORKERS; i++) {
            int threadID = i;

            new Thread(() -> {
                Node node = new Node(threadID);

                while (true) {
                    randomSleep(threadID);
                    print("Thread", threadID, "acordou!");
                    processMessages(node);
                    requestCriticalZone(node);
                    criticalZone(node);
                    releaseCriticalZone(node);
                    processMessages(node);
                }
            }).start();
        }
    }

    private static void processMessages(Node node) {
        messageQueue.spliterator().forEachRemaining(message -> {
            if (message.receiverID == node.getID()) {
                print("Thread", node.getID(), "recebeu mensagem de", message.sender.getID(), "com um clock de", message.clock, "e timestamp de", message.sender.getTimestamp());
                if (message.sender.getTimestamp() > node.getTimestamp()) {
                    node.setTimestamp(message.sender.getTimestamp());
                    print("Thread", node.getID(), "atualizou o timestamp para", node.getTimestamp());
                }

                if (node.getProcessState().equals(EnumStateProcess.FREE)) {
                    print("Thread", node.getID(), "respondeu para", message.sender.getID());
                    offerMessage(node, message.sender.getID());
                }

                messageQueue.remove(message);
            }
        });
    }

    private static void requestCriticalZone(Node node) {
        lock.lock();
        node.updateClock();
        node.setTimestamp(node.getClock());
        node.setProcessState(EnumStateProcess.WAINTING);
        print("Thread", node.getID(), "quer acessar zona crica com clock", node.getClock(), "e timestamp de", node.getTimestamp());

        // Send request to everyone
        for (int i = 0; i < NUM_WORKERS; i++) {
            if (i != node.getID()) {
                offerMessage(node, i);
                print("Thread", node.getID(), "enviou request para", i, "no clock", node.getClock());
            }
        }
        lock.unlock();

        print("Thread", node.getID(), "aguardando respostas");

        while (node.getRequestAnswers().size() < (NUM_WORKERS - 1)) {
            Message message = messageQueue.peek();
            if (message != null && message.receiverID() == node.getID()) {
                print("Thread", node.getID(), "recebeu resposta de", message.sender.getID());

                if (message.sender.getTimestamp() > node.getTimestamp()) {
                    node.setTimestamp(message.sender.getTimestamp());
                    print("Thread", node.getID(), "atualizou o timestamp para", node.getTimestamp());
                }

                print("Thread", node.getID(), "Sender", message.sender.getID(), "possui clock", message.clock, "e status", message.sender.getProcessState());
                if (message.clock > node.getClock()
                        && message.sender.getProcessState().equals(EnumStateProcess.WAINTING)
                ) {
                    offerMessage(node, message.sender.getID());
                    print("Thread", node.getID(), "respondeu para", message.sender.getID());
                } else {
                    node.addAnswer(message.sender.getID());
                    print("Thread", node.getID(), " adicionou a resposta de", message.sender.getID());
                    print("Thread", node.getID(), "possui", node.getRequestAnswers().size(), "respostas");
                }

                messageQueue.poll();
            }
        }

        print("Thread", node.getID(), "possui todas respostas!");
    }

    private static void criticalZone(Node node) {
        lock.lock();
        print("Thread", node.getID(), "entrou na zona critica");
        node.setProcessState(EnumStateProcess.BUSY);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        print("Thread", node.getID(), "saiu na zona critica");
        lock.unlock();
    }

    private static void releaseCriticalZone(Node node) {
        node.setProcessState(EnumStateProcess.FREE);

        if (!node.getWaitingForResponse().isEmpty()) {
            print("Thread", node.getID(), "possui mensagens a responder");
            node.getWaitingForResponse().forEach(id -> {
                offerMessage(node, id);
                print("Thread", node.getID(), "respondeu", id);
            });
        }
    }

    private static void offerMessage(Node sender, int receiverID) {
        Message requestMessage = new Message(sender, receiverID, sender.getClock());
        messageQueue.offer(requestMessage);
    }

    private static record Message(Node sender, int receiverID, int clock) {
    }

    private static void randomSleep(int id) {
        long sleepTime = (new Random().nextInt(60 - 30) + 30) * 1000;
        print("Thread", id, "dormindo por:", sleepTime / 1000, "segundos");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void print(Object... message) {
        System.out.println(Arrays.stream(message).map(Object::toString).collect(Collectors.joining(" ")));
    }
}
