package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;

public class SystemAlarmScheduler implements Scheduler {

    /* renamed from: c  reason: collision with root package name */
    private static final String f12398c = Logger.f("SystemAlarmScheduler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f12399b;

    public SystemAlarmScheduler(Context context) {
        this.f12399b = context.getApplicationContext();
    }

    private void b(WorkSpec workSpec) {
        Logger.c().a(f12398c, String.format("Scheduling work with workSpecId %s", new Object[]{workSpec.f12516a}), new Throwable[0]);
        this.f12399b.startService(CommandHandler.f(this.f12399b, workSpec.f12516a));
    }

    public void a(String str) {
        this.f12399b.startService(CommandHandler.g(this.f12399b, str));
    }

    public void c(WorkSpec... workSpecArr) {
        for (WorkSpec b2 : workSpecArr) {
            b(b2);
        }
    }

    public boolean d() {
        return true;
    }
}
