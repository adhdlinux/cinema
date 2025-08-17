package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask<Params, Progress, Result> {

    /* renamed from: g  reason: collision with root package name */
    private static final ThreadFactory f3798g;

    /* renamed from: h  reason: collision with root package name */
    private static final BlockingQueue<Runnable> f3799h;

    /* renamed from: i  reason: collision with root package name */
    public static final Executor f3800i;

    /* renamed from: j  reason: collision with root package name */
    private static InternalHandler f3801j;

    /* renamed from: k  reason: collision with root package name */
    private static volatile Executor f3802k;

    /* renamed from: b  reason: collision with root package name */
    private final WorkerRunnable<Params, Result> f3803b;

    /* renamed from: c  reason: collision with root package name */
    private final FutureTask<Result> f3804c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Status f3805d = Status.PENDING;

    /* renamed from: e  reason: collision with root package name */
    final AtomicBoolean f3806e = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    final AtomicBoolean f3807f = new AtomicBoolean();

    /* renamed from: androidx.loader.content.ModernAsyncTask$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3811a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.loader.content.ModernAsyncTask$Status[] r0 = androidx.loader.content.ModernAsyncTask.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3811a = r0
                androidx.loader.content.ModernAsyncTask$Status r1 = androidx.loader.content.ModernAsyncTask.Status.RUNNING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3811a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.loader.content.ModernAsyncTask$Status r1 = androidx.loader.content.ModernAsyncTask.Status.FINISHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.loader.content.ModernAsyncTask.AnonymousClass4.<clinit>():void");
        }
    }

    private static class AsyncTaskResult<Data> {

        /* renamed from: a  reason: collision with root package name */
        final ModernAsyncTask f3812a;

        /* renamed from: b  reason: collision with root package name */
        final Data[] f3813b;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f3812a = modernAsyncTask;
            this.f3813b = dataArr;
        }
    }

    private static class InternalHandler extends Handler {
        InternalHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                asyncTaskResult.f3812a.d(asyncTaskResult.f3813b[0]);
            } else if (i2 == 2) {
                asyncTaskResult.f3812a.k(asyncTaskResult.f3813b);
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {

        /* renamed from: b  reason: collision with root package name */
        Params[] f3818b;

        WorkerRunnable() {
        }
    }

    static {
        AnonymousClass1 r7 = new ThreadFactory() {

            /* renamed from: b  reason: collision with root package name */
            private final AtomicInteger f3808b = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ModernAsyncTask #" + this.f3808b.getAndIncrement());
            }
        };
        f3798g = r7;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f3799h = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, linkedBlockingQueue, r7);
        f3800i = threadPoolExecutor;
        f3802k = threadPoolExecutor;
    }

    ModernAsyncTask() {
        AnonymousClass2 r02 = new WorkerRunnable<Params, Result>() {
            public Result call() throws Exception {
                ModernAsyncTask.this.f3807f.set(true);
                Result result = null;
                try {
                    Process.setThreadPriority(10);
                    result = ModernAsyncTask.this.b(this.f3818b);
                    Binder.flushPendingCommands();
                    ModernAsyncTask.this.l(result);
                    return result;
                } catch (Throwable th) {
                    ModernAsyncTask.this.l(result);
                    throw th;
                }
            }
        };
        this.f3803b = r02;
        this.f3804c = new FutureTask<Result>(r02) {
            /* access modifiers changed from: protected */
            public void done() {
                try {
                    ModernAsyncTask.this.m(get());
                } catch (InterruptedException e2) {
                    Log.w("AsyncTask", e2);
                } catch (ExecutionException e3) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", e3.getCause());
                } catch (CancellationException unused) {
                    ModernAsyncTask.this.m(null);
                } catch (Throwable th) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", th);
                }
            }
        };
    }

    private static Handler e() {
        InternalHandler internalHandler;
        synchronized (ModernAsyncTask.class) {
            if (f3801j == null) {
                f3801j = new InternalHandler();
            }
            internalHandler = f3801j;
        }
        return internalHandler;
    }

    public final boolean a(boolean z2) {
        this.f3806e.set(true);
        return this.f3804c.cancel(z2);
    }

    /* access modifiers changed from: protected */
    public abstract Result b(Params... paramsArr);

    public final ModernAsyncTask<Params, Progress, Result> c(Executor executor, Params... paramsArr) {
        if (this.f3805d != Status.PENDING) {
            int i2 = AnonymousClass4.f3811a[this.f3805d.ordinal()];
            if (i2 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i2 != 2) {
                throw new IllegalStateException("We should never reach this state");
            } else {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        } else {
            this.f3805d = Status.RUNNING;
            j();
            this.f3803b.f3818b = paramsArr;
            executor.execute(this.f3804c);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Result result) {
        if (f()) {
            h(result);
        } else {
            i(result);
        }
        this.f3805d = Status.FINISHED;
    }

    public final boolean f() {
        return this.f3806e.get();
    }

    /* access modifiers changed from: protected */
    public void g() {
    }

    /* access modifiers changed from: protected */
    public void h(Result result) {
        g();
    }

    /* access modifiers changed from: protected */
    public void i(Result result) {
    }

    /* access modifiers changed from: protected */
    public void j() {
    }

    /* access modifiers changed from: protected */
    public void k(Progress... progressArr) {
    }

    /* access modifiers changed from: package-private */
    public Result l(Result result) {
        e().obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: package-private */
    public void m(Result result) {
        if (!this.f3807f.get()) {
            l(result);
        }
    }
}
