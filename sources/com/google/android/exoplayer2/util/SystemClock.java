package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;

public class SystemClock implements Clock {
    protected SystemClock() {
    }

    public long a() {
        return android.os.SystemClock.uptimeMillis();
    }

    public HandlerWrapper b(Looper looper, Handler.Callback callback) {
        return new SystemHandlerWrapper(new Handler(looper, callback));
    }

    public void c() {
    }

    public long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }
}
