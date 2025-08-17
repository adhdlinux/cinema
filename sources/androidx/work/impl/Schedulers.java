package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmScheduler;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.PackageManagerHelper;
import java.util.List;

public class Schedulers {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12260a = Logger.f("Schedulers");

    private Schedulers() {
    }

    static Scheduler a(Context context, WorkManagerImpl workManagerImpl) {
        if (Build.VERSION.SDK_INT >= 23) {
            SystemJobScheduler systemJobScheduler = new SystemJobScheduler(context, workManagerImpl);
            PackageManagerHelper.a(context, SystemJobService.class, true);
            Logger.c().a(f12260a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return systemJobScheduler;
        }
        Scheduler c2 = c(context);
        if (c2 != null) {
            return c2;
        }
        SystemAlarmScheduler systemAlarmScheduler = new SystemAlarmScheduler(context);
        PackageManagerHelper.a(context, SystemAlarmService.class, true);
        Logger.c().a(f12260a, "Created SystemAlarmScheduler", new Throwable[0]);
        return systemAlarmScheduler;
    }

    public static void b(Configuration configuration, WorkDatabase workDatabase, List<Scheduler> list) {
        if (list != null && list.size() != 0) {
            WorkSpecDao D = workDatabase.D();
            workDatabase.c();
            try {
                List<WorkSpec> n2 = D.n(configuration.h());
                List<WorkSpec> j2 = D.j(200);
                if (n2 != null && n2.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (WorkSpec workSpec : n2) {
                        D.l(workSpec.f12516a, currentTimeMillis);
                    }
                }
                workDatabase.t();
                if (n2 != null && n2.size() > 0) {
                    WorkSpec[] workSpecArr = (WorkSpec[]) n2.toArray(new WorkSpec[n2.size()]);
                    for (Scheduler next : list) {
                        if (next.d()) {
                            next.c(workSpecArr);
                        }
                    }
                }
                if (j2 != null && j2.size() > 0) {
                    WorkSpec[] workSpecArr2 = (WorkSpec[]) j2.toArray(new WorkSpec[j2.size()]);
                    for (Scheduler next2 : list) {
                        if (!next2.d()) {
                            next2.c(workSpecArr2);
                        }
                    }
                }
            } finally {
                workDatabase.g();
            }
        }
    }

    private static Scheduler c(Context context) {
        try {
            Scheduler scheduler = (Scheduler) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            Logger.c().a(f12260a, String.format("Created %s", new Object[]{"androidx.work.impl.background.gcm.GcmScheduler"}), new Throwable[0]);
            return scheduler;
        } catch (Throwable th) {
            Logger.c().a(f12260a, "Unable to create GCM Scheduler", th);
            return null;
        }
    }
}
