package com.vungle.ads.internal.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import kotlin.jvm.internal.Intrinsics;

public final class HandlerScheduler {
    private final Handler handler = new Handler(Looper.getMainLooper());

    private final long calculateTime(long j2) {
        return SystemClock.uptimeMillis() + j2;
    }

    public final void cancel(String str) {
        Intrinsics.f(str, "tag");
        this.handler.removeCallbacksAndMessages(str);
    }

    public final void cancelAll() {
        this.handler.removeCallbacksAndMessages((Object) null);
    }

    public final void schedule(Runnable runnable, String str, long j2) {
        Intrinsics.f(runnable, "runnable");
        Intrinsics.f(str, "tag");
        this.handler.postAtTime(runnable, str, calculateTime(j2));
    }

    public final void schedule(Runnable runnable, long j2) {
        Intrinsics.f(runnable, "runnable");
        this.handler.postAtTime(runnable, calculateTime(j2));
    }
}
