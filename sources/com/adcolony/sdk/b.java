package com.adcolony.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.Iterator;
import java.util.Map;

class b extends Activity {

    /* renamed from: b  reason: collision with root package name */
    c f12948b;

    /* renamed from: c  reason: collision with root package name */
    int f12949c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f12950d;

    /* renamed from: e  reason: collision with root package name */
    boolean f12951e;

    /* renamed from: f  reason: collision with root package name */
    boolean f12952f;

    /* renamed from: g  reason: collision with root package name */
    boolean f12953g;

    /* renamed from: h  reason: collision with root package name */
    boolean f12954h;

    /* renamed from: i  reason: collision with root package name */
    boolean f12955i;

    /* renamed from: j  reason: collision with root package name */
    boolean f12956j;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            b.this.c(h0Var);
        }
    }

    b() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Rect rect;
        k f2 = a.f();
        if (this.f12948b == null) {
            this.f12948b = f2.t0();
        }
        c cVar = this.f12948b;
        if (cVar != null) {
            cVar.u(false);
            if (z0.O()) {
                this.f12948b.u(true);
            }
            if (this.f12954h) {
                rect = f2.x0().Z();
            } else {
                rect = f2.x0().Y();
            }
            if (rect.width() > 0 && rect.height() > 0) {
                f1 q2 = c0.q();
                f1 q3 = c0.q();
                float U = f2.x0().U();
                c0.u(q3, "width", (int) (((float) rect.width()) / U));
                c0.u(q3, "height", (int) (((float) rect.height()) / U));
                c0.u(q3, "app_orientation", z0.F(z0.M()));
                c0.u(q3, "x", 0);
                c0.u(q3, "y", 0);
                c0.n(q3, "ad_session_id", this.f12948b.b());
                c0.u(q2, "screen_width", rect.width());
                c0.u(q2, "screen_height", rect.height());
                c0.n(q2, "ad_session_id", this.f12948b.b());
                c0.u(q2, "id", this.f12948b.p());
                this.f12948b.setLayoutParams(new FrameLayout.LayoutParams(rect.width(), rect.height()));
                this.f12948b.m(rect.width());
                this.f12948b.d(rect.height());
                new h0("MRAID.on_size_change", this.f12948b.I(), q3).e();
                new h0("AdContainer.on_orientation_change", this.f12948b.I(), q2).e();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        if (i2 == 0) {
            setRequestedOrientation(7);
        } else if (i2 != 1) {
            setRequestedOrientation(4);
        } else {
            setRequestedOrientation(6);
        }
        this.f12949c = i2;
    }

    /* access modifiers changed from: package-private */
    public void c(h0 h0Var) {
        int A = c0.A(h0Var.a(), "status");
        if ((A == 5 || A == 0 || A == 6 || A == 1) && !this.f12951e) {
            k f2 = a.f();
            r A0 = f2.A0();
            f2.b0(h0Var);
            if (A0.a() != null) {
                A0.a().dismiss();
                A0.d((AlertDialog) null);
            }
            if (!this.f12953g) {
                finish();
            }
            this.f12951e = true;
            ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            f2.f0(false);
            f1 q2 = c0.q();
            c0.n(q2, "id", this.f12948b.b());
            new h0("AdSession.on_close", this.f12948b.I(), q2).e();
            f2.y((c) null);
            f2.x((AdColonyInterstitial) null);
            f2.v((AdColonyAdView) null);
            a.f().T().z().remove(this.f12948b.b());
        }
    }

    /* access modifiers changed from: package-private */
    public void d(boolean z2) {
        Iterator<Map.Entry<Integer, a1>> it2 = this.f12948b.K().entrySet().iterator();
        while (it2.hasNext() && !isFinishing()) {
            a1 a1Var = (a1) it2.next().getValue();
            if (!a1Var.D() && a1Var.j().isPlaying()) {
                a1Var.H();
            }
        }
        AdColonyInterstitial q02 = a.f().q0();
        if (q02 != null && q02.z() && q02.s().m() != null && z2 && this.f12955i) {
            q02.s().f("pause");
        }
    }

    /* access modifiers changed from: package-private */
    public void e(boolean z2) {
        for (Map.Entry<Integer, a1> value : this.f12948b.K().entrySet()) {
            a1 a1Var = (a1) value.getValue();
            if (!a1Var.D() && !a1Var.j().isPlaying() && !a.f().A0().h()) {
                a1Var.I();
            }
        }
        AdColonyInterstitial q02 = a.f().q0();
        if (q02 != null && q02.z() && q02.s().m() != null) {
            if ((!z2 || !this.f12955i) && this.f12956j) {
                q02.s().f("resume");
            }
        }
    }

    public void onBackPressed() {
        f1 q2 = c0.q();
        c0.n(q2, "id", this.f12948b.b());
        new h0("AdSession.on_back_button", this.f12948b.I(), q2).e();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this instanceof AdColonyInterstitialActivity) {
            a();
        } else {
            ((AdColonyAdViewActivity) this).g();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!a.i() || a.f().t0() == null) {
            finish();
            return;
        }
        k f2 = a.f();
        this.f12953g = false;
        c t02 = f2.t0();
        this.f12948b = t02;
        t02.u(false);
        if (z0.O()) {
            this.f12948b.u(true);
        }
        this.f12948b.b();
        this.f12950d = this.f12948b.I();
        boolean f3 = f2.L0().f();
        this.f12954h = f3;
        if (f3) {
            getWindow().addFlags(2048);
            getWindow().clearFlags(1024);
        } else {
            getWindow().addFlags(1024);
            getWindow().clearFlags(2048);
        }
        requestWindowFeature(1);
        getWindow().getDecorView().setBackgroundColor(-16777216);
        if (f2.L0().d()) {
            getWindow().addFlags(128);
        }
        ViewParent parent = this.f12948b.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f12948b);
        }
        setContentView(this.f12948b);
        this.f12948b.E().add(a.b("AdSession.finish_fullscreen_ad", new a(), true));
        this.f12948b.G().add("AdSession.finish_fullscreen_ad");
        b(this.f12949c);
        if (!this.f12948b.M()) {
            f1 q2 = c0.q();
            c0.n(q2, "id", this.f12948b.b());
            c0.u(q2, "screen_width", this.f12948b.s());
            c0.u(q2, "screen_height", this.f12948b.k());
            new h0("AdSession.on_fullscreen_ad_started", this.f12948b.I(), q2).e();
            this.f12948b.w(true);
            return;
        }
        a();
    }

    public void onDestroy() {
        super.onDestroy();
        if (a.i() && this.f12948b != null && !this.f12951e) {
            if ((Build.VERSION.SDK_INT < 24 || !z0.O()) && !this.f12948b.O()) {
                f1 q2 = c0.q();
                c0.n(q2, "id", this.f12948b.b());
                new h0("AdSession.on_error", this.f12948b.I(), q2).e();
                this.f12953g = true;
            }
        }
    }

    public void onPause() {
        super.onPause();
        d(this.f12952f);
        this.f12952f = false;
    }

    public void onResume() {
        super.onResume();
        a();
        e(this.f12952f);
        this.f12952f = true;
        this.f12956j = true;
    }

    public void onWindowFocusChanged(boolean z2) {
        if (z2 && this.f12952f) {
            a.f().N0().f(true);
            e(this.f12952f);
            this.f12955i = true;
        } else if (!z2 && this.f12952f) {
            a.f().N0().c(true);
            d(this.f12952f);
            this.f12955i = false;
        }
    }
}
