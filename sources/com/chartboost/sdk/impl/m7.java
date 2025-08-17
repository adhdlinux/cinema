package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.ib;
import com.chartboost.sdk.impl.tb;
import com.facebook.imageutils.JfifUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class m7 extends qb {

    /* renamed from: m  reason: collision with root package name */
    public static final a f18191m = new a((DefaultConstructorMarker) null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m7(tb tbVar, String str, String str2, String str3, Mediation mediation, ib ibVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(tbVar, str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? null : mediation, (i2 & 32) != 0 ? new ib((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ib.a) null, JfifUtil.MARKER_FIRST_BYTE, (DefaultConstructorMarker) null) : ibVar);
    }

    public final boolean n() {
        tb f2 = f();
        if (f2 == tb.a.FINISH_SUCCESS || f2 == tb.a.FINISH_FAILURE || f2 == tb.h.FINISH_SUCCESS || f2 == tb.h.FINISH_FAILURE) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public m7(com.chartboost.sdk.impl.tb r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, com.chartboost.sdk.Mediation r22, com.chartboost.sdk.impl.ib r23) {
        /*
            r17 = this;
            r15 = r17
            java.lang.String r0 = "name"
            r1 = r18
            kotlin.jvm.internal.Intrinsics.f(r1, r0)
            java.lang.String r0 = "message"
            r2 = r19
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "adType"
            r3 = r20
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "location"
            r4 = r21
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = "trackAd"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            com.chartboost.sdk.impl.qb$b r6 = com.chartboost.sdk.impl.qb.b.INFO
            com.chartboost.sdk.impl.qb$a r13 = com.chartboost.sdk.impl.qb.a.LOW
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r14 = 1920(0x780, float:2.69E-42)
            r16 = 0
            r0 = r17
            r5 = r22
            r15 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15)
            boolean r0 = r17.n()
            if (r0 == 0) goto L_0x004d
            com.chartboost.sdk.impl.qb$a r0 = com.chartboost.sdk.impl.qb.a.HIGH
            r1 = r17
            r1.a((com.chartboost.sdk.impl.qb.a) r0)
            r0 = 1
            r1.a((boolean) r0)
            goto L_0x004f
        L_0x004d:
            r1 = r17
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.m7.<init>(com.chartboost.sdk.impl.tb, java.lang.String, java.lang.String, java.lang.String, com.chartboost.sdk.Mediation, com.chartboost.sdk.impl.ib):void");
    }
}
