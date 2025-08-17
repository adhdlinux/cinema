package com.chartboost.sdk.impl;

import kotlin.jvm.internal.Intrinsics;

public final class t9 {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f18639a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f18640b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18641c;

    /* renamed from: d  reason: collision with root package name */
    public final h8 f18642d;

    public t9(Integer num, Integer num2, String str, h8 h8Var) {
        Intrinsics.f(h8Var, "openRTBConnectionType");
        this.f18639a = num;
        this.f18640b = num2;
        this.f18641c = str;
        this.f18642d = h8Var;
    }

    public final Integer a() {
        return this.f18639a;
    }

    public final Integer b() {
        return this.f18640b;
    }

    public final String c() {
        return this.f18641c;
    }

    public final h8 d() {
        return this.f18642d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t9)) {
            return false;
        }
        t9 t9Var = (t9) obj;
        return Intrinsics.a(this.f18639a, t9Var.f18639a) && Intrinsics.a(this.f18640b, t9Var.f18640b) && Intrinsics.a(this.f18641c, t9Var.f18641c) && this.f18642d == t9Var.f18642d;
    }

    public int hashCode() {
        Integer num = this.f18639a;
        int i2 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.f18640b;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.f18641c;
        if (str != null) {
            i2 = str.hashCode();
        }
        return ((hashCode2 + i2) * 31) + this.f18642d.hashCode();
    }

    public String toString() {
        return "ReachabilityBodyFields(cellularConnectionType=" + this.f18639a + ", connectionTypeFromActiveNetwork=" + this.f18640b + ", detailedConnectionType=" + this.f18641c + ", openRTBConnectionType=" + this.f18642d + ')';
    }
}
