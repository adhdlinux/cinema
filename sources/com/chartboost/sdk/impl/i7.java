package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.view.CBImpressionActivity;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class i7 implements l7 {

    /* renamed from: a  reason: collision with root package name */
    public final b1 f17918a;

    /* renamed from: b  reason: collision with root package name */
    public final y2 f17919b;

    /* renamed from: c  reason: collision with root package name */
    public final s4 f17920c;

    /* renamed from: d  reason: collision with root package name */
    public final k0 f17921d;

    /* renamed from: e  reason: collision with root package name */
    public final e7 f17922e;

    /* renamed from: f  reason: collision with root package name */
    public final q6 f17923f;

    /* renamed from: g  reason: collision with root package name */
    public final WeakReference f17924g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17925h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17926i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f17927j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f17928k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f17929l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f17930m;

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i7 f17931b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(i7 i7Var) {
            super(0);
            this.f17931b = i7Var;
        }

        public final void a() {
            String a2 = j7.f17984a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "Cannot display on host because view was not created!");
            this.f17931b.a(CBError.CBImpressionError.ERROR_CREATING_VIEW);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public i7(b1 b1Var, y2 y2Var, s4 s4Var, ViewGroup viewGroup, k0 k0Var, e7 e7Var, q6 q6Var) {
        Intrinsics.f(b1Var, "appRequest");
        Intrinsics.f(y2Var, "viewProtocol");
        Intrinsics.f(s4Var, "downloader");
        Intrinsics.f(k0Var, "adUnitRendererImpressionCallback");
        Intrinsics.f(e7Var, "impressionIntermediateCallback");
        Intrinsics.f(q6Var, "impressionClickCallback");
        this.f17918a = b1Var;
        this.f17919b = y2Var;
        this.f17920c = s4Var;
        this.f17921d = k0Var;
        this.f17922e = e7Var;
        this.f17923f = q6Var;
        this.f17924g = new WeakReference(viewGroup);
    }

    public void a(boolean z2) {
        this.f17927j = z2;
    }

    public void b(boolean z2) {
        this.f17926i = z2;
    }

    public void c(boolean z2) {
        this.f17929l = z2;
    }

    public void d(boolean z2) {
        this.f17925h = z2;
    }

    public void e(boolean z2) {
        this.f17930m = z2;
    }

    public void f() {
        if (!this.f17928k) {
            this.f17928k = true;
            this.f17919b.F();
        }
    }

    public void g() {
        this.f17923f.a(false);
    }

    public boolean h() {
        return this.f17925h;
    }

    public boolean i() {
        return this.f17927j;
    }

    public void j() {
        this.f17921d.v();
    }

    public boolean k() {
        return this.f17929l;
    }

    public void l() {
        if (!a()) {
            e(true);
            if (k()) {
                this.f17922e.e();
            } else {
                a(CBError.CBImpressionError.INTERNAL);
            }
            this.f17919b.a(oc.SKIP);
            this.f17922e.h();
            this.f17919b.J();
        }
    }

    public boolean m() {
        return this.f17926i;
    }

    public void n() {
        this.f17921d.a(this.f17918a);
    }

    public ViewGroup o() {
        return (ViewGroup) this.f17924g.get();
    }

    public boolean a() {
        return this.f17930m;
    }

    public void b() {
        this.f17923f.a(false);
        if (this.f17928k) {
            this.f17928k = false;
            this.f17919b.G();
        }
    }

    public void a(CBError.CBImpressionError cBImpressionError) {
        Intrinsics.f(cBImpressionError, MRAIDPresenter.ERROR);
        this.f17929l = true;
        this.f17921d.a(this.f17918a, cBImpressionError);
    }

    public void a(g7 g7Var, CBImpressionActivity cBImpressionActivity) {
        Intrinsics.f(g7Var, AdOperationMetric.INIT_STATE);
        Intrinsics.f(cBImpressionActivity, "activity");
        if (g7Var != g7.LOADING) {
            a(cBImpressionActivity);
            return;
        }
        String a2 = j7.f17984a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "displayOnActivity invalid state: " + g7Var);
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            try {
                String a2 = j7.f17984a;
                Intrinsics.e(a2, "TAG");
                w7.b(a2, "Cannot display on host because it is null!");
                a(CBError.CBImpressionError.ERROR_DISPLAYING_VIEW);
            } catch (Exception e2) {
                String a3 = j7.f17984a;
                Intrinsics.e(a3, "TAG");
                w7.b(a3, "displayOnHostView e: " + e2);
                a(CBError.CBImpressionError.ERROR_CREATING_VIEW);
            }
        } else {
            CBError.CBImpressionError a4 = this.f17919b.a(viewGroup);
            if (a4 != null) {
                w7.b("test", "displayOnHostView tryCreatingViewOnHostView error " + a4);
                a(a4);
                return;
            }
            kd z2 = this.f17919b.z();
            if (z2 != null) {
                a(viewGroup, (View) z2);
                Unit unit = Unit.f40298a;
                return;
            }
            new a(this);
        }
    }

    public final void a(ViewGroup viewGroup, View view) {
        Unit unit;
        Context context;
        this.f17922e.a(g7.DISPLAYED);
        kd z2 = this.f17919b.z();
        if (z2 == null || (context = z2.getContext()) == null) {
            unit = null;
        } else {
            this.f17921d.a(context);
            unit = Unit.f40298a;
        }
        if (unit == null) {
            String a2 = j7.f17984a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "Missing context on onImpressionViewCreated");
        }
        viewGroup.addView(view);
        this.f17920c.a();
    }

    public final void a(CBImpressionActivity cBImpressionActivity) {
        this.f17922e.a(g7.DISPLAYED);
        try {
            CBError.CBImpressionError a2 = this.f17919b.a(cBImpressionActivity);
            if (a2 != null) {
                a(a2);
                return;
            }
            String a3 = j7.f17984a;
            Intrinsics.e(a3, "TAG");
            w7.c(a3, "Displaying the impression");
        } catch (Exception e2) {
            String a4 = j7.f17984a;
            Intrinsics.e(a4, "TAG");
            w7.b(a4, "Cannot create view in protocol: " + e2);
            a(CBError.CBImpressionError.ERROR_CREATING_VIEW);
        }
    }
}
