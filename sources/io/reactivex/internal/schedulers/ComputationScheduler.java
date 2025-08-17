package io.reactivex.internal.schedulers;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ComputationScheduler extends Scheduler {

    /* renamed from: d  reason: collision with root package name */
    static final FixedSchedulerPool f39942d;

    /* renamed from: e  reason: collision with root package name */
    static final RxThreadFactory f39943e;

    /* renamed from: f  reason: collision with root package name */
    static final int f39944f = f(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: g  reason: collision with root package name */
    static final PoolWorker f39945g;

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f39946b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<FixedSchedulerPool> f39947c;

    static final class EventLoopWorker extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        private final ListCompositeDisposable f39948b;

        /* renamed from: c  reason: collision with root package name */
        private final CompositeDisposable f39949c;

        /* renamed from: d  reason: collision with root package name */
        private final ListCompositeDisposable f39950d;

        /* renamed from: e  reason: collision with root package name */
        private final PoolWorker f39951e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f39952f;

        EventLoopWorker(PoolWorker poolWorker) {
            this.f39951e = poolWorker;
            ListCompositeDisposable listCompositeDisposable = new ListCompositeDisposable();
            this.f39948b = listCompositeDisposable;
            CompositeDisposable compositeDisposable = new CompositeDisposable();
            this.f39949c = compositeDisposable;
            ListCompositeDisposable listCompositeDisposable2 = new ListCompositeDisposable();
            this.f39950d = listCompositeDisposable2;
            listCompositeDisposable2.b(listCompositeDisposable);
            listCompositeDisposable2.b(compositeDisposable);
        }

        public Disposable b(Runnable runnable) {
            if (this.f39952f) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f39951e.e(runnable, 0, TimeUnit.MILLISECONDS, this.f39948b);
        }

        public Disposable c(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (this.f39952f) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f39951e.e(runnable, j2, timeUnit, this.f39949c);
        }

        public void dispose() {
            if (!this.f39952f) {
                this.f39952f = true;
                this.f39950d.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f39952f;
        }
    }

    static final class FixedSchedulerPool {

        /* renamed from: a  reason: collision with root package name */
        final int f39953a;

        /* renamed from: b  reason: collision with root package name */
        final PoolWorker[] f39954b;

        /* renamed from: c  reason: collision with root package name */
        long f39955c;

        FixedSchedulerPool(int i2, ThreadFactory threadFactory) {
            this.f39953a = i2;
            this.f39954b = new PoolWorker[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f39954b[i3] = new PoolWorker(threadFactory);
            }
        }

        public PoolWorker a() {
            int i2 = this.f39953a;
            if (i2 == 0) {
                return ComputationScheduler.f39945g;
            }
            PoolWorker[] poolWorkerArr = this.f39954b;
            long j2 = this.f39955c;
            this.f39955c = 1 + j2;
            return poolWorkerArr[(int) (j2 % ((long) i2))];
        }

        public void b() {
            for (PoolWorker dispose : this.f39954b) {
                dispose.dispose();
            }
        }
    }

    static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        PoolWorker poolWorker = new PoolWorker(new RxThreadFactory("RxComputationShutdown"));
        f39945g = poolWorker;
        poolWorker.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f39943e = rxThreadFactory;
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(0, rxThreadFactory);
        f39942d = fixedSchedulerPool;
        fixedSchedulerPool.b();
    }

    public ComputationScheduler() {
        this(f39943e);
    }

    static int f(int i2, int i3) {
        return (i3 <= 0 || i3 > i2) ? i2 : i3;
    }

    public Scheduler.Worker a() {
        return new EventLoopWorker(this.f39947c.get().a());
    }

    public Disposable d(Runnable runnable, long j2, TimeUnit timeUnit) {
        return this.f39947c.get().a().f(runnable, j2, timeUnit);
    }

    public Disposable e(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        return this.f39947c.get().a().g(runnable, j2, j3, timeUnit);
    }

    public void g() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(f39944f, this.f39946b);
        if (!f.a(this.f39947c, f39942d, fixedSchedulerPool)) {
            fixedSchedulerPool.b();
        }
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        this.f39946b = threadFactory;
        this.f39947c = new AtomicReference<>(f39942d);
        g();
    }
}
