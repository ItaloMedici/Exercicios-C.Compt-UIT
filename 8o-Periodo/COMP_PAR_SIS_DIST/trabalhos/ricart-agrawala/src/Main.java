import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

class Main {
    private static int numThreads = 2;
    private static LinkedBlockingQueue<Message> messageQueue = new LinkedBlockingQueue<>();
    private static int myTimestamp = 0;
    private static volatile int[] requestTimestamps = new int[numThreads];
    private static boolean inCriticalSection = false;
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                while (true) {
                    randomSleep(threadId);
                    System.out.println("Thread " + threadId + ", acordou!");
                    processMessages(threadId);

                    System.out.println("Thread " + threadId + ", vai enviar mensagem");
                    messageQueue.offer(new Message(
                            threadId,
                            1,
                            myTimestamp
                    ));
                    System.out.println("Thread " + threadId + ", enviou mensagem");
//                    requestCriticalSection(threadId);
                    // Execute a seção crítica
//                    releaseCriticalSection(threadId);
                }
            });
            threads[i].start();
        }
    }
    private static void processMessages(int threadId) {
        while (!messageQueue.isEmpty()) {
            Message message = messageQueue.peek();
            System.out.println("Thread " + threadId + ", viu a mensagem de " + message.senderId + " para " + message.receiverId);

            if (message.getReceiverId() == threadId) {
                System.out.println("Thread " + threadId + ", recebeu a mensagem de " + message.senderId);
                messageQueue.poll();
            }
        }
    }

    private static void handleReceivedMessage(int threadId, Message message) {
        int senderTimestamp = message.getTimestamp();
        System.out.println("Thread " + threadId + ", recebeu a mensagem de " + message.senderId);

        lock.lock();
        try {
            if (senderTimestamp > requestTimestamps[threadId]) {
                requestTimestamps[threadId] = senderTimestamp;
            }
        } finally {
            lock.unlock();
        }
    }


    private static void requestCriticalSection(int threadId) {
        myTimestamp++;
        System.out.println("Thread " + threadId + ", quer acessar a sessão crítica!");

        lock.lock();
        for (int i = 0; i < numThreads; i++) {
            if (i != threadId) {
                sendRequest(threadId, i);
                waitForReply(threadId);
            }
        }
        lock.unlock();
    }

    private static void sendRequest(int senderId, int receiverId) {
        int senderTimestamp = myTimestamp;

        lock.lock();
        requestTimestamps[senderId] = senderTimestamp;

        // Simula o envio de mensagem para a fila
        Message message = new Message(senderId, receiverId, senderTimestamp);
        System.out.println("Thread " + senderId + ", enviando request para " + receiverId + ", no clock " + senderTimestamp);
        messageQueue.offer(message);

        // Aguarda pela resposta
        waitForReply(senderId);
        lock.unlock();
    }

    private static void waitForReply(int threadId) {
        int senderTimestamp = requestTimestamps[threadId];
        int repliesReceived = 0;

        System.out.println("Thread " + threadId + " agurdando responstas!");

        lock.lock();
        for (int i = 0; i < numThreads; i++) {
            if (i != threadId) {
                int receiverTimestamp = requestTimestamps[i];
                System.out.println("Thread " + threadId + " - resposta " + receiverTimestamp);

                if (receiverTimestamp > 0 && receiverTimestamp < senderTimestamp) {
                    repliesReceived++;
                }
            }
        }
        lock.unlock();

        while (repliesReceived < numThreads - 1) {
            Message message = messageQueue.poll();
            if (message.getReceiverId() == threadId) {
                int senderMessageTimestamp = message.getTimestamp();
                System.out.println("Thread " + threadId + ", recebeu a mensagem de " + message.senderId);

                lock.lock();
                try {
                    if (senderTimestamp > requestTimestamps[threadId]) {
                        requestTimestamps[threadId] = senderTimestamp;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static void releaseCriticalSection(int threadId) {
        lock.lock();
        inCriticalSection = true;

        // Executa a seção crítica
        System.out.println("Thread " + threadId + " está na seção crítica");
        randomSleep(threadId);
        System.out.println("Thread " + threadId + " saiu seção crítica");

        inCriticalSection = false;

        for (int i = 0; i < numThreads; i++) {
            if (i != threadId) {
                sendRelease(threadId, i);
            }
        }
        lock.unlock();
    }

    private static void sendRelease(int senderId, int receiverId) {
        // Simula o envio de mensagem de liberação para a fila
        Message message = new Message(senderId, receiverId, -1);
        messageQueue.offer(message);
    }

    private static class Message {
        private int senderId;
        private int receiverId;
        private int timestamp;

        public Message(int senderId, int receiverId, int timestamp) {
            this.senderId = senderId;
            this.receiverId = receiverId;
            this.timestamp = timestamp;
        }

        public int getSenderId() {
            return senderId;
        }

        public int getReceiverId() {
            return receiverId;
        }

        public int getTimestamp() {
            return timestamp;
        }
    }

    private static void randomSleep(int id) {
        long sleepTime = (new Random().nextInt(15 - 10) + 10) * 1000;
        System.out.println(id + ", dormindo por: " + sleepTime);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
