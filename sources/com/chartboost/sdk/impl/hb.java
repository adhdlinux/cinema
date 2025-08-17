package com.chartboost.sdk.impl;

import b0.y;

public final class hb {

    /* renamed from: a  reason: collision with root package name */
    public final long f17871a;

    /* renamed from: b  reason: collision with root package name */
    public final long f17872b;

    /* renamed from: c  reason: collision with root package name */
    public final long f17873c;

    public hb(long j2, long j3, long j4) {
        this.f17871a = j2;
        this.f17872b = j3;
        this.f17873c = j4;
    }

    public final long a() {
        return this.f17871a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hb)) {
            return false;
        }
        hb hbVar = (hb) obj;
        return this.f17871a == hbVar.f17871a && this.f17872b == hbVar.f17872b && this.f17873c == hbVar.f17873c;
    }

    public int hashCode() {
        return (((y.a(this.f17871a) * 31) + y.a(this.f17872b)) * 31) + y.a(this.f17873c);
    }

    public String toString() {
        return "TimeSourceBodyFields(currentTimeMillis=" + this.f17871a + ", nanoTime=" + this.f17872b + ", uptimeMillis=" + this.f17873c + ')';
    }
}
