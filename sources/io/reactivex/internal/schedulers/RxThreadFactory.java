package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class RxThreadFactory extends AtomicLong implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    final String f40006b;

    /* renamed from: c  reason: collision with root package name */
    final int f40007c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f40008d;

    static final class RxCustomThread extends Thread implements NonBlockingThread {
        RxCustomThread(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    public Thread newThread(Runnable runnable) {
        Thread thread;
        String str = this.f40006b + '-' + incrementAndGet();
        if (this.f40008d) {
            thread = new RxCustomThread(runnable, str);
        } else {
            thread = new Thread(runnable, str);
        }
        thread.setPriority(this.f40007c);
        thread.setDaemon(true);
        return thread;
    }

    public String toString() {
        return "RxThreadFactory[" + this.f40006b + "]";
    }

    public RxThreadFactory(String str, int i2) {
        this(str, i2, false);
    }

    public RxThreadFactory(String str, int i2, boolean z2) {
        this.f40006b = str;
        this.f40007c = i2;
        this.f40008d = z2;
    }
}
