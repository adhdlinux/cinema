package com.chartboost.sdk.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

public class qe implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public boolean f18495a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f18496b;

    /* renamed from: c  reason: collision with root package name */
    public a f18497c;

    public interface a {
        void a(boolean z2);
    }

    public void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this);
        }
    }

    public ActivityManager.RunningAppProcessInfo b() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo;
    }

    public void b(boolean z2) {
    }

    public boolean c() {
        return this.f18496b;
    }

    public boolean d() {
        return false;
    }

    public void e() {
        this.f18495a = true;
        boolean a2 = a();
        this.f18496b = a2;
        b(a2);
    }

    public void f() {
        this.f18495a = false;
        this.f18497c = null;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        a(true);
    }

    public void onActivityStopped(Activity activity) {
        a(a());
    }

    public void a(a aVar) {
        this.f18497c = aVar;
    }

    public final void a(boolean z2) {
        if (this.f18496b != z2) {
            this.f18496b = z2;
            if (this.f18495a) {
                b(z2);
                a aVar = this.f18497c;
                if (aVar != null) {
                    aVar.a(z2);
                }
            }
        }
    }

    public final boolean a() {
        return b().importance == 100 || d();
    }
}
