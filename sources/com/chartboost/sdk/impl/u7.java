package com.chartboost.sdk.impl;

import kotlin.jvm.internal.Intrinsics;

public final class u7 {

    /* renamed from: a  reason: collision with root package name */
    public final b1 f18769a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f18770b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f18771c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f18772d;

    /* renamed from: e  reason: collision with root package name */
    public final b0 f18773e = new b0();

    public u7(b1 b1Var, boolean z2, Integer num, Integer num2) {
        Intrinsics.f(b1Var, "appRequest");
        this.f18769a = b1Var;
        this.f18770b = z2;
        this.f18771c = num;
        this.f18772d = num2;
    }

    public final b1 a() {
        return this.f18769a;
    }

    public final Integer b() {
        return this.f18771c;
    }

    public final Integer c() {
        return this.f18772d;
    }

    public final b0 d() {
        return this.f18773e;
    }

    public final boolean e() {
        return this.f18770b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u7)) {
            return false;
        }
        u7 u7Var = (u7) obj;
        return Intrinsics.a(this.f18769a, u7Var.f18769a) && this.f18770b == u7Var.f18770b && Intrinsics.a(this.f18771c, u7Var.f18771c) && Intrinsics.a(this.f18772d, u7Var.f18772d);
    }

    public int hashCode() {
        int hashCode = this.f18769a.hashCode() * 31;
        boolean z2 = this.f18770b;
        if (z2) {
            z2 = true;
        }
        int i2 = (hashCode + (z2 ? 1 : 0)) * 31;
        Integer num = this.f18771c;
        int i3 = 0;
        int hashCode2 = (i2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f18772d;
        if (num2 != null) {
            i3 = num2.hashCode();
        }
        return hashCode2 + i3;
    }

    public String toString() {
        return "LoadParams(appRequest=" + this.f18769a + ", isCacheRequest=" + this.f18770b + ", bannerHeight=" + this.f18771c + ", bannerWidth=" + this.f18772d + ')';
    }
}
