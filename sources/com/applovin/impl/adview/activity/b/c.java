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
import com.applovin.impl.sdk.a.d;
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

public class c extends e {
    /* access modifiers changed from: private */
    public final a F;
    /* access modifiers changed from: private */
    public final Set<j> G;

    public c(e eVar, Activity activity, m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        HashSet hashSet = new HashSet();
        this.G = hashSet;
        a aVar = (a) eVar;
        this.F = aVar;
        a.c cVar = a.c.VIDEO;
        hashSet.addAll(aVar.a(cVar, k.f13806a));
        a(a.c.IMPRESSION);
        a(cVar, "creativeView");
        aVar.o().d();
    }

    private void E() {
        if (r() && !this.G.isEmpty()) {
            if (v.a()) {
                v vVar = this.f13885c;
                vVar.d("AppLovinFullscreenActivity", "Firing " + this.G.size() + " un-fired video progress trackers when video was completed.");
            }
            a(this.G);
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
        a(this.F.a(cVar, str), fVar);
    }

    /* access modifiers changed from: private */
    public void a(Set<j> set) {
        a(set, f.UNSPECIFIED);
    }

    private void a(Set<j> set, f fVar) {
        if (set != null && !set.isEmpty()) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(this.f13937t.getCurrentPosition());
            n n2 = this.F.n();
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
        this.F.o().o();
        super.a(pointF);
    }

    public void a(ViewGroup viewGroup) {
        super.a(viewGroup);
        this.f13943z.a("PROGRESS_TRACKING", TimeUnit.SECONDS.toMillis(1), (j.a) new j.a() {
            public void a() {
                long seconds = TimeUnit.MILLISECONDS.toSeconds(c.this.B - (c.this.f13937t.getDuration() - c.this.f13937t.getCurrentPosition()));
                int D = c.this.D();
                HashSet hashSet = new HashSet();
                for (com.applovin.impl.a.j jVar : new HashSet(c.this.G)) {
                    if (jVar.a(seconds, D)) {
                        hashSet.add(jVar);
                        c.this.G.remove(jVar);
                    }
                }
                c.this.a((Set<com.applovin.impl.a.j>) hashSet);
                if (D >= 25 && D < 50) {
                    c.this.F.o().f();
                } else if (D >= 50 && D < 75) {
                    c.this.F.o().g();
                } else if (D >= 75) {
                    c.this.F.o().h();
                }
            }

            public boolean b() {
                return !c.this.D;
            }
        });
        ArrayList arrayList = new ArrayList();
        com.applovin.impl.adview.a aVar = this.f13938u;
        if (aVar != null) {
            arrayList.add(new d(aVar, FriendlyObstructionPurpose.OTHER, "video stream buffering indicator"));
        }
        com.applovin.impl.adview.m mVar = this.f13939v;
        if (mVar != null) {
            arrayList.add(new d(mVar, FriendlyObstructionPurpose.CLOSE_AD, "skip button"));
        }
        ProgressBar progressBar = this.f13942y;
        if (progressBar != null) {
            arrayList.add(new d(progressBar, FriendlyObstructionPurpose.OTHER, "progress bar"));
        }
        ImageView imageView = this.f13940w;
        if (imageView != null) {
            arrayList.add(new d(imageView, FriendlyObstructionPurpose.VIDEO_CONTROLS, "mute button"));
        }
        t tVar = this.f13941x;
        if (tVar != null) {
            arrayList.add(new d(tVar, FriendlyObstructionPurpose.VIDEO_CONTROLS, "generic webview overlay containing HTML controls"));
        }
        this.F.o().a((View) this.f13936s, (List<d>) arrayList);
    }

    public void c() {
        a(a.c.VIDEO, "skip");
        this.F.o().n();
        super.c();
    }

    /* access modifiers changed from: protected */
    public void c(long j2) {
        super.c(j2);
        this.F.o().a((float) TimeUnit.MILLISECONDS.toSeconds(j2), Utils.isVideoMutedInitially(this.f13884b));
    }

    public void c(String str) {
        a(a.c.ERROR, f.MEDIA_FILE_ERROR);
        this.F.o().a(str);
        super.c(str);
    }

    public void d() {
        a((ViewGroup) null);
    }

    public void e() {
        this.f13943z.c();
        super.e();
    }

    public void f() {
        super.f();
        a(this.D ? a.c.COMPANION : a.c.VIDEO, "resume");
        this.F.o().k();
    }

    public void g() {
        super.g();
        a(this.D ? a.c.COMPANION : a.c.VIDEO, "pause");
        this.F.o().j();
    }

    public void h() {
        if (this.F != null) {
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
        if (this.F.ad() >= 0 || this.F.ae() >= 0) {
            int i2 = (this.F.ad() > 0 ? 1 : (this.F.ad() == 0 ? 0 : -1));
            a aVar = this.F;
            if (i2 >= 0) {
                j2 = aVar.ad();
            } else {
                com.applovin.impl.a.m m2 = aVar.m();
                if (m2 == null || m2.b() <= 0) {
                    long j4 = this.B;
                    if (j4 > 0) {
                        j3 = 0 + j4;
                    }
                } else {
                    j3 = 0 + TimeUnit.SECONDS.toMillis((long) m2.b());
                }
                if (aVar.af() && (s2 = (int) aVar.s()) > 0) {
                    j3 += TimeUnit.SECONDS.toMillis((long) s2);
                }
                j2 = (long) (((double) j3) * (((double) this.F.ae()) / 100.0d));
            }
            b(j2);
        }
    }

    /* access modifiers changed from: protected */
    public void v() {
        super.v();
        a aVar = this.F;
        if (aVar != null) {
            aVar.o().l();
        }
    }

    /* access modifiers changed from: protected */
    public void w() {
        super.w();
        a aVar = this.F;
        if (aVar != null) {
            aVar.o().m();
        }
    }

    public void x() {
        super.x();
        a(a.c.VIDEO, this.A ? "mute" : "unmute");
        this.F.o().a(this.A);
    }

    public void y() {
        E();
        if (!l.c(this.F)) {
            if (v.a()) {
                this.f13885c.b("AppLovinFullscreenActivity", "VAST ad does not have valid companion ad - dismissing...");
            }
            h();
        } else if (!this.D) {
            a(a.c.COMPANION, "creativeView");
            this.F.o().i();
            g c2 = this.F.o();
            AppLovinAdView appLovinAdView = this.f13888f;
            c2.a((View) appLovinAdView, (List<d>) Collections.singletonList(new d(appLovinAdView, FriendlyObstructionPurpose.CLOSE_AD, "close button")));
            super.y();
        }
    }
}
