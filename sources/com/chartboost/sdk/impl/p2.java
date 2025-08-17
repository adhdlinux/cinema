package com.chartboost.sdk.impl;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

public final class p2 {

    /* renamed from: a  reason: collision with root package name */
    public final int f18328a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f18329b;

    public p2(int i2, byte[] bArr) {
        Intrinsics.f(bArr, "data");
        this.f18328a = i2;
        this.f18329b = bArr;
    }

    public final byte[] a() {
        return this.f18329b;
    }

    public final int b() {
        return this.f18328a;
    }

    public final boolean c() {
        int i2 = this.f18328a;
        return i2 >= 200 && i2 < 300;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p2)) {
            return false;
        }
        p2 p2Var = (p2) obj;
        return this.f18328a == p2Var.f18328a && Intrinsics.a(this.f18329b, p2Var.f18329b);
    }

    public int hashCode() {
        return (this.f18328a * 31) + Arrays.hashCode(this.f18329b);
    }

    public String toString() {
        return "CBNetworkServerResponse(statusCode=" + this.f18328a + ", data=" + Arrays.toString(this.f18329b) + ')';
    }
}
