package com.chartboost.sdk.impl;

import kotlin.jvm.internal.Intrinsics;

public final class i6 {

    /* renamed from: a  reason: collision with root package name */
    public final yb f17912a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17913b;

    /* renamed from: c  reason: collision with root package name */
    public final String f17914c;

    /* renamed from: d  reason: collision with root package name */
    public final String f17915d;

    /* renamed from: e  reason: collision with root package name */
    public final String f17916e;

    /* renamed from: f  reason: collision with root package name */
    public final Integer f17917f;

    public i6(yb ybVar, String str, String str2, String str3, String str4, Integer num) {
        Intrinsics.f(ybVar, "trackingState");
        this.f17912a = ybVar;
        this.f17913b = str;
        this.f17914c = str2;
        this.f17915d = str3;
        this.f17916e = str4;
        this.f17917f = num;
    }

    public final String a() {
        return this.f17915d;
    }

    public final String b() {
        return this.f17913b;
    }

    public final String c() {
        return this.f17916e;
    }

    public final Integer d() {
        return this.f17917f;
    }

    public final yb e() {
        return this.f17912a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i6)) {
            return false;
        }
        i6 i6Var = (i6) obj;
        return this.f17912a == i6Var.f17912a && Intrinsics.a(this.f17913b, i6Var.f17913b) && Intrinsics.a(this.f17914c, i6Var.f17914c) && Intrinsics.a(this.f17915d, i6Var.f17915d) && Intrinsics.a(this.f17916e, i6Var.f17916e) && Intrinsics.a(this.f17917f, i6Var.f17917f);
    }

    public final String f() {
        return this.f17914c;
    }

    public int hashCode() {
        int hashCode = this.f17912a.hashCode() * 31;
        String str = this.f17913b;
        int i2 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f17914c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f17915d;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f17916e;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.f17917f;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode5 + i2;
    }

    public String toString() {
        return "IdentityBodyFields(trackingState=" + this.f17912a + ", identifiers=" + this.f17913b + ", uuid=" + this.f17914c + ", gaid=" + this.f17915d + ", setId=" + this.f17916e + ", setIdScope=" + this.f17917f + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ i6(com.chartboost.sdk.impl.yb r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.Integer r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0006
            com.chartboost.sdk.impl.yb r5 = com.chartboost.sdk.impl.yb.TRACKING_UNKNOWN
        L_0x0006:
            r12 = r11 & 2
            r0 = 0
            if (r12 == 0) goto L_0x000d
            r12 = r0
            goto L_0x000e
        L_0x000d:
            r12 = r6
        L_0x000e:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0014
            r1 = r0
            goto L_0x0015
        L_0x0014:
            r1 = r7
        L_0x0015:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001b
            r2 = r0
            goto L_0x001c
        L_0x001b:
            r2 = r8
        L_0x001c:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0022
            r3 = r0
            goto L_0x0023
        L_0x0022:
            r3 = r9
        L_0x0023:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r0 = r10
        L_0x0029:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.i6.<init>(com.chartboost.sdk.impl.yb, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
