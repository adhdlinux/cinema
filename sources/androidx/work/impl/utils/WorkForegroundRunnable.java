package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.os.BuildCompat;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;

public class WorkForegroundRunnable implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    static final String f12606h = Logger.f("WorkForegroundRunnable");

    /* renamed from: b  reason: collision with root package name */
    final SettableFuture<Void> f12607b = SettableFuture.s();

    /* renamed from: c  reason: collision with root package name */
    final Context f12608c;

    /* renamed from: d  reason: collision with root package name */
    final WorkSpec f12609d;

    /* renamed from: e  reason: collision with root package name */
    final ListenableWorker f12610e;

    /* renamed from: f  reason: collision with root package name */
    final ForegroundUpdater f12611f;

    /* renamed from: g  reason: collision with root package name */
    final TaskExecutor f12612g;

    @SuppressLint({"LambdaLast"})
    public WorkForegroundRunnable(Context context, WorkSpec workSpec, ListenableWorker listenableWorker, ForegroundUpdater foregroundUpdater, TaskExecutor taskExecutor) {
        this.f12608c = context;
        this.f12609d = workSpec;
        this.f12610e = listenableWorker;
        this.f12611f = foregroundUpdater;
        this.f12612g = taskExecutor;
    }

    public ListenableFuture<Void> a() {
        return this.f12607b;
    }

    @SuppressLint({"UnsafeExperimentalUsageError"})
    public void run() {
        if (!this.f12609d.f12532q || BuildCompat.c()) {
            this.f12607b.o(null);
            return;
        }
        final SettableFuture s2 = SettableFuture.s();
        this.f12612g.a().execute(new Runnable() {
            public void run() {
                s2.q(WorkForegroundRunnable.this.f12610e.getForegroundInfoAsync());
            }
        });
        s2.addListener(new Runnable() {
            public void run() {
                try {
                    ForegroundInfo foregroundInfo = (ForegroundInfo) s2.get();
                    if (foregroundInfo != null) {
                        Logger.c().a(WorkForegroundRunnable.f12606h, String.format("Updating notification for %s", new Object[]{WorkForegroundRunnable.this.f12609d.f12518c}), new Throwable[0]);
                        WorkForegroundRunnable.this.f12610e.setRunInForeground(true);
                        WorkForegroundRunnable workForegroundRunnable = WorkForegroundRunnable.this;
                        workForegroundRunnable.f12607b.q(workForegroundRunnable.f12611f.a(workForegroundRunnable.f12608c, workForegroundRunnable.f12610e.getId(), foregroundInfo));
                        return;
                    }
                    throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", new Object[]{WorkForegroundRunnable.this.f12609d.f12518c}));
                } catch (Throwable th) {
                    WorkForegroundRunnable.this.f12607b.p(th);
                }
            }
        }, this.f12612g.a());
    }
}
