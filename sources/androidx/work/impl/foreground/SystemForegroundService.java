package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.foreground.SystemForegroundDispatcher;

public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {

    /* renamed from: g  reason: collision with root package name */
    private static final String f12468g = Logger.f("SystemFgService");

    /* renamed from: h  reason: collision with root package name */
    private static SystemForegroundService f12469h = null;

    /* renamed from: c  reason: collision with root package name */
    private Handler f12470c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12471d;

    /* renamed from: e  reason: collision with root package name */
    SystemForegroundDispatcher f12472e;

    /* renamed from: f  reason: collision with root package name */
    NotificationManager f12473f;

    private void e() {
        this.f12470c = new Handler(Looper.getMainLooper());
        this.f12473f = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.f12472e = systemForegroundDispatcher;
        systemForegroundDispatcher.m(this);
    }

    public void a(final int i2, final Notification notification) {
        this.f12470c.post(new Runnable() {
            public void run() {
                SystemForegroundService.this.f12473f.notify(i2, notification);
            }
        });
    }

    public void c(final int i2, final int i3, final Notification notification) {
        this.f12470c.post(new Runnable() {
            public void run() {
                if (Build.VERSION.SDK_INT >= 29) {
                    SystemForegroundService.this.startForeground(i2, notification, i3);
                } else {
                    SystemForegroundService.this.startForeground(i2, notification);
                }
            }
        });
    }

    public void d(final int i2) {
        this.f12470c.post(new Runnable() {
            public void run() {
                SystemForegroundService.this.f12473f.cancel(i2);
            }
        });
    }

    public void onCreate() {
        super.onCreate();
        f12469h = this;
        e();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f12472e.k();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.f12471d) {
            Logger.c().d(f12468g, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f12472e.k();
            e();
            this.f12471d = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f12472e.l(intent);
        return 3;
    }

    public void stop() {
        this.f12471d = true;
        Logger.c().a(f12468g, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        f12469h = null;
        stopSelf();
    }
}
