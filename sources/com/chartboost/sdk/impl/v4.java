package com.chartboost.sdk.impl;

import b0.y;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import kotlin.jvm.internal.Intrinsics;

public final class v4 {
    public final int A;
    public final int B;
    public final int C;
    public final long D;
    public final long E;

    /* renamed from: a  reason: collision with root package name */
    public final String f18821a;

    /* renamed from: b  reason: collision with root package name */
    public final int f18822b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18823c;

    /* renamed from: d  reason: collision with root package name */
    public final String f18824d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f18825e;

    /* renamed from: f  reason: collision with root package name */
    public final String f18826f;

    /* renamed from: g  reason: collision with root package name */
    public final String f18827g;

    /* renamed from: h  reason: collision with root package name */
    public final String f18828h;

    /* renamed from: i  reason: collision with root package name */
    public final String f18829i;

    /* renamed from: j  reason: collision with root package name */
    public final String f18830j;

    /* renamed from: k  reason: collision with root package name */
    public final String f18831k;

    /* renamed from: l  reason: collision with root package name */
    public final String f18832l;

    /* renamed from: m  reason: collision with root package name */
    public final String f18833m;

    /* renamed from: n  reason: collision with root package name */
    public final String f18834n;

    /* renamed from: o  reason: collision with root package name */
    public final String f18835o;

    /* renamed from: p  reason: collision with root package name */
    public final String f18836p;

    /* renamed from: q  reason: collision with root package name */
    public final String f18837q;

    /* renamed from: r  reason: collision with root package name */
    public final String f18838r;

    /* renamed from: s  reason: collision with root package name */
    public final String f18839s;

    /* renamed from: t  reason: collision with root package name */
    public final int f18840t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f18841u;

    /* renamed from: v  reason: collision with root package name */
    public final int f18842v;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f18843w;

    /* renamed from: x  reason: collision with root package name */
    public final int f18844x;

    /* renamed from: y  reason: collision with root package name */
    public final long f18845y;

    /* renamed from: z  reason: collision with root package name */
    public final long f18846z;

    public v4(String str, int i2, String str2, String str3, boolean z2, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i3, boolean z3, int i4, boolean z4, int i5, long j2, long j3, int i6, int i7, int i8, long j4, long j5) {
        String str18 = str;
        String str19 = str2;
        String str20 = str3;
        String str21 = str4;
        String str22 = str5;
        String str23 = str6;
        String str24 = str7;
        String str25 = str8;
        String str26 = str9;
        String str27 = str10;
        String str28 = str11;
        String str29 = str12;
        String str30 = str13;
        String str31 = str14;
        String str32 = str16;
        Intrinsics.f(str18, JsonStorageKeyNames.SESSION_ID_KEY);
        Intrinsics.f(str19, "appId");
        Intrinsics.f(str20, "chartboostSdkVersion");
        Intrinsics.f(str21, "chartboostSdkGdpr");
        Intrinsics.f(str22, "chartboostSdkCcpa");
        Intrinsics.f(str23, "chartboostSdkCoppa");
        Intrinsics.f(str24, "chartboostSdkLgpd");
        Intrinsics.f(str25, "deviceId");
        Intrinsics.f(str26, "deviceMake");
        Intrinsics.f(str27, "deviceModel");
        Intrinsics.f(str28, "deviceOsVersion");
        Intrinsics.f(str29, "devicePlatform");
        Intrinsics.f(str30, "deviceCountry");
        Intrinsics.f(str31, "deviceLanguage");
        Intrinsics.f(str15, "deviceTimezone");
        Intrinsics.f(str16, "deviceConnectionType");
        Intrinsics.f(str17, "deviceOrientation");
        this.f18821a = str18;
        this.f18822b = i2;
        this.f18823c = str19;
        this.f18824d = str20;
        this.f18825e = z2;
        this.f18826f = str21;
        this.f18827g = str22;
        this.f18828h = str23;
        this.f18829i = str24;
        this.f18830j = str25;
        this.f18831k = str26;
        this.f18832l = str27;
        this.f18833m = str28;
        this.f18834n = str29;
        this.f18835o = str30;
        this.f18836p = str31;
        this.f18837q = str15;
        this.f18838r = str16;
        this.f18839s = str17;
        this.f18840t = i3;
        this.f18841u = z3;
        this.f18842v = i4;
        this.f18843w = z4;
        this.f18844x = i5;
        this.f18845y = j2;
        this.f18846z = j3;
        this.A = i6;
        this.B = i7;
        this.C = i8;
        this.D = j4;
        this.E = j5;
    }

