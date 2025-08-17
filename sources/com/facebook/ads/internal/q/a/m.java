package com.facebook.ads.internal.q.a;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class m implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    protected final AtomicLong f20650a = new AtomicLong();

    /* renamed from: b  reason: collision with root package name */
    private int f20651b = Thread.currentThread().getPriority();

    /* access modifiers changed from: protected */
    public String a() {
        return String.format(Locale.ENGLISH, "com.facebook.ads thread-%d %tF %<tT", new Object[]{Long.valueOf(this.f20650a.incrementAndGet()), Long.valueOf(System.currentTimeMillis())});
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread((ThreadGroup) null, runnable, a(), 0);
        thread.setPriority(this.f20651b);
        return thread;
    }
}
