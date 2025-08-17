package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.tb;
import com.google.ar.core.ImageMetadata;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class cd extends y2 implements t0 {

    /* renamed from: j0  reason: collision with root package name */
    public static final b f17380j0 = new b((DefaultConstructorMarker) null);
    public final v5 T;
    public final dd U;
    public final String V;
    public final Mediation W;
    public final Function5 X;
    public final String Y;
    public final d7 Z;

    /* renamed from: a0  reason: collision with root package name */
    public final c8 f17381a0;

    /* renamed from: b0  reason: collision with root package name */
    public final a5 f17382b0;

    /* renamed from: c0  reason: collision with root package name */
    public final Function1 f17383c0;

    /* renamed from: d0  reason: collision with root package name */
    public long f17384d0;

    /* renamed from: e0  reason: collision with root package name */
    public long f17385e0;

    /* renamed from: f0  reason: collision with root package name */
    public long f17386f0;

    /* renamed from: g0  reason: collision with root package name */
    public int f17387g0;

    /* renamed from: h0  reason: collision with root package name */
    public sc f17388h0;

    /* renamed from: i0  reason: collision with root package name */
    public s0 f17389i0;

    public static final class a extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f17390b = new a();

        public a() {
            super(1);
        }

        /* renamed from: a */
        public final z2 invoke(Context context) {
            Intrinsics.f(context, "it");
            return new z2(context);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public b() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ cd(Context context, String str, y7 y7Var, String str2, bc bcVar, v5 v5Var, w2 w2Var, dd ddVar, String str3, Mediation mediation, Function5 function5, q2 q2Var, String str4, p8 p8Var, k0 k0Var, d7 d7Var, od odVar, c8 c8Var, a5 a5Var, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, y7Var, str2, bcVar, v5Var, w2Var, ddVar, str3, mediation, function5, q2Var, str4, p8Var, k0Var, d7Var, odVar, c8Var, a5Var, (i2 & ImageMetadata.LENS_APERTURE) != 0 ? a.f17390b : function1);
    }

    public void D() {
        int i2;
        sc scVar = this.f17388h0;
        int i3 = 0;
        if (scVar != null) {
            i2 = scVar.getWidth();
        } else {
            i2 = 0;
        }
        sc scVar2 = this.f17388h0;
        if (scVar2 != null) {
            i3 = scVar2.getHeight();
        }
        s0 s0Var = this.f17389i0;
        if (!(s0Var instanceof ma)) {
            s0Var = null;
        }
        if (s0Var != null) {
            s0Var.a(i2, i3);
        }
    }

    public void F() {
        w7.c("VideoProtocol", "onPause()");
        s0 s0Var = this.f17389i0;
        if (s0Var != null) {
            s0Var.pause();
        }
        super.F();
    }

    public void G() {
        w7.c("VideoProtocol", "onResume()");
        o1 o1Var = null;
        this.U.a((String) null, 1, false);
        s0 s0Var = this.f17389i0;
        if (s0Var != null) {
            if (s0Var instanceof o1) {
                o1Var = (o1) s0Var;
            }
            if (o1Var != null) {
                o1Var.a();
            }
            s0Var.play();
        }
        super.G();
    }

    public final void L() {
        M();
    }

    public final void M() {
        s0 s0Var = this.f17389i0;
        if (s0Var != null) {
            s0Var.stop();
        }
        sc scVar = this.f17388h0;
        if (scVar != null) {
            scVar.b();
        }
        this.f17389i0 = null;
        this.f17388h0 = null;
    }

    public final int N() {
        w7.a("VideoProtocol", "getAssetDownloadStateNow()");
        rc b2 = this.U.b(this.V);
        if (b2 != null) {
            return this.U.a(b2);
        }
        return 0;
    }

    public final z2 O() {
        sc scVar = this.f17388h0;
        if (scVar != null) {
            return scVar.getWebView();
        }
        return null;
    }

    public final void P() {
        s0 s0Var = this.f17389i0;
        if (s0Var != null) {
            s0Var.f();
        }
        s().a(0.0f);
    }

    public final void Q() {
        w2 v2 = v();
        if (v2 != null) {
            v2.c(O(), o(), h());
        }
    }

    public final void R() {
        w7.a("VideoProtocol", "notifyTemplateVideoStarted() duration: " + this.f17384d0);
        w2 v2 = v();
        if (v2 != null) {
            v2.b(O(), ((float) this.f17384d0) / 1000.0f, o(), h());
        }
    }

    public final void S() {
        w7.a("VideoProtocol", "pauseVideo()");
        s().c();
        s0 s0Var = this.f17389i0;
        if (s0Var != null) {
            s0Var.pause();
        }
    }

    public final void T() {
        w7.a("VideoProtocol", "playVideo()");
        U();
        this.f17385e0 = ab.a();
        s0 s0Var = this.f17389i0;
        if (s0Var != null) {
            s0Var.play();
        }
    }

    public final void U() {
        float f2;
        s().a(f9.FULLSCREEN);
        s0 s0Var = this.f17389i0;
        if (s0Var == null || s0Var.h()) {
            s().b();
            return;
        }
        p8 s2 = s();
        float f3 = ((float) this.f17384d0) / 1000.0f;
        s0 s0Var2 = this.f17389i0;
        if (s0Var2 != null) {
            f2 = s0Var2.g();
        } else {
            f2 = 1.0f;
        }
        s2.a(f3, f2);
    }

    public final void V() {
        s0 s0Var = this.f17389i0;
        if (s0Var != null) {
            s0Var.b();
        }
        s().a(1.0f);
    }

    public kd a(Context context, Activity activity) {
        sc scVar;
        Context context2 = context;
        Intrinsics.f(context2, "context");
        this.f17381a0.a(this.Z);
        w7.a("VideoProtocol", "createViewObject()");
        Unit unit = null;
        try {
            SurfaceView surfaceView = new SurfaceView(context2);
            try {
                scVar = new sc(context, this.Y, k(), this.f17381a0, this.f19047p, surfaceView, (FrameLayout) null, this.f17382b0, this.f17383c0, 64, (DefaultConstructorMarker) null);
                scVar.setActivity(activity);
            } catch (Exception e2) {
                c("Can't instantiate VideoBase: " + e2);
                scVar = null;
            }
            this.f17388h0 = scVar;
            String str = "VideoProtocol";
            s0 s0Var = (s0) this.X.invoke(context, surfaceView, this, w(), this.T);
            rc b2 = this.U.b(this.V);
            if (b2 != null) {
                s0Var.a(b2);
                unit = Unit.f40298a;
            }
            if (unit == null) {
                w7.b(str, "Video asset not found in the repository");
            }
            this.f17389i0 = s0Var;
            return this.f17388h0;
        } catch (Exception e3) {
            c("Can't instantiate SurfaceView: " + e3);
            return null;
        }
    }

    public void b() {
        w7.a("VideoProtocol", "onVideoDisplayStarted");
        R();
        this.f17386f0 = ab.a();
    }

    public void c() {
        s().a(false);
    }

    public void d() {
        w7.a("VideoProtocol", "onVideoDisplayCompleted");
        a(true);
        Q();
        s().a();
    }

    public final void e(String str) {
        long j2;
        long j3;
        x4 x4Var = new x4(tb.i.FINISH_FAILURE, str, h(), o(), this.W);
        if (this.f17386f0 == 0) {
            j3 = this.f17385e0;
            j2 = ab.a();
        } else {
            j3 = ab.a();
            j2 = this.f17386f0;
        }
        x4Var.a((float) (j3 - j2));
        x4Var.a(true);
        x4Var.b(false);
        track((qb) x4Var);
    }

    public final void f(String str) {
        m7 m7Var = new m7(tb.i.FINISH_SUCCESS, str, h(), o(), this.W, (ib) null, 32, (DefaultConstructorMarker) null);
        m7Var.a((float) (this.f17386f0 - this.f17385e0));
        m7Var.a(true);
        m7Var.b(false);
        track((qb) m7Var);
    }

    public void g() {
        w7.a("VideoProtocol", "destroyView()");
        M();
        super.g();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public cd(android.content.Context r17, java.lang.String r18, com.chartboost.sdk.impl.y7 r19, java.lang.String r20, com.chartboost.sdk.impl.bc r21, com.chartboost.sdk.impl.v5 r22, com.chartboost.sdk.impl.w2 r23, com.chartboost.sdk.impl.dd r24, java.lang.String r25, com.chartboost.sdk.Mediation r26, kotlin.jvm.functions.Function5 r27, com.chartboost.sdk.impl.q2 r28, java.lang.String r29, com.chartboost.sdk.impl.p8 r30, com.chartboost.sdk.impl.k0 r31, com.chartboost.sdk.impl.d7 r32, com.chartboost.sdk.impl.od r33, com.chartboost.sdk.impl.c8 r34, com.chartboost.sdk.impl.a5 r35, kotlin.jvm.functions.Function1 r36) {
        /*
            r16 = this;
            r15 = r16
            r14 = r22
            r13 = r24
            r12 = r25
            r11 = r27
            r10 = r29
            r9 = r32
            r8 = r34
            r7 = r35
            r6 = r36
            java.lang.String r0 = "context"
            r1 = r17
            kotlin.jvm.internal.Intrinsics.f(r1, r0)
            java.lang.String r0 = "location"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "mtype"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "adUnitParameters"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = "uiPoster"
            r5 = r21
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            java.lang.String r0 = "fileCache"
            kotlin.jvm.internal.Intrinsics.f(r14, r0)
            java.lang.String r0 = "templateProxy"
            r14 = r23
            kotlin.jvm.internal.Intrinsics.f(r14, r0)
            java.lang.String r0 = "videoRepository"
            kotlin.jvm.internal.Intrinsics.f(r13, r0)
            java.lang.String r0 = "videoFilename"
            kotlin.jvm.internal.Intrinsics.f(r12, r0)
            java.lang.String r0 = "adsVideoPlayerFactory"
            kotlin.jvm.internal.Intrinsics.f(r11, r0)
            java.lang.String r0 = "networkService"
            r11 = r28
            kotlin.jvm.internal.Intrinsics.f(r11, r0)
            java.lang.String r0 = "templateHtml"
            kotlin.jvm.internal.Intrinsics.f(r10, r0)
            java.lang.String r0 = "openMeasurementImpressionCallback"
            r11 = r30
            kotlin.jvm.internal.Intrinsics.f(r11, r0)
            java.lang.String r0 = "adUnitRendererImpressionCallback"
            r12 = r31
            kotlin.jvm.internal.Intrinsics.f(r12, r0)
            java.lang.String r0 = "impressionInterface"
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            java.lang.String r0 = "webViewTimeoutInterface"
            r14 = r33
            kotlin.jvm.internal.Intrinsics.f(r14, r0)
            java.lang.String r0 = "nativeBridgeCommand"
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.lang.String r0 = "eventTracker"
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            java.lang.String r0 = "cbWebViewFactory"
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            r0 = r16
            r6 = r22
            r7 = r28
            r8 = r23
            r9 = r26
            r13 = r32
            r15 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r1 = r22
            r0.T = r1
            r1 = r24
            r0.U = r1
            r1 = r25
            r0.V = r1
            r1 = r26
            r0.W = r1
            r1 = r27
            r0.X = r1
            r1 = r29
            r0.Y = r1
            r1 = r32
            r0.Z = r1
            r1 = r34
            r0.f17381a0 = r1
            r1 = r35
            r0.f17382b0 = r1
            r1 = r36
            r0.f17383c0 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.cd.<init>(android.content.Context, java.lang.String, com.chartboost.sdk.impl.y7, java.lang.String, com.chartboost.sdk.impl.bc, com.chartboost.sdk.impl.v5, com.chartboost.sdk.impl.w2, com.chartboost.sdk.impl.dd, java.lang.String, com.chartboost.sdk.Mediation, kotlin.jvm.functions.Function5, com.chartboost.sdk.impl.q2, java.lang.String, com.chartboost.sdk.impl.p8, com.chartboost.sdk.impl.k0, com.chartboost.sdk.impl.d7, com.chartboost.sdk.impl.od, com.chartboost.sdk.impl.c8, com.chartboost.sdk.impl.a5, kotlin.jvm.functions.Function1):void");
    }

    public void b(long j2) {
        w7.a("VideoProtocol", "onVideoDisplayPrepared ready to receive signal from template, duration: " + j2);
        this.f17387g0 = N();
        this.f17384d0 = j2;
        E();
    }

    public void a(long j2) {
        float f2 = ((float) j2) / 1000.0f;
        float f3 = ((float) this.f17384d0) / 1000.0f;
        if (la.f18112a.g()) {
            w7.c("VideoProtocol", "onVideoDisplayProgress: " + f2 + '/' + f3);
        }
        w2 v2 = v();
        if (v2 != null) {
            v2.a(O(), f2, o(), h());
        }
        a(f3, f2);
    }

    public void a(String str) {
        Intrinsics.f(str, MRAIDPresenter.ERROR);
        w7.a("VideoProtocol", "onVideoDisplayError: " + str);
        a(false);
        w2 v2 = v();
        if (v2 != null) {
            v2.d(O(), o(), h());
        }
        M();
        c(str);
    }

    public void a() {
        s().a(true);
    }

    public final void a(boolean z2) {
        String valueOf = String.valueOf(this.f17387g0);
        if (z2) {
            f(valueOf);
        } else {
            e(valueOf);
        }
    }
}
