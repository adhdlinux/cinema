package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

final class zzfwy extends TimeoutException {
    /* synthetic */ zzfwy(String str, zzfwx zzfwx) {
        super(str);
    }

    public final synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
