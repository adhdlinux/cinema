package com.iab.omid.library.applovin.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class b implements Application.ActivityLifecycleCallbacks {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static b f31489a = new b();

    /* renamed from: b  reason: collision with root package name */
    private boolean f31490b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31491c;

    /* renamed from: d  reason: collision with root package name */
    private a f31492d;

    public interface a {
        void a(boolean z2);
    }

    private b() {
    }

    public static b a() {
        return f31489a;
    }

    private void a(boolean z2) {
        if (this.f31491c != z2) {
            this.f31491c = z2;
            if (this.f31490b) {
                e();
                a aVar = this.f31492d;
                if (aVar != null) {
                    aVar.a(!z2);
                }
            }
        }
    }

    private void e() {
        boolean z2 = !this.f31491c;
        for (com.iab.omid.library.applovin.adsession.a adSessionStatePublisher : a.a().b()) {
            adSessionStatePublisher.getAdSessionStatePublisher().a(z2);
        }
    }

    public void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this);
        }
    }

    public void a(a aVar) {
        this.f31492d = aVar;
    }

    public void b() {
        this.f31490b = true;
        this.f31491c = false;
        e();
    }

    public void c() {
        this.f31490b = false;
        this.f31491c = false;
        this.f31492d = null;
    }

    /* access modifiers changed from: package-private */
    public ActivityManager.RunningAppProcessInfo d() {
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
        a(false);
    }

    public void onActivityStopped(Activity activity) {
        View e2;
        boolean z2 = true;
        boolean z3 = d().importance != 100;
        boolean z4 = true;
        for (com.iab.omid.library.applovin.adsession.a next : a.a().c()) {
            if (next.f() && (e2 = next.e()) != null && e2.hasWindowFocus()) {
                z4 = false;
            }
        }
        if (!z3 || !z4) {
            z2 = false;
        }
        a(z2);
    }
}
