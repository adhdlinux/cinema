package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class GlideExecutor implements ExecutorService {

    /* renamed from: c  reason: collision with root package name */
    private static final long f16656c = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: d  reason: collision with root package name */
    private static volatile int f16657d;

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f16658b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f16659a;

        /* renamed from: b  reason: collision with root package name */
        private int f16660b;

        /* renamed from: c  reason: collision with root package name */
        private int f16661c;

        /* renamed from: d  reason: collision with root package name */
        private UncaughtThrowableStrategy f16662d = UncaughtThrowableStrategy.f16673d;

        /* renamed from: e  reason: collision with root package name */
        private String f16663e;

        /* renamed from: f  reason: collision with root package name */
        private long f16664f;

        Builder(boolean z2) {
            this.f16659a = z2;
        }

        public GlideExecutor a() {
            if (!TextUtils.isEmpty(this.f16663e)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f16660b, this.f16661c, this.f16664f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(this.f16663e, this.f16662d, this.f16659a));
                if (this.f16664f != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new GlideExecutor(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f16663e);
        }

        public Builder b(String str) {
            this.f16663e = str;
            return this;
        }

        public Builder c(int i2) {
            this.f16660b = i2;
            this.f16661c = i2;
            return this;
        }
    }

    private static final class DefaultThreadFactory implements ThreadFactory {

        /* renamed from: b  reason: collision with root package name */
        private final String f16665b;

        /* renamed from: c  reason: collision with root package name */
        final UncaughtThrowableStrategy f16666c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f16667d;

        /* renamed from: e  reason: collision with root package name */
        private int f16668e;

        DefaultThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z2) {
            this.f16665b = str;
            this.f16666c = uncaughtThrowableStrategy;
            this.f16667d = z2;
        }

        public synchronized Thread newThread(Runnable runnable) {
            AnonymousClass1 r02;
            r02 = new Thread(runnable, "glide-" + this.f16665b + "-thread-" + this.f16668e) {
                public void run() {
                    Process.setThreadPriority(9);
                    if (DefaultThreadFactory.this.f16667d) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        DefaultThreadFactory.this.f16666c.a(th);
                    }
                }
            };
            this.f16668e = this.f16668e + 1;
            return r02;
        }
    }

    public interface UncaughtThrowableStrategy {

        /* renamed from: a  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f16670a = new UncaughtThrowableStrategy() {
            public void a(Throwable th) {
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f16671b;

        /* renamed from: c  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f16672c = new UncaughtThrowableStrategy() {
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };

        /* renamed from: d  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f16673d;

        static {
            AnonymousClass2 r02 = new UncaughtThrowableStrategy() {
                public void a(Throwable th) {
                    if (th != null && Log.isLoggable("GlideExecutor", 6)) {
                        Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                    }
                }
            };
            f16671b = r02;
            f16673d = r02;
        }

        void a(Throwable th);
    }

    GlideExecutor(ExecutorService executorService) {
        this.f16658b = executorService;
    }

    public static int a() {
        if (f16657d == 0) {
            f16657d = Math.min(4, RuntimeCompat.a());
        }
        return f16657d;
    }

    public static Builder b() {
        int i2;
        if (a() >= 4) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        return new Builder(true).c(i2).b("animation");
    }

    public static GlideExecutor c() {
        return b().a();
    }

    public static Builder d() {
        return new Builder(true).c(1).b("disk-cache");
    }

    public static GlideExecutor e() {
        return d().a();
    }

    public static Builder f() {
        return new Builder(false).c(a()).b("source");
    }

    public static GlideExecutor g() {
        return f().a();
    }

    public static GlideExecutor h() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f16656c, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory("source-unlimited", UncaughtThrowableStrategy.f16673d, false)));
    }

    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f16658b.awaitTermination(j2, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.f16658b.execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f16658b.invokeAll(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.f16658b.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.f16658b.isShutdown();
    }

    public boolean isTerminated() {
        return this.f16658b.isTerminated();
    }

    public void shutdown() {
        this.f16658b.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.f16658b.shutdownNow();
    }

    public Future<?> submit(Runnable runnable) {
        return this.f16658b.submit(runnable);
    }

    public String toString() {
        return this.f16658b.toString();
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f16658b.invokeAll(collection, j2, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f16658b.invokeAny(collection, j2, timeUnit);
    }

    public <T> Future<T> submit(Runnable runnable, T t2) {
        return this.f16658b.submit(runnable, t2);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.f16658b.submit(callable);
    }
}
