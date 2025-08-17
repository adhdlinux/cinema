package com.startapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;
import java.util.Collections;

public class h implements Application.ActivityLifecycleCallbacks {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static h f34604a = new h();

    /* renamed from: b  reason: collision with root package name */
    public boolean f34605b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34606c;

    /* renamed from: d  reason: collision with root package name */
    public a f34607d;

    public interface a {
    }

    public final void a(boolean z2) {
        if (this.f34606c != z2) {
            this.f34606c = z2;
            if (this.f34605b) {
                a();
                if (this.f34607d == null) {
                    return;
                }
                if (!z2) {
                    d0.f34311a.a();
                    return;
                }
                d0.f34311a.getClass();
                Handler handler = d0.f34313c;
                if (handler != null) {
                    handler.removeCallbacks(d0.f34315e);
                    d0.f34313c = null;
                }
            }
        }
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
        boolean z2;
        View b2;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        boolean z3 = true;
        if (runningAppProcessInfo.importance != 100) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z4 = true;
        for (T t2 : Collections.unmodifiableCollection(g.f34545a.f34547c)) {
            if (t2.c() && (b2 = t2.b()) != null && b2.hasWindowFocus()) {
                z4 = false;
            }
        }
        if (!z2 || !z4) {
            z3 = false;
        }
        a(z3);
    }

    public final void a() {
        boolean z2 = !this.f34606c;
        for (T t2 : Collections.unmodifiableCollection(g.f34545a.f34546b)) {
            AdSessionStatePublisher adSessionStatePublisher = t2.f36850f;
            if (adSessionStatePublisher.f31609a.get() != null) {
                l.f34848a.a(adSessionStatePublisher.c(), "setState", z2 ? "foregrounded" : "backgrounded");
            }
        }
    }
}
