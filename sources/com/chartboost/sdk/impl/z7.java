package com.chartboost.sdk.impl;

import kotlin.jvm.internal.Intrinsics;

public final class z7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f19122a;

    /* renamed from: b  reason: collision with root package name */
    public final String f19123b;

    /* renamed from: c  reason: collision with root package name */
    public final String f19124c;

    public z7(String str, String str2, String str3) {
        Intrinsics.f(str, "mediationName");
        Intrinsics.f(str2, "libraryVersion");
        Intrinsics.f(str3, "adapterVersion");
        this.f19122a = str;
        this.f19123b = str2;
        this.f19124c = str3;
    }

    public final String a() {
        return this.f19124c;
    }

    public final String b() {
        return this.f19123b;
    }

    public final String c() {
        return this.f19122a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z7)) {
            return false;
        }
        z7 z7Var = (z7) obj;
        return Intrinsics.a(this.f19122a, z7Var.f19122a) && Intrinsics.a(this.f19123b, z7Var.f19123b) && Intrinsics.a(this.f19124c, z7Var.f19124c);
    }

    public int hashCode() {
        return (((this.f19122a.hashCode() * 31) + this.f19123b.hashCode()) * 31) + this.f19124c.hashCode();
    }

    public String toString() {
        return "MediationBodyFields(mediationName=" + this.f19122a + ", libraryVersion=" + this.f19123b + ", adapterVersion=" + this.f19124c + ')';
    }
}
