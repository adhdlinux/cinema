package com.xuhao.didi.core.exceptions;

public class ReadException extends RuntimeException {
    public ReadException() {
    }

    public ReadException(String str) {
        super(str);
    }

    public ReadException(String str, Throwable th) {
        super(str, th);
    }

    public ReadException(Throwable th) {
        super(th);
    }

    protected ReadException(String str, Throwable th, boolean z2, boolean z3) {
        super(str, th, z2, z3);
    }
}
