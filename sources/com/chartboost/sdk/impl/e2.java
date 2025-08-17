package com.chartboost.sdk.impl;

import android.view.View;
import android.view.ViewGroup;
import com.chartboost.sdk.impl.u;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.view.CBImpressionActivity;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

public final class e2 implements s6, b7, t6, l7 {

    /* renamed from: a  reason: collision with root package name */
    public final y6 f17583a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s6 f17584b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b7 f17585c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ t6 f17586d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l7 f17587e;

    /* renamed from: f  reason: collision with root package name */
    public g7 f17588f = g7.LOADING;

    public e2(y6 y6Var, s6 s6Var, b7 b7Var, t6 t6Var, l7 l7Var) {
        Intrinsics.f(y6Var, "impressionDependency");
        Intrinsics.f(s6Var, "impressionClick");
        Intrinsics.f(b7Var, "impressionDismiss");
        Intrinsics.f(t6Var, "impressionComplete");
        Intrinsics.f(l7Var, "impressionView");
        this.f17583a = y6Var;
        this.f17584b = s6Var;
        this.f17585c = b7Var;
        this.f17586d = t6Var;
        this.f17587e = l7Var;
    }

    public final int A() {
        if (this.f17583a.q() instanceof cd) {
            return ((cd) this.f17583a.q()).N();
        }
        return -1;
    }

    public final kd B() {
        return this.f17583a.q().z();
    }

    public final void C() {
        if (this.f17583a.q().m() <= 1) {
            c();
            y2 q2 = this.f17583a.q();
            q2.b(q2.m() + 1);
        }
    }

    public final void D() {
        if (k() && Intrinsics.a(this.f17583a.a(), u.c.f18737g)) {
            C();
        }
    }

    public final void E() {
        if (this.f17583a.q().n() <= 1) {
            O();
            y2 q2 = this.f17583a.q();
            q2.c(q2.n() + 1);
        }
    }

    public final boolean F() {
        return this.f17583a.q().B();
    }

    public final boolean G() {
        View view;
        if (this.f17583a.q().z() != null) {
            kd z2 = this.f17583a.q().z();
            if (z2 != null) {
                view = z2.getRootView();
            } else {
                view = null;
            }
            if (view == null) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final void H() {
        try {
            if (this.f17583a.q() instanceof cd) {
                ((cd) this.f17583a.q()).P();
                return;
            }
            this.f17583a.q().C();
            this.f17583a.q().a(oc.VOLUME_CHANGE);
        } catch (Exception unused) {
            String a2 = g2.f17715a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "Invalid mute video command");
        }
    }

    public final void I() {
        b(this.f17583a.m(), Float.valueOf(this.f17583a.q().y()), Float.valueOf(this.f17583a.q().x()));
        a();
    }

    public final void J() {
        if (this.f17583a.q().q() <= 1) {
            E();
            y2 q2 = this.f17583a.q();
            q2.d(q2.q() + 1);
        }
    }

    public final void K() {
        if (this.f17588f == g7.DISPLAYED && !k()) {
            n();
            c(true);
        }
    }

    public final void L() {
        try {
            y2 q2 = this.f17583a.q();
            Intrinsics.d(q2, "null cannot be cast to non-null type com.chartboost.sdk.internal.video.VideoProtocol");
            ((cd) q2).S();
        } catch (Exception e2) {
            String a2 = g2.f17715a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "Invalid pause video command: " + e2);
        }
    }

