package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.ProcessUtils;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GreedyScheduler implements Scheduler, WorkConstraintsCallback, ExecutionListener {

    /* renamed from: j  reason: collision with root package name */
    private static final String f12346j = Logger.f("GreedyScheduler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f12347b;

    /* renamed from: c  reason: collision with root package name */
    private final WorkManagerImpl f12348c;

    /* renamed from: d  reason: collision with root package name */
    private final WorkConstraintsTracker f12349d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<WorkSpec> f12350e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private DelayedWorkTracker f12351f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12352g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f12353h;

    /* renamed from: i  reason: collision with root package name */
    Boolean f12354i;

    public GreedyScheduler(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkManagerImpl workManagerImpl) {
        this.f12347b = context;
        this.f12348c = workManagerImpl;
        this.f12349d = new WorkConstraintsTracker(context, taskExecutor, this);
        this.f12351f = new DelayedWorkTracker(this, configuration.k());
        this.f12353h = new Object();
    }

    private void g() {
        this.f12354i = Boolean.valueOf(ProcessUtils.b(this.f12347b, this.f12348c.i()));
    }

    private void h() {
        if (!this.f12352g) {
            this.f12348c.m().c(this);
            this.f12352g = true;
        }
    }

    private void i(String str) {
        synchronized (this.f12353h) {
            Iterator<WorkSpec> it2 = this.f12350e.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                WorkSpec next = it2.next();
                if (next.f12516a.equals(str)) {
                    Logger.c().a(f12346j, String.format("Stopping tracking for %s", new Object[]{str}), new Throwable[0]);
                    this.f12350e.remove(next);
                    this.f12349d.d(this.f12350e);
                    break;
                }
            }
        }
    }

    public void a(String str) {
        if (this.f12354i == null) {
            g();
        }
        if (!this.f12354i.booleanValue()) {
            Logger.c().d(f12346j, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        h();
        Logger.c().a(f12346j, String.format("Cancelling work ID %s", new Object[]{str}), new Throwable[0]);
        DelayedWorkTracker delayedWorkTracker = this.f12351f;
        if (delayedWorkTracker != null) {
            delayedWorkTracker.b(str);
        }
        this.f12348c.x(str);
    }

    public void b(List<String> list) {
        for (String next : list) {
            Logger.c().a(f12346j, String.format("Constraints not met: Cancelling work ID %s", new Object[]{next}), new Throwable[0]);
            this.f12348c.x(next);
        }
    }

    public void c(WorkSpec... workSpecArr) {
        if (this.f12354i == null) {
            g();
        }
        if (!this.f12354i.booleanValue()) {
            Logger.c().d(f12346j, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        h();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (WorkSpec workSpec : workSpecArr) {
            long a2 = workSpec.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (workSpec.f12517b == WorkInfo.State.ENQUEUED) {
                if (currentTimeMillis < a2) {
                    DelayedWorkTracker delayedWorkTracker = this.f12351f;
                    if (delayedWorkTracker != null) {
                        delayedWorkTracker.a(workSpec);
                    }
                } else if (workSpec.b()) {
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 23 && workSpec.f12525j.h()) {
                        Logger.c().a(f12346j, String.format("Ignoring WorkSpec %s, Requires device idle.", new Object[]{workSpec}), new Throwable[0]);
                    } else if (i2 < 24 || !workSpec.f12525j.e()) {
                        hashSet.add(workSpec);
                        hashSet2.add(workSpec.f12516a);
                    } else {
                        Logger.c().a(f12346j, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", new Object[]{workSpec}), new Throwable[0]);
                    }
                } else {
                    Logger.c().a(f12346j, String.format("Starting work for %s", new Object[]{workSpec.f12516a}), new Throwable[0]);
                    this.f12348c.u(workSpec.f12516a);
                }
            }
        }
        synchronized (this.f12353h) {
            if (!hashSet.isEmpty()) {
                Logger.c().a(f12346j, String.format("Starting tracking for [%s]", new Object[]{TextUtils.join(",", hashSet2)}), new Throwable[0]);
                this.f12350e.addAll(hashSet);
                this.f12349d.d(this.f12350e);
            }
        }
    }

    public boolean d() {
        return false;
    }

    public void e(String str, boolean z2) {
        i(str);
    }

    public void f(List<String> list) {
        for (String next : list) {
            Logger.c().a(f12346j, String.format("Constraints met: Scheduling work ID %s", new Object[]{next}), new Throwable[0]);
            this.f12348c.u(next);
        }
    }
}
