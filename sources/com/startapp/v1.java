package com.startapp;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import com.startapp.networkTest.startapp.CoverageMapperManager;
import com.startapp.networkTest.startapp.NetworkTester;
import com.startapp.networkTest.threads.ThreadManager;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class v1 implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f36691a = "v1";

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f36692b = false;

    /* renamed from: c  reason: collision with root package name */
    private Application f36693c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ScheduledFuture<?> f36694d;

    /* renamed from: e  reason: collision with root package name */
    private int f36695e = -1;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f36696f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f36697g = false;

    /* renamed from: h  reason: collision with root package name */
    private CoverageMapperManager f36698h;

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f36699i = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            v1.this.c();
            if (v1.this.f36696f == 0 && !v1.this.f36697g) {
                v1.this.f36694d.cancel(false);
            }
        }
    }

    public class b implements NetworkTester.b {
        public b() {
        }

        public void a(boolean z2) {
        }
    }

    public v1(Context context, CoverageMapperManager coverageMapperManager) {
        this.f36693c = (Application) context.getApplicationContext();
        this.f36698h = coverageMapperManager;
    }

    private void f() {
        this.f36698h.c();
    }

    private void g() {
        j();
        long FOREGROUND_TEST_CT_SCHEDULE_INTERVAL = w0.b().FOREGROUND_TEST_CT_SCHEDULE_INTERVAL();
        if (FOREGROUND_TEST_CT_SCHEDULE_INTERVAL > 0) {
            this.f36694d = ThreadManager.b().d().scheduleWithFixedDelay(this.f36699i, FOREGROUND_TEST_CT_SCHEDULE_INTERVAL, FOREGROUND_TEST_CT_SCHEDULE_INTERVAL, TimeUnit.MILLISECONDS);
        }
    }

    private void i() {
        this.f36698h.f();
    }

    private void j() {
        ScheduledFuture<?> scheduledFuture = this.f36694d;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.f36694d = null;
        }
    }

    public void e() {
        this.f36695e = 0;
        this.f36693c.registerActivityLifecycleCallbacks(this);
        this.f36693c.registerComponentCallbacks(this);
    }

    public void h() {
        this.f36693c.unregisterActivityLifecycleCallbacks(this);
        this.f36693c.unregisterComponentCallbacks(this);
        this.f36695e = -1;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        if (activity.isTaskRoot() && this.f36696f < 0) {
            this.f36696f = 0;
        }
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        int i2 = this.f36696f + 1;
        this.f36696f = i2;
        if (i2 == 1 && !this.f36697g) {
            a();
        }
    }

    public void onActivityStopped(Activity activity) {
        boolean isChangingConfigurations = activity.isChangingConfigurations();
        this.f36697g = isChangingConfigurations;
        int i2 = this.f36696f - 1;
        this.f36696f = i2;
        if (i2 == 0 && !isChangingConfigurations) {
            b();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i2) {
    }

    private void a() {
        this.f36695e = 1;
        if (w0.b().FOREGROUND_TEST_CT_ENABLED()) {
            c();
            g();
        }
        if (w0.b().FOREGROUND_TEST_NIR_ENABLED()) {
            f();
        }
    }

    private void b() {
        this.f36695e = 0;
        i();
        j();
    }

    /* access modifiers changed from: private */
    public void c() {
        NetworkTester.runTests(this.f36693c, new b());
    }

    public int d() {
        return this.f36695e;
    }
}
