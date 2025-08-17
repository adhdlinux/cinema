package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class j2 extends y2 {
    public final String T;
    public final d7 U;
    public final c8 V;
    public final a5 W;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public j2(android.content.Context r17, java.lang.String r18, com.chartboost.sdk.impl.y7 r19, java.lang.String r20, com.chartboost.sdk.impl.v5 r21, com.chartboost.sdk.impl.q2 r22, com.chartboost.sdk.impl.bc r23, com.chartboost.sdk.impl.w2 r24, com.chartboost.sdk.Mediation r25, java.lang.String r26, com.chartboost.sdk.impl.p8 r27, com.chartboost.sdk.impl.k0 r28, com.chartboost.sdk.impl.d7 r29, com.chartboost.sdk.impl.od r30, com.chartboost.sdk.impl.c8 r31, com.chartboost.sdk.impl.a5 r32) {
        /*
            r16 = this;
            r15 = r16
            r14 = r29
            r13 = r31
            r12 = r32
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
            java.lang.String r0 = "openMeasurementImpressionCallback"
            r11 = r27
            kotlin.jvm.internal.Intrinsics.f(r11, r0)
            java.lang.String r0 = "adUnitRendererCallback"
            r10 = r28
            kotlin.jvm.internal.Intrinsics.f(r10, r0)
            java.lang.String r0 = "impressionInterface"
            kotlin.jvm.internal.Intrinsics.f(r14, r0)
            java.lang.String r0 = "webViewTimeoutInterface"
            r9 = r30
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            java.lang.String r0 = "nativeBridgeCommand"
            kotlin.jvm.internal.Intrinsics.f(r13, r0)
            java.lang.String r0 = "eventTracker"
            kotlin.jvm.internal.Intrinsics.f(r12, r0)
            r0 = r16
            r7 = r22
            r8 = r24
            r9 = r25
            r10 = r26
            r12 = r28
            r13 = r29
            r14 = r30
            r15 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r1 = r26
            r0.T = r1
            r1 = r29
            r0.U = r1
            r1 = r31
            r0.V = r1
            r1 = r32
            r0.W = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.j2.<init>(android.content.Context, java.lang.String, com.chartboost.sdk.impl.y7, java.lang.String, com.chartboost.sdk.impl.v5, com.chartboost.sdk.impl.q2, com.chartboost.sdk.impl.bc, com.chartboost.sdk.impl.w2, com.chartboost.sdk.Mediation, java.lang.String, com.chartboost.sdk.impl.p8, com.chartboost.sdk.impl.k0, com.chartboost.sdk.impl.d7, com.chartboost.sdk.impl.od, com.chartboost.sdk.impl.c8, com.chartboost.sdk.impl.a5):void");
    }

    public void D() {
    }

    public kd a(Context context, Activity activity) {
        Intrinsics.f(context, "context");
        this.V.a(this.U);
        String str = this.T;
        if (str == null || StringsKt__StringsJVMKt.v(str)) {
            String a2 = k2.f18012a;
            Intrinsics.e(a2, "TAG");
            w7.e(a2, "templateHtml must not be null or blank");
            return null;
        }
        try {
            b8 b8Var = new b8(context, this.T, k(), this.f19047p, this.V, this.W, (Function1) null, 64, (DefaultConstructorMarker) null);
            b8Var.setActivity(activity);
            return b8Var;
        } catch (Exception e2) {
            c("Can't instantiate MraidWebViewBase: " + e2);
            return null;
        }
    }

    public void track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        super.track(qbVar);
    }
}
