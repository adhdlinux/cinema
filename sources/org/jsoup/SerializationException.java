package org.jsoup;

public final class SerializationException extends RuntimeException {
    public SerializationException() {
    }

    public SerializationException(Throwable th) {
        super(th);
    }
}
