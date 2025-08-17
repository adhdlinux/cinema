package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class SystemForegroundDispatcher implements WorkConstraintsCallback, ExecutionListener {

    /* renamed from: l  reason: collision with root package name */
    static final String f12454l = Logger.f("SystemFgDispatcher");

    /* renamed from: b  reason: collision with root package name */
    private Context f12455b;

    /* renamed from: c  reason: collision with root package name */
    private WorkManagerImpl f12456c;

    /* renamed from: d  reason: collision with root package name */
    private final TaskExecutor f12457d;

    /* renamed from: e  reason: collision with root package name */
    final Object f12458e = new Object();

    /* renamed from: f  reason: collision with root package name */
    String f12459f;

    /* renamed from: g  reason: collision with root package name */
    final Map<String, ForegroundInfo> f12460g;

    /* renamed from: h  reason: collision with root package name */
    final Map<String, WorkSpec> f12461h;

    /* renamed from: i  reason: collision with root package name */
    final Set<WorkSpec> f12462i;

    /* renamed from: j  reason: collision with root package name */
    final WorkConstraintsTracker f12463j;

    /* renamed from: k  reason: collision with root package name */
    private Callback f12464k;

    interface Callback {
        void a(int i2, Notification notification);

        void c(int i2, int i3, Notification notification);

        void d(int i2);

        void stop();
    }

    SystemForegroundDispatcher(Context context) {
        this.f12455b = context;
        WorkManagerImpl k2 = WorkManagerImpl.k(context);
        this.f12456c = k2;
        TaskExecutor p2 = k2.p();
        this.f12457d = p2;
        this.f12459f = null;
        this.f12460g = new LinkedHashMap();
        this.f12462i = new HashSet();
        this.f12461h = new HashMap();
        this.f12463j = new WorkConstraintsTracker(this.f12455b, p2, this);
        this.f12456c.m().c(this);
    }

    public static Intent a(Context context, String str, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.a());
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent c(Context context, String str, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.a());
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent d(Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    private void g(Intent intent) {
        Logger.c().d(f12454l, String.format("Stopping foreground work for %s", new Object[]{intent}), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
            this.f12456c.f(UUID.fromString(stringExtra));
        }
    }

    private void h(Intent intent) {
        int i2 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        Logger.c().a(f12454l, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", new Object[]{Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)}), new Throwable[0]);
        if (notification != null && this.f12464k != null) {
            this.f12460g.put(stringExtra, new ForegroundInfo(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.f12459f)) {
                this.f12459f = stringExtra;
                this.f12464k.c(intExtra, intExtra2, notification);
                return;
            }
            this.f12464k.a(intExtra, notification);
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, ForegroundInfo> value : this.f12460g.entrySet()) {
                    i2 |= ((ForegroundInfo) value.getValue()).a();
                }
                ForegroundInfo foregroundInfo = this.f12460g.get(this.f12459f);
                if (foregroundInfo != null) {
                    this.f12464k.c(foregroundInfo.c(), i2, foregroundInfo.b());
                }
            }
        }
    }

    private void i(Intent intent) {
        Logger.c().d(f12454l, String.format("Started foreground service %s", new Object[]{intent}), new Throwable[0]);
        final String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        final WorkDatabase o2 = this.f12456c.o();
        this.f12457d.b(new Runnable() {
            public void run() {
                WorkSpec g2 = o2.D().g(stringExtra);
                if (g2 != null && g2.b()) {
                    synchronized (SystemForegroundDispatcher.this.f12458e) {
                        SystemForegroundDispatcher.this.f12461h.put(stringExtra, g2);
                        SystemForegroundDispatcher.this.f12462i.add(g2);
                        SystemForegroundDispatcher systemForegroundDispatcher = SystemForegroundDispatcher.this;
                        systemForegroundDispatcher.f12463j.d(systemForegroundDispatcher.f12462i);
                    }
                }
            }
        });
    }

    public void b(List<String> list) {
        if (!list.isEmpty()) {
            for (String next : list) {
                Logger.c().a(f12454l, String.format("Constraints unmet for WorkSpec %s", new Object[]{next}), new Throwable[0]);
                this.f12456c.w(next);
            }
        }
    }

    public void e(String str, boolean z2) {
        boolean z3;
        Map.Entry entry;
        synchronized (this.f12458e) {
            WorkSpec remove = this.f12461h.remove(str);
            if (remove != null) {
                z3 = this.f12462i.remove(remove);
            } else {
                z3 = false;
            }
            if (z3) {
                this.f12463j.d(this.f12462i);
            }
        }
        ForegroundInfo remove2 = this.f12460g.remove(str);
        if (str.equals(this.f12459f) && this.f12460g.size() > 0) {
            Iterator it2 = this.f12460g.entrySet().iterator();
            Object next = it2.next();
            while (true) {
                entry = (Map.Entry) next;
                if (!it2.hasNext()) {
                    break;
                }
                next = it2.next();
            }
            this.f12459f = (String) entry.getKey();
            if (this.f12464k != null) {
                ForegroundInfo foregroundInfo = (ForegroundInfo) entry.getValue();
                this.f12464k.c(foregroundInfo.c(), foregroundInfo.a(), foregroundInfo.b());
                this.f12464k.d(foregroundInfo.c());
            }
        }
        Callback callback = this.f12464k;
        if (remove2 != null && callback != null) {
            Logger.c().a(f12454l, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", new Object[]{Integer.valueOf(remove2.c()), str, Integer.valueOf(remove2.a())}), new Throwable[0]);
            callback.d(remove2.c());
        }
    }

    public void f(List<String> list) {
    }

    /* access modifiers changed from: package-private */
    public void j(Intent intent) {
        Logger.c().d(f12454l, "Stopping foreground service", new Throwable[0]);
        Callback callback = this.f12464k;
        if (callback != null) {
            callback.stop();
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.f12464k = null;
        synchronized (this.f12458e) {
            this.f12463j.e();
        }
        this.f12456c.m().i(this);
    }

    /* access modifiers changed from: package-private */
    public void l(Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            i(intent);
            h(intent);
        } else if ("ACTION_NOTIFY".equals(action)) {
            h(intent);
        } else if ("ACTION_CANCEL_WORK".equals(action)) {
            g(intent);
        } else if ("ACTION_STOP_FOREGROUND".equals(action)) {
            j(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public void m(Callback callback) {
        if (this.f12464k != null) {
            Logger.c().b(f12454l, "A callback already exists.", new Throwable[0]);
        } else {
            this.f12464k = callback;
        }
    }
}
