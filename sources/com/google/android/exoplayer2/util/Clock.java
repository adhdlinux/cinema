package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;

public interface Clock {

    /* renamed from: a  reason: collision with root package name */
    public static final Clock f28651a = new SystemClock();

    long a();

    HandlerWrapper b(Looper looper, Handler.Callback callback);

    void c();

    long elapsedRealtime();
}
