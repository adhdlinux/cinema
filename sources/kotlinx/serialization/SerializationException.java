package kotlinx.serialization;

public class SerializationException extends IllegalArgumentException {
    public SerializationException() {
    }

    public SerializationException(String str) {
        super(str);
    }

    public SerializationException(String str, Throwable th) {
        super(str, th);
    }
}
