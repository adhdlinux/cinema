package com.chartboost.sdk.impl;

import kotlin.jvm.internal.Intrinsics;

public final class k3 {

    /* renamed from: a  reason: collision with root package name */
    public final String f18013a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18014b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18015c;

    /* renamed from: d  reason: collision with root package name */
    public final String f18016d;

    /* renamed from: e  reason: collision with root package name */
    public final String f18017e;

    /* renamed from: f  reason: collision with root package name */
    public final Float f18018f;

    /* renamed from: g  reason: collision with root package name */
    public final Float f18019g;

    /* renamed from: h  reason: collision with root package name */
    public final f7 f18020h;

    /* renamed from: i  reason: collision with root package name */
    public final Boolean f18021i;

    public k3(String str, String str2, String str3, String str4, String str5, Float f2, Float f3, f7 f7Var, Boolean bool) {
        Intrinsics.f(str, "location");
        Intrinsics.f(str2, "adId");
        Intrinsics.f(str3, "to");
        Intrinsics.f(str4, "cgn");
        Intrinsics.f(str5, "creative");
        Intrinsics.f(f7Var, "impressionMediaType");
        this.f18013a = str;
        this.f18014b = str2;
        this.f18015c = str3;
        this.f18016d = str4;
        this.f18017e = str5;
        this.f18018f = f2;
        this.f18019g = f3;
        this.f18020h = f7Var;
        this.f18021i = bool;
    }

    public final String a() {
        return this.f18014b;
    }

    public final String b() {
        return this.f18016d;
    }

    public final String c() {
        return this.f18017e;
    }

    public final f7 d() {
        return this.f18020h;
    }

    public final String e() {
        return this.f18013a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k3)) {
            return false;
        }
        k3 k3Var = (k3) obj;
        return Intrinsics.a(this.f18013a, k3Var.f18013a) && Intrinsics.a(this.f18014b, k3Var.f18014b) && Intrinsics.a(this.f18015c, k3Var.f18015c) && Intrinsics.a(this.f18016d, k3Var.f18016d) && Intrinsics.a(this.f18017e, k3Var.f18017e) && Intrinsics.a(this.f18018f, k3Var.f18018f) && Intrinsics.a(this.f18019g, k3Var.f18019g) && this.f18020h == k3Var.f18020h && Intrinsics.a(this.f18021i, k3Var.f18021i);
    }

    public final Boolean f() {
        return this.f18021i;
    }

    public final String g() {
        return this.f18015c;
    }

    public final Float h() {
        return this.f18019g;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f18013a.hashCode() * 31) + this.f18014b.hashCode()) * 31) + this.f18015c.hashCode()) * 31) + this.f18016d.hashCode()) * 31) + this.f18017e.hashCode()) * 31;
        Float f2 = this.f18018f;
        int i2 = 0;
        int hashCode2 = (hashCode + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.f18019g;
        int hashCode3 = (((hashCode2 + (f3 == null ? 0 : f3.hashCode())) * 31) + this.f18020h.hashCode()) * 31;
        Boolean bool = this.f18021i;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode3 + i2;
    }

    public final Float i() {
        return this.f18018f;
    }

    public String toString() {
        return "ClickParams(location=" + this.f18013a + ", adId=" + this.f18014b + ", to=" + this.f18015c + ", cgn=" + this.f18016d + ", creative=" + this.f18017e + ", videoPostion=" + this.f18018f + ", videoDuration=" + this.f18019g + ", impressionMediaType=" + this.f18020h + ", retarget_reinstall=" + this.f18021i + ')';
    }
}
