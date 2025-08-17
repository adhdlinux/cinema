package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.graphics.PointF;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.a.a;
import com.applovin.impl.a.f;
import com.applovin.impl.a.j;
import com.applovin.impl.a.k;
import com.applovin.impl.a.l;
import com.applovin.impl.a.n;
import com.applovin.impl.adview.j;
import com.applovin.impl.adview.t;
import com.applovin.impl.sdk.a.g;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class d extends f {
    /* access modifiers changed from: private */
    public final a C;
    /* access modifiers changed from: private */
    public final Set<j> D;

    public d(e eVar, Activity activity, m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        HashSet hashSet = new HashSet();
        this.D = hashSet;
        a aVar = (a) eVar;
        this.C = aVar;
        a.c cVar = a.c.VIDEO;
        hashSet.addAll(aVar.a(cVar, k.f13806a));
        a(a.c.IMPRESSION);
        a(cVar, "creativeView");
        aVar.o().d();
    }

    private void A() {
        if (r() && !this.D.isEmpty()) {
            if (v.a()) {
                v vVar = this.f13885c;
                vVar.d("AppLovinFullscreenActivity", "Firing " + this.D.size() + " un-fired video progress trackers when video was completed.");
            }
            a(this.D);
        }
    }

    private void a(a.c cVar) {
        a(cVar, f.UNSPECIFIED);
    }

    private void a(a.c cVar, f fVar) {
        a(cVar, "", fVar);
    }

    private void a(a.c cVar, String str) {
        a(cVar, str, f.UNSPECIFIED);
    }

    private void a(a.c cVar, String str, f fVar) {
        a(this.C.a(cVar, str), fVar);
    }

    /* access modifiers changed from: private */
    public void a(Set<j> set) {
        a(set, f.UNSPECIFIED);
    }

    private void a(Set<j> set, f fVar) {
        if (set != null && !set.isEmpty()) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds((long) this.f13958s.getCurrentPosition());
            n n2 = this.C.n();
            Uri a2 = n2 != null ? n2.a() : null;
            if (v.a()) {
                v vVar = this.f13885c;
                vVar.b("AppLovinFullscreenActivity", "Firing " + set.size() + " tracker(s): " + set);
            }
            l.a(set, seconds, a2, fVar, this.f13884b);
        }
    }

    public void a(PointF pointF) {
        a(a.c.VIDEO_CLICK);
        this.C.o().o();
        super.a(pointF);
    }

    public void a(ViewGroup viewGroup) {
        super.a(viewGroup);
        this.f13964y.a("PROGRESS_TRACKING", TimeUnit.SECONDS.toMillis(1), (j.a) new j.a() {
            public void a() {
                long seconds = TimeUnit.MILLISECONDS.toSeconds(d.this.A - ((long) (d.this.f13958s.getDuration() - d.this.f13958s.getCurrentPosition())));
                int z2 = d.this.z();
                HashSet hashSet = new HashSet();
                for (com.applovin.impl.a.j jVar : new HashSet(d.this.D)) {
                    if (jVar.a(seconds, z2)) {
                        hashSet.add(jVar);
                        d.this.D.remove(jVar);
                    }
                }
                d.this.a((Set<com.applovin.impl.a.j>) hashSet);
                if (z2 >= 25 && z2 < 50) {
                    d.this.C.o().f();
                } else if (z2 >= 50 && z2 < 75) {
                    d.this.C.o().g();
                } else if (z2 >= 75) {
                    d.this.C.o().h();
                }
            }

            public boolean b() {
                return !d.this.B;
            }
        });
        ArrayList arrayList = new ArrayList();
        com.applovin.impl.adview.a aVar = this.f13959t;
        if (aVar != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(aVar, FriendlyObstructionPurpose.OTHER, "video stream buffering indicator"));
        }
        com.applovin.impl.adview.m mVar = this.f13960u;
        if (mVar != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(mVar, FriendlyObstructionPurpose.CLOSE_AD, "skip button"));
        }
        ProgressBar progressBar = this.f13963x;
        if (progressBar != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(progressBar, FriendlyObstructionPurpose.OTHER, "progress bar"));
        }
        ImageView imageView = this.f13961v;
        if (imageView != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(imageView, FriendlyObstructionPurpose.VIDEO_CONTROLS, "mute button"));
        }
        t tVar = this.f13962w;
        if (tVar != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(tVar, FriendlyObstructionPurpose.VIDEO_CONTROLS, "generic webview overlay containing HTML controls"));
        }
        this.C.o().a((View) this.f13958s, (List<com.applovin.impl.sdk.a.d>) arrayList);
    }

    public void c() {
        a(a.c.VIDEO, "skip");
        this.C.o().n();
        super.c();
    }

    /* access modifiers changed from: protected */
    public void c(long j2) {
        super.c(j2);
        this.C.o().a((float) TimeUnit.MILLISECONDS.toSeconds(j2), Utils.isVideoMutedInitially(this.f13884b));
    }

    public void c(String str) {
        a(a.c.ERROR, f.MEDIA_FILE_ERROR);
        this.C.o().a(str);
        super.c(str);
    }

    public void d() {
        a((ViewGroup) null);
    }

    public void e() {
        this.f13964y.c();
        super.e();
    }

    public void f() {
        super.f();
        a(this.B ? a.c.COMPANION : a.c.VIDEO, "resume");
        this.C.o().k();
    }

    public void g() {
        super.g();
        a(this.B ? a.c.COMPANION : a.c.VIDEO, "pause");
        this.C.o().j();
    }

    public void h() {
        if (this.C != null) {
            a(a.c.VIDEO, MRAIDPresenter.CLOSE);
            a(a.c.COMPANION, MRAIDPresenter.CLOSE);
        }
        super.h();
    }

    /* access modifiers changed from: protected */
    public void u() {
        long j2;
        int s2;
        long j3 = 0;
        if (this.C.ad() >= 0 || this.C.ae() >= 0) {
            int i2 = (this.C.ad() > 0 ? 1 : (this.C.ad() == 0 ? 0 : -1));
            a aVar = this.C;
            if (i2 >= 0) {
                j2 = aVar.ad();
            } else {
                com.applovin.impl.a.m m2 = aVar.m();
                if (m2 == null || m2.b() <= 0) {
                    long j4 = this.A;
                    if (j4 > 0) {
                        j3 = 0 + j4;
                    }
                } else {
                    j3 = 0 + TimeUnit.SECONDS.toMillis((long) m2.b());
                }
                if (aVar.af() && (s2 = (int) aVar.s()) > 0) {
                    j3 += TimeUnit.SECONDS.toMillis((long) s2);
                }
                j2 = (long) (((double) j3) * (((double) this.C.ae()) / 100.0d));
            }
            b(j2);
        }
    }

    /* access modifiers changed from: protected */
    public void v() {
        super.v();
        a aVar = this.C;
        if (aVar != null) {
            aVar.o().l();
        }
    }

    /* access modifiers changed from: protected */
    public void w() {
        super.w();
        a aVar = this.C;
        if (aVar != null) {
            aVar.o().m();
        }
    }

    public void x() {
        super.x();
        a(a.c.VIDEO, this.f13965z ? "mute" : "unmute");
        this.C.o().a(this.f13965z);
    }

    public void y() {
        A();
        if (!l.c(this.C)) {
            if (v.a()) {
                this.f13885c.b("AppLovinFullscreenActivity", "VAST ad does not have valid companion ad - dismissing...");
            }
            h();
        } else if (!this.B) {
            a(a.c.COMPANION, "creativeView");
            this.C.o().i();
            g c2 = this.C.o();
            AppLovinAdView appLovinAdView = this.f13888f;
            c2.a((View) appLovinAdView, (List<com.applovin.impl.sdk.a.d>) Collections.singletonList(new com.applovin.impl.sdk.a.d(appLovinAdView, FriendlyObstructionPurpose.CLOSE_AD, "close button")));
            super.y();
        }
    }
}
