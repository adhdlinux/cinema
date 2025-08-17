package com.facebook.common.util;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ExceptionWithNoStacktrace extends Exception {
    public ExceptionWithNoStacktrace(String str) {
        super(str);
    }

    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
