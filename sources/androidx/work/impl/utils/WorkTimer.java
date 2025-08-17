package androidx.work.impl.utils;

import androidx.work.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class WorkTimer {

    /* renamed from: f  reason: collision with root package name */
    private static final String f12633f = Logger.f("WorkTimer");

    /* renamed from: a  reason: collision with root package name */
    private final ThreadFactory f12634a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f12635b;

    /* renamed from: c  reason: collision with root package name */
    final Map<String, WorkTimerRunnable> f12636c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    final Map<String, TimeLimitExceededListener> f12637d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    final Object f12638e = new Object();

    public interface TimeLimitExceededListener {
        void a(String str);
    }

    public static class WorkTimerRunnable implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final WorkTimer f12641b;

        /* renamed from: c  reason: collision with root package name */
        private final String f12642c;

        WorkTimerRunnable(WorkTimer workTimer, String str) {
            this.f12641b = workTimer;
            this.f12642c = str;
        }

        public void run() {
            synchronized (this.f12641b.f12638e) {
                if (this.f12641b.f12636c.remove(this.f12642c) != null) {
                    TimeLimitExceededListener remove = this.f12641b.f12637d.remove(this.f12642c);
                    if (remove != null) {
                        remove.a(this.f12642c);
                    }
                } else {
                    Logger.c().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", new Object[]{this.f12642c}), new Throwable[0]);
                }
            }
        }
    }

    public WorkTimer() {
        AnonymousClass1 r02 = new ThreadFactory() {

            /* renamed from: b  reason: collision with root package name */
            private int f12639b = 0;

            public Thread newThread(Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                newThread.setName("WorkManager-WorkTimer-thread-" + this.f12639b);
                this.f12639b = this.f12639b + 1;
                return newThread;
            }
        };
        this.f12634a = r02;
        this.f12635b = Executors.newSingleThreadScheduledExecutor(r02);
    }

    public void a() {
        if (!this.f12635b.isShutdown()) {
            this.f12635b.shutdownNow();
        }
    }

    public void b(String str, long j2, TimeLimitExceededListener timeLimitExceededListener) {
        synchronized (this.f12638e) {
            Logger.c().a(f12633f, String.format("Starting timer for %s", new Object[]{str}), new Throwable[0]);
            c(str);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, str);
            this.f12636c.put(str, workTimerRunnable);
            this.f12637d.put(str, timeLimitExceededListener);
            this.f12635b.schedule(workTimerRunnable, j2, TimeUnit.MILLISECONDS);
        }
    }

    public void c(String str) {
        synchronized (this.f12638e) {
            if (this.f12636c.remove(str) != null) {
                Logger.c().a(f12633f, String.format("Stopping timer for %s", new Object[]{str}), new Throwable[0]);
                this.f12637d.remove(str);
            }
        }
    }
}
