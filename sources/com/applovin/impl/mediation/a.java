package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.mediation.a.c;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;

public class a extends com.applovin.impl.sdk.utils.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.applovin.impl.sdk.a f14214a;

    /* renamed from: b  reason: collision with root package name */
    private final v f14215b;

    /* renamed from: c  reason: collision with root package name */
    private C0010a f14216c;

    /* renamed from: d  reason: collision with root package name */
    private c f14217d;

    /* renamed from: e  reason: collision with root package name */
    private int f14218e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14219f;

    /* renamed from: com.applovin.impl.mediation.a$a  reason: collision with other inner class name */
    public interface C0010a {
        void a(c cVar);
    }

    a(m mVar) {
        this.f14215b = mVar.A();
        this.f14214a = mVar.af();
    }

    public void a() {
        if (v.a()) {
            this.f14215b.b("AdActivityObserver", "Cancelling...");
        }
        this.f14214a.b(this);
        this.f14216c = null;
        this.f14217d = null;
        this.f14218e = 0;
        this.f14219f = false;
    }

    public void a(c cVar, C0010a aVar) {
        if (v.a()) {
            v vVar = this.f14215b;
            vVar.b("AdActivityObserver", "Starting for ad " + cVar.getAdUnitId() + "...");
        }
        a();
        this.f14216c = aVar;
        this.f14217d = cVar;
        this.f14214a.a(this);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.f14219f) {
            this.f14219f = true;
        }
        this.f14218e++;
        if (v.a()) {
            this.f14215b.b("AdActivityObserver", "Created Activity: " + activity + ", counter is " + this.f14218e);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (this.f14219f) {
            this.f14218e--;
            if (v.a()) {
                this.f14215b.b("AdActivityObserver", "Destroyed Activity: " + activity + ", counter is " + this.f14218e);
            }
            if (this.f14218e <= 0) {
                if (v.a()) {
                    this.f14215b.b("AdActivityObserver", "Last ad Activity destroyed");
                }
                if (this.f14216c != null) {
                    if (v.a()) {
                        this.f14215b.b("AdActivityObserver", "Invoking callback...");
                    }
                    this.f14216c.a(this.f14217d);
                }
                a();
            }
        }
    }
}
