package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.utils.IdGenerator;

class Alarms {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12355a = Logger.f("Alarms");

    private Alarms() {
    }

    public static void a(Context context, WorkManagerImpl workManagerImpl, String str) {
        SystemIdInfoDao A = workManagerImpl.o().A();
        SystemIdInfo a2 = A.a(str);
        if (a2 != null) {
            b(context, str, a2.f12494b);
            Logger.c().a(f12355a, String.format("Removing SystemIdInfo for workSpecId (%s)", new Object[]{str}), new Throwable[0]);
            A.d(str);
        }
    }

    private static void b(Context context, String str, int i2) {
        int i3;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent b2 = CommandHandler.b(context, str);
        if (Build.VERSION.SDK_INT >= 23) {
            i3 = 603979776;
        } else {
            i3 = 536870912;
        }
        PendingIntent service = PendingIntent.getService(context, i2, b2, i3);
        if (service != null && alarmManager != null) {
            Logger.c().a(f12355a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", new Object[]{str, Integer.valueOf(i2)}), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    public static void c(Context context, WorkManagerImpl workManagerImpl, String str, long j2) {
        WorkDatabase o2 = workManagerImpl.o();
        SystemIdInfoDao A = o2.A();
        SystemIdInfo a2 = A.a(str);
        if (a2 != null) {
            b(context, str, a2.f12494b);
            d(context, str, a2.f12494b, j2);
            return;
        }
        int b2 = new IdGenerator(o2).b();
        A.c(new SystemIdInfo(str, b2));
        d(context, str, b2, j2);
    }

    private static void d(Context context, String str, int i2, long j2) {
        int i3;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (Build.VERSION.SDK_INT >= 23) {
            i3 = 201326592;
        } else {
            i3 = 134217728;
        }
        PendingIntent service = PendingIntent.getService(context, i2, CommandHandler.b(context, str), i3);
        if (alarmManager != null) {
            alarmManager.setExact(0, j2, service);
        }
    }
}
