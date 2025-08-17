package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

public class CommandHandler implements ExecutionListener {

    /* renamed from: e  reason: collision with root package name */
    private static final String f12356e = Logger.f("CommandHandler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f12357b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, ExecutionListener> f12358c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Object f12359d = new Object();

    CommandHandler(Context context) {
        this.f12357b = context;
    }

    static Intent a(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    static Intent b(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent c(Context context, String str, boolean z2) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z2);
        return intent;
    }

    static Intent d(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    static Intent f(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent g(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    private void h(Intent intent, int i2, SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.c().a(f12356e, String.format("Handling constraints changed %s", new Object[]{intent}), new Throwable[0]);
        new ConstraintsCommandHandler(this.f12357b, i2, systemAlarmDispatcher).a();
    }

    private void i(Intent intent, int i2, SystemAlarmDispatcher systemAlarmDispatcher) {
        Bundle extras = intent.getExtras();
        synchronized (this.f12359d) {
            String string = extras.getString("KEY_WORKSPEC_ID");
            Logger c2 = Logger.c();
            String str = f12356e;
            c2.a(str, String.format("Handing delay met for %s", new Object[]{string}), new Throwable[0]);
            if (!this.f12358c.containsKey(string)) {
                DelayMetCommandHandler delayMetCommandHandler = new DelayMetCommandHandler(this.f12357b, i2, string, systemAlarmDispatcher);
                this.f12358c.put(string, delayMetCommandHandler);
                delayMetCommandHandler.d();
            } else {
                Logger.c().a(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", new Object[]{string}), new Throwable[0]);
            }
        }
    }

    private void j(Intent intent, int i2) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z2 = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        Logger.c().a(f12356e, String.format("Handling onExecutionCompleted %s, %s", new Object[]{intent, Integer.valueOf(i2)}), new Throwable[0]);
        e(string, z2);
    }

    private void k(Intent intent, int i2, SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.c().a(f12356e, String.format("Handling reschedule %s, %s", new Object[]{intent, Integer.valueOf(i2)}), new Throwable[0]);
        systemAlarmDispatcher.g().s();
    }

    private void l(Intent intent, int i2, SystemAlarmDispatcher systemAlarmDispatcher) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        Logger c2 = Logger.c();
        String str = f12356e;
        c2.a(str, String.format("Handling schedule work for %s", new Object[]{string}), new Throwable[0]);
        WorkDatabase o2 = systemAlarmDispatcher.g().o();
        o2.c();
        try {
            WorkSpec g2 = o2.D().g(string);
            if (g2 == null) {
                Logger c3 = Logger.c();
                c3.h(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
            } else if (g2.f12517b.a()) {
                Logger c4 = Logger.c();
                c4.h(str, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                o2.g();
            } else {
                long a2 = g2.a();
                if (!g2.b()) {
                    Logger.c().a(str, String.format("Setting up Alarms for %s at %s", new Object[]{string, Long.valueOf(a2)}), new Throwable[0]);
                    Alarms.c(this.f12357b, systemAlarmDispatcher.g(), string, a2);
                } else {
                    Logger.c().a(str, String.format("Opportunistically setting an alarm for %s at %s", new Object[]{string, Long.valueOf(a2)}), new Throwable[0]);
                    Alarms.c(this.f12357b, systemAlarmDispatcher.g(), string, a2);
                    systemAlarmDispatcher.k(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, a(this.f12357b), i2));
                }
                o2.t();
                o2.g();
            }
        } finally {
            o2.g();
        }
    }

    private void m(Intent intent, SystemAlarmDispatcher systemAlarmDispatcher) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        Logger.c().a(f12356e, String.format("Handing stopWork work for %s", new Object[]{string}), new Throwable[0]);
        systemAlarmDispatcher.g().x(string);
        Alarms.a(this.f12357b, systemAlarmDispatcher.g(), string);
        systemAlarmDispatcher.e(string, false);
    }

    private static boolean n(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    public void e(String str, boolean z2) {
        synchronized (this.f12359d) {
            ExecutionListener remove = this.f12358c.remove(str);
            if (remove != null) {
                remove.e(str, z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        boolean z2;
        synchronized (this.f12359d) {
            if (!this.f12358c.isEmpty()) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public void p(Intent intent, int i2, SystemAlarmDispatcher systemAlarmDispatcher) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            h(intent, i2, systemAlarmDispatcher);
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            k(intent, i2, systemAlarmDispatcher);
        } else if (!n(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            Logger.c().b(f12356e, String.format("Invalid request for %s, requires %s.", new Object[]{action, "KEY_WORKSPEC_ID"}), new Throwable[0]);
        } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
            l(intent, i2, systemAlarmDispatcher);
        } else if ("ACTION_DELAY_MET".equals(action)) {
            i(intent, i2, systemAlarmDispatcher);
        } else if ("ACTION_STOP_WORK".equals(action)) {
            m(intent, systemAlarmDispatcher);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            j(intent, i2);
        } else {
            Logger.c().h(f12356e, String.format("Ignoring intent %s", new Object[]{intent}), new Throwable[0]);
        }
    }
}
