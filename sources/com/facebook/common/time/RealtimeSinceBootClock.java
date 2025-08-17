package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
@DoNotStrip
public class RealtimeSinceBootClock implements MonotonicClock {
    private static final RealtimeSinceBootClock INSTANCE = new RealtimeSinceBootClock();

    private RealtimeSinceBootClock() {
    }

    @DoNotStrip
    public static RealtimeSinceBootClock get() {
        return INSTANCE;
    }

    public long now() {
        return SystemClock.elapsedRealtime();
    }
}
