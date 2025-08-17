package com.chartboost.sdk.impl;

public final class o4 {

    /* renamed from: a  reason: collision with root package name */
    public final int f18287a;

    /* renamed from: b  reason: collision with root package name */
    public final int f18288b;

    public o4(int i2, int i3) {
        this.f18287a = i2;
        this.f18288b = i3;
    }

    public final int a() {
        return this.f18288b;
    }

    public final int b() {
        return this.f18287a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o4)) {
            return false;
        }
        o4 o4Var = (o4) obj;
        return this.f18287a == o4Var.f18287a && this.f18288b == o4Var.f18288b;
    }

    public int hashCode() {
        return (this.f18287a * 31) + this.f18288b;
    }

    public String toString() {
        return "DisplaySize(width=" + this.f18287a + ", height=" + this.f18288b + ')';
    }
}
