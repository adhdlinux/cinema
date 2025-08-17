package com.xuhao.didi.socket.server.exceptions;

public class CacheException extends RuntimeException {
    public CacheException() {
    }

    public CacheException(String str) {
        super(str);
    }

    public CacheException(String str, Throwable th) {
        super(str, th);
    }

    public CacheException(Throwable th) {
        super(th);
    }

    protected CacheException(String str, Throwable th, boolean z2, boolean z3) {
        super(str, th, z2, z3);
    }
}
