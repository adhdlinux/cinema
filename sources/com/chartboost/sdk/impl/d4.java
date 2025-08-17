package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.ib;
import com.facebook.imageutils.JfifUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class d4 extends qb {

    /* renamed from: m  reason: collision with root package name */
    public static final a f17420m = new a((DefaultConstructorMarker) null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d4 a(tb tbVar, String str, String str2, String str3) {
            Intrinsics.f(tbVar, "name");
            Intrinsics.f(str, "message");
            Intrinsics.f(str2, "adType");
            Intrinsics.f(str3, "location");
            return new d4(tbVar, str, str2, str3, (Mediation) null, (ib) null, 48, (DefaultConstructorMarker) null);
        }

        public a() {
        }

        public final d4 a(tb tbVar, String str) {
            Intrinsics.f(tbVar, "name");
            Intrinsics.f(str, "message");
            return new d4(tbVar, str, (String) null, (String) null, (Mediation) null, (ib) null, 60, (DefaultConstructorMarker) null);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d4(tb tbVar, String str, String str2, String str3, Mediation mediation, ib ibVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(tbVar, str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? null : mediation, (i2 & 32) != 0 ? new ib((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ib.a) null, JfifUtil.MARKER_FIRST_BYTE, (DefaultConstructorMarker) null) : ibVar);
    }

    public static final d4 a(tb tbVar, String str) {
        return f17420m.a(tbVar, str);
    }

    public static final d4 a(tb tbVar, String str, String str2, String str3) {
        return f17420m.a(tbVar, str, str2, str3);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d4(com.chartboost.sdk.impl.tb r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, com.chartboost.sdk.Mediation r22, com.chartboost.sdk.impl.ib r23) {
        /*
            r17 = this;
            java.lang.String r0 = "name"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "message"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "adType"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = "location"
            r5 = r21
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            java.lang.String r0 = "trackAd"
            r8 = r23
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            com.chartboost.sdk.impl.qb$b r7 = com.chartboost.sdk.impl.qb.b.CRITICAL
            com.chartboost.sdk.impl.qb$a r14 = com.chartboost.sdk.impl.qb.a.HIGH
            r9 = 0
            r10 = 0
            r11 = 0
            r13 = 0
            r15 = 1920(0x780, float:2.69E-42)
            r16 = 0
            r1 = r17
            r6 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.d4.<init>(com.chartboost.sdk.impl.tb, java.lang.String, java.lang.String, java.lang.String, com.chartboost.sdk.Mediation, com.chartboost.sdk.impl.ib):void");
    }
}
