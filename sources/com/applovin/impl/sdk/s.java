package com.applovin.impl.sdk;

import com.applovin.impl.mediation.d.c;
import com.applovin.impl.sdk.c.b;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class s {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final m f15762a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f15763b = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public long f15764c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f15765d = new Object();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f15766e = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f15767f;

    /* renamed from: g  reason: collision with root package name */
    private Object f15768g;

    s(m mVar) {
        this.f15762a = mVar;
    }

    public void a(final Object obj) {
        if (!c.a(obj) && this.f15763b.compareAndSet(false, true)) {
            this.f15768g = obj;
            this.f15764c = System.currentTimeMillis();
            if (v.a()) {
                v A = this.f15762a.A();
                A.b("FullScreenAdTracker", "Setting fullscreen ad displayed: " + this.f15764c);
            }
            this.f15762a.aj().sendBroadcastWithAdObject("com.applovin.fullscreen_ad_displayed", obj);
            final long longValue = ((Long) this.f15762a.a(b.cg)).longValue();
            if (longValue >= 0) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                    public void run() {
                        if (s.this.f15763b.get() && System.currentTimeMillis() - s.this.f15764c >= longValue) {
                            if (v.a()) {
                                s.this.f15762a.A().b("FullScreenAdTracker", "Resetting \"display\" state...");
                            }
                            s.this.b(obj);
                        }
                    }
                }, longValue);
            }
        }
    }

    public void a(boolean z2) {
        synchronized (this.f15765d) {
            this.f15766e.set(z2);
            if (z2) {
                this.f15767f = System.currentTimeMillis();
                if (v.a()) {
                    v A = this.f15762a.A();
                    A.b("FullScreenAdTracker", "Setting fullscreen ad pending display: " + this.f15767f);
                }
                final long longValue = ((Long) this.f15762a.a(b.cf)).longValue();
                if (longValue >= 0) {
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                        public void run() {
                            if (s.this.a() && System.currentTimeMillis() - s.this.f15767f >= longValue) {
                                if (v.a()) {
                                    s.this.f15762a.A().b("FullScreenAdTracker", "Resetting \"pending display\" state...");
                                }
                                s.this.f15766e.set(false);
                            }
                        }
                    }, longValue);
                }
            } else {
                this.f15767f = 0;
                if (v.a()) {
                    v A2 = this.f15762a.A();
                    A2.b("FullScreenAdTracker", "Setting fullscreen ad not pending display: " + System.currentTimeMillis());
                }
            }
        }
    }

    public boolean a() {
        return this.f15766e.get();
    }

    public void b(Object obj) {
        if (!c.a(obj) && this.f15763b.compareAndSet(true, false)) {
            this.f15768g = null;
            if (v.a()) {
                v A = this.f15762a.A();
                A.b("FullScreenAdTracker", "Setting fullscreen ad hidden: " + System.currentTimeMillis());
            }
            this.f15762a.aj().sendBroadcastWithAdObject("com.applovin.fullscreen_ad_hidden", obj);
        }
    }

    public boolean b() {
        return this.f15763b.get();
    }

    public Object c() {
        return this.f15768g;
    }
}
