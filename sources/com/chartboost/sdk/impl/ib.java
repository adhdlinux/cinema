package com.chartboost.sdk.impl;

import kotlin.jvm.internal.Intrinsics;

public final class ib {

    /* renamed from: a  reason: collision with root package name */
    public final String f17942a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17943b;

    /* renamed from: c  reason: collision with root package name */
    public final String f17944c;

    /* renamed from: d  reason: collision with root package name */
    public final String f17945d;

    /* renamed from: e  reason: collision with root package name */
    public final String f17946e;

    /* renamed from: f  reason: collision with root package name */
    public final String f17947f;

    /* renamed from: g  reason: collision with root package name */
    public final String f17948g;

    /* renamed from: h  reason: collision with root package name */
    public final a f17949h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f17950a;

        /* renamed from: b  reason: collision with root package name */
        public final int f17951b;

        public a(int i2, int i3) {
            this.f17950a = i2;
            this.f17951b = i3;
        }

        public final int a() {
            return this.f17950a;
        }

        public final int b() {
            return this.f17951b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f17950a == aVar.f17950a && this.f17951b == aVar.f17951b;
        }

        public int hashCode() {
            return (this.f17950a * 31) + this.f17951b;
        }

        public String toString() {
            return "AdSize(height=" + this.f17950a + ", width=" + this.f17951b + ')';
        }
    }

    public ib(String str, String str2, String str3, String str4, String str5, String str6, String str7, a aVar) {
        Intrinsics.f(str, "location");
        Intrinsics.f(str2, "adType");
        Intrinsics.f(str4, "adCreativeId");
        Intrinsics.f(str5, "adCreativeType");
        Intrinsics.f(str6, "adMarkup");
        Intrinsics.f(str7, "templateUrl");
        this.f17942a = str;
        this.f17943b = str2;
        this.f17944c = str3;
        this.f17945d = str4;
        this.f17946e = str5;
        this.f17947f = str6;
        this.f17948g = str7;
        this.f17949h = aVar;
    }

    public final String a() {
        return this.f17945d;
    }

    public final String b() {
        return this.f17944c;
    }

    public final a c() {
        return this.f17949h;
    }

    public final String d() {
        return this.f17943b;
    }

    public final String e() {
        return this.f17942a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ib)) {
            return false;
        }
        ib ibVar = (ib) obj;
        return Intrinsics.a(this.f17942a, ibVar.f17942a) && Intrinsics.a(this.f17943b, ibVar.f17943b) && Intrinsics.a(this.f17944c, ibVar.f17944c) && Intrinsics.a(this.f17945d, ibVar.f17945d) && Intrinsics.a(this.f17946e, ibVar.f17946e) && Intrinsics.a(this.f17947f, ibVar.f17947f) && Intrinsics.a(this.f17948g, ibVar.f17948g) && Intrinsics.a(this.f17949h, ibVar.f17949h);
    }

    public final String f() {
        String str = this.f17944c;
        if (str == null) {
            return null;
        }
        String substring = str.substring(0, RangesKt___RangesKt.d(str.length(), 20));
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String g() {
        return this.f17948g;
    }

    public int hashCode() {
        int hashCode = ((this.f17942a.hashCode() * 31) + this.f17943b.hashCode()) * 31;
        String str = this.f17944c;
        int i2 = 0;
        int hashCode2 = (((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f17945d.hashCode()) * 31) + this.f17946e.hashCode()) * 31) + this.f17947f.hashCode()) * 31) + this.f17948g.hashCode()) * 31;
        a aVar = this.f17949h;
        if (aVar != null) {
            i2 = aVar.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "TrackAd: location: " + this.f17942a + " adType: " + this.f17943b + " adImpressionId: " + f() + " adCreativeId: " + this.f17945d + " adCreativeType: " + this.f17946e + " adMarkup: " + this.f17947f + " templateUrl: " + this.f17948g;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ib(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, com.chartboost.sdk.impl.ib.a r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r10
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0012
        L_0x0011:
            r3 = r11
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x0019
        L_0x0018:
            r4 = r12
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r2
            goto L_0x0020
        L_0x001f:
            r5 = r13
        L_0x0020:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0026
            r6 = r2
            goto L_0x0027
        L_0x0026:
            r6 = r14
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r2
            goto L_0x002e
        L_0x002d:
            r7 = r15
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r2 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003b
            r0 = 0
            goto L_0x003d
        L_0x003b:
            r0 = r17
        L_0x003d:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r2
            r18 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.ib.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.chartboost.sdk.impl.ib$a, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
