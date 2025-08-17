package com.vungle.ads.internal.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

public final class NamedThreadFactory implements ThreadFactory {
    private final AtomicInteger atomicInteger = new AtomicInteger(0);
    private final String name;
    private final ThreadFactory threadFactory = Executors.defaultThreadFactory();

    public NamedThreadFactory(String str) {
        Intrinsics.f(str, "name");
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    public Thread newThread(Runnable runnable) {
        Intrinsics.f(runnable, "r");
        Thread newThread = this.threadFactory.newThread(runnable);
        newThread.setName(this.name + "-th-" + this.atomicInteger.incrementAndGet());
        Intrinsics.e(newThread, "t");
        return newThread;
    }
}
