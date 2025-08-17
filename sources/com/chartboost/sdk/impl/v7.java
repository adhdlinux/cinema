package com.chartboost.sdk.impl;

import b0.y;
import com.chartboost.sdk.internal.Model.CBError;
import kotlin.jvm.internal.Intrinsics;

public final class v7 {

    /* renamed from: a  reason: collision with root package name */
    public final b1 f18850a;

    /* renamed from: b  reason: collision with root package name */
    public final v f18851b;

    /* renamed from: c  reason: collision with root package name */
    public final CBError f18852c;

    /* renamed from: d  reason: collision with root package name */
    public final long f18853d;

    /* renamed from: e  reason: collision with root package name */
    public final long f18854e;

    public v7(b1 b1Var, v vVar, CBError cBError, long j2, long j3) {
        Intrinsics.f(b1Var, "appRequest");
        this.f18850a = b1Var;
        this.f18851b = vVar;
        this.f18852c = cBError;
        this.f18853d = j2;
        this.f18854e = j3;
    }

    public final v a() {
        return this.f18851b;
    }

    public final CBError b() {
        return this.f18852c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v7)) {
            return false;
        }
        v7 v7Var = (v7) obj;
        return Intrinsics.a(this.f18850a, v7Var.f18850a) && Intrinsics.a(this.f18851b, v7Var.f18851b) && Intrinsics.a(this.f18852c, v7Var.f18852c) && this.f18853d == v7Var.f18853d && this.f18854e == v7Var.f18854e;
    }

    public int hashCode() {
        int hashCode = this.f18850a.hashCode() * 31;
        v vVar = this.f18851b;
        int i2 = 0;
        int hashCode2 = (hashCode + (vVar == null ? 0 : vVar.hashCode())) * 31;
        CBError cBError = this.f18852c;
        if (cBError != null) {
            i2 = cBError.hashCode();
        }
        return ((((hashCode2 + i2) * 31) + y.a(this.f18853d)) * 31) + y.a(this.f18854e);
    }

    public String toString() {
        return "LoadResult(appRequest=" + this.f18850a + ", adUnit=" + this.f18851b + ", error=" + this.f18852c + ", requestResponseCodeNs=" + this.f18853d + ", readDataNs=" + this.f18854e + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ v7(com.chartboost.sdk.impl.b1 r8, com.chartboost.sdk.impl.v r9, com.chartboost.sdk.internal.Model.CBError r10, long r11, long r13, int r15, kotlin.jvm.internal.DefaultConstructorMarker r16) {
        /*
            r7 = this;
            r0 = r15 & 2
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r9
        L_0x0008:
            r2 = r15 & 4
            if (r2 == 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            r1 = r10
        L_0x000e:
            r2 = r15 & 8
            r3 = 0
            if (r2 == 0) goto L_0x0016
            r5 = r3
            goto L_0x0017
        L_0x0016:
            r5 = r11
        L_0x0017:
            r2 = r15 & 16
            if (r2 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r3 = r13
        L_0x001d:
            r9 = r7
            r10 = r8
            r11 = r0
            r12 = r1
            r13 = r5
            r15 = r3
            r9.<init>(r10, r11, r12, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.v7.<init>(com.chartboost.sdk.impl.b1, com.chartboost.sdk.impl.v, com.chartboost.sdk.internal.Model.CBError, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
