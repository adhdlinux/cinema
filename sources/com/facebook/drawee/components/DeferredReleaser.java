package com.facebook.drawee.components;

import android.os.Looper;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public abstract class DeferredReleaser {
    private static DeferredReleaser sInstance;

    public interface Releasable {
        void release();
    }

    public static synchronized DeferredReleaser getInstance() {
        DeferredReleaser deferredReleaser;
        synchronized (DeferredReleaser.class) {
            if (sInstance == null) {
                sInstance = new DeferredReleaserConcurrentImpl();
            }
            deferredReleaser = sInstance;
        }
        return deferredReleaser;
    }

    static boolean isOnUiThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public abstract void cancelDeferredRelease(Releasable releasable);

    public abstract void scheduleDeferredRelease(Releasable releasable);
}
