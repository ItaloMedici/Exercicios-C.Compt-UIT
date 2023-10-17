import java.util.concurrent.atomic.AtomicInteger;

public class RicartAgrawala {

    public static AtomicInteger totalNodes = new AtomicInteger(1);

    public static void handleRequest(Node currentNode, Message message) {
//        currentNode.getLock().lock();

        Utils.print(currentNode.getId(), "recebeu request de:", message.sender().getId());

        Message responseMessage;

        if (message.sender().getTimestamp() > currentNode.getTimestamp()) {
            currentNode.setTimestamp(message.sender().getTimestamp());
        }

        EnumState currentNodeState = currentNode.getState();
        EnumState senderNodeState = message.sender().getState();

        Boolean isCurrentNodeFree = Utils.isEquals(currentNodeState, EnumState.FREE);

        Boolean isSenderAndCurrentStateWaiting = Utils.isEquals(currentNodeState, EnumState.WAINTING) && Utils.isEquals(senderNodeState, EnumState.WAINTING);

        Boolean isSenderClockBiggerThenCurrentNode = message.clock() > currentNode.getClock();

        if (isCurrentNodeFree || isSenderAndCurrentStateWaiting && isSenderClockBiggerThenCurrentNode) {
            responseMessage = new Message(currentNode, message.sender().getId(), EnumMessageType.REPLY, currentNode.getClock());
            Utils.print(currentNode.getId(), "respondeu", message.sender().getId());
        } else {
            currentNode.getWaitingForResponse().add(message.sender().getId());
            responseMessage = new Message(currentNode, message.sender().getId(), EnumMessageType.REQUEST, currentNode.getClock());
            Utils.print(currentNode.getId(), "requisitou", message.sender().getId());
        }

        currentNode.getMessageQueue().offer(responseMessage);
//        currentNode.getLock().unlock();
    }

    public static void handleReply(Node currentNode, Message message) {
        currentNode.getLock().lock();

        currentNode.getRequestAnswers().add(message.sender().getId());
        Utils.print(currentNode.getId(), "recebeu resposta de ", message.sender().getId());


        if (Utils.isEquals(currentNode.getRequestAnswers().size(), totalNodes.get() - 1)) {
            Utils.print(currentNode.getId(), "recebeu todas respostas");
            handleCriticalZone(currentNode);
        }

        currentNode.getLock().unlock();
    }

    public static void handleCriticalZone(Node node) {
        accessCriticalZone(node);
        releaseCriticalZone(node);
    }

    public static void requestCriticalZone(Node node) {
        node.getLock().lock();

        node.setClock(node.getTimestamp() + 1);
        node.setTimestamp(node.getClock());

        node.setState(EnumState.WAINTING);

        Utils.print(node.getId(), "quer entrar na zona com clock", node.getClock());

        if (totalNodes.get() > 1) {
            Message broadcastMessage = new Message(node, null, EnumMessageType.REQUEST, node.getClock());
            node.getMessageQueue().offer(broadcastMessage);

            Utils.print(node.getId(), "requisitou a zona critica e esta aguardando respostas");
        } else {
            handleCriticalZone(node);
        }

        node.getLock().unlock();
    }

    public static void accessCriticalZone(Node node) {
        node.getLock().lock();
        Utils.print("--> Thread", node.getId(), "entrou na zona critica <---");
        node.setState(EnumState.BUSY);
        try {
            Thread.sleep(30 * 1000);// Dorme 30s
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Utils.print("<-- Thread", node.getId(), "saiu na zona critica -->");
        node.getLock().unlock();
    }

    public static void releaseCriticalZone(Node node) {
        node.setState(EnumState.FREE);

        if (!node.getWaitingForResponse().isEmpty()) {
            Utils.print(node.getId(), "possui mensagens a responder");

            node.getWaitingForResponse().forEach(id -> {
                Message message = new Message(node, id, EnumMessageType.REPLY, node.getClock());
                node.getMessageQueue().offer(message);

                Utils.print("Thread", node.getId(), "respondeu a", id);
            });

            node.getWaitingForResponse().clear();
            node.getRequestAnswers().clear();
        }
    }
}
