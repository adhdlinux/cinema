package com.chartboost.sdk.impl;

import kotlin.jvm.internal.Intrinsics;

public final class i4 {

    /* renamed from: a  reason: collision with root package name */
    public final int f17884a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17885b;

    /* renamed from: c  reason: collision with root package name */
    public final int f17886c;

    /* renamed from: d  reason: collision with root package name */
    public final int f17887d;

    /* renamed from: e  reason: collision with root package name */
    public final float f17888e;

    /* renamed from: f  reason: collision with root package name */
    public final String f17889f;

    /* renamed from: g  reason: collision with root package name */
    public final int f17890g;

    /* renamed from: h  reason: collision with root package name */
    public final String f17891h;

    /* renamed from: i  reason: collision with root package name */
    public final String f17892i;

    /* renamed from: j  reason: collision with root package name */
    public final String f17893j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f17894k;

    public i4(int i2, int i3, int i4, int i5, float f2, String str, int i6, String str2, String str3, String str4, boolean z2) {
        Intrinsics.f(str2, "deviceType");
        this.f17884a = i2;
        this.f17885b = i3;
        this.f17886c = i4;
        this.f17887d = i5;
        this.f17888e = f2;
        this.f17889f = str;
        this.f17890g = i6;
        this.f17891h = str2;
        this.f17892i = str3;
        this.f17893j = str4;
        this.f17894k = z2;
    }

    public final int a() {
        return this.f17885b;
    }

    public final String b() {
        return this.f17891h;
    }

    public final int c() {
        return this.f17884a;
    }

    public final String d() {
        return this.f17889f;
    }

    public final int e() {
        return this.f17887d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i4)) {
            return false;
        }
        i4 i4Var = (i4) obj;
        return this.f17884a == i4Var.f17884a && this.f17885b == i4Var.f17885b && this.f17886c == i4Var.f17886c && this.f17887d == i4Var.f17887d && Float.compare(this.f17888e, i4Var.f17888e) == 0 && Intrinsics.a(this.f17889f, i4Var.f17889f) && this.f17890g == i4Var.f17890g && Intrinsics.a(this.f17891h, i4Var.f17891h) && Intrinsics.a(this.f17892i, i4Var.f17892i) && Intrinsics.a(this.f17893j, i4Var.f17893j) && this.f17894k == i4Var.f17894k;
    }

    public final int f() {
        return this.f17890g;
    }

    public final String g() {
        return this.f17892i;
    }

    public final float h() {
        return this.f17888e;
    }

    public int hashCode() {
        int floatToIntBits = ((((((((this.f17884a * 31) + this.f17885b) * 31) + this.f17886c) * 31) + this.f17887d) * 31) + Float.floatToIntBits(this.f17888e)) * 31;
        String str = this.f17889f;
        int i2 = 0;
        int hashCode = (((((floatToIntBits + (str == null ? 0 : str.hashCode())) * 31) + this.f17890g) * 31) + this.f17891h.hashCode()) * 31;
        String str2 = this.f17892i;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f17893j;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z2 = this.f17894k;
        if (z2) {
            z2 = true;
        }
        return i3 + (z2 ? 1 : 0);
    }

    public final String i() {
        return this.f17893j;
    }

    public final int j() {
        return this.f17886c;
    }

    public final boolean k() {
        return this.f17894k;
    }

    public String toString() {
        return "DeviceBodyFields(deviceWidth=" + this.f17884a + ", deviceHeight=" + this.f17885b + ", width=" + this.f17886c + ", height=" + this.f17887d + ", scale=" + this.f17888e + ", dpi=" + this.f17889f + ", ortbDeviceType=" + this.f17890g + ", deviceType=" + this.f17891h + ", packageName=" + this.f17892i + ", versionName=" + this.f17893j + ", isPortrait=" + this.f17894k + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ i4(int r13, int r14, int r15, int r16, float r17, java.lang.String r18, int r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, boolean r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0011
        L_0x0010:
            r3 = r14
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = 0
            goto L_0x0018
        L_0x0017:
            r4 = r15
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r2 = r16
        L_0x001f:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0025
            r5 = 0
            goto L_0x0027
        L_0x0025:
            r5 = r17
        L_0x0027:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x002e
            java.lang.String r6 = ""
            goto L_0x0030
        L_0x002e:
            r6 = r18
        L_0x0030:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0037
            int r7 = com.chartboost.sdk.impl.m4.f18188a
            goto L_0x0039
        L_0x0037:
            r7 = r19
        L_0x0039:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0040
            java.lang.String r8 = "phone"
            goto L_0x0042
        L_0x0040:
            r8 = r20
        L_0x0042:
            r9 = r0 & 256(0x100, float:3.59E-43)
            r10 = 0
            if (r9 == 0) goto L_0x0049
            r9 = r10
            goto L_0x004b
        L_0x0049:
            r9 = r21
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r10 = r22
        L_0x0052:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0058
            r0 = 1
            goto L_0x005a
        L_0x0058:
            r0 = r23
        L_0x005a:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r2
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.i4.<init>(int, int, int, int, float, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