    public final void M() {
        try {
            y2 q2 = this.f17583a.q();
            Intrinsics.d(q2, "null cannot be cast to non-null type com.chartboost.sdk.internal.video.VideoProtocol");
            ((cd) q2).T();
        } catch (Exception e2) {
            String a2 = g2.f17715a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "Invalid play video command: " + e2);
        }
    }

    public final void N() {
        this.f17588f = g7.LOADING;
        CBError.CBImpressionError H = this.f17583a.q().H();
        if (H == null) {
            j();
        } else {
            b(H);
        }
    }

    public final void O() {
        a(this.f17583a.m(), Float.valueOf(this.f17583a.q().y()), Float.valueOf(this.f17583a.q().x()));
    }

    public final boolean P() {
        return this.f17583a.a().c();
    }

    public final void Q() {
        if (this.f17583a.q().r() <= 1) {
            C();
            E();
            y2 q2 = this.f17583a.q();
            q2.e(q2.r() + 1);
        }
    }

    public final void R() {
        try {
            if (this.f17583a.q() instanceof cd) {
                ((cd) this.f17583a.q()).V();
                return;
            }
            this.f17583a.q().K();
            this.f17583a.q().a(oc.VOLUME_CHANGE);
        } catch (Exception unused) {
            String a2 = g2.f17715a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "Invalid unmute video command");
        }
    }

    public final void S() {
        this.f17583a.q().D();
    }

    public final void T() {
        this.f17583a.q().g();
    }

    public void a(String str, CBError.CBClickError cBClickError) {
        Intrinsics.f(cBClickError, MRAIDPresenter.ERROR);
        this.f17584b.a(str, cBClickError);
    }

    public void b(x2 x2Var) {
        Intrinsics.f(x2Var, "cbUrl");
        this.f17584b.b(x2Var);
    }

    public void c(x2 x2Var) {
        Intrinsics.f(x2Var, "cbUrl");
        this.f17584b.c(x2Var);
    }

    public void d(boolean z2) {
        this.f17587e.d(z2);
    }

    public void e() {
        this.f17585c.e();
    }

    public void f() {
        this.f17587e.f();
    }

    public void g() {
        this.f17587e.g();
    }

    public boolean h() {
        return this.f17587e.h();
    }

    public boolean i() {
        return this.f17587e.i();
    }

    public void j() {
        this.f17587e.j();
    }

    public boolean k() {
        return this.f17587e.k();
    }

    public void l() {
        this.f17587e.l();
    }

    public boolean m() {
        return this.f17587e.m();
    }

    public void n() {
        this.f17587e.n();
    }

    public ViewGroup o() {
        return this.f17587e.o();
    }

    public final boolean p() {
        return this.f17583a.a().a();
    }

    public final void q() {
        try {
            y2 q2 = this.f17583a.q();
            Intrinsics.d(q2, "null cannot be cast to non-null type com.chartboost.sdk.internal.video.VideoProtocol");
            ((cd) q2).L();
        } catch (Exception e2) {
            String a2 = g2.f17715a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "Invalid close video command: " + e2);
        }
    }

    public final String r() {
        return this.f17583a.b().m();
    }

    public final String s() {
        return this.f17583a.b().t();
    }

    public g7 t() {
        return this.f17588f;
    }

    public final String u() {
        return this.f17583a.m();
    }

    public final String v() {
        return this.f17583a.q().j();
    }

    public final String w() {
        return this.f17583a.q().l();
    }

    public final String x() {
        return this.f17583a.q().p();
    }

    public final String y() {
        return this.f17583a.q().t();
    }

    public final String z() {
        return this.f17583a.q().u();
    }

    public void a() {
        this.f17584b.a();
    }

    public void b() {
        this.f17587e.b();
    }

    public void c() {
        this.f17586d.c();
    }

    public final void d() {
        a(this.f17588f);
    }

    public void e(boolean z2) {
        this.f17584b.e(z2);
    }

    public void f(boolean z2) {
        this.f17585c.f(z2);
    }

    public void a(g7 g7Var, CBImpressionActivity cBImpressionActivity) {
        Intrinsics.f(g7Var, AdOperationMetric.INIT_STATE);
        Intrinsics.f(cBImpressionActivity, "activity");
        this.f17587e.a(g7Var, cBImpressionActivity);
    }

    public void b(boolean z2) {
        this.f17587e.b(z2);
    }

    public void c(boolean z2) {
        this.f17587e.c(z2);
    }

    public void a(ViewGroup viewGroup) {
        this.f17587e.a(viewGroup);
    }

    public void b(String str, Float f2, Float f3) {
        Intrinsics.f(str, "location");
        this.f17584b.b(str, f2, f3);
    }

    public boolean a(Boolean bool, g7 g7Var) {
        Intrinsics.f(g7Var, "impressionState");
        return this.f17584b.a(bool, g7Var);
    }

    public void b(g7 g7Var) {
        Intrinsics.f(g7Var, "newState");
        this.f17588f = g7Var;
    }

    public void a(g7 g7Var) {
        Intrinsics.f(g7Var, AdOperationMetric.INIT_STATE);
        this.f17585c.a(g7Var);
    }

    public final void b(CBError.CBImpressionError cBImpressionError) {
        Intrinsics.f(cBImpressionError, MRAIDPresenter.ERROR);
        if (k()) {
            this.f17583a.c().p();
        } else {
            a(cBImpressionError);
        }
    }

    public void a(CBError.CBImpressionError cBImpressionError) {
        Intrinsics.f(cBImpressionError, MRAIDPresenter.ERROR);
        this.f17587e.a(cBImpressionError);
    }

    public void a(x2 x2Var) {
        Intrinsics.f(x2Var, "cbUrl");
        this.f17584b.a(x2Var);
    }

    public void a(String str, Float f2, Float f3) {
        Intrinsics.f(str, "location");
        this.f17586d.a(str, f2, f3);
    }

    public final void b(float f2) {
        this.f17583a.q().b(f2);
    }

    public void a(boolean z2) {
        this.f17587e.a(z2);
    }

    public final void a(String str) {
        List<String> list;
        Intrinsics.f(str, "event");
        Map l2 = this.f17583a.b().l();
        if (str.length() > 0 && (list = (List) l2.get(str)) != null) {
            for (String d2 : list) {
                this.f17583a.q().d(d2);
            }
        }
    }

    public final void a(boolean z2, String str) {
        Intrinsics.f(str, "forceOrientation");
        this.f17583a.q().a(z2, str);
    }

    public final void a(List list) {
        Intrinsics.f(list, "verificationScriptResourceList");
        this.f17583a.q().a(list);
    }

    public final void a(float f2, float f3) {
        this.f17583a.q().a(f2, f3);
    }

    public final void a(float f2) {
        this.f17583a.q().a(f2);
    }

    public final void a(g9 g9Var) {
        Intrinsics.f(g9Var, "playerState");
        this.f17583a.q().a(g9Var);
    }

    public final void a(oc ocVar) {
        Intrinsics.f(ocVar, "vastVideoEvent");
        this.f17583a.q().a(ocVar);
    }

    public final void a(Boolean bool) {
        a(bool, this.f17588f);
    }
}
