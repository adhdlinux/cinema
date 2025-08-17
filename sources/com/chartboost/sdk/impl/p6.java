package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Model.CBError;
import com.google.android.gms.ads.OutOfContextTestingActivity;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

public final class p6 implements s6, q3 {

    /* renamed from: a  reason: collision with root package name */
    public final v f18337a;

    /* renamed from: b  reason: collision with root package name */
    public final kc f18338b;

    /* renamed from: c  reason: collision with root package name */
    public final q7 f18339c;

    /* renamed from: d  reason: collision with root package name */
    public final m3 f18340d;

    /* renamed from: e  reason: collision with root package name */
    public final q3 f18341e;

    /* renamed from: f  reason: collision with root package name */
    public final f7 f18342f;

    /* renamed from: g  reason: collision with root package name */
    public final q6 f18343g;

    /* renamed from: h  reason: collision with root package name */
    public final p8 f18344h;

    /* renamed from: i  reason: collision with root package name */
    public final k0 f18345i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f18346j;

    /* renamed from: k  reason: collision with root package name */
    public Boolean f18347k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f18348l;

    public static final class a extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18349b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CBError.CBClickError f18350c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ p6 f18351d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, CBError.CBClickError cBClickError, p6 p6Var) {
            super(1);
            this.f18349b = str;
            this.f18350c = cBClickError;
            this.f18351d = p6Var;
        }

        public final void a(q6 q6Var) {
            Intrinsics.f(q6Var, "$this$notify");
            q6Var.a(this.f18349b, this.f18350c);
            p6 p6Var = this.f18351d;
            p6Var.b("Impression click callback for: " + this.f18349b + " failed with error: " + this.f18350c);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((q6) obj);
            return Unit.f40298a;
        }
    }

    public static final class b implements n3 {
        public void a(JSONObject jSONObject) {
            String str;
            String a2 = r6.f18513a;
            Intrinsics.e(a2, "TAG");
            StringBuilder sb = new StringBuilder();
            sb.append("onClickRequestSuccess ");
            if (jSONObject == null || (str = jSONObject.toString()) == null) {
                str = "";
            }
            sb.append(str);
            w7.c(a2, sb.toString());
        }

        public void a(String str) {
            String a2 = r6.f18513a;
            Intrinsics.e(a2, "TAG");
            w7.c(a2, "onClickRequestFailure " + str);
        }
    }

    public static final class c extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ p6 f18352b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18353c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(p6 p6Var, String str) {
            super(1);
            this.f18352b = p6Var;
            this.f18353c = str;
        }

        public final void a(q6 q6Var) {
            Intrinsics.f(q6Var, "$this$notify");
            q6Var.a();
            p6 p6Var = this.f18352b;
            p6Var.a("Url impression callback success: " + this.f18353c);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((q6) obj);
            return Unit.f40298a;
        }
    }

    public p6(v vVar, kc kcVar, q7 q7Var, m3 m3Var, q3 q3Var, f7 f7Var, q6 q6Var, p8 p8Var, k0 k0Var) {
        Intrinsics.f(vVar, OutOfContextTestingActivity.AD_UNIT_KEY);
        Intrinsics.f(kcVar, "urlResolver");
        Intrinsics.f(q7Var, "intentResolver");
        Intrinsics.f(m3Var, "clickRequest");
        Intrinsics.f(q3Var, "clickTracking");
        Intrinsics.f(f7Var, "mediaType");
        Intrinsics.f(q6Var, "impressionCallback");
        Intrinsics.f(p8Var, "openMeasurementImpressionCallback");
        Intrinsics.f(k0Var, "adUnitRendererImpressionCallback");
        this.f18337a = vVar;
        this.f18338b = kcVar;
        this.f18339c = q7Var;
        this.f18340d = m3Var;
        this.f18341e = q3Var;
        this.f18342f = f7Var;
        this.f18343g = q6Var;
        this.f18344h = p8Var;
        this.f18345i = k0Var;
    }

    public void a(String str) {
        Intrinsics.f(str, "message");
        this.f18341e.a(str);
    }

    public void b(String str) {
        Intrinsics.f(str, "message");
        this.f18341e.b(str);
    }

    public void c(x2 x2Var) {
        Intrinsics.f(x2Var, "cbUrl");
        c(x2Var.b());
    }

    public final void d(String str) {
        this.f18338b.a(str, this.f18337a.h(), this.f18341e);
    }

    public void e(boolean z2) {
        this.f18346j = z2;
    }

    public void a() {
        this.f18345i.b(this.f18337a.m());
        if (this.f18348l) {
            this.f18343g.B();
        }
    }

    public boolean b() {
        return this.f18346j;
    }

    public final void c(String str) {
        a(this.f18343g, str, CBError.CBClickError.LOAD_NOT_FINISHED);
    }

    public void b(String str, Float f2, Float f3) {
        Intrinsics.f(str, "location");
        this.f18340d.a((n3) new b(), new k3(str, this.f18337a.a(), this.f18337a.A(), this.f18337a.g(), this.f18337a.i(), f2, f3, this.f18342f, this.f18347k));
    }

    public void a(String str, CBError.CBClickError cBClickError) {
        Intrinsics.f(cBClickError, MRAIDPresenter.ERROR);
        this.f18345i.a(this.f18337a.m(), str, cBClickError);
    }

    public void a(x2 x2Var) {
        Intrinsics.f(x2Var, "cbUrl");
        d(x2Var.b());
    }

    public boolean a(Boolean bool, g7 g7Var) {
        Intrinsics.f(g7Var, "impressionState");
        if (bool != null) {
            this.f18348l = bool.booleanValue();
        }
        if (g7Var != g7.DISPLAYED) {
            return false;
        }
        String o2 = this.f18337a.o();
        String k2 = this.f18337a.k();
        if (this.f18339c.b(k2)) {
            this.f18347k = Boolean.TRUE;
            o2 = k2;
        } else {
            this.f18347k = Boolean.FALSE;
        }
        if (b()) {
            return false;
        }
        e(true);
        this.f18343g.b(false);
        a(o2, Boolean.valueOf(this.f18348l));
        return true;
    }

    public void b(x2 x2Var) {
        Intrinsics.f(x2Var, "cbUrl");
        a(x2Var.b(), x2Var.a());
    }

    public final void a(String str, Boolean bool) {
        Unit unit;
        this.f18344h.d();
        if (bool != null) {
            this.f18348l = bool.booleanValue();
        }
        CBError.CBClickError a2 = this.f18338b.a(str, this.f18337a.h(), this.f18341e);
        if (a2 != null) {
            a(this.f18343g, str, a2);
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            a(this.f18343g, str);
        }
    }

    public final void a(q6 q6Var, String str) {
        a(q6Var, (Function1) new c(this, str));
    }

    public final void a(q6 q6Var, String str, CBError.CBClickError cBClickError) {
        a(q6Var, (Function1) new a(str, cBClickError, this));
    }

    public final void a(q6 q6Var, Function1 function1) {
        Unit unit;
        if (q6Var != null) {
            q6Var.a(false);
            function1.invoke(q6Var);
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            w7.b("test", "Impression callback is null");
        }
    }
}
