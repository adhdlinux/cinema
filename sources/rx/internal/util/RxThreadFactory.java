package rx.internal.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public final class RxThreadFactory implements ThreadFactory {

    /* renamed from: d  reason: collision with root package name */
    static final AtomicLongFieldUpdater<RxThreadFactory> f42089d = AtomicLongFieldUpdater.newUpdater(RxThreadFactory.class, "c");

    /* renamed from: b  reason: collision with root package name */
    final String f42090b;

    /* renamed from: c  reason: collision with root package name */
    volatile long f42091c;

    public RxThreadFactory(String str) {
        this.f42090b = str;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f42090b + f42089d.incrementAndGet(this));
        thread.setDaemon(true);
        return thread;
    }
}
