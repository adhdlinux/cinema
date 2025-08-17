package androidx.work.impl.utils;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class SerialExecutor implements Executor {

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<Task> f12591b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private final Executor f12592c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f12593d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private volatile Runnable f12594e;

    static class Task implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final SerialExecutor f12595b;

        /* renamed from: c  reason: collision with root package name */
        final Runnable f12596c;

        Task(SerialExecutor serialExecutor, Runnable runnable) {
            this.f12595b = serialExecutor;
            this.f12596c = runnable;
        }

        public void run() {
            try {
                this.f12596c.run();
            } finally {
                this.f12595b.b();
            }
        }
    }

    public SerialExecutor(Executor executor) {
        this.f12592c = executor;
    }

    public boolean a() {
        boolean z2;
        synchronized (this.f12593d) {
            if (!this.f12591b.isEmpty()) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        synchronized (this.f12593d) {
            Runnable poll = this.f12591b.poll();
            this.f12594e = poll;
            if (poll != null) {
                this.f12592c.execute(this.f12594e);
            }
        }
    }

    public void execute(Runnable runnable) {
        synchronized (this.f12593d) {
            this.f12591b.add(new Task(this, runnable));
            if (this.f12594e == null) {
                b();
            }
        }
    }
}
