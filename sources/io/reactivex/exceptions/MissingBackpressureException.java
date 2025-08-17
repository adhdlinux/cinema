package io.reactivex.exceptions;

public final class MissingBackpressureException extends RuntimeException {
    public MissingBackpressureException() {
    }

    public MissingBackpressureException(String str) {
        super(str);
    }
}
