package androidx.work;

import android.os.Build;
import androidx.work.impl.DefaultRunnableScheduler;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class Configuration {

    /* renamed from: a  reason: collision with root package name */
    final Executor f12112a;

    /* renamed from: b  reason: collision with root package name */
    final Executor f12113b;

    /* renamed from: c  reason: collision with root package name */
    final WorkerFactory f12114c;

    /* renamed from: d  reason: collision with root package name */
    final InputMergerFactory f12115d;

    /* renamed from: e  reason: collision with root package name */
    final RunnableScheduler f12116e;

    /* renamed from: f  reason: collision with root package name */
    final String f12117f;

    /* renamed from: g  reason: collision with root package name */
    final int f12118g;

    /* renamed from: h  reason: collision with root package name */
    final int f12119h;

    /* renamed from: i  reason: collision with root package name */
    final int f12120i;

    /* renamed from: j  reason: collision with root package name */
    final int f12121j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f12122k;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        Executor f12126a;

        /* renamed from: b  reason: collision with root package name */
        WorkerFactory f12127b;

        /* renamed from: c  reason: collision with root package name */
        InputMergerFactory f12128c;

        /* renamed from: d  reason: collision with root package name */
        Executor f12129d;

        /* renamed from: e  reason: collision with root package name */
        RunnableScheduler f12130e;

        /* renamed from: f  reason: collision with root package name */
        String f12131f;

        /* renamed from: g  reason: collision with root package name */
        int f12132g = 4;

        /* renamed from: h  reason: collision with root package name */
        int f12133h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f12134i = Integer.MAX_VALUE;

        /* renamed from: j  reason: collision with root package name */
        int f12135j = 20;

        public Configuration a() {
            return new Configuration(this);
        }
    }

    public interface Provider {
        Configuration a();
    }

    Configuration(Builder builder) {
        Executor executor = builder.f12126a;
        if (executor == null) {
            this.f12112a = a(false);
        } else {
            this.f12112a = executor;
        }
        Executor executor2 = builder.f12129d;
        if (executor2 == null) {
            this.f12122k = true;
            this.f12113b = a(true);
        } else {
            this.f12122k = false;
            this.f12113b = executor2;
        }
        WorkerFactory workerFactory = builder.f12127b;
        if (workerFactory == null) {
            this.f12114c = WorkerFactory.c();
        } else {
            this.f12114c = workerFactory;
        }
        InputMergerFactory inputMergerFactory = builder.f12128c;
        if (inputMergerFactory == null) {
            this.f12115d = InputMergerFactory.c();
        } else {
            this.f12115d = inputMergerFactory;
        }
        RunnableScheduler runnableScheduler = builder.f12130e;
        if (runnableScheduler == null) {
            this.f12116e = new DefaultRunnableScheduler();
        } else {
            this.f12116e = runnableScheduler;
        }
        this.f12118g = builder.f12132g;
        this.f12119h = builder.f12133h;
        this.f12120i = builder.f12134i;
        this.f12121j = builder.f12135j;
        this.f12117f = builder.f12131f;
    }

    private Executor a(boolean z2) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), b(z2));
    }

    private ThreadFactory b(final boolean z2) {
        return new ThreadFactory() {

            /* renamed from: b  reason: collision with root package name */
            private final AtomicInteger f12123b = new AtomicInteger(0);

            public Thread newThread(Runnable runnable) {
                String str;
                if (z2) {
                    str = "WM.task-";
                } else {
                    str = "androidx.work-";
                }
                return new Thread(runnable, str + this.f12123b.incrementAndGet());
            }
        };
    }

    public String c() {
        return this.f12117f;
    }

    public InitializationExceptionHandler d() {
        return null;
    }

    public Executor e() {
        return this.f12112a;
    }

    public InputMergerFactory f() {
        return this.f12115d;
    }

    public int g() {
        return this.f12120i;
    }

    public int h() {
        if (Build.VERSION.SDK_INT == 23) {
            return this.f12121j / 2;
        }
        return this.f12121j;
    }

    public int i() {
        return this.f12119h;
    }

    public int j() {
        return this.f12118g;
    }

    public RunnableScheduler k() {
        return this.f12116e;
    }

    public Executor l() {
        return this.f12113b;
    }

    public WorkerFactory m() {
        return this.f12114c;
    }
}
