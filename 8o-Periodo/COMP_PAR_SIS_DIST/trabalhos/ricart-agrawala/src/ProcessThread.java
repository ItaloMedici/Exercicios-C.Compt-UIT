import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class ProcessThread extends Thread {
    final Long processID;
    EnumStateProcess processState = EnumStateProcess.FREE;
    int hsn = 0;
    int osn = 0;

    private LinkedList<Long> waitingForResponse = new LinkedList<>();
    private LinkedList<Long> responses = new LinkedList<>();
    private BlockingQueue<Message> messagesQueue;
    private CountDownLatch latch;

    public final int cs_zone;

    public ProcessThread(Long processID, BlockingQueue<Message> messagesQueue, int csZone, int numOfWorkers) {
        this.processID = processID;
        this.messagesQueue = messagesQueue;
        cs_zone = csZone;
        this.latch = new CountDownLatch(numOfWorkers);
    }

    public Long getProcessID() {
        return processID;
    }

    @Override
    public void run() {
        while (true) {
            randomSleep();

            Message message;
            while ((message = this.messagesQueue.poll()) != null) {
                if (getProcessState().equals(EnumStateProcess.WAINTING)) {
                    responses.push(message.processID());
                }

                if (getProcessState().equals(EnumStateProcess.FREE)) {

                }
            }

            System.out.println(getProcessID() + ", quer acessar a zona crítica");

            setProcessState(EnumStateProcess.WAINTING);
            setOsn(getHsn()+1);
            sendMessage();

            this.waitLatch();

        }
    }

    private void randomSleep() {
        long sleepTime = new Random().nextInt(60 - 30) + 30 * 1000;
        System.out.println(getProcessID() + ", dormindo por: " + sleepTime);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMessage() {
        try {
            this.messagesQueue.put(new Message(getOsn(), getProcessID()));
        } catch (InterruptedException e) {
            System.out.println("Thread " + getProcessID() + ", deu erro ao enviar uma mensagem");
            throw new RuntimeException(e);
        }
    }

    private void waitLatch() {
        try {
            this.latch.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public EnumStateProcess getProcessState() {
        return processState;
    }

    public void setProcessState(EnumStateProcess state) {
        this.processState = state;
    }

    public int getHsn() {
        return hsn;
    }

    public void setHsn(int hsn) {
        this.hsn = hsn;
    }

    public int getOsn() {
        return osn;
    }

    public void setOsn(int osn) {
        this.osn = osn;
    }
}
