package com.xuhao.didi.socket.client.impl.exceptions;

public class ManuallyDisconnectException extends RuntimeException {
    public ManuallyDisconnectException() {
    }

    public ManuallyDisconnectException(String str) {
        super(str);
    }

    public ManuallyDisconnectException(String str, Throwable th) {
        super(str, th);
    }

    public ManuallyDisconnectException(Throwable th) {
        super(th);
    }
}
