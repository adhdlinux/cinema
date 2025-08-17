package com.facebook.imagepipeline.memory;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class NoOpPoolStatsTracker implements PoolStatsTracker {
    private static NoOpPoolStatsTracker sInstance;

    private NoOpPoolStatsTracker() {
    }

    public static synchronized NoOpPoolStatsTracker getInstance() {
        NoOpPoolStatsTracker noOpPoolStatsTracker;
        synchronized (NoOpPoolStatsTracker.class) {
            if (sInstance == null) {
                sInstance = new NoOpPoolStatsTracker();
            }
            noOpPoolStatsTracker = sInstance;
        }
        return noOpPoolStatsTracker;
    }

    public void onAlloc(int i2) {
    }

    public void onFree(int i2) {
    }

    public void onHardCapReached() {
    }

    public void onSoftCapReached() {
    }

    public void onValueRelease(int i2) {
    }

    public void onValueReuse(int i2) {
    }

    public void setBasePool(BasePool basePool) {
    }
}
