package com.chartboost.sdk.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class t1 {

    public class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f18619a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Chartboost Thread #" + this.f18619a.getAndIncrement());
        }
    }

    public static ScheduledExecutorService a() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2, new a());
        scheduledThreadPoolExecutor.prestartAllCoreThreads();
        return scheduledThreadPoolExecutor;
    }

    public static ExecutorService a(int i2) {
        int i3 = i2;
        int i4 = i2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i3, i4, 10, TimeUnit.SECONDS, new PriorityBlockingQueue());
        threadPoolExecutor.prestartAllCoreThreads();
        return threadPoolExecutor;
    }
}
