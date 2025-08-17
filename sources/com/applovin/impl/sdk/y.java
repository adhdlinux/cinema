package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.d.f;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.a;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class y {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicBoolean f15941b = new AtomicBoolean();

    /* renamed from: a  reason: collision with root package name */
    final m f15942a;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f15943c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f15944d = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f15945e = new AtomicInteger();

    /* renamed from: f  reason: collision with root package name */
    private Date f15946f;

    /* renamed from: g  reason: collision with root package name */
    private Date f15947g;

    y(final m mVar) {
        this.f15942a = mVar;
        final Application application = (Application) mVar.L();
        application.registerActivityLifecycleCallbacks(new a() {
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                y.this.e();
            }
        });
        application.registerComponentCallbacks(new ComponentCallbacks2() {
            public void onConfigurationChanged(Configuration configuration) {
            }

            public void onLowMemory() {
            }

            public void onTrimMemory(int i2) {
                y.this.f15945e.set(i2);
                if (i2 == 20) {
                    y.this.f();
                }
            }
        });
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        application.registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (Utils.isCurrentProcessInForeground()) {
                        y.this.e();
                    }
                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    y.this.f();
                }
            }
        }, intentFilter);
        if (((Boolean) mVar.a(b.cp)).booleanValue() && f15941b.compareAndSet(false, true)) {
            final Intent intent = new Intent(application, AppKilledService.class);
            application.startService(intent);
            mVar.aj().registerReceiver(new AppLovinBroadcastManager.Receiver() {
                public void onReceive(Context context, Intent intent, Map<String, Object> map) {
                    application.stopService(intent);
                    mVar.aj().unregisterReceiver(this);
                }
            }, new IntentFilter(AppKilledService.ACTION_APP_KILLED));
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.f15944d.compareAndSet(true, false)) {
            h();
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.f15944d.compareAndSet(false, true)) {
            g();
        }
    }

    private void g() {
        if (v.a()) {
            this.f15942a.A().b("SessionTracker", "Application Paused");
        }
        this.f15942a.aj().sendBroadcastSync(new Intent("com.applovin.application_paused"), (Map<String, Object>) null);
        if (!this.f15943c.get()) {
            boolean booleanValue = ((Boolean) this.f15942a.a(b.dl)).booleanValue();
            long millis = TimeUnit.MINUTES.toMillis(((Long) this.f15942a.a(b.dn)).longValue());
            if (this.f15946f == null || System.currentTimeMillis() - this.f15946f.getTime() >= millis) {
                ((EventServiceImpl) this.f15942a.w()).trackEvent("paused");
                if (booleanValue) {
                    this.f15946f = new Date();
                }
            }
            if (!booleanValue) {
                this.f15946f = new Date();
            }
        }
    }

    private void h() {
        if (v.a()) {
            this.f15942a.A().b("SessionTracker", "Application Resumed");
        }
        boolean booleanValue = ((Boolean) this.f15942a.a(b.dl)).booleanValue();
        long longValue = ((Long) this.f15942a.a(b.dm)).longValue();
        this.f15942a.aj().sendBroadcastSync(new Intent("com.applovin.application_resumed"), (Map<String, Object>) null);
        if (!this.f15943c.getAndSet(false)) {
            long millis = TimeUnit.MINUTES.toMillis(longValue);
            if (this.f15947g == null || System.currentTimeMillis() - this.f15947g.getTime() >= millis) {
                ((EventServiceImpl) this.f15942a.w()).trackEvent("resumed");
                if (booleanValue) {
                    this.f15947g = new Date();
                }
            }
            if (!booleanValue) {
                this.f15947g = new Date();
            }
            this.f15942a.T().a(f.f15312k);
        }
    }

    public boolean a() {
        return this.f15944d.get();
    }

    public int b() {
        return this.f15945e.get();
    }

    public void c() {
        this.f15943c.set(true);
    }

    public void d() {
        this.f15943c.set(false);
    }
}
