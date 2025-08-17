package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.utils.WakeLocks;

public class SystemAlarmService extends LifecycleService implements SystemAlarmDispatcher.CommandsCompletedListener {

    /* renamed from: e  reason: collision with root package name */
    private static final String f12400e = Logger.f("SystemAlarmService");

    /* renamed from: c  reason: collision with root package name */
    private SystemAlarmDispatcher f12401c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12402d;

    private void e() {
        SystemAlarmDispatcher systemAlarmDispatcher = new SystemAlarmDispatcher(this);
        this.f12401c = systemAlarmDispatcher;
        systemAlarmDispatcher.m(this);
    }

    public void b() {
        this.f12402d = true;
        Logger.c().a(f12400e, "All commands completed in dispatcher", new Throwable[0]);
        WakeLocks.a();
        stopSelf();
    }

    public void onCreate() {
        super.onCreate();
        e();
        this.f12402d = false;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f12402d = true;
        this.f12401c.j();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.f12402d) {
            Logger.c().d(f12400e, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f12401c.j();
            e();
            this.f12402d = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f12401c.a(intent, i3);
        return 3;
    }
}
