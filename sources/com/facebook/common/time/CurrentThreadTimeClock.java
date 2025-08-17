package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class CurrentThreadTimeClock implements Clock {
    public long now() {
        return SystemClock.currentThreadTimeMillis();
    }
}
