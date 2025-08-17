package androidx.work.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class WorkerWrapper implements Runnable {

    /* renamed from: u  reason: collision with root package name */
    static final String f12305u = Logger.f("WorkerWrapper");

    /* renamed from: b  reason: collision with root package name */
    Context f12306b;

    /* renamed from: c  reason: collision with root package name */
    private String f12307c;

    /* renamed from: d  reason: collision with root package name */
    private List<Scheduler> f12308d;

    /* renamed from: e  reason: collision with root package name */
    private WorkerParameters.RuntimeExtras f12309e;

    /* renamed from: f  reason: collision with root package name */
    WorkSpec f12310f;

    /* renamed from: g  reason: collision with root package name */
    ListenableWorker f12311g;

    /* renamed from: h  reason: collision with root package name */
    TaskExecutor f12312h;

    /* renamed from: i  reason: collision with root package name */
    ListenableWorker.Result f12313i = ListenableWorker.Result.a();

    /* renamed from: j  reason: collision with root package name */
    private Configuration f12314j;

    /* renamed from: k  reason: collision with root package name */
    private ForegroundProcessor f12315k;

    /* renamed from: l  reason: collision with root package name */
    private WorkDatabase f12316l;

    /* renamed from: m  reason: collision with root package name */
    private WorkSpecDao f12317m;

    /* renamed from: n  reason: collision with root package name */
    private DependencyDao f12318n;

    /* renamed from: o  reason: collision with root package name */
    private WorkTagDao f12319o;

    /* renamed from: p  reason: collision with root package name */
    private List<String> f12320p;

    /* renamed from: q  reason: collision with root package name */
    private String f12321q;

    /* renamed from: r  reason: collision with root package name */
    SettableFuture<Boolean> f12322r = SettableFuture.s();

    /* renamed from: s  reason: collision with root package name */
    ListenableFuture<ListenableWorker.Result> f12323s = null;

    /* renamed from: t  reason: collision with root package name */
    private volatile boolean f12324t;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        Context f12331a;

        /* renamed from: b  reason: collision with root package name */
        ListenableWorker f12332b;

        /* renamed from: c  reason: collision with root package name */
        ForegroundProcessor f12333c;

        /* renamed from: d  reason: collision with root package name */
        TaskExecutor f12334d;

        /* renamed from: e  reason: collision with root package name */
        Configuration f12335e;

        /* renamed from: f  reason: collision with root package name */
        WorkDatabase f12336f;

        /* renamed from: g  reason: collision with root package name */
        String f12337g;

        /* renamed from: h  reason: collision with root package name */
        List<Scheduler> f12338h;

        /* renamed from: i  reason: collision with root package name */
        WorkerParameters.RuntimeExtras f12339i = new WorkerParameters.RuntimeExtras();

        public Builder(Context context, Configuration configuration, TaskExecutor taskExecutor, ForegroundProcessor foregroundProcessor, WorkDatabase workDatabase, String str) {
            this.f12331a = context.getApplicationContext();
            this.f12334d = taskExecutor;
            this.f12333c = foregroundProcessor;
            this.f12335e = configuration;
            this.f12336f = workDatabase;
            this.f12337g = str;
        }

        public WorkerWrapper a() {
            return new WorkerWrapper(this);
        }

        public Builder b(WorkerParameters.RuntimeExtras runtimeExtras) {
            if (runtimeExtras != null) {
                this.f12339i = runtimeExtras;
            }
            return this;
        }

        public Builder c(List<Scheduler> list) {
            this.f12338h = list;
            return this;
        }
    }

    WorkerWrapper(Builder builder) {
        this.f12306b = builder.f12331a;
        this.f12312h = builder.f12334d;
        this.f12315k = builder.f12333c;
        this.f12307c = builder.f12337g;
        this.f12308d = builder.f12338h;
        this.f12309e = builder.f12339i;
        this.f12311g = builder.f12332b;
        this.f12314j = builder.f12335e;
        WorkDatabase workDatabase = builder.f12336f;
        this.f12316l = workDatabase;
        this.f12317m = workDatabase.D();
        this.f12318n = this.f12316l.v();
        this.f12319o = this.f12316l.E();
    }

    private String a(List<String> list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.f12307c);
        sb.append(", tags={ ");
        boolean z2 = true;
        for (String next : list) {
            if (z2) {
                z2 = false;
            } else {
                sb.append(", ");
            }
            sb.append(next);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    private void c(ListenableWorker.Result result) {
        if (result instanceof ListenableWorker.Result.Success) {
            Logger.c().d(f12305u, String.format("Worker result SUCCESS for %s", new Object[]{this.f12321q}), new Throwable[0]);
            if (this.f12310f.d()) {
                h();
            } else {
                m();
            }
        } else if (result instanceof ListenableWorker.Result.Retry) {
            Logger.c().d(f12305u, String.format("Worker result RETRY for %s", new Object[]{this.f12321q}), new Throwable[0]);
            g();
        } else {
            Logger.c().d(f12305u, String.format("Worker result FAILURE for %s", new Object[]{this.f12321q}), new Throwable[0]);
            if (this.f12310f.d()) {
                h();
            } else {
                l();
            }
        }
    }

    private void e(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.f12317m.f(str2) != WorkInfo.State.CANCELLED) {
                this.f12317m.a(WorkInfo.State.FAILED, str2);
            }
            linkedList.addAll(this.f12318n.b(str2));
        }
    }

    private void g() {
        this.f12316l.c();
        try {
            this.f12317m.a(WorkInfo.State.ENQUEUED, this.f12307c);
            this.f12317m.t(this.f12307c, System.currentTimeMillis());
            this.f12317m.l(this.f12307c, -1);
            this.f12316l.t();
        } finally {
            this.f12316l.g();
            i(true);
        }
    }

    private void h() {
        this.f12316l.c();
        try {
            this.f12317m.t(this.f12307c, System.currentTimeMillis());
            this.f12317m.a(WorkInfo.State.ENQUEUED, this.f12307c);
            this.f12317m.r(this.f12307c);
            this.f12317m.l(this.f12307c, -1);
            this.f12316l.t();
        } finally {
            this.f12316l.g();
            i(false);
        }
    }

    /* JADX INFO: finally extract failed */
    private void i(boolean z2) {
        ListenableWorker listenableWorker;
        this.f12316l.c();
        try {
            if (!this.f12316l.D().q()) {
                PackageManagerHelper.a(this.f12306b, RescheduleReceiver.class, false);
            }
            if (z2) {
                this.f12317m.a(WorkInfo.State.ENQUEUED, this.f12307c);
                this.f12317m.l(this.f12307c, -1);
            }
            if (!(this.f12310f == null || (listenableWorker = this.f12311g) == null || !listenableWorker.isRunInForeground())) {
                this.f12315k.a(this.f12307c);
            }
            this.f12316l.t();
            this.f12316l.g();
            this.f12322r.o(Boolean.valueOf(z2));
        } catch (Throwable th) {
            this.f12316l.g();
            throw th;
        }
    }

    private void j() {
        WorkInfo.State f2 = this.f12317m.f(this.f12307c);
        if (f2 == WorkInfo.State.RUNNING) {
            Logger.c().a(f12305u, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", new Object[]{this.f12307c}), new Throwable[0]);
            i(true);
            return;
        }
        Logger.c().a(f12305u, String.format("Status for %s is %s; not doing any work", new Object[]{this.f12307c, f2}), new Throwable[0]);
        i(false);
    }

    private void k() {
        Data b2;
        boolean z2;
        if (!n()) {
            this.f12316l.c();
            try {
                WorkSpec g2 = this.f12317m.g(this.f12307c);
                this.f12310f = g2;
                if (g2 == null) {
                    Logger.c().b(f12305u, String.format("Didn't find WorkSpec for id %s", new Object[]{this.f12307c}), new Throwable[0]);
                    i(false);
                    this.f12316l.t();
                } else if (g2.f12517b != WorkInfo.State.ENQUEUED) {
                    j();
                    this.f12316l.t();
                    Logger.c().a(f12305u, String.format("%s is not in ENQUEUED state. Nothing more to do.", new Object[]{this.f12310f.f12518c}), new Throwable[0]);
                    this.f12316l.g();
                } else {
                    if (g2.d() || this.f12310f.c()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        WorkSpec workSpec = this.f12310f;
                        if (workSpec.f12529n == 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2 && currentTimeMillis < workSpec.a()) {
                            Logger.c().a(f12305u, String.format("Delaying execution for %s because it is being executed before schedule.", new Object[]{this.f12310f.f12518c}), new Throwable[0]);
                            i(true);
                            this.f12316l.t();
                            this.f12316l.g();
                            return;
                        }
                    }
                    this.f12316l.t();
                    this.f12316l.g();
                    if (this.f12310f.d()) {
                        b2 = this.f12310f.f12520e;
                    } else {
                        InputMerger b3 = this.f12314j.f().b(this.f12310f.f12519d);
                        if (b3 == null) {
                            Logger.c().b(f12305u, String.format("Could not create Input Merger %s", new Object[]{this.f12310f.f12519d}), new Throwable[0]);
                            l();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f12310f.f12520e);
                        arrayList.addAll(this.f12317m.i(this.f12307c));
                        b2 = b3.b(arrayList);
                    }
                    WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.f12307c), b2, this.f12320p, this.f12309e, this.f12310f.f12526k, this.f12314j.e(), this.f12312h, this.f12314j.m(), new WorkProgressUpdater(this.f12316l, this.f12312h), new WorkForegroundUpdater(this.f12316l, this.f12315k, this.f12312h));
                    if (this.f12311g == null) {
                        this.f12311g = this.f12314j.m().b(this.f12306b, this.f12310f.f12518c, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.f12311g;
                    if (listenableWorker == null) {
                        Logger.c().b(f12305u, String.format("Could not create Worker %s", new Object[]{this.f12310f.f12518c}), new Throwable[0]);
                        l();
                    } else if (listenableWorker.isUsed()) {
                        Logger.c().b(f12305u, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", new Object[]{this.f12310f.f12518c}), new Throwable[0]);
                        l();
                    } else {
                        this.f12311g.setUsed();
                        if (!o()) {
                            j();
                        } else if (!n()) {
                            final SettableFuture s2 = SettableFuture.s();
                            WorkForegroundRunnable workForegroundRunnable = new WorkForegroundRunnable(this.f12306b, this.f12310f, this.f12311g, workerParameters.b(), this.f12312h);
                            this.f12312h.a().execute(workForegroundRunnable);
                            final ListenableFuture<Void> a2 = workForegroundRunnable.a();
                            a2.addListener(new Runnable() {
                                public void run() {
                                    try {
                                        a2.get();
                                        Logger.c().a(WorkerWrapper.f12305u, String.format("Starting work for %s", new Object[]{WorkerWrapper.this.f12310f.f12518c}), new Throwable[0]);
                                        WorkerWrapper workerWrapper = WorkerWrapper.this;
                                        workerWrapper.f12323s = workerWrapper.f12311g.startWork();
                                        s2.q(WorkerWrapper.this.f12323s);
                                    } catch (Throwable th) {
                                        s2.p(th);
                                    }
                                }
                            }, this.f12312h.a());
                            final String str = this.f12321q;
                            s2.addListener(new Runnable() {
                                @SuppressLint({"SyntheticAccessor"})
                                public void run() {
                                    try {
                                        ListenableWorker.Result result = (ListenableWorker.Result) s2.get();
                                        if (result == null) {
                                            Logger.c().b(WorkerWrapper.f12305u, String.format("%s returned a null result. Treating it as a failure.", new Object[]{WorkerWrapper.this.f12310f.f12518c}), new Throwable[0]);
                                        } else {
                                            Logger.c().a(WorkerWrapper.f12305u, String.format("%s returned a %s result.", new Object[]{WorkerWrapper.this.f12310f.f12518c, result}), new Throwable[0]);
                                            WorkerWrapper.this.f12313i = result;
                                        }
                                    } catch (CancellationException e2) {
                                        Logger.c().d(WorkerWrapper.f12305u, String.format("%s was cancelled", new Object[]{str}), e2);
                                    } catch (InterruptedException | ExecutionException e3) {
                                        Logger.c().b(WorkerWrapper.f12305u, String.format("%s failed because it threw an exception/error", new Object[]{str}), e3);
                                    } catch (Throwable th) {
                                        WorkerWrapper.this.f();
                                        throw th;
                                    }
                                    WorkerWrapper.this.f();
                                }
                            }, this.f12312h.getBackgroundExecutor());
                        }
                    }
                }
            } finally {
                this.f12316l.g();
            }
        }
    }

    private void m() {
        this.f12316l.c();
        try {
            this.f12317m.a(WorkInfo.State.SUCCEEDED, this.f12307c);
            this.f12317m.o(this.f12307c, ((ListenableWorker.Result.Success) this.f12313i).e());
            long currentTimeMillis = System.currentTimeMillis();
            for (String next : this.f12318n.b(this.f12307c)) {
                if (this.f12317m.f(next) == WorkInfo.State.BLOCKED && this.f12318n.c(next)) {
                    Logger.c().d(f12305u, String.format("Setting status to enqueued for %s", new Object[]{next}), new Throwable[0]);
                    this.f12317m.a(WorkInfo.State.ENQUEUED, next);
                    this.f12317m.t(next, currentTimeMillis);
                }
            }
            this.f12316l.t();
        } finally {
            this.f12316l.g();
            i(false);
        }
    }

    private boolean n() {
        if (!this.f12324t) {
            return false;
        }
        Logger.c().a(f12305u, String.format("Work interrupted for %s", new Object[]{this.f12321q}), new Throwable[0]);
        WorkInfo.State f2 = this.f12317m.f(this.f12307c);
        if (f2 == null) {
            i(false);
        } else {
            i(!f2.a());
        }
        return true;
    }

    private boolean o() {
        this.f12316l.c();
        try {
            boolean z2 = false;
            if (this.f12317m.f(this.f12307c) == WorkInfo.State.ENQUEUED) {
                this.f12317m.a(WorkInfo.State.RUNNING, this.f12307c);
                this.f12317m.s(this.f12307c);
                z2 = true;
            }
            this.f12316l.t();
            return z2;
        } finally {
            this.f12316l.g();
        }
    }

    public ListenableFuture<Boolean> b() {
        return this.f12322r;
    }

    public void d() {
        boolean z2;
        this.f12324t = true;
        n();
        ListenableFuture<ListenableWorker.Result> listenableFuture = this.f12323s;
        if (listenableFuture != null) {
            z2 = listenableFuture.isDone();
            this.f12323s.cancel(true);
        } else {
            z2 = false;
        }
        ListenableWorker listenableWorker = this.f12311g;
        if (listenableWorker == null || z2) {
            Logger.c().a(f12305u, String.format("WorkSpec %s is already done. Not interrupting.", new Object[]{this.f12310f}), new Throwable[0]);
            return;
        }
        listenableWorker.stop();
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (!n()) {
            this.f12316l.c();
            try {
                WorkInfo.State f2 = this.f12317m.f(this.f12307c);
                this.f12316l.C().delete(this.f12307c);
                if (f2 == null) {
                    i(false);
                } else if (f2 == WorkInfo.State.RUNNING) {
                    c(this.f12313i);
                } else if (!f2.a()) {
                    g();
                }
                this.f12316l.t();
            } finally {
                this.f12316l.g();
            }
        }
        List<Scheduler> list = this.f12308d;
        if (list != null) {
            for (Scheduler a2 : list) {
                a2.a(this.f12307c);
            }
            Schedulers.b(this.f12314j, this.f12316l, this.f12308d);
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.f12316l.c();
        try {
            e(this.f12307c);
            this.f12317m.o(this.f12307c, ((ListenableWorker.Result.Failure) this.f12313i).e());
            this.f12316l.t();
        } finally {
            this.f12316l.g();
            i(false);
        }
    }

    public void run() {
        List<String> a2 = this.f12319o.a(this.f12307c);
        this.f12320p = a2;
        this.f12321q = a(a2);
        k();
    }
}
