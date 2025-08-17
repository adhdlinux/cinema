package com.facebook.ads.internal.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import com.facebook.ads.internal.m.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private final c f19665a;

    /* renamed from: b  reason: collision with root package name */
    private Application f19666b;

    /* renamed from: c  reason: collision with root package name */
    private a f19667c;

    /* renamed from: d  reason: collision with root package name */
    private long f19668d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f19669e = null;

    /* renamed from: f  reason: collision with root package name */
    private a f19670f = null;

    @TargetApi(14)
    private static class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<Activity> f19671a;

        /* renamed from: b  reason: collision with root package name */
        private l f19672b;

        public a(Activity activity, l lVar) {
            this.f19671a = new WeakReference<>(activity);
            this.f19672b = lVar;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
            if (this.f19672b != null) {
                Activity activity2 = this.f19671a.get();
                if (activity2 == null || activity.equals(activity2)) {
                    this.f19672b.a();
                    this.f19672b = null;
                }
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    private l(c cVar, Activity activity, int i2) {
        this.f19665a = cVar;
        this.f19666b = activity.getApplication();
        this.f19667c = new a(activity, this);
    }

    public static l a(c cVar, Activity activity) {
        return a(cVar, activity, Build.VERSION.SDK_INT);
    }

    protected static l a(c cVar, Activity activity, int i2) {
        if (activity == null || i2 < 14) {
            return null;
        }
        return new l(cVar, activity, i2);
    }

    private void a(String str, long j2, long j3, a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("leave_time", Long.toString(j2));
        hashMap.put("back_time", Long.toString(j3));
        if (aVar != null) {
            hashMap.put("outcome", aVar.name());
        }
        this.f19665a.j(str, hashMap);
    }

    @TargetApi(14)
    public void a() {
        a aVar;
        a(this.f19669e, this.f19668d, System.currentTimeMillis(), this.f19670f);
        Application application = this.f19666b;
        if (application != null && (aVar = this.f19667c) != null) {
            application.unregisterActivityLifecycleCallbacks(aVar);
            this.f19667c = null;
            this.f19666b = null;
        }
    }

    public void a(a aVar) {
        this.f19670f = aVar;
    }

    @TargetApi(14)
    public void a(String str) {
        this.f19669e = str;
        if (this.f19667c == null || this.f19666b == null) {
            a(str, -1, -1, a.CANNOT_TRACK);
            return;
        }
        this.f19668d = System.currentTimeMillis();
        this.f19666b.registerActivityLifecycleCallbacks(this.f19667c);
    }
}
