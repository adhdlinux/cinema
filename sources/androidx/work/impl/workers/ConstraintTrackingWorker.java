package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public class ConstraintTrackingWorker extends ListenableWorker implements WorkConstraintsCallback {

    /* renamed from: g  reason: collision with root package name */
    private static final String f12676g = Logger.f("ConstraintTrkngWrkr");

    /* renamed from: b  reason: collision with root package name */
    private WorkerParameters f12677b;

    /* renamed from: c  reason: collision with root package name */
    final Object f12678c = new Object();

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f12679d = false;

    /* renamed from: e  reason: collision with root package name */
    SettableFuture<ListenableWorker.Result> f12680e = SettableFuture.s();

    /* renamed from: f  reason: collision with root package name */
    private ListenableWorker f12681f;

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f12677b = workerParameters;
    }

    public WorkDatabase a() {
        return WorkManagerImpl.k(getApplicationContext()).o();
    }

    public void b(List<String> list) {
        Logger.c().a(f12676g, String.format("Constraints changed for %s", new Object[]{list}), new Throwable[0]);
        synchronized (this.f12678c) {
            this.f12679d = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f12680e.o(ListenableWorker.Result.a());
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f12680e.o(ListenableWorker.Result.b());
    }

    /* access modifiers changed from: package-private */
    public void e() {
        String k2 = getInputData().k("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(k2)) {
            Logger.c().b(f12676g, "No worker to delegate to.", new Throwable[0]);
            c();
            return;
        }
        ListenableWorker b2 = getWorkerFactory().b(getApplicationContext(), k2, this.f12677b);
        this.f12681f = b2;
        if (b2 == null) {
            Logger.c().a(f12676g, "No worker to delegate to.", new Throwable[0]);
            c();
            return;
        }
        WorkSpec g2 = a().D().g(getId().toString());
        if (g2 == null) {
            c();
            return;
        }
        WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(getApplicationContext(), getTaskExecutor(), this);
        workConstraintsTracker.d(Collections.singletonList(g2));
        if (workConstraintsTracker.c(getId().toString())) {
            Logger.c().a(f12676g, String.format("Constraints met for delegate %s", new Object[]{k2}), new Throwable[0]);
            try {
                final ListenableFuture<ListenableWorker.Result> startWork = this.f12681f.startWork();
                startWork.addListener(new Runnable() {
                    public void run() {
                        synchronized (ConstraintTrackingWorker.this.f12678c) {
                            if (ConstraintTrackingWorker.this.f12679d) {
                                ConstraintTrackingWorker.this.d();
                            } else {
                                ConstraintTrackingWorker.this.f12680e.q(startWork);
                            }
                        }
                    }
                }, getBackgroundExecutor());
            } catch (Throwable th) {
                Logger c2 = Logger.c();
                String str = f12676g;
                c2.a(str, String.format("Delegated worker %s threw exception in startWork.", new Object[]{k2}), th);
                synchronized (this.f12678c) {
                    if (this.f12679d) {
                        Logger.c().a(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                        d();
                    } else {
                        c();
                    }
                }
            }
        } else {
            Logger.c().a(f12676g, String.format("Constraints not met for delegate %s. Requesting retry.", new Object[]{k2}), new Throwable[0]);
            d();
        }
    }

    public void f(List<String> list) {
    }

    public TaskExecutor getTaskExecutor() {
        return WorkManagerImpl.k(getApplicationContext()).p();
    }

    public boolean isRunInForeground() {
        ListenableWorker listenableWorker = this.f12681f;
        return listenableWorker != null && listenableWorker.isRunInForeground();
    }

    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.f12681f;
        if (listenableWorker != null && !listenableWorker.isStopped()) {
            this.f12681f.stop();
        }
    }

    public ListenableFuture<ListenableWorker.Result> startWork() {
        getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                ConstraintTrackingWorker.this.e();
            }
        });
        return this.f12680e;
    }
}
