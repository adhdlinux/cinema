package com.chartboost.sdk.impl;

import kotlin.jvm.internal.Intrinsics;

public final class u0 {

    /* renamed from: a  reason: collision with root package name */
    public final yb f18738a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18739b;

    public u0(yb ybVar, String str) {
        Intrinsics.f(ybVar, "advertisingIDState");
        this.f18738a = ybVar;
        this.f18739b = str;
    }

    public final String a() {
        return this.f18739b;
    }

    public final yb b() {
        return this.f18738a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return this.f18738a == u0Var.f18738a && Intrinsics.a(this.f18739b, u0Var.f18739b);
    }

    public int hashCode() {
        int hashCode = this.f18738a.hashCode() * 31;
        String str = this.f18739b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "AdvertisingIDHolder(advertisingIDState=" + this.f18738a + ", advertisingID=" + this.f18739b + ')';
    }
}
