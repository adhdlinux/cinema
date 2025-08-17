package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import java.util.Collections;
import java.util.List;

public class DelayMetCommandHandler implements WorkConstraintsCallback, ExecutionListener, WorkTimer.TimeLimitExceededListener {

    /* renamed from: k  reason: collision with root package name */
    private static final String f12371k = Logger.f("DelayMetCommandHandler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f12372b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12373c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12374d;

    /* renamed from: e  reason: collision with root package name */
    private final SystemAlarmDispatcher f12375e;

    /* renamed from: f  reason: collision with root package name */
    private final WorkConstraintsTracker f12376f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f12377g = new Object();

    /* renamed from: h  reason: collision with root package name */
    private int f12378h = 0;

    /* renamed from: i  reason: collision with root package name */
    private PowerManager.WakeLock f12379i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12380j = false;

    DelayMetCommandHandler(Context context, int i2, String str, SystemAlarmDispatcher systemAlarmDispatcher) {
        this.f12372b = context;
        this.f12373c = i2;
        this.f12375e = systemAlarmDispatcher;
        this.f12374d = str;
        this.f12376f = new WorkConstraintsTracker(context, systemAlarmDispatcher.f(), this);
    }

    private void c() {
        synchronized (this.f12377g) {
            this.f12376f.e();
            this.f12375e.h().c(this.f12374d);
            PowerManager.WakeLock wakeLock = this.f12379i;
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger.c().a(f12371k, String.format("Releasing wakelock %s for WorkSpec %s", new Object[]{this.f12379i, this.f12374d}), new Throwable[0]);
                this.f12379i.release();
            }
        }
    }

    private void g() {
        synchronized (this.f12377g) {
            if (this.f12378h < 2) {
                this.f12378h = 2;
                Logger c2 = Logger.c();
                String str = f12371k;
                c2.a(str, String.format("Stopping work for WorkSpec %s", new Object[]{this.f12374d}), new Throwable[0]);
                Intent g2 = CommandHandler.g(this.f12372b, this.f12374d);
                SystemAlarmDispatcher systemAlarmDispatcher = this.f12375e;
                systemAlarmDispatcher.k(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, g2, this.f12373c));
                if (this.f12375e.d().g(this.f12374d)) {
                    Logger.c().a(str, String.format("WorkSpec %s needs to be rescheduled", new Object[]{this.f12374d}), new Throwable[0]);
                    Intent f2 = CommandHandler.f(this.f12372b, this.f12374d);
                    SystemAlarmDispatcher systemAlarmDispatcher2 = this.f12375e;
                    systemAlarmDispatcher2.k(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher2, f2, this.f12373c));
                } else {
                    Logger.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", new Object[]{this.f12374d}), new Throwable[0]);
                }
            } else {
                Logger.c().a(f12371k, String.format("Already stopped work for %s", new Object[]{this.f12374d}), new Throwable[0]);
            }
        }
    }

    public void a(String str) {
        Logger.c().a(f12371k, String.format("Exceeded time limits on execution for %s", new Object[]{str}), new Throwable[0]);
        g();
    }

    public void b(List<String> list) {
        g();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f12379i = WakeLocks.b(this.f12372b, String.format("%s (%s)", new Object[]{this.f12374d, Integer.valueOf(this.f12373c)}));
        Logger c2 = Logger.c();
        String str = f12371k;
        c2.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", new Object[]{this.f12379i, this.f12374d}), new Throwable[0]);
        this.f12379i.acquire();
        WorkSpec g2 = this.f12375e.g().o().D().g(this.f12374d);
        if (g2 == null) {
            g();
            return;
        }
        boolean b2 = g2.b();
        this.f12380j = b2;
        if (!b2) {
            Logger.c().a(str, String.format("No constraints for %s", new Object[]{this.f12374d}), new Throwable[0]);
            f(Collections.singletonList(this.f12374d));
            return;
        }
        this.f12376f.d(Collections.singletonList(g2));
    }

    public void e(String str, boolean z2) {
        Logger.c().a(f12371k, String.format("onExecuted %s, %s", new Object[]{str, Boolean.valueOf(z2)}), new Throwable[0]);
        c();
        if (z2) {
            Intent f2 = CommandHandler.f(this.f12372b, this.f12374d);
            SystemAlarmDispatcher systemAlarmDispatcher = this.f12375e;
            systemAlarmDispatcher.k(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, f2, this.f12373c));
        }
        if (this.f12380j) {
            Intent a2 = CommandHandler.a(this.f12372b);
            SystemAlarmDispatcher systemAlarmDispatcher2 = this.f12375e;
            systemAlarmDispatcher2.k(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher2, a2, this.f12373c));
        }
    }

    public void f(List<String> list) {
        if (list.contains(this.f12374d)) {
            synchronized (this.f12377g) {
                if (this.f12378h == 0) {
                    this.f12378h = 1;
                    Logger.c().a(f12371k, String.format("onAllConstraintsMet for %s", new Object[]{this.f12374d}), new Throwable[0]);
                    if (this.f12375e.d().j(this.f12374d)) {
                        this.f12375e.h().b(this.f12374d, 600000, this);
                    } else {
                        c();
                    }
                } else {
                    Logger.c().a(f12371k, String.format("Already started work for %s", new Object[]{this.f12374d}), new Throwable[0]);
                }
            }
        }
    }
}
