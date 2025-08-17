package com.google.zxing;

public abstract class ReaderException extends Exception {

    /* renamed from: b  reason: collision with root package name */
    protected static final boolean f31183b;

    static {
        boolean z2;
        if (System.getProperty("surefire.test.class.path") != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        f31183b = z2;
    }

    ReaderException() {
    }

    public final Throwable fillInStackTrace() {
        return null;
    }
}
