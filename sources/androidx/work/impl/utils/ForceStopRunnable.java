package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.BuildCompat;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ForceStopRunnable implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    private static final String f12581e = Logger.f("ForceStopRunnable");

    /* renamed from: f  reason: collision with root package name */
    private static final long f12582f = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: b  reason: collision with root package name */
    private final Context f12583b;

    /* renamed from: c  reason: collision with root package name */
    private final WorkManagerImpl f12584c;

    /* renamed from: d  reason: collision with root package name */
    private int f12585d = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private static final String f12586a = Logger.f("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                Logger.c().g(f12586a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
                ForceStopRunnable.g(context);
            }
        }
    }

    public ForceStopRunnable(Context context, WorkManagerImpl workManagerImpl) {
        this.f12583b = context.getApplicationContext();
        this.f12584c = workManagerImpl;
    }

    static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    private static PendingIntent d(Context context, int i2) {
        return PendingIntent.getBroadcast(context, -1, c(context), i2);
    }

    @SuppressLint({"ClassVerificationFailure"})
    static void g(Context context) {
        int i2;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (BuildCompat.c()) {
            i2 = 167772160;
        } else {
            i2 = 134217728;
        }
        PendingIntent d2 = d(context, i2);
        long currentTimeMillis = System.currentTimeMillis() + f12582f;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, d2);
        }
    }

    public boolean a() {
        boolean z2;
        boolean z3;
        if (Build.VERSION.SDK_INT >= 23) {
            z2 = SystemJobScheduler.i(this.f12583b, this.f12584c);
        } else {
            z2 = false;
        }
        WorkDatabase o2 = this.f12584c.o();
        WorkSpecDao D = o2.D();
        WorkProgressDao C = o2.C();
        o2.c();
        try {
            List<WorkSpec> p2 = D.p();
            if (p2 == null || p2.isEmpty()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                for (WorkSpec next : p2) {
                    D.a(WorkInfo.State.ENQUEUED, next.f12516a);
                    D.l(next.f12516a, -1);
                }
            }
            C.a();
            o2.t();
            if (z3 || z2) {
                return true;
            }
            return false;
        } finally {
            o2.g();
        }
    }

    public void b() {
        boolean a2 = a();
        if (h()) {
            Logger.c().a(f12581e, "Rescheduling Workers.", new Throwable[0]);
            this.f12584c.s();
            this.f12584c.l().c(false);
        } else if (e()) {
            Logger.c().a(f12581e, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.f12584c.s();
        } else if (a2) {
            Logger.c().a(f12581e, "Found unfinished work, scheduling it.", new Throwable[0]);
            Schedulers.b(this.f12584c.i(), this.f12584c.o(), this.f12584c.n());
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    public boolean e() {
        int i2;
        try {
            if (BuildCompat.c()) {
                i2 = 570425344;
            } else {
                i2 = 536870912;
            }
            PendingIntent d2 = d(this.f12583b, i2);
            if (Build.VERSION.SDK_INT >= 30) {
                if (d2 != null) {
                    d2.cancel();
                }
                List a2 = ((ActivityManager) this.f12583b.getSystemService("activity")).getHistoricalProcessExitReasons((String) null, 0, 0);
                if (a2 != null && !a2.isEmpty()) {
                    for (int i3 = 0; i3 < a2.size(); i3++) {
                        if (((ApplicationExitInfo) a2.get(i3)).getReason() == 10) {
                            return true;
                        }
                    }
                }
            } else if (d2 == null) {
                g(this.f12583b);
                return true;
            }
            return false;
        } catch (IllegalArgumentException | SecurityException e2) {
            Logger.c().h(f12581e, "Ignoring exception", e2);
            return true;
        }
    }

    public boolean f() {
        Configuration i2 = this.f12584c.i();
        if (TextUtils.isEmpty(i2.c())) {
            Logger.c().a(f12581e, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean b2 = ProcessUtils.b(this.f12583b, i2);
        Logger.c().a(f12581e, String.format("Is default app process = %s", new Object[]{Boolean.valueOf(b2)}), new Throwable[0]);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.f12584c.l().a();
    }

    public void i(long j2) {
        try {
            Thread.sleep(j2);
        } catch (InterruptedException unused) {
        }
    }

    public void run() {
        try {
            if (!f()) {
                this.f12584c.r();
                return;
            }
            while (true) {
                WorkDatabasePathHelper.e(this.f12583b);
                Logger.c().a(f12581e, "Performing cleanup operations.", new Throwable[0]);
                b();
                this.f12584c.r();
                return;
            }
        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e2) {
            int i2 = this.f12585d + 1;
            this.f12585d = i2;
            if (i2 < 3) {
                Logger.c().a(f12581e, String.format("Retrying after %s", new Object[]{Long.valueOf(((long) i2) * 300)}), e2);
                i(((long) this.f12585d) * 300);
            } else {
                Logger.c().b(f12581e, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                this.f12584c.i().d();
                throw illegalStateException;
            }
        } catch (Throwable th) {
            this.f12584c.r();
            throw th;
        }
    }
}
