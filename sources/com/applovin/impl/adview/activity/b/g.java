package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.StrictMode;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.applovin.impl.adview.activity.a.d;
import com.applovin.impl.adview.m;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.e.z;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.R;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class g extends a implements com.applovin.impl.adview.g {
    private AtomicBoolean A;
    private boolean B;
    /* access modifiers changed from: private */
    public long C;
    /* access modifiers changed from: private */
    public long D;

    /* renamed from: s  reason: collision with root package name */
    private final d f13982s = new d(this.f13883a, this.f13887e, this.f13884b);
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public final m f13983t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public final ImageView f13984u;

    /* renamed from: v  reason: collision with root package name */
    private final com.applovin.impl.adview.a f13985v;

    /* renamed from: w  reason: collision with root package name */
    private final boolean f13986w;

    /* renamed from: x  reason: collision with root package name */
    private double f13987x;

    /* renamed from: y  reason: collision with root package name */
    private double f13988y;

    /* renamed from: z  reason: collision with root package name */
    private AtomicBoolean f13989z;

    private class a implements View.OnClickListener {
        private a() {
        }

        public void onClick(View view) {
            if (view == g.this.f13983t) {
                if (g.this.s()) {
                    g.this.p();
                    g.this.f13899q.b();
                    return;
                }
                g.this.v();
            } else if (view == g.this.f13984u) {
                g.this.x();
            } else if (v.a()) {
                v vVar = g.this.f13885c;
                vVar.e("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    public g(e eVar, Activity activity, com.applovin.impl.sdk.m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        boolean f2 = this.f13883a.f();
        this.f13986w = f2;
        this.f13989z = new AtomicBoolean();
        this.A = new AtomicBoolean();
        this.B = Utils.isVideoMutedInitially(this.f13884b);
        this.C = -2;
        this.D = 0;
        a aVar = new a();
        if (eVar.q() >= 0) {
            m mVar2 = new m(eVar.w(), activity);
            this.f13983t = mVar2;
            mVar2.setVisibility(8);
            mVar2.setOnClickListener(aVar);
        } else {
            this.f13983t = null;
        }
        if (a(this.B, mVar)) {
            ImageView imageView = new ImageView(activity);
            this.f13984u = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClickable(true);
            imageView.setOnClickListener(aVar);
            d(this.B);
        } else {
            this.f13984u = null;
        }
        if (f2) {
            com.applovin.impl.adview.a aVar2 = new com.applovin.impl.adview.a(activity, ((Integer) mVar.a(b.cB)).intValue(), 16842874);
            this.f13985v = aVar2;
            aVar2.setColor(Color.parseColor("#75FFFFFF"));
            aVar2.setBackgroundColor(Color.parseColor("#00000000"));
            aVar2.setVisibility(8);
            return;
        }
        this.f13985v = null;
    }

    private static boolean a(boolean z2, com.applovin.impl.sdk.m mVar) {
        if (!((Boolean) mVar.a(b.cq)).booleanValue()) {
            return false;
        }
        if (!((Boolean) mVar.a(b.cr)).booleanValue() || z2) {
            return true;
        }
        return ((Boolean) mVar.a(b.ct)).booleanValue();
    }

    private void d(boolean z2) {
        if (com.applovin.impl.sdk.utils.g.d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f13887e.getDrawable(z2 ? R.drawable.unmute_to_mute : R.drawable.mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.f13984u.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f13984u.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri aC = z2 ? this.f13883a.aC() : this.f13883a.aD();
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.f13984u.setImageURI(aC);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* access modifiers changed from: private */
    public void y() {
        if (this.A.compareAndSet(false, true)) {
            a(this.f13983t, this.f13883a.q(), new Runnable() {
                public void run() {
                    long unused = g.this.C = -1;
                    long unused2 = g.this.D = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    public void a() {
        if (v.a()) {
            this.f13885c.b("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
        }
    }

    public void a(double d2) {
        b("javascript:al_setVideoMuted(" + this.B + ");");
        com.applovin.impl.adview.a aVar = this.f13985v;
        if (aVar != null) {
            aVar.b();
        }
        if (this.f13983t != null) {
            y();
        }
        this.f13888f.getController().m();
        this.f13988y = d2;
        u();
        if (this.f13883a.am()) {
            this.f13899q.a(this.f13883a, (Runnable) null);
        }
    }

    public void a(long j2) {
    }

    public void a(ViewGroup viewGroup) {
        this.f13982s.a(this.f13984u, this.f13983t, this.f13889g, this.f13985v, this.f13888f, viewGroup);
        this.f13888f.getController().a((com.applovin.impl.adview.g) this);
        a(false);
        com.applovin.impl.adview.a aVar = this.f13985v;
        if (aVar != null) {
            aVar.a();
        }
        this.f13888f.renderAd(this.f13883a);
        if (this.f13983t != null) {
            this.f13884b.S().a(new z(this.f13884b, new Runnable() {
                public void run() {
                    g.this.y();
                }
            }), o.a.MAIN, this.f13883a.r(), true);
        }
        this.f13884b.S().a((com.applovin.impl.sdk.e.a) new z(this.f13884b, new Runnable() {
            public void run() {
                g gVar = g.this;
                m mVar = gVar.f13889g;
                com.applovin.impl.sdk.a.b o2 = gVar.f13883a.o();
                if (mVar != null) {
                    g gVar2 = g.this;
                    o2.a((View) gVar2.f13888f, (List<com.applovin.impl.sdk.a.d>) Collections.singletonList(new com.applovin.impl.sdk.a.d(gVar2.f13889g, FriendlyObstructionPurpose.CLOSE_AD, "close button")));
                    return;
                }
                o2.a((View) g.this.f13888f);
            }
        }), o.a.MAIN, 500);
        super.b(this.B);
    }

    public void a_() {
        w();
    }

    public void b() {
        if (v.a()) {
            this.f13885c.b("AppLovinFullscreenActivity", "Skipping video from prompt");
        }
        v();
    }

    public void b(double d2) {
        this.f13987x = d2;
    }

    public void b_() {
        com.applovin.impl.adview.a aVar = this.f13985v;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void c() {
        com.applovin.impl.adview.a aVar = this.f13985v;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void d() {
        a((ViewGroup) null);
    }

    public void e() {
    }

    public void h() {
        m();
        super.h();
    }

    /* access modifiers changed from: protected */
    public void m() {
        super.a((int) this.f13987x, this.f13986w, r(), this.C);
    }

    /* access modifiers changed from: protected */
    public boolean r() {
        return this.f13987x >= ((double) this.f13883a.Q());
    }

    /* access modifiers changed from: protected */
    public boolean s() {
        return t() && !r();
    }

    /* access modifiers changed from: protected */
    public void u() {
        long j2;
        int l2;
        long j3 = 0;
        if (this.f13883a.ad() >= 0 || this.f13883a.ae() >= 0) {
            int i2 = (this.f13883a.ad() > 0 ? 1 : (this.f13883a.ad() == 0 ? 0 : -1));
            e eVar = this.f13883a;
            if (i2 >= 0) {
                j2 = eVar.ad();
            } else {
                com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) eVar;
                double d2 = this.f13988y;
                if (d2 > 0.0d) {
                    j3 = 0 + TimeUnit.SECONDS.toMillis((long) d2);
                }
                if (aVar.af() && ((l2 = (int) ((com.applovin.impl.sdk.ad.a) this.f13883a).l()) > 0 || (l2 = (int) aVar.s()) > 0)) {
                    j3 += TimeUnit.SECONDS.toMillis((long) l2);
                }
                j2 = (long) (((double) j3) * (((double) this.f13883a.ae()) / 100.0d));
            }
            b(j2);
        }
    }

    public void v() {
        this.C = SystemClock.elapsedRealtime() - this.D;
        if (v.a()) {
            this.f13885c.b("AppLovinFullscreenActivity", "Skipping video with skip time: " + this.C + "ms");
        }
        this.f13886d.f();
        this.f13892j++;
        if (this.f13883a.x()) {
            h();
        } else {
            w();
        }
    }

    public void w() {
        if (this.f13989z.compareAndSet(false, true)) {
            if (v.a()) {
                this.f13885c.b("AppLovinFullscreenActivity", "Showing postitial...");
            }
            b("javascript:al_showPostitial();");
            m mVar = this.f13983t;
            if (mVar != null) {
                mVar.setVisibility(8);
            }
            ImageView imageView = this.f13984u;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            com.applovin.impl.adview.a aVar = this.f13985v;
            if (aVar != null) {
                aVar.b();
            }
            if (this.f13889g != null) {
                int i2 = (this.f13883a.s() > 0 ? 1 : (this.f13883a.s() == 0 ? 0 : -1));
                m mVar2 = this.f13889g;
                if (i2 >= 0) {
                    a(mVar2, this.f13883a.s(), new Runnable() {
                        public void run() {
                            g.this.f13891i = SystemClock.elapsedRealtime();
                        }
                    });
                } else {
                    mVar2.setVisibility(0);
                }
            }
            this.f13888f.getController().n();
        }
    }

    /* access modifiers changed from: protected */
    public void x() {
        this.B = !this.B;
        b("javascript:al_setVideoMuted(" + this.B + ");");
        d(this.B);
        a(this.B, 0);
    }
}
