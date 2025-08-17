package com.startapp.sdk.ads.splash;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.startapp.d8;
import com.startapp.ia;
import com.startapp.o6;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.adrules.AdaptMetaData;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.wb;
import com.startapp.x4;
import com.startapp.y8;
import java.lang.ref.WeakReference;

public class SplashEventHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Context f36028a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<Activity> f36029b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36030c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36031d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36032e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36033f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36034g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36035h;

    /* renamed from: i  reason: collision with root package name */
    public SplashState f36036i;

    /* renamed from: j  reason: collision with root package name */
    public SplashHtml f36037j;

    /* renamed from: k  reason: collision with root package name */
    public final BroadcastReceiver f36038k;

    public enum SplashState {
        LOADING,
        RECEIVED,
        DISPLAYED,
        HIDDEN,
        DO_NOT_DISPLAY
    }

    public class a implements x4 {
        public a() {
        }

        public void a() {
            SplashEventHandler.this.b();
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        public void onReceive(Context context, Intent intent) {
            SplashEventHandler.this.f36033f = true;
        }
    }

    public SplashEventHandler(Activity activity) {
        this.f36030c = false;
        this.f36031d = true;
        this.f36032e = false;
        this.f36033f = false;
        this.f36034g = false;
        this.f36035h = false;
        this.f36036i = SplashState.LOADING;
        this.f36037j = null;
        this.f36038k = new b();
        this.f36028a = ia.b(activity);
        this.f36029b = new WeakReference<>(activity);
    }

    public void a(Runnable runnable, CacheKey cacheKey) {
        AdRulesResult a2 = AdaptMetaData.f36307a.a().a(AdPreferences.Placement.INAPP_SPLASH, (String) null);
        if (a2.b()) {
            a(runnable);
            return;
        }
        this.f36036i = SplashState.DO_NOT_DISPLAY;
        if (cacheKey != null) {
            o6.a(this.f36028a, o6.a(d8.f34354a.a(cacheKey)), (String) null, 0, a2.a());
        }
        c();
    }

    public void b() {
        if (!this.f36032e) {
            this.f36032e = true;
            wb.a(this.f36028a).a(new Intent("com.startapp.android.splashHidden"));
        }
        try {
            wb.a(this.f36028a).a(this.f36038k);
        } catch (Throwable th) {
            y8.a(this.f36028a, th);
        }
        Activity activity = this.f36029b.get();
        if (activity != null && !activity.isFinishing()) {
            try {
                activity.finish();
            } catch (Throwable th2) {
                y8.a(this.f36028a, th2);
            }
        }
    }

    public final void c() {
        SplashHtml splashHtml = this.f36037j;
        a aVar = new a();
        if (splashHtml == null) {
            b();
            return;
        }
        splashHtml.callback = aVar;
        splashHtml.a();
    }

    public void d() {
        this.f36030c = true;
    }

    public void a() {
        this.f36036i = SplashState.DO_NOT_DISPLAY;
        a((Runnable) null);
    }

    public SplashEventHandler(Activity activity, SplashHtml splashHtml) {
        this(activity);
        this.f36037j = splashHtml;
    }

    public final void a(Runnable runnable) {
        if (!this.f36030c) {
            return;
        }
        if (this.f36035h || runnable == null) {
            SplashState splashState = this.f36036i;
            if (splashState == SplashState.RECEIVED && runnable != null) {
                this.f36031d = false;
                runnable.run();
            } else if (splashState != SplashState.LOADING) {
                c();
            }
        }
    }
}
