package com.chartboost.sdk.impl;

import android.util.Log;
import android.view.ViewGroup;
import b0.t;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.d7;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.impl.u;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.view.CBImpressionActivity;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.protobuf.CodedOutputStream;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

public final class h0 implements k0, e7, q6, d7, i0, a5 {

    /* renamed from: a  reason: collision with root package name */
    public final u f17803a;

    /* renamed from: b  reason: collision with root package name */
    public final r2 f17804b;

    /* renamed from: c  reason: collision with root package name */
    public final v5 f17805c;

    /* renamed from: d  reason: collision with root package name */
    public final dd f17806d;

    /* renamed from: e  reason: collision with root package name */
    public final n6 f17807e;

    /* renamed from: f  reason: collision with root package name */
    public final m0 f17808f;

    /* renamed from: g  reason: collision with root package name */
    public final n8 f17809g;

    /* renamed from: h  reason: collision with root package name */
    public final k7 f17810h;

    /* renamed from: i  reason: collision with root package name */
    public final x9 f17811i;

    /* renamed from: j  reason: collision with root package name */
    public final c8 f17812j;

    /* renamed from: k  reason: collision with root package name */
    public final eb f17813k;

    /* renamed from: l  reason: collision with root package name */
    public final Mediation f17814l;

    /* renamed from: m  reason: collision with root package name */
    public final CoroutineScope f17815m;

    /* renamed from: n  reason: collision with root package name */
    public final a5 f17816n;

    /* renamed from: o  reason: collision with root package name */
    public j0 f17817o;

    /* renamed from: p  reason: collision with root package name */
    public e2 f17818p;

    /* renamed from: q  reason: collision with root package name */
    public final b f17819q;

