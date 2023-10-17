import java.io.Serializable;

public record Message(Node sender, String nodeReceiver, EnumMessageType type, Integer clock) implements Serializable {
}
