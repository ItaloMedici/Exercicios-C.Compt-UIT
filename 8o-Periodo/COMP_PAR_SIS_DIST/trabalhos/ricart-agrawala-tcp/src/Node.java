import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Node implements Serializable {
    private final String id;
    private EnumState state = EnumState.FREE;
    private int timestamp = 0;
    private int clock = 0;
    private ArrayList<String> requestAnswers = new ArrayList<>();
    private ArrayList<String> waitingForResponse = new ArrayList<>();

    private LinkedBlockingQueue<Message> messageQueue = new LinkedBlockingQueue<>();
    private final ReentrantLock lock = new ReentrantLock();

    Node(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public EnumState getState() {
        return state;
    }

    public void setState(EnumState state) {
        this.state = state;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getClock() {
        return clock;
    }

    public void setClock(int clock) {
        this.clock = clock;
    }

    public ArrayList<String> getRequestAnswers() {
        return requestAnswers;
    }

    public void setRequestAnswers(ArrayList<String> requestAnswers) {
        this.requestAnswers = requestAnswers;
    }

    public ArrayList<String> getWaitingForResponse() {
        return waitingForResponse;
    }

    public void setWaitingForResponse(ArrayList<String> waitingForResponse) {
        this.waitingForResponse = waitingForResponse;
    }

    public LinkedBlockingQueue<Message> getMessageQueue() {
        return messageQueue;
    }

    public ReentrantLock getLock() {
        return lock;
    }
}
