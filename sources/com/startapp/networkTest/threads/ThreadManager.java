package com.startapp.networkTest.threads;

import com.startapp.n2;
import com.startapp.p2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadManager {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadManager f35517a = new ThreadManager();

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f35518b = new p2(a(1, 60, TimeUnit.SECONDS, true));

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f35519c;

    /* renamed from: d  reason: collision with root package name */
    private final ExecutorService f35520d;

    public class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f35521a = new AtomicInteger();

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f35522b;

        public a(String str) {
            this.f35522b = str;
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.f35522b + "-" + this.f35521a.incrementAndGet());
        }
    }

    public class b implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            try {
                threadPoolExecutor.getQueue().put(runnable);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private ThreadManager() {
        StringBuilder sb = new StringBuilder();
        Class<ThreadManager> cls = ThreadManager.class;
        sb.append(cls.getSimpleName());
        sb.append("-Single");
        this.f35519c = new n2(a(0, 1, 30, sb.toString()));
        this.f35520d = new n2(a(0, 4, 30, cls.getSimpleName() + "-Cached"));
    }

    public static ThreadManager b() {
        return f35517a;
    }

    public ExecutorService a() {
        return this.f35520d;
    }

    public ExecutorService c() {
        return this.f35519c;
    }

    public ScheduledExecutorService d() {
        return this.f35518b;
    }

    private static ExecutorService a(int i2, int i3, long j2, String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i3, j2, TimeUnit.SECONDS, new LinkedTransferQueue<Runnable>() {
            /* renamed from: a */
            public boolean offer(Runnable runnable) {
                return tryTransfer(runnable);
            }
        }, new a(str), new b());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    private static ScheduledThreadPoolExecutor a(int i2, long j2, TimeUnit timeUnit, boolean z2) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(i2);
        scheduledThreadPoolExecutor.setKeepAliveTime(j2, timeUnit);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(z2);
        return scheduledThreadPoolExecutor;
    }
}