    public static final class a extends SuspendLambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public int f17820b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e2 f17821c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h0 f17822d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b1 f17823e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e2 e2Var, h0 h0Var, b1 b1Var, Continuation continuation) {
            super(2, continuation);
            this.f17821c = e2Var;
            this.f17822d = h0Var;
            this.f17823e = b1Var;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new a(this.f17821c, this.f17822d, this.f17823e, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Unit unit;
            Object unused = IntrinsicsKt__IntrinsicsKt.e();
            if (this.f17820b == 0) {
                ResultKt.b(obj);
                e2 e2Var = this.f17821c;
                if (e2Var != null) {
                    e2Var.N();
                    unit = Unit.f40298a;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    this.f17822d.d(this.f17823e, CBError.CBImpressionError.PENDING_IMPRESSION_ERROR);
                }
                return Unit.f40298a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class b implements od {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h0 f17824a;

        public b(h0 h0Var) {
            this.f17824a = h0Var;
        }

        public void a() {
            e2 a2 = this.f17824a.f17818p;
            if (a2 != null) {
                a2.b(CBError.CBImpressionError.WEB_VIEW_PAGE_LOAD_TIMEOUT);
            }
        }
    }

    public h0(u uVar, r2 r2Var, v5 v5Var, dd ddVar, n6 n6Var, m0 m0Var, n8 n8Var, k7 k7Var, x9 x9Var, c8 c8Var, eb ebVar, Mediation mediation, CoroutineScope coroutineScope, a5 a5Var) {
        Intrinsics.f(uVar, "adType");
        Intrinsics.f(r2Var, "reachability");
        Intrinsics.f(v5Var, "fileCache");
        Intrinsics.f(ddVar, "videoRepository");
        Intrinsics.f(n6Var, "impressionBuilder");
        Intrinsics.f(m0Var, "adUnitRendererShowRequest");
        Intrinsics.f(n8Var, "openMeasurementController");
        Intrinsics.f(k7Var, "viewProtocolBuilder");
        Intrinsics.f(x9Var, "rendererActivityBridge");
        Intrinsics.f(c8Var, "nativeBridgeCommand");
        Intrinsics.f(ebVar, "templateLoader");
        Intrinsics.f(coroutineScope, "uiScope");
        Intrinsics.f(a5Var, "eventTracker");
        this.f17803a = uVar;
        this.f17804b = r2Var;
        this.f17805c = v5Var;
        this.f17806d = ddVar;
        this.f17807e = n6Var;
        this.f17808f = m0Var;
        this.f17809g = n8Var;
        this.f17810h = k7Var;
        this.f17811i = x9Var;
        this.f17812j = c8Var;
        this.f17813k = ebVar;
        this.f17814l = mediation;
        this.f17815m = coroutineScope;
        this.f17816n = a5Var;
        this.f17819q = new b(this);
    }

    /* access modifiers changed from: private */
    public final void d(b1 b1Var, CBError.CBImpressionError cBImpressionError) {
        c(b1Var, cBImpressionError);
        if (cBImpressionError != CBError.CBImpressionError.NO_AD_FOUND) {
            String a2 = l0.f18083a;
            Intrinsics.e(a2, "TAG");
            StringBuilder sb = new StringBuilder();
            sb.append("reportError: adTypeTraits: ");
            sb.append(this.f17803a.b());
            sb.append(" reason: cache  format: web error: ");
            sb.append(cBImpressionError);
            sb.append(" adId: ");
            v a3 = b1Var.a();
            sb.append(a3 != null ? a3.a() : null);
            sb.append(" appRequest.location: ");
            sb.append(b1Var.d());
            w7.b(a2, sb.toString());
        }
    }

    private final void e(b1 b1Var) {
        b1Var.b(false);
        b1Var.a((v) null);
    }

    public void A() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.b();
        }
    }

    public void B() {
        g7 g7Var;
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            g7Var = e2Var.t();
        } else {
            g7Var = null;
        }
        if (g7Var == g7.DISPLAYED && !Intrinsics.a(this.f17803a, u.a.f18735g)) {
            this.f17811i.a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.v();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String C() {
        /*
            r1 = this;
            com.chartboost.sdk.impl.e2 r0 = r1.f17818p
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.v()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.h0.C():java.lang.String");
    }

    public void D() {
        this.f17811i.a();
    }

    public final void E() {
        try {
            e2 e2Var = this.f17818p;
            if (e2Var != null) {
                this.f17809g.e();
                ViewGroup o2 = e2Var.o();
                if (o2 != null) {
                    o2.removeAllViews();
                    o2.invalidate();
                }
                e2Var.T();
                this.f17818p = null;
                this.f17817o = null;
            }
        } catch (Exception e2) {
            String a2 = l0.f18083a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "detachBannerImpression error: " + e2);
        }
    }

    public final Mediation F() {
        return this.f17814l;
    }

    public final int G() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            return e2Var.A();
        }
        return -1;
    }

    public boolean H() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            return e2Var.h();
        }
        return false;
    }

    public final void b(b1 b1Var, CBError.CBImpressionError cBImpressionError) {
        d(b1Var, cBImpressionError);
        if (cBImpressionError != CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE) {
            e(b1Var);
        }
        this.f17809g.g();
    }

    public CBError.CBImpressionError c(String str) {
        return d7.a.a(this, str);
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f17816n.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f17816n.clearFromStorage(qbVar);
    }

    public final void f(b1 b1Var) {
        if (this.f17818p != null && b1Var.b() == null) {
            String a2 = l0.f18083a;
            Intrinsics.e(a2, "TAG");
            w7.e(a2, "Fullscreen impression is currently loading.");
        } else if (!this.f17804b.e()) {
            c(b1Var, CBError.CBImpressionError.INTERNET_UNAVAILABLE_AT_SHOW);
        } else {
            j0 j0Var = this.f17817o;
            if (j0Var != null) {
                j0Var.d(c(b1Var));
            }
            n6 n6Var = this.f17807e;
            w b2 = b1Var.b();
            c7 a3 = n6Var.a(b1Var, this, b2 != null ? b2.b() : null, this, this, this.f17810h, this, this.f17819q, this.f17812j, this.f17813k);
            this.f17818p = a3.b();
            a(b1Var, a3.b(), a3.a());
        }
    }

    public final void g(b1 b1Var) {
        String str;
        String B;
        v a2 = b1Var.a();
        if (a2 == null || !a2.D()) {
            f(b1Var);
            return;
        }
        dd ddVar = this.f17806d;
        v a3 = b1Var.a();
        String str2 = "";
        if (a3 == null || (str = a3.C()) == null) {
            str = str2;
        }
        v a4 = b1Var.a();
        if (!(a4 == null || (B = a4.B()) == null)) {
            str2 = B;
        }
        ddVar.a(str, str2, true, new t(this, b1Var));
    }

    public final void h(b1 b1Var) {
        if (!b1Var.e()) {
            b1Var.b(true);
            track((qb) new m7(tb.h.START, "", this.f17803a.b(), b1Var.d(), (Mediation) null, (ib) null, 48, (DefaultConstructorMarker) null));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.x();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String i() {
        /*
            r1 = this;
            com.chartboost.sdk.impl.e2 r0 = r1.f17818p
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.x()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.h0.i():java.lang.String");
    }

    public void j() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.D();
        }
    }

    public void k() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.M();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.s();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String l() {
        /*
            r1 = this;
            com.chartboost.sdk.impl.e2 r0 = r1.f17818p
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.s()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.h0.l():java.lang.String");
    }

    public void m() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.L();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.w();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String n() {
        /*
            r1 = this;
            com.chartboost.sdk.impl.e2 r0 = r1.f17818p
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.w()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.h0.n():java.lang.String");
    }

    public void o() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.Q();
        }
    }

    public void p() {
        this.f17811i.a();
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f17816n.persist(qbVar);
    }

    public void q() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.l();
        }
        this.f17812j.a((d6) null);
        this.f17812j.a();
    }

    public void r() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.T();
        }
        this.f17818p = null;
        this.f17817o = null;
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f17816n.refresh(obVar);
    }

    public void s() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.f();
        }
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f17816n.store(ibVar);
    }

    public void t() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.q();
        }
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f17816n.track(qbVar);
    }

    public void u() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.C();
        }
    }

    public void v() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.b(g7.LOADED);
            if (e2Var.P()) {
                e2Var.a(e2Var.o());
            } else {
                this.f17811i.a((i0) this);
            }
        } else {
            Log.e(l0.f18083a, "Cannot display missing impression onImpressionReadyToBeDisplayed");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.z();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String w() {
        /*
            r1 = this;
            com.chartboost.sdk.impl.e2 r0 = r1.f17818p
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.z()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.h0.w():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.y();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String x() {
        /*
            r1 = this;
            com.chartboost.sdk.impl.e2 r0 = r1.f17818p
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.y()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.h0.x():java.lang.String");
    }

    public void y() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.g();
        }
    }

    public void z() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.J();
        }
    }

    private final void c(b1 b1Var, CBError.CBImpressionError cBImpressionError) {
        j0 j0Var = this.f17817o;
        if (j0Var != null) {
            j0Var.a(c(b1Var), cBImpressionError);
            return;
        }
        String a2 = l0.f18083a;
        Log.d(a2, "Missing AdUnitRendererAdCallback while sending onShowFailure with error: " + cBImpressionError);
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m26clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f17816n.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m27persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f17816n.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m28refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f17816n.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m29store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f17816n.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m30track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f17816n.track(qbVar);
    }

    public final void a(b1 b1Var, j0 j0Var) {
        Intrinsics.f(b1Var, "appRequest");
        Intrinsics.f(j0Var, "callback");
        this.f17817o = j0Var;
        if (!this.f17804b.e()) {
            c(b1Var, CBError.CBImpressionError.INTERNET_UNAVAILABLE_AT_SHOW);
            return;
        }
        v a2 = b1Var.a();
        if (a2 == null) {
            d(b1Var, CBError.CBImpressionError.NO_AD_FOUND);
        } else if (!this.f17805c.a(a2).booleanValue()) {
            d(b1Var, CBError.CBImpressionError.ASSET_MISSING);
        } else {
            h(b1Var);
            g(b1Var);
        }
    }

    public void e() {
        String a2 = l0.f18083a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "DISMISS_MISSING event was successfully removed upon dismiss callback");
        clearFromStorage((qb) new x4(tb.h.DISMISS_MISSING, "", "", "", (Mediation) null, 16, (DefaultConstructorMarker) null));
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.e();
        }
    }

    public void b(b1 b1Var) {
        Intrinsics.f(b1Var, "appRequest");
        e(b1Var);
        this.f17809g.g();
    }

    private final String c(b1 b1Var) {
        v a2;
        if (b1Var == null || (a2 = b1Var.a()) == null) {
            return null;
        }
        return a2.m();
    }

    public void b(String str) {
        Intrinsics.f(str, "impressionId");
        a((tb) tb.b.SUCCESS, "");
        j0 j0Var = this.f17817o;
        if (j0Var != null) {
            j0Var.b(str);
        }
    }

    public void c() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.S();
        }
    }

    public final void g(String str) {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.a(true);
        }
        j0 j0Var = this.f17817o;
        if (j0Var != null) {
            j0Var.c(str);
        }
        this.f17809g.i();
    }

    public void c(boolean z2) {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.b(z2);
        }
    }

    public void b(boolean z2) {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.f(z2);
        }
    }

    public void c(x2 x2Var) {
        Intrinsics.f(x2Var, ImagesContract.URL);
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.b(x2Var);
        }
    }

    public void e(String str) {
        Intrinsics.f(str, "msg");
        String a2 = l0.f18083a;
        Intrinsics.e(a2, "TAG");
        w7.e(a2, "WebView warning occurred closing the webview " + str);
    }

    public void h() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.d();
        }
    }

    public void b(float f2) {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.a(f2);
        }
    }

    public void g() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.K();
        }
    }

    public void b(x2 x2Var) {
        Intrinsics.f(x2Var, ImagesContract.URL);
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.a(x2Var.a());
        }
    }

    public static final void a(h0 h0Var, b1 b1Var, String str) {
        Intrinsics.f(h0Var, "this$0");
        Intrinsics.f(b1Var, "$appRequest");
        Intrinsics.f(str, "it");
        h0Var.f(b1Var);
    }

    public void b() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.R();
        }
    }

    public final void a(b1 b1Var, e2 e2Var, CBError.CBImpressionError cBImpressionError) {
        if (cBImpressionError != null) {
            d(b1Var, cBImpressionError);
            e(b1Var);
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.b(this.f17815m, (CoroutineContext) null, (CoroutineStart) null, new a(e2Var, this, b1Var, (Continuation) null), 3, (Object) null);
    }

    public final void d(b1 b1Var) {
        m0 m0Var = this.f17808f;
        String d2 = this.f17803a.d();
        v a2 = b1Var.a();
        m0Var.a(d2, new xa(a2 != null ? a2.a() : null, b1Var.d(), G(), this.f17803a.b(), this.f17814l));
    }

    public void a(CBImpressionActivity cBImpressionActivity) {
        Unit unit;
        Intrinsics.f(cBImpressionActivity, "activity");
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.a(e2Var.t(), cBImpressionActivity);
            kd B = e2Var.B();
            if (B != null) {
                this.f17811i.a(B);
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        Log.e(l0.f18083a, "Cannot display missing impression onActivityIsReadyToDisplay");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(u uVar, r2 r2Var, v5 v5Var, dd ddVar, n6 n6Var, m0 m0Var, n8 n8Var, k7 k7Var, x9 x9Var, c8 c8Var, eb ebVar, Mediation mediation, CoroutineScope coroutineScope, a5 a5Var, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(uVar, r2Var, v5Var, ddVar, n6Var, m0Var, n8Var, k7Var, x9Var, c8Var, ebVar, mediation, (i2 & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 0 ? CoroutineScopeKt.a(Dispatchers.c()) : coroutineScope, a5Var);
    }

    public final void f(String str) {
        if (!Intrinsics.a(this.f17803a, u.a.f18735g)) {
            persist((qb) new x4(tb.h.DISMISS_MISSING, "dismiss_missing due to ad not finished", this.f17803a.b(), str, this.f17814l));
        }
    }

    public void a(CBError.CBImpressionError cBImpressionError) {
        Intrinsics.f(cBImpressionError, MRAIDPresenter.ERROR);
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.a(cBImpressionError);
        }
    }

    public boolean d() {
        e2 e2Var;
        e2 e2Var2 = this.f17818p;
        if (e2Var2 == null || !e2Var2.F() || ((e2Var = this.f17818p) != null && e2Var.p())) {
            this.f17811i.a();
        }
        return true;
    }

    public void a(String str, String str2, CBError.CBClickError cBClickError) {
        Intrinsics.f(str, "impressionId");
        Intrinsics.f(cBClickError, MRAIDPresenter.ERROR);
        a((tb) tb.b.FAILURE, cBClickError.name());
        j0 j0Var = this.f17817o;
        if (j0Var != null) {
            j0Var.a(str, str2, cBClickError);
        }
    }

    public void d(String str) {
        Intrinsics.f(str, "event");
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.a(str);
        }
    }

    public void f() {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.H();
        }
    }

    public final void a(tb tbVar, String str) {
        String str2;
        String b2 = this.f17803a.b();
        e2 e2Var = this.f17818p;
        if (e2Var == null || (str2 = e2Var.u()) == null) {
            str2 = "No location";
        }
        track((qb) new m7(tbVar, str, b2, str2, this.f17814l, (ib) null, 32, (DefaultConstructorMarker) null));
    }

    public void d(x2 x2Var) {
        Intrinsics.f(x2Var, ImagesContract.URL);
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.c(x2Var);
        }
    }

    public void a(String str, int i2) {
        j0 j0Var = this.f17817o;
        if (j0Var != null) {
            j0Var.a(str, i2);
        }
    }

    public void a(String str) {
        j0 j0Var = this.f17817o;
        if (j0Var != null) {
            j0Var.a(str);
        }
        this.f17809g.g();
    }

    public void a(b1 b1Var) {
        Intrinsics.f(b1Var, "appRequest");
        c(true);
        String c2 = c(b1Var);
        j0 j0Var = this.f17817o;
        if (j0Var != null) {
            j0Var.e(c2);
        }
        f(b1Var.d());
        if (H()) {
            g(c2);
        }
        d(b1Var);
        e(b1Var);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            com.chartboost.sdk.impl.e2 r0 = r6.f17818p
            java.lang.String r1 = "TAG"
            if (r0 == 0) goto L_0x0053
            com.chartboost.sdk.impl.n8 r2 = r6.f17809g
            boolean r2 = r2.h()
            if (r2 != 0) goto L_0x0024
            r7 = 1
            r0.d(r7)
            java.lang.String r7 = com.chartboost.sdk.impl.l0.f18083a
            kotlin.jvm.internal.Intrinsics.e(r7, r1)
            java.lang.String r0 = "Cannot create visibility tracker due to the OM SDK being disabled!"
            com.chartboost.sdk.impl.w7.a(r7, r0)
            return
        L_0x0024:
            boolean r2 = r0.G()
            if (r2 == 0) goto L_0x0037
            java.lang.String r7 = com.chartboost.sdk.impl.l0.f18083a
            kotlin.jvm.internal.Intrinsics.e(r7, r1)
            java.lang.String r0 = "Cannot create VisibilityTracker due to missing view!"
            com.chartboost.sdk.impl.w7.e(r7, r0)
            return
        L_0x0037:
            com.chartboost.sdk.impl.kd r2 = r0.B()
            if (r2 == 0) goto L_0x0053
            com.chartboost.sdk.impl.n8 r3 = r6.f17809g
            android.view.View r4 = r2.getRootView()
            java.lang.String r5 = "view.rootView"
            kotlin.jvm.internal.Intrinsics.e(r4, r5)
            b0.u r5 = new b0.u
            r5.<init>(r6, r0)
            r3.a(r7, r2, r4, r5)
            kotlin.Unit r7 = kotlin.Unit.f40298a
            goto L_0x0054
        L_0x0053:
            r7 = 0
        L_0x0054:
            if (r7 != 0) goto L_0x0062
            java.lang.String r7 = com.chartboost.sdk.impl.l0.f18083a
            kotlin.jvm.internal.Intrinsics.e(r7, r1)
            java.lang.String r0 = "Missing impression onImpressionViewCreated"
            com.chartboost.sdk.impl.w7.b(r7, r0)
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.h0.a(android.content.Context):void");
    }

    public static final void a(h0 h0Var, e2 e2Var) {
        Intrinsics.f(h0Var, "this$0");
        Intrinsics.f(e2Var, "$it");
        h0Var.a(e2Var);
    }

    public final void a(e2 e2Var) {
        String a2 = l0.f18083a;
        Intrinsics.e(a2, "TAG");
        w7.c(a2, "Visibility check success!");
        e2Var.d(true);
        if (e2Var.m() && !e2Var.i()) {
            g(e2Var.r());
        }
    }

    public void a(b1 b1Var, CBError.CBImpressionError cBImpressionError) {
        Intrinsics.f(b1Var, "appRequest");
        Intrinsics.f(cBImpressionError, MRAIDPresenter.ERROR);
        b(b1Var, cBImpressionError);
        track((qb) new d4(tb.h.UNEXPECTED_DISMISS_ERROR, "", this.f17803a.b(), b1Var.d(), this.f17814l, (ib) null, 32, (DefaultConstructorMarker) null));
        this.f17811i.a();
    }

    public void a(boolean z2) {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.e(z2);
        }
    }

    public void a(String str, CBError.CBClickError cBClickError) {
        Unit unit;
        Intrinsics.f(cBClickError, MRAIDPresenter.ERROR);
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.a(str, cBClickError);
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            String a2 = l0.f18083a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Missing impression on impression click failure callback ");
        }
    }

    public void a() {
        Unit unit;
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.I();
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            String a2 = l0.f18083a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Missing impression on impression click success callback ");
        }
    }

    public void a(g7 g7Var) {
        Intrinsics.f(g7Var, AdOperationMetric.INIT_STATE);
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.b(g7Var);
        }
    }

    public void a(oc ocVar) {
        Intrinsics.f(ocVar, "vastVideoEvent");
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.a(ocVar);
        }
    }

    public void a(g9 g9Var) {
        Intrinsics.f(g9Var, "playerState");
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.a(g9Var);
        }
    }

    public void a(float f2) {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.b(f2);
        }
    }

    public void a(float f2, float f3) {
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.a(f2, f3);
        }
    }

    public void a(x2 x2Var) {
        Intrinsics.f(x2Var, ImagesContract.URL);
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.a(x2Var);
        }
    }

    public void a(boolean z2, String str) {
        Intrinsics.f(str, "forceOrientation");
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.a(z2, str);
        }
    }

    public void a(List list) {
        Intrinsics.f(list, "verificationScriptResourceList");
        e2 e2Var = this.f17818p;
        if (e2Var != null) {
            e2Var.a(list);
        }
    }
}
