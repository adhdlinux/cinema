package com.facebook.imagepipeline.core;

import android.os.Process;
import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@Nullsafe(Nullsafe.Mode.STRICT)
public class PriorityThreadFactory implements ThreadFactory {
    private final boolean mAddThreadNumber;
    private final String mPrefix;
    private final AtomicInteger mThreadNumber;
    /* access modifiers changed from: private */
    public final int mThreadPriority;

    public PriorityThreadFactory(int i2) {
        this(i2, "PriorityThreadFactory", true);
    }

    public Thread newThread(final Runnable runnable) {
        String str;
        AnonymousClass1 r02 = new Runnable() {
            public void run() {
                try {
                    Process.setThreadPriority(PriorityThreadFactory.this.mThreadPriority);
                } catch (Throwable unused) {
                }
                runnable.run();
            }
        };
        if (this.mAddThreadNumber) {
            str = this.mPrefix + "-" + this.mThreadNumber.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(r02, str);
    }

    public PriorityThreadFactory(int i2, String str, boolean z2) {
        this.mThreadNumber = new AtomicInteger(1);
        this.mThreadPriority = i2;
        this.mPrefix = str;
        this.mAddThreadNumber = z2;
    }
}
