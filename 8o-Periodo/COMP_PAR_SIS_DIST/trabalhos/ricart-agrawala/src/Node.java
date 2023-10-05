import java.util.ArrayList;

public class Node {
    private final int id;
    private EnumStateProcess processState = EnumStateProcess.FREE;
    private int timestamp = 0;
    private int clock = 0;
    private ArrayList<Integer> requestAnswers = new ArrayList<>();
    private ArrayList<Integer> waitingForResponse = new ArrayList<>();

    Node(int id) {
        this.id = id;
    }

    public int getClock() {
        return clock;
    }

    public void updateClock() {
        this.clock += getTimestamp();
    }

    public int getID() {
        return id;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public void setProcessState(EnumStateProcess processState) {
        this.processState = processState;
    }

    public EnumStateProcess getProcessState() {
        return processState;
    }

    public ArrayList<Integer> getRequestAnswers() {
        return requestAnswers;
    }

    public void addAnswer(int id) {
        this.requestAnswers.add(id);
    }

    public ArrayList<Integer> getWaitingForResponse() {
        return waitingForResponse;
    }

    public void addWaitingForResponse(int id) {
        this.waitingForResponse.add(id);
    }
}
