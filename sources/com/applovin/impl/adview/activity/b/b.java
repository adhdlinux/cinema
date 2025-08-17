package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.sdk.a.d;
import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.e.z;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.e;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class b extends a {

    /* renamed from: s  reason: collision with root package name */
    private final com.applovin.impl.adview.activity.a.b f13927s = new com.applovin.impl.adview.activity.a.b(this.f13883a, this.f13887e, this.f13884b);

    /* renamed from: t  reason: collision with root package name */
    private e f13928t;

    /* renamed from: u  reason: collision with root package name */
    private long f13929u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public AtomicBoolean f13930v = new AtomicBoolean();

    public b(com.applovin.impl.sdk.ad.e eVar, Activity activity, m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
    }

    private long c() {
        com.applovin.impl.sdk.ad.e eVar = this.f13883a;
        if (!(eVar instanceof a)) {
            return 0;
        }
        float l2 = ((a) eVar).l();
        if (l2 <= 0.0f) {
            l2 = (float) this.f13883a.s();
        }
        return (long) (((double) Utils.secondsToMillisLong(l2)) * (((double) this.f13883a.R()) / 100.0d));
    }

    public void a() {
    }

    public void a(long j2) {
    }

    public void a(ViewGroup viewGroup) {
        this.f13927s.a(this.f13889g, this.f13888f, viewGroup);
        a(false);
        this.f13888f.renderAd(this.f13883a);
        a("javascript:al_onPoststitialShow();", (long) this.f13883a.S());
        if (t()) {
            long c2 = c();
            this.f13929u = c2;
            if (c2 > 0) {
                if (v.a()) {
                    v vVar = this.f13885c;
                    vVar.b("AppLovinFullscreenActivity", "Scheduling timer for ad fully watched in " + this.f13929u + "ms...");
                }
                this.f13928t = e.a(this.f13929u, this.f13884b, new Runnable() {
                    public void run() {
                        if (v.a()) {
                            b.this.f13885c.b("AppLovinFullscreenActivity", "Marking ad as fully watched");
                        }
                        b.this.f13930v.set(true);
                    }
                });
            }
        }
        if (this.f13889g != null) {
            if (this.f13883a.s() >= 0) {
                a(this.f13889g, this.f13883a.s(), new Runnable() {
                    public void run() {
                        b.this.f13891i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                this.f13889g.setVisibility(0);
            }
        }
        u();
        this.f13884b.S().a((com.applovin.impl.sdk.e.a) new z(this.f13884b, new Runnable() {
            public void run() {
                b bVar = b.this;
                com.applovin.impl.adview.m mVar = bVar.f13889g;
                com.applovin.impl.sdk.a.b o2 = bVar.f13883a.o();
                if (mVar != null) {
                    b bVar2 = b.this;
                    o2.a((View) bVar2.f13888f, (List<d>) Collections.singletonList(new d(bVar2.f13889g, FriendlyObstructionPurpose.CLOSE_AD, "close button")));
                    return;
                }
                o2.a((View) b.this.f13888f);
            }
        }), o.a.MAIN, TimeUnit.SECONDS.toMillis(1));
        super.b(Utils.isVideoMutedInitially(this.f13884b));
    }

    public void b() {
    }

    public void d() {
        a((ViewGroup) null);
    }

    public void e() {
    }

    public void h() {
        m();
        e eVar = this.f13928t;
        if (eVar != null) {
            eVar.a();
            this.f13928t = null;
        }
        super.h();
    }

    /* access modifiers changed from: protected */
    public void m() {
        e eVar;
        boolean r2 = r();
        int i2 = 100;
        if (t()) {
            if (!r2 && (eVar = this.f13928t) != null) {
                i2 = (int) Math.min(100.0d, (((double) (this.f13929u - eVar.b())) / ((double) this.f13929u)) * 100.0d);
            }
            if (v.a()) {
                v vVar = this.f13885c;
                vVar.b("AppLovinFullscreenActivity", "Ad engaged at " + i2 + "%");
            }
        }
        super.a(i2, false, r2, -2);
    }

    /* access modifiers changed from: protected */
    public boolean r() {
        if (t()) {
            return this.f13930v.get();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean s() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void u() {
        long j2;
        long millis;
        long j3 = 0;
        if (this.f13883a.ad() >= 0 || this.f13883a.ae() >= 0) {
            int i2 = (this.f13883a.ad() > 0 ? 1 : (this.f13883a.ad() == 0 ? 0 : -1));
            com.applovin.impl.sdk.ad.e eVar = this.f13883a;
            if (i2 >= 0) {
                j2 = eVar.ad();
            } else {
                if (eVar.af()) {
                    int l2 = (int) ((a) this.f13883a).l();
                    if (l2 > 0) {
                        millis = TimeUnit.SECONDS.toMillis((long) l2);
                    } else {
                        int s2 = (int) this.f13883a.s();
                        if (s2 > 0) {
                            millis = TimeUnit.SECONDS.toMillis((long) s2);
                        }
                    }
                    j3 = 0 + millis;
                }
                j2 = (long) (((double) j3) * (((double) this.f13883a.ae()) / 100.0d));
            }
            b(j2);
        }
    }
}
