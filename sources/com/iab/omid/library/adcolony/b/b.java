package com.iab.omid.library.adcolony.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class b implements Application.ActivityLifecycleCallbacks {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    private static b f31372e = new b();

    /* renamed from: b  reason: collision with root package name */
    private boolean f31373b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31374c;

    /* renamed from: d  reason: collision with root package name */
    private a f31375d;

    public interface a {
        void a(boolean z2);
    }

    private b() {
    }

    public static b a() {
        return f31372e;
    }

    private void d(boolean z2) {
        if (this.f31374c != z2) {
            this.f31374c = z2;
            if (this.f31373b) {
                h();
                a aVar = this.f31375d;
                if (aVar != null) {
                    aVar.a(!z2);
                }
            }
        }
    }

    private void h() {
        boolean z2 = !this.f31374c;
        for (com.iab.omid.library.adcolony.adsession.a v2 : a.a().c()) {
            v2.v().n(z2);
        }
    }

    public void b(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this);
        }
    }

    public void c(a aVar) {
        this.f31375d = aVar;
    }

    public void e() {
        this.f31373b = true;
        this.f31374c = false;
        h();
    }

    public void f() {
        this.f31373b = false;
        this.f31374c = false;
        this.f31375d = null;
    }

    /* access modifiers changed from: package-private */
    public ActivityManager.RunningAppProcessInfo g() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo;
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
        d(false);
    }

    public void onActivityStopped(Activity activity) {
        View s2;
        boolean z2 = true;
        boolean z3 = g().importance != 100;
        boolean z4 = true;
        for (com.iab.omid.library.adcolony.adsession.a next : a.a().e()) {
            if (next.t() && (s2 = next.s()) != null && s2.hasWindowFocus()) {
                z4 = false;
            }
        }
        if (!z3 || !z4) {
            z2 = false;
        }
        d(z2);
    }
}
