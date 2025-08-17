package com.iab.omid.library.vungle.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

public class d implements Application.ActivityLifecycleCallbacks {

    /* renamed from: b  reason: collision with root package name */
    private boolean f31706b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f31707c;

    /* renamed from: d  reason: collision with root package name */
    private a f31708d;

    public interface a {
        void a(boolean z2);
    }

    private void c(boolean z2) {
        if (this.f31707c != z2) {
            this.f31707c = z2;
            if (this.f31706b) {
                f(z2);
                a aVar = this.f31708d;
                if (aVar != null) {
                    aVar.a(z2);
                }
            }
        }
    }

    private boolean d() {
        return (e().importance == 100) || h();
    }

    public void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this);
        }
    }

    public void b(a aVar) {
        this.f31708d = aVar;
    }

    /* access modifiers changed from: package-private */
    public ActivityManager.RunningAppProcessInfo e() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo;
    }

    /* access modifiers changed from: protected */
    public void f(boolean z2) {
    }

    public boolean g() {
        return this.f31707c;
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        return false;
    }

    public void i() {
        this.f31706b = true;
        boolean d2 = d();
        this.f31707c = d2;
        f(d2);
    }

    public void j() {
        this.f31706b = false;
        this.f31708d = null;
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
        c(true);
    }

    public void onActivityStopped(Activity activity) {
        c(d());
    }
}
