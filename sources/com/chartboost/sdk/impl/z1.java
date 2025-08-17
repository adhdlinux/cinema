package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.webkit.ValueCallback;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Mediation;
import com.google.ar.core.ImageMetadata;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

public final class z1 extends y2 {
    public final String T;
    public final String U;
    public final n7 V;
    public final d7 W;
    public final List X;
    public final a5 Y;
    public final CoroutineDispatcher Z;

    /* renamed from: a0  reason: collision with root package name */
    public final Function1 f19106a0;

    public static final class a extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f19107b = new a();

        public a() {
            super(1);
        }

        /* renamed from: a */
        public final x1 invoke(Context context) {
            Intrinsics.f(context, "it");
            return new x1(context);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z1(Context context, String str, y7 y7Var, String str2, v5 v5Var, q2 q2Var, bc bcVar, w2 w2Var, Mediation mediation, String str3, String str4, n7 n7Var, p8 p8Var, k0 k0Var, d7 d7Var, od odVar, List list, a5 a5Var, CoroutineDispatcher coroutineDispatcher, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, y7Var, str2, v5Var, q2Var, bcVar, w2Var, mediation, str3, str4, n7Var, p8Var, k0Var, d7Var, odVar, list, a5Var, (i2 & 262144) != 0 ? Dispatchers.c() : coroutineDispatcher, (i2 & ImageMetadata.LENS_APERTURE) != 0 ? a.f19107b : function1);
    }

    public void D() {
    }

    public void E() {
        z2 webView;
        super.E();
        this.W.g();
        kd z2 = z();
        if (z2 != null && (webView = z2.getWebView()) != null) {
            for (String evaluateJavascript : this.X) {
                webView.evaluateJavascript(evaluateJavascript, (ValueCallback) null);
            }
        }
    }

    public kd a(Context context, Activity activity) {
        Unit unit;
        Intrinsics.f(context, "context");
        String str = this.U;
        if (str == null || StringsKt__StringsJVMKt.v(str)) {
            String a2 = a2.f17195a;
            Intrinsics.e(a2, "TAG");
            w7.e(a2, "html must not be null or blank");
            return null;
        }
        try {
            e6 e6Var = new e6(context, this.T, this.U, this.V, this.Y, k(), this.W, this.Z, this.f19106a0, (d2) null, 512, (DefaultConstructorMarker) null);
            RelativeLayout webViewContainer = e6Var.getWebViewContainer();
            if (webViewContainer != null) {
                e6Var.a(webViewContainer);
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                String a3 = a2.f17195a;
                Intrinsics.e(a3, "TAG");
                w7.b(a3, "webViewContainer null when creating HtmlWebViewBase");
            }
            e6Var.setActivity(activity);
            return e6Var;
        } catch (Exception e2) {
            c("Can't instantiate WebViewBase: " + e2);
            return null;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public z1(android.content.Context r17, java.lang.String r18, com.chartboost.sdk.impl.y7 r19, java.lang.String r20, com.chartboost.sdk.impl.v5 r21, com.chartboost.sdk.impl.q2 r22, com.chartboost.sdk.impl.bc r23, com.chartboost.sdk.impl.w2 r24, com.chartboost.sdk.Mediation r25, java.lang.String r26, java.lang.String r27, com.chartboost.sdk.impl.n7 r28, com.chartboost.sdk.impl.p8 r29, com.chartboost.sdk.impl.k0 r30, com.chartboost.sdk.impl.d7 r31, com.chartboost.sdk.impl.od r32, java.util.List r33, com.chartboost.sdk.impl.a5 r34, kotlinx.coroutines.CoroutineDispatcher r35, kotlin.jvm.functions.Function1 r36) {
        /*
            r16 = this;
            r15 = r16
            r14 = r26
            r13 = r28
            r12 = r31
            r11 = r33
            r10 = r34
            r9 = r35
            r8 = r36
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
            java.lang.String r0 = "fileCache"
            r6 = r21
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            java.lang.String r0 = "uiPoster"
            r5 = r23
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            java.lang.String r0 = "baseUrl"
            kotlin.jvm.internal.Intrinsics.f(r14, r0)
            java.lang.String r0 = "infoIcon"
            kotlin.jvm.internal.Intrinsics.f(r13, r0)
            java.lang.String r0 = "openMeasurementImpressionCallback"
            r7 = r29
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            java.lang.String r0 = "adUnitRendererCallback"
            r13 = r30
            kotlin.jvm.internal.Intrinsics.f(r13, r0)
            java.lang.String r0 = "impressionInterface"
            kotlin.jvm.internal.Intrinsics.f(r12, r0)
            java.lang.String r0 = "webViewTimeoutInterface"
            r14 = r32
            kotlin.jvm.internal.Intrinsics.f(r14, r0)
            java.lang.String r0 = "scripts"
            kotlin.jvm.internal.Intrinsics.f(r11, r0)
            java.lang.String r0 = "eventTracker"
            kotlin.jvm.internal.Intrinsics.f(r10, r0)
            java.lang.String r0 = "dispatcher"
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            java.lang.String r0 = "cbWebViewFactory"
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            r0 = r16
            r7 = r22
            r8 = r24
            r9 = r25
            r10 = r27
            r11 = r29
            r12 = r30
            r13 = r31
            r15 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r1 = r26
            r0.T = r1
            r1 = r27
            r0.U = r1
            r1 = r28
            r0.V = r1
            r1 = r31
            r0.W = r1
            r1 = r33
            r0.X = r1
            r1 = r34
            r0.Y = r1
            r1 = r35
            r0.Z = r1
            r1 = r36
            r0.f19106a0 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.z1.<init>(android.content.Context, java.lang.String, com.chartboost.sdk.impl.y7, java.lang.String, com.chartboost.sdk.impl.v5, com.chartboost.sdk.impl.q2, com.chartboost.sdk.impl.bc, com.chartboost.sdk.impl.w2, com.chartboost.sdk.Mediation, java.lang.String, java.lang.String, com.chartboost.sdk.impl.n7, com.chartboost.sdk.impl.p8, com.chartboost.sdk.impl.k0, com.chartboost.sdk.impl.d7, com.chartboost.sdk.impl.od, java.util.List, com.chartboost.sdk.impl.a5, kotlinx.coroutines.CoroutineDispatcher, kotlin.jvm.functions.Function1):void");
    }
}
