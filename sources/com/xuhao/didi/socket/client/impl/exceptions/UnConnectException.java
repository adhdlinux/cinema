package com.xuhao.didi.socket.client.impl.exceptions;

public class UnConnectException extends RuntimeException {
    public UnConnectException() {
    }

    public UnConnectException(String str) {
        super(str);
    }

    public UnConnectException(String str, Throwable th) {
        super(str, th);
    }

    public UnConnectException(Throwable th) {
        super(th);
    }

    protected UnConnectException(String str, Throwable th, boolean z2, boolean z3) {
        super(str, th, z2, z3);
    }
}
