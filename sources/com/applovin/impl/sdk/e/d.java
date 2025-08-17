package com.applovin.impl.sdk.e;

import android.net.Uri;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAdLoadListener;

public class d extends c {

    /* renamed from: c  reason: collision with root package name */
    private final a f15352c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15353d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f15354e;

    public d(a aVar, m mVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheAppLovinAd", aVar, mVar, appLovinAdLoadListener);
        this.f15352c = aVar;
    }

    private void j() {
        if (v.a()) {
            a("Caching HTML resources...");
        }
        this.f15352c.a(a(this.f15352c.b(), this.f15352c.H(), (e) this.f15352c));
        this.f15352c.a(true);
        if (v.a()) {
            a("Finish caching non-video resources for ad #" + this.f15352c.getAdIdNumber());
            v A = this.f15333b.A();
            String e2 = e();
            A.a(e2, "Ad updated with cachedHTML = " + this.f15352c.b());
        }
    }

    private void k() {
        Uri e2;
        if (!b() && (e2 = e(this.f15352c.i())) != null) {
            if (this.f15352c.aK()) {
                this.f15352c.a(this.f15352c.b().replaceFirst(this.f15352c.e(), e2.toString()));
                if (v.a()) {
                    a("Replaced video URL with cached video URI in HTML for web video ad");
                }
            }
            this.f15352c.g();
            this.f15352c.a(e2);
        }
    }

    public void a(boolean z2) {
        this.f15353d = z2;
    }

    public void b(boolean z2) {
        this.f15354e = z2;
    }

    public void run() {
        super.run();
        boolean f2 = this.f15352c.f();
        boolean z2 = this.f15354e;
        if (f2 || z2) {
            if (v.a()) {
                a("Begin caching for streaming ad #" + this.f15352c.getAdIdNumber() + "...");
            }
            c();
            if (f2) {
                if (this.f15353d) {
                    i();
                }
                j();
                if (!this.f15353d) {
                    i();
                }
                k();
            } else {
                i();
                j();
            }
        } else {
            if (v.a()) {
                a("Begin processing for non-streaming ad #" + this.f15352c.getAdIdNumber() + "...");
            }
            c();
            j();
            k();
            i();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f15352c.getCreatedAtMillis();
        com.applovin.impl.sdk.d.d.a(this.f15352c, this.f15333b);
        com.applovin.impl.sdk.d.d.a(currentTimeMillis, (AppLovinAdBase) this.f15352c, this.f15333b);
        a((AppLovinAdBase) this.f15352c);
        a();
    }
}