    public final long A() {
        return this.D;
    }

    public final String B() {
        return this.f18821a;
    }

    public final int C() {
        return this.C;
    }

    public final int D() {
        return this.A;
    }

    public final int E() {
        return this.B;
    }

    public final String a() {
        return this.f18823c;
    }

    public final boolean b() {
        return this.f18825e;
    }

    public final String c() {
        return this.f18827g;
    }

    public final String d() {
        return this.f18828h;
    }

    public final String e() {
        return this.f18826f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v4)) {
            return false;
        }
        v4 v4Var = (v4) obj;
        return Intrinsics.a(this.f18821a, v4Var.f18821a) && this.f18822b == v4Var.f18822b && Intrinsics.a(this.f18823c, v4Var.f18823c) && Intrinsics.a(this.f18824d, v4Var.f18824d) && this.f18825e == v4Var.f18825e && Intrinsics.a(this.f18826f, v4Var.f18826f) && Intrinsics.a(this.f18827g, v4Var.f18827g) && Intrinsics.a(this.f18828h, v4Var.f18828h) && Intrinsics.a(this.f18829i, v4Var.f18829i) && Intrinsics.a(this.f18830j, v4Var.f18830j) && Intrinsics.a(this.f18831k, v4Var.f18831k) && Intrinsics.a(this.f18832l, v4Var.f18832l) && Intrinsics.a(this.f18833m, v4Var.f18833m) && Intrinsics.a(this.f18834n, v4Var.f18834n) && Intrinsics.a(this.f18835o, v4Var.f18835o) && Intrinsics.a(this.f18836p, v4Var.f18836p) && Intrinsics.a(this.f18837q, v4Var.f18837q) && Intrinsics.a(this.f18838r, v4Var.f18838r) && Intrinsics.a(this.f18839s, v4Var.f18839s) && this.f18840t == v4Var.f18840t && this.f18841u == v4Var.f18841u && this.f18842v == v4Var.f18842v && this.f18843w == v4Var.f18843w && this.f18844x == v4Var.f18844x && this.f18845y == v4Var.f18845y && this.f18846z == v4Var.f18846z && this.A == v4Var.A && this.B == v4Var.B && this.C == v4Var.C && this.D == v4Var.D && this.E == v4Var.E;
    }

    public final String f() {
        return this.f18829i;
    }

    public final String g() {
        return this.f18824d;
    }

    public final int h() {
        return this.f18844x;
    }

    public int hashCode() {
        int hashCode = ((((((this.f18821a.hashCode() * 31) + this.f18822b) * 31) + this.f18823c.hashCode()) * 31) + this.f18824d.hashCode()) * 31;
        boolean z2 = this.f18825e;
        boolean z3 = true;
        if (z2) {
            z2 = true;
        }
        int hashCode2 = (((((((((((((((((((((((((((((((hashCode + (z2 ? 1 : 0)) * 31) + this.f18826f.hashCode()) * 31) + this.f18827g.hashCode()) * 31) + this.f18828h.hashCode()) * 31) + this.f18829i.hashCode()) * 31) + this.f18830j.hashCode()) * 31) + this.f18831k.hashCode()) * 31) + this.f18832l.hashCode()) * 31) + this.f18833m.hashCode()) * 31) + this.f18834n.hashCode()) * 31) + this.f18835o.hashCode()) * 31) + this.f18836p.hashCode()) * 31) + this.f18837q.hashCode()) * 31) + this.f18838r.hashCode()) * 31) + this.f18839s.hashCode()) * 31) + this.f18840t) * 31;
        boolean z4 = this.f18841u;
        if (z4) {
            z4 = true;
        }
        int i2 = (((hashCode2 + (z4 ? 1 : 0)) * 31) + this.f18842v) * 31;
        boolean z5 = this.f18843w;
        if (!z5) {
            z3 = z5;
        }
        return ((((((((((((((((i2 + (z3 ? 1 : 0)) * 31) + this.f18844x) * 31) + y.a(this.f18845y)) * 31) + y.a(this.f18846z)) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + y.a(this.D)) * 31) + y.a(this.E);
    }

    public final int i() {
        return this.f18840t;
    }

    public final boolean j() {
        return this.f18841u;
    }

    public final String k() {
        return this.f18838r;
    }

    public final String l() {
        return this.f18835o;
    }

    public final String m() {
        return this.f18830j;
    }

    public final String n() {
        return this.f18836p;
    }

    public final long o() {
        return this.f18846z;
    }

    public final String p() {
        return this.f18831k;
    }

    public final String q() {
        return this.f18832l;
    }

    public final boolean r() {
        return this.f18843w;
    }

    public final String s() {
        return this.f18839s;
    }

    public final String t() {
        return this.f18833m;
    }

    public String toString() {
        return "EnvironmentData(sessionId=" + this.f18821a + ", sessionCount=" + this.f18822b + ", appId=" + this.f18823c + ", chartboostSdkVersion=" + this.f18824d + ", chartboostSdkAutocacheEnabled=" + this.f18825e + ", chartboostSdkGdpr=" + this.f18826f + ", chartboostSdkCcpa=" + this.f18827g + ", chartboostSdkCoppa=" + this.f18828h + ", chartboostSdkLgpd=" + this.f18829i + ", deviceId=" + this.f18830j + ", deviceMake=" + this.f18831k + ", deviceModel=" + this.f18832l + ", deviceOsVersion=" + this.f18833m + ", devicePlatform=" + this.f18834n + ", deviceCountry=" + this.f18835o + ", deviceLanguage=" + this.f18836p + ", deviceTimezone=" + this.f18837q + ", deviceConnectionType=" + this.f18838r + ", deviceOrientation=" + this.f18839s + ", deviceBatteryLevel=" + this.f18840t + ", deviceChargingStatus=" + this.f18841u + ", deviceVolume=" + this.f18842v + ", deviceMute=" + this.f18843w + ", deviceAudioOutput=" + this.f18844x + ", deviceStorage=" + this.f18845y + ", deviceLowMemoryWarning=" + this.f18846z + ", sessionImpressionInterstitialCount=" + this.A + ", sessionImpressionRewardedCount=" + this.B + ", sessionImpressionBannerCount=" + this.C + ", sessionDuration=" + this.D + ", deviceUpTime=" + this.E + ')';
    }

    public final String u() {
        return this.f18834n;
    }

    public final long v() {
        return this.f18845y;
    }

    public final String w() {
        return this.f18837q;
    }

    public final long x() {
        return this.E;
    }

    public final int y() {
        return this.f18842v;
    }

    public final int z() {
        return this.f18822b;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ v4(java.lang.String r37, int r38, java.lang.String r39, java.lang.String r40, boolean r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, int r56, boolean r57, int r58, boolean r59, int r60, long r61, long r63, int r65, int r66, int r67, long r68, long r70, int r72, kotlin.jvm.internal.DefaultConstructorMarker r73) {
        /*
            r36 = this;
            r0 = r72
            r1 = r0 & 1
            java.lang.String r2 = "not available"
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r37
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = 0
            goto L_0x0014
        L_0x0012:
            r3 = r38
        L_0x0014:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001a
            r5 = r2
            goto L_0x001c
        L_0x001a:
            r5 = r39
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0022
            r6 = r2
            goto L_0x0024
        L_0x0022:
            r6 = r40
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r41
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            r8 = r2
            goto L_0x0034
        L_0x0032:
            r8 = r42
        L_0x0034:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            r9 = r2
            goto L_0x003c
        L_0x003a:
            r9 = r43
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = r2
            goto L_0x0044
        L_0x0042:
            r10 = r44
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            r11 = r2
            goto L_0x004c
        L_0x004a:
            r11 = r45
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0052
            r12 = r2
            goto L_0x0054
        L_0x0052:
            r12 = r46
        L_0x0054:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005a
            r13 = r2
            goto L_0x005c
        L_0x005a:
            r13 = r47
        L_0x005c:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            r14 = r2
            goto L_0x0064
        L_0x0062:
            r14 = r48
        L_0x0064:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x006a
            r15 = r2
            goto L_0x006c
        L_0x006a:
            r15 = r49
        L_0x006c:
            r4 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r4 == 0) goto L_0x0072
            r4 = r2
            goto L_0x0074
        L_0x0072:
            r4 = r50
        L_0x0074:
            r73 = r2
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x007d
            r2 = r73
            goto L_0x007f
        L_0x007d:
            r2 = r51
        L_0x007f:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0089
            r16 = r73
            goto L_0x008b
        L_0x0089:
            r16 = r52
        L_0x008b:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0094
            r17 = r73
            goto L_0x0096
        L_0x0094:
            r17 = r53
        L_0x0096:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009f
            r18 = r73
            goto L_0x00a1
        L_0x009f:
            r18 = r54
        L_0x00a1:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00aa
            r19 = r73
            goto L_0x00ac
        L_0x00aa:
            r19 = r55
        L_0x00ac:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b5
            r20 = 0
            goto L_0x00b7
        L_0x00b5:
            r20 = r56
        L_0x00b7:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00c0
            r21 = 0
            goto L_0x00c2
        L_0x00c0:
            r21 = r57
        L_0x00c2:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00cb
            r22 = 0
            goto L_0x00cd
        L_0x00cb:
            r22 = r58
        L_0x00cd:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d6
            r23 = 0
            goto L_0x00d8
        L_0x00d6:
            r23 = r59
        L_0x00d8:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00e1
            r24 = 0
            goto L_0x00e3
        L_0x00e1:
            r24 = r60
        L_0x00e3:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            r26 = 0
            if (r25 == 0) goto L_0x00ee
            r28 = r26
            goto L_0x00f0
        L_0x00ee:
            r28 = r61
        L_0x00f0:
            r25 = 33554432(0x2000000, float:9.403955E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00f9
            r30 = r26
            goto L_0x00fb
        L_0x00f9:
            r30 = r63
        L_0x00fb:
            r25 = 67108864(0x4000000, float:1.5046328E-36)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x0104
            r25 = 0
            goto L_0x0106
        L_0x0104:
            r25 = r65
        L_0x0106:
            r32 = 134217728(0x8000000, float:3.85186E-34)
            r32 = r0 & r32
            if (r32 == 0) goto L_0x010f
            r32 = 0
            goto L_0x0111
        L_0x010f:
            r32 = r66
        L_0x0111:
            r33 = 268435456(0x10000000, float:2.5243549E-29)
            r33 = r0 & r33
            if (r33 == 0) goto L_0x011a
            r33 = 0
            goto L_0x011c
        L_0x011a:
            r33 = r67
        L_0x011c:
            r34 = 536870912(0x20000000, float:1.0842022E-19)
            r34 = r0 & r34
            if (r34 == 0) goto L_0x0123
            goto L_0x0125
        L_0x0123:
            r26 = r68
        L_0x0125:
            r34 = 1073741824(0x40000000, float:2.0)
            r0 = r0 & r34
            if (r0 == 0) goto L_0x0130
            long r34 = android.os.SystemClock.uptimeMillis()
            goto L_0x0132
        L_0x0130:
            r34 = r70
        L_0x0132:
            r37 = r36
            r38 = r1
            r39 = r3
            r40 = r5
            r41 = r6
            r42 = r7
            r43 = r8
            r44 = r9
            r45 = r10
            r46 = r11
            r47 = r12
            r48 = r13
            r49 = r14
            r50 = r15
            r51 = r4
            r52 = r2
            r53 = r16
            r54 = r17
            r55 = r18
            r56 = r19
            r57 = r20
            r58 = r21
            r59 = r22
            r60 = r23
            r61 = r24
            r62 = r28
            r64 = r30
            r66 = r25
            r67 = r32
            r68 = r33
            r69 = r26
            r71 = r34
            r37.<init>(r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r64, r66, r67, r68, r69, r71)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.v4.<init>(java.lang.String, int, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, boolean, int, boolean, int, long, long, int, int, int, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
