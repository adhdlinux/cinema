package io.reactivex.android.schedulers;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

final class HandlerScheduler extends Scheduler {

    /* renamed from: b  reason: collision with root package name */
    private final Handler f38318b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f38319c;

    private static final class HandlerWorker extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        private final Handler f38320b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f38321c;

        /* renamed from: d  reason: collision with root package name */
        private volatile boolean f38322d;

        HandlerWorker(Handler handler, boolean z2) {
            this.f38320b = handler;
            this.f38321c = z2;
        }

        @SuppressLint({"NewApi"})
        public Disposable c(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.f38322d) {
                return Disposables.a();
            } else {
                ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.f38320b, RxJavaPlugins.u(runnable));
                Message obtain = Message.obtain(this.f38320b, scheduledRunnable);
                obtain.obj = this;
                if (this.f38321c) {
                    obtain.setAsynchronous(true);
                }
                this.f38320b.sendMessageDelayed(obtain, timeUnit.toMillis(j2));
                if (!this.f38322d) {
                    return scheduledRunnable;
                }
                this.f38320b.removeCallbacks(scheduledRunnable);
                return Disposables.a();
            }
        }

        public void dispose() {
            this.f38322d = true;
            this.f38320b.removeCallbacksAndMessages(this);
        }

        public boolean isDisposed() {
            return this.f38322d;
        }
    }

    private static final class ScheduledRunnable implements Runnable, Disposable {

        /* renamed from: b  reason: collision with root package name */
        private final Handler f38323b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f38324c;

        /* renamed from: d  reason: collision with root package name */
        private volatile boolean f38325d;

        ScheduledRunnable(Handler handler, Runnable runnable) {
            this.f38323b = handler;
            this.f38324c = runnable;
        }

        public void dispose() {
            this.f38323b.removeCallbacks(this);
            this.f38325d = true;
        }

        public boolean isDisposed() {
            return this.f38325d;
        }

        public void run() {
            try {
                this.f38324c.run();
            } catch (Throwable th) {
                RxJavaPlugins.s(th);
            }
        }
    }

    HandlerScheduler(Handler handler, boolean z2) {
        this.f38318b = handler;
        this.f38319c = z2;
    }

    public Scheduler.Worker a() {
        return new HandlerWorker(this.f38318b, this.f38319c);
    }

    @SuppressLint({"NewApi"})
    public Disposable d(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit != null) {
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.f38318b, RxJavaPlugins.u(runnable));
            Message obtain = Message.obtain(this.f38318b, scheduledRunnable);
            if (this.f38319c) {
                obtain.setAsynchronous(true);
            }
            this.f38318b.sendMessageDelayed(obtain, timeUnit.toMillis(j2));
            return scheduledRunnable;
        } else {
            throw new NullPointerException("unit == null");
        }
    }
}
