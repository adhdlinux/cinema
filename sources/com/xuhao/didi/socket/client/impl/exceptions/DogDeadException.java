package com.xuhao.didi.socket.client.impl.exceptions;

public class DogDeadException extends RuntimeException {
    public DogDeadException() {
    }

    public DogDeadException(String str) {
        super(str);
    }

    public DogDeadException(String str, Throwable th) {
        super(str, th);
    }

    public DogDeadException(Throwable th) {
        super(th);
    }

    protected DogDeadException(String str, Throwable th, boolean z2, boolean z3) {
        super(str, th, z2, z3);
    }
}
