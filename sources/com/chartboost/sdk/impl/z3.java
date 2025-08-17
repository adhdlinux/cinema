package com.chartboost.sdk.impl;

import kotlin.jvm.internal.Intrinsics;

public final class z3 {

    /* renamed from: a  reason: collision with root package name */
    public final String f19108a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f19109b;

    /* renamed from: c  reason: collision with root package name */
    public final String f19110c;

    public z3(String str, boolean z2, String str2) {
        Intrinsics.f(str2, "webViewVersion");
        this.f19108a = str;
        this.f19109b = z2;
        this.f19110c = str2;
    }

    public final String a() {
        return this.f19108a;
    }

    public final boolean b() {
        return this.f19109b;
    }

    public final String c() {
        return this.f19110c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z3)) {
            return false;
        }
        z3 z3Var = (z3) obj;
        return Intrinsics.a(this.f19108a, z3Var.f19108a) && this.f19109b == z3Var.f19109b && Intrinsics.a(this.f19110c, z3Var.f19110c);
    }

    public int hashCode() {
        String str = this.f19108a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z2 = this.f19109b;
        if (z2) {
            z2 = true;
        }
        return ((hashCode + (z2 ? 1 : 0)) * 31) + this.f19110c.hashCode();
    }

    public String toString() {
        return "ConfigurationBodyFields(configVariant=" + this.f19108a + ", webViewEnabled=" + this.f19109b + ", webViewVersion=" + this.f19110c + ')';
    }
}
