package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
@DoNotStrip
public class AwakeTimeSinceBootClock implements MonotonicClock, MonotonicNanoClock {
    @DoNotStrip
    private static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();

    private AwakeTimeSinceBootClock() {
    }

    @DoNotStrip
    public static AwakeTimeSinceBootClock get() {
        return INSTANCE;
    }

    @DoNotStrip
    public long now() {
        return SystemClock.uptimeMillis();
    }

    @DoNotStrip
    public long nowNanos() {
        return System.nanoTime();
    }
}
