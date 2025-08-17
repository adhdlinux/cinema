package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.h2;
import com.vungle.ads.internal.model.AdPayload;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class v {
    public final String A;
    public final boolean B;

    /* renamed from: a  reason: collision with root package name */
    public String f18788a;

    /* renamed from: b  reason: collision with root package name */
    public String f18789b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18790c;

    /* renamed from: d  reason: collision with root package name */
    public String f18791d;

    /* renamed from: e  reason: collision with root package name */
    public final n7 f18792e;

    /* renamed from: f  reason: collision with root package name */
    public String f18793f;

    /* renamed from: g  reason: collision with root package name */
    public String f18794g;

    /* renamed from: h  reason: collision with root package name */
    public String f18795h;

    /* renamed from: i  reason: collision with root package name */
    public final Map f18796i;

    /* renamed from: j  reason: collision with root package name */
    public String f18797j;

    /* renamed from: k  reason: collision with root package name */
    public String f18798k;

    /* renamed from: l  reason: collision with root package name */
    public String f18799l;

    /* renamed from: m  reason: collision with root package name */
    public String f18800m;

    /* renamed from: n  reason: collision with root package name */
    public String f18801n;

    /* renamed from: o  reason: collision with root package name */
    public int f18802o;

    /* renamed from: p  reason: collision with root package name */
    public String f18803p;

    /* renamed from: q  reason: collision with root package name */
    public String f18804q;

    /* renamed from: r  reason: collision with root package name */
    public f1 f18805r;

    /* renamed from: s  reason: collision with root package name */
    public final Map f18806s;

    /* renamed from: t  reason: collision with root package name */
    public final aa f18807t;

    /* renamed from: u  reason: collision with root package name */
    public final List f18808u;

    /* renamed from: v  reason: collision with root package name */
    public final Map f18809v;

    /* renamed from: w  reason: collision with root package name */
    public final String f18810w;

    /* renamed from: x  reason: collision with root package name */
    public final String f18811x;

    /* renamed from: y  reason: collision with root package name */
    public final y7 f18812y;

    /* renamed from: z  reason: collision with root package name */
    public final l3 f18813z;

    public v(String str, String str2, String str3, String str4, n7 n7Var, String str5, String str6, String str7, Map map, String str8, String str9, String str10, String str11, String str12, int i2, String str13, String str14, f1 f1Var, Map map2, aa aaVar, List list, Map map3, String str15, String str16, y7 y7Var, l3 l3Var, String str17) {
        String str18 = str;
        String str19 = str2;
        String str20 = str3;
        String str21 = str4;
        n7 n7Var2 = n7Var;
        String str22 = str5;
        String str23 = str6;
        String str24 = str7;
        Map map4 = map;
        String str25 = str8;
        String str26 = str9;
        String str27 = str10;
        String str28 = str11;
        String str29 = str12;
        String str30 = str14;
        Intrinsics.f(str18, "name");
        Intrinsics.f(str19, "adId");
        Intrinsics.f(str20, "baseUrl");
        Intrinsics.f(str21, "impressionId");
        Intrinsics.f(n7Var2, "infoIcon");
        Intrinsics.f(str22, "cgn");
        Intrinsics.f(str23, "creative");
        Intrinsics.f(str24, "mediaType");
        Intrinsics.f(map4, "assets");
        Intrinsics.f(str25, "videoUrl");
        Intrinsics.f(str26, "videoFilename");
        Intrinsics.f(str27, "link");
        Intrinsics.f(str28, "deepLink");
        Intrinsics.f(str29, "to");
        Intrinsics.f(str13, "rewardCurrency");
        Intrinsics.f(str14, AdPayload.KEY_TEMPLATE);
        Intrinsics.f(f1Var, "body");
        Intrinsics.f(map2, "parameters");
        Intrinsics.f(aaVar, "renderingEngine");
        Intrinsics.f(list, "scripts");
        Intrinsics.f(map3, "events");
        Intrinsics.f(str15, "adm");
        Intrinsics.f(str16, "templateParams");
        Intrinsics.f(y7Var, "mtype");
        Intrinsics.f(l3Var, "clkp");
        Intrinsics.f(str17, "decodedAdm");
        this.f18788a = str18;
        this.f18789b = str19;
        this.f18790c = str20;
        this.f18791d = str21;
        this.f18792e = n7Var2;
        this.f18793f = str22;
        this.f18794g = str23;
        this.f18795h = str24;
        this.f18796i = map4;
        this.f18797j = str25;
        this.f18798k = str26;
        this.f18799l = str27;
        this.f18800m = str28;
        this.f18801n = str29;
        this.f18802o = i2;
        this.f18803p = str13;
        this.f18804q = str14;
        this.f18805r = f1Var;
        this.f18806s = map2;
        this.f18807t = aaVar;
        this.f18808u = list;
        this.f18809v = map3;
        this.f18810w = str15;
        this.f18811x = str16;
        this.f18812y = y7Var;
        this.f18813z = l3Var;
        this.A = str17;
        this.B = str8.length() > 0 && this.f18798k.length() > 0;
    }

    public final String A() {
        return this.f18801n;
    }

    public final String B() {
        return this.f18798k;
    }

    public final String C() {
        return this.f18797j;
    }

    public final boolean D() {
        return this.B;
    }

    public final Map E() {
        Map map = this.f18806s;
        Map map2 = this.f18796i;
        ArrayList arrayList = new ArrayList(map2.size());
        for (Map.Entry entry : map2.entrySet()) {
            f1 f1Var = (f1) entry.getValue();
            arrayList.add(TuplesKt.a((String) entry.getKey(), f1Var.f17671a + '/' + f1Var.f17672b));
        }
        return MapsKt__MapsKt.n(map, arrayList);
    }

    public final String a() {
        return this.f18789b;
    }

    public final String b() {
        if (this.A.length() == 0) {
            return "";
        }
        if (StringsKt__StringsKt.J(this.A, "<VAST ", true)) {
            return "Wrapper";
        }
        return "Inline";
    }

    public final String c() {
        return this.f18810w;
    }

    public final Map d() {
        return this.f18796i;
    }

    public final String e() {
        return this.f18790c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return Intrinsics.a(this.f18788a, vVar.f18788a) && Intrinsics.a(this.f18789b, vVar.f18789b) && Intrinsics.a(this.f18790c, vVar.f18790c) && Intrinsics.a(this.f18791d, vVar.f18791d) && Intrinsics.a(this.f18792e, vVar.f18792e) && Intrinsics.a(this.f18793f, vVar.f18793f) && Intrinsics.a(this.f18794g, vVar.f18794g) && Intrinsics.a(this.f18795h, vVar.f18795h) && Intrinsics.a(this.f18796i, vVar.f18796i) && Intrinsics.a(this.f18797j, vVar.f18797j) && Intrinsics.a(this.f18798k, vVar.f18798k) && Intrinsics.a(this.f18799l, vVar.f18799l) && Intrinsics.a(this.f18800m, vVar.f18800m) && Intrinsics.a(this.f18801n, vVar.f18801n) && this.f18802o == vVar.f18802o && Intrinsics.a(this.f18803p, vVar.f18803p) && Intrinsics.a(this.f18804q, vVar.f18804q) && Intrinsics.a(this.f18805r, vVar.f18805r) && Intrinsics.a(this.f18806s, vVar.f18806s) && this.f18807t == vVar.f18807t && Intrinsics.a(this.f18808u, vVar.f18808u) && Intrinsics.a(this.f18809v, vVar.f18809v) && Intrinsics.a(this.f18810w, vVar.f18810w) && Intrinsics.a(this.f18811x, vVar.f18811x) && this.f18812y == vVar.f18812y && this.f18813z == vVar.f18813z && Intrinsics.a(this.A, vVar.A);
    }

    public final f1 f() {
        return this.f18805r;
    }

    public final String g() {
        return this.f18793f;
    }

    public final l3 h() {
        return this.f18813z;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((this.f18788a.hashCode() * 31) + this.f18789b.hashCode()) * 31) + this.f18790c.hashCode()) * 31) + this.f18791d.hashCode()) * 31) + this.f18792e.hashCode()) * 31) + this.f18793f.hashCode()) * 31) + this.f18794g.hashCode()) * 31) + this.f18795h.hashCode()) * 31) + this.f18796i.hashCode()) * 31) + this.f18797j.hashCode()) * 31) + this.f18798k.hashCode()) * 31) + this.f18799l.hashCode()) * 31) + this.f18800m.hashCode()) * 31) + this.f18801n.hashCode()) * 31) + this.f18802o) * 31) + this.f18803p.hashCode()) * 31) + this.f18804q.hashCode()) * 31) + this.f18805r.hashCode()) * 31) + this.f18806s.hashCode()) * 31) + this.f18807t.hashCode()) * 31) + this.f18808u.hashCode()) * 31) + this.f18809v.hashCode()) * 31) + this.f18810w.hashCode()) * 31) + this.f18811x.hashCode()) * 31) + this.f18812y.hashCode()) * 31) + this.f18813z.hashCode()) * 31) + this.A.hashCode();
    }

    public final String i() {
        return this.f18794g;
    }

    public final String j() {
        return this.A;
    }

    public final String k() {
        return this.f18800m;
    }

    public final Map l() {
        return this.f18809v;
    }

    public final String m() {
        return this.f18791d;
    }

    public final n7 n() {
        return this.f18792e;
    }

    public final String o() {
        return this.f18799l;
    }

    public final String p() {
        return this.f18795h;
    }

    public final y7 q() {
        return this.f18812y;
    }

    public final String r() {
        return this.f18788a;
    }

    public final Map s() {
        return this.f18806s;
    }

    public final String t() {
        JSONObject a2 = h2.a(new h2.a[0]);
        for (Map.Entry entry : E().entrySet()) {
            Intrinsics.e(a2, "getParametersAsString$lambda$1$lambda$0");
            i2.a(a2, (String) entry.getKey(), (String) entry.getValue());
        }
        String jSONObject = a2.toString();
        Intrinsics.e(jSONObject, "jsonObject().apply {\n   …e) }\n        }.toString()");
        return jSONObject;
    }

    public String toString() {
        return "AdUnit(name=" + this.f18788a + ", adId=" + this.f18789b + ", baseUrl=" + this.f18790c + ", impressionId=" + this.f18791d + ", infoIcon=" + this.f18792e + ", cgn=" + this.f18793f + ", creative=" + this.f18794g + ", mediaType=" + this.f18795h + ", assets=" + this.f18796i + ", videoUrl=" + this.f18797j + ", videoFilename=" + this.f18798k + ", link=" + this.f18799l + ", deepLink=" + this.f18800m + ", to=" + this.f18801n + ", rewardAmount=" + this.f18802o + ", rewardCurrency=" + this.f18803p + ", template=" + this.f18804q + ", body=" + this.f18805r + ", parameters=" + this.f18806s + ", renderingEngine=" + this.f18807t + ", scripts=" + this.f18808u + ", events=" + this.f18809v + ", adm=" + this.f18810w + ", templateParams=" + this.f18811x + ", mtype=" + this.f18812y + ", clkp=" + this.f18813z + ", decodedAdm=" + this.A + ')';
    }

    public final aa u() {
        return this.f18807t;
    }

    public final int v() {
        return this.f18802o;
    }

    public final String w() {
        return this.f18803p;
    }

    public final List x() {
        return this.f18808u;
    }

    public final String y() {
        return this.f18804q;
    }

    public final String z() {
        return this.f18811x;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ v(java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, com.chartboost.sdk.impl.n7 r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.util.Map r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, int r43, java.lang.String r44, java.lang.String r45, com.chartboost.sdk.impl.f1 r46, java.util.Map r47, com.chartboost.sdk.impl.aa r48, java.util.List r49, java.util.Map r50, java.lang.String r51, java.lang.String r52, com.chartboost.sdk.impl.y7 r53, com.chartboost.sdk.impl.l3 r54, java.lang.String r55, int r56, kotlin.jvm.internal.DefaultConstructorMarker r57) {
        /*
            r28 = this;
            r0 = r56
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r29
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r30
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001b
            java.lang.String r4 = "https://live.chartboost.com"
            goto L_0x001d
        L_0x001b:
            r4 = r31
        L_0x001d:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0023
            r5 = r2
            goto L_0x0025
        L_0x0023:
            r5 = r32
        L_0x0025:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0039
            com.chartboost.sdk.impl.n7 r6 = new com.chartboost.sdk.impl.n7
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 63
            r15 = 0
            r7 = r6
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)
            goto L_0x003b
        L_0x0039:
            r6 = r33
        L_0x003b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0041
            r7 = r2
            goto L_0x0043
        L_0x0041:
            r7 = r34
        L_0x0043:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0049
            r8 = r2
            goto L_0x004b
        L_0x0049:
            r8 = r35
        L_0x004b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0051
            r9 = r2
            goto L_0x0053
        L_0x0051:
            r9 = r36
        L_0x0053:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x005d
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            goto L_0x005f
        L_0x005d:
            r10 = r37
        L_0x005f:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0065
            r11 = r2
            goto L_0x0067
        L_0x0065:
            r11 = r38
        L_0x0067:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x006d
            r12 = r2
            goto L_0x006f
        L_0x006d:
            r12 = r39
        L_0x006f:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0075
            r13 = r2
            goto L_0x0077
        L_0x0075:
            r13 = r40
        L_0x0077:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x007d
            r14 = r2
            goto L_0x007f
        L_0x007d:
            r14 = r41
        L_0x007f:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0085
            r15 = r2
            goto L_0x0087
        L_0x0085:
            r15 = r42
        L_0x0087:
            r57 = r15
            r15 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r15 == 0) goto L_0x008f
            r15 = 0
            goto L_0x0091
        L_0x008f:
            r15 = r43
        L_0x0091:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x009b
            r16 = r2
            goto L_0x009d
        L_0x009b:
            r16 = r44
        L_0x009d:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x00a6
            r17 = r2
            goto L_0x00a8
        L_0x00a6:
            r17 = r45
        L_0x00a8:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x00b6
            r18 = r15
            com.chartboost.sdk.impl.f1 r15 = new com.chartboost.sdk.impl.f1
            r15.<init>(r2, r2, r2)
            goto L_0x00ba
        L_0x00b6:
            r18 = r15
            r15 = r46
        L_0x00ba:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00c6
            java.util.HashMap r19 = new java.util.HashMap
            r19.<init>()
            goto L_0x00c8
        L_0x00c6:
            r19 = r47
        L_0x00c8:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00d1
            com.chartboost.sdk.impl.aa r20 = com.chartboost.sdk.impl.aa.UNKNOWN
            goto L_0x00d3
        L_0x00d1:
            r20 = r48
        L_0x00d3:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00de
            java.util.List r21 = kotlin.collections.CollectionsKt__CollectionsKt.f()
            goto L_0x00e0
        L_0x00de:
            r21 = r49
        L_0x00e0:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00ec
            java.util.HashMap r22 = new java.util.HashMap
            r22.<init>()
            goto L_0x00ee
        L_0x00ec:
            r22 = r50
        L_0x00ee:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00f7
            r23 = r2
            goto L_0x00f9
        L_0x00f7:
            r23 = r51
        L_0x00f9:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x0102
            r24 = r2
            goto L_0x0104
        L_0x0102:
            r24 = r52
        L_0x0104:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x010d
            com.chartboost.sdk.impl.y7 r25 = com.chartboost.sdk.impl.y7.UNKNOWN
            goto L_0x010f
        L_0x010d:
            r25 = r53
        L_0x010f:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x0118
            com.chartboost.sdk.impl.l3 r26 = com.chartboost.sdk.impl.l3.CLICK_PREFERENCE_EMBEDDED
            goto L_0x011a
        L_0x0118:
            r26 = r54
        L_0x011a:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r0 = r0 & r27
            if (r0 == 0) goto L_0x0121
            goto L_0x0123
        L_0x0121:
            r2 = r55
        L_0x0123:
            r29 = r28
            r30 = r1
            r31 = r3
            r32 = r4
            r33 = r5
            r34 = r6
            r35 = r7
            r36 = r8
            r37 = r9
            r38 = r10
            r39 = r11
            r40 = r12
            r41 = r13
            r42 = r14
            r43 = r57
            r44 = r18
            r45 = r16
            r46 = r17
            r47 = r15
            r48 = r19
            r49 = r20
            r50 = r21
            r51 = r22
            r52 = r23
            r53 = r24
            r54 = r25
            r55 = r26
            r56 = r2
            r29.<init>(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.v.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.chartboost.sdk.impl.n7, java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, com.chartboost.sdk.impl.f1, java.util.Map, com.chartboost.sdk.impl.aa, java.util.List, java.util.Map, java.lang.String, java.lang.String, com.chartboost.sdk.impl.y7, com.chartboost.sdk.impl.l3, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
