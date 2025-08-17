package com.xuhao.didi.core.exceptions;

public class WriteException extends RuntimeException {
    public WriteException() {
    }

    public WriteException(String str) {
        super(str);
    }

    public WriteException(String str, Throwable th) {
        super(str, th);
    }

    public WriteException(Throwable th) {
        super(th);
    }

    protected WriteException(String str, Throwable th, boolean z2, boolean z3) {
        super(str, th, z2, z3);
    }
}
