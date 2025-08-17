package com.chartboost.sdk.impl;

import b0.y;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class j8 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f17985a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f17986b;

    /* renamed from: c  reason: collision with root package name */
    public int f17987c;

    /* renamed from: d  reason: collision with root package name */
    public int f17988d;

    /* renamed from: e  reason: collision with root package name */
    public long f17989e;

    /* renamed from: f  reason: collision with root package name */
    public int f17990f;

    /* renamed from: g  reason: collision with root package name */
    public List f17991g;

    public j8(boolean z2, boolean z3, int i2, int i3, long j2, int i4, List list) {
        this.f17985a = z2;
        this.f17986b = z3;
        this.f17987c = i2;
        this.f17988d = i3;
        this.f17989e = j2;
        this.f17990f = i4;
        this.f17991g = list;
    }

    public final int a() {
        return this.f17987c;
    }

    public final int b() {
        return this.f17988d;
    }

    public final int c() {
        return this.f17990f;
    }

    public final boolean d() {
        return this.f17986b;
    }

    public final List e() {
        return this.f17991g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j8)) {
            return false;
        }
        j8 j8Var = (j8) obj;
        return this.f17985a == j8Var.f17985a && this.f17986b == j8Var.f17986b && this.f17987c == j8Var.f17987c && this.f17988d == j8Var.f17988d && this.f17989e == j8Var.f17989e && this.f17990f == j8Var.f17990f && Intrinsics.a(this.f17991g, j8Var.f17991g);
    }

    public final long f() {
        return this.f17989e;
    }

    public final boolean g() {
        return this.f17985a;
    }

    public int hashCode() {
        boolean z2 = this.f17985a;
        boolean z3 = true;
        if (z2) {
            z2 = true;
        }
        int i2 = (z2 ? 1 : 0) * true;
        boolean z4 = this.f17986b;
        if (!z4) {
            z3 = z4;
        }
        int a2 = (((((((((i2 + (z3 ? 1 : 0)) * 31) + this.f17987c) * 31) + this.f17988d) * 31) + y.a(this.f17989e)) * 31) + this.f17990f) * 31;
        List list = this.f17991g;
        return a2 + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "OmSdkModel(isEnabled=" + this.f17985a + ", verificationEnabled=" + this.f17986b + ", minVisibleDips=" + this.f17987c + ", minVisibleDurationMs=" + this.f17988d + ", visibilityCheckIntervalMs=" + this.f17989e + ", traversalLimit=" + this.f17990f + ", verificationList=" + this.f17991g + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ j8(boolean r9, boolean r10, int r11, int r12, long r13, int r15, java.util.List r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r8 = this;
            r0 = r17 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = 0
            goto L_0x0008
        L_0x0007:
            r0 = r9
        L_0x0008:
            r2 = r17 & 2
            if (r2 == 0) goto L_0x000e
            r2 = 0
            goto L_0x000f
        L_0x000e:
            r2 = r10
        L_0x000f:
            r3 = r17 & 4
            if (r3 == 0) goto L_0x0015
            r3 = 1
            goto L_0x0016
        L_0x0015:
            r3 = r11
        L_0x0016:
            r4 = r17 & 8
            if (r4 == 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r1 = r12
        L_0x001c:
            r4 = r17 & 16
            if (r4 == 0) goto L_0x0023
            r4 = 100
            goto L_0x0024
        L_0x0023:
            r4 = r13
        L_0x0024:
            r6 = r17 & 32
            if (r6 == 0) goto L_0x002b
            r6 = 25
            goto L_0x002c
        L_0x002b:
            r6 = r15
        L_0x002c:
            r7 = r17 & 64
            if (r7 == 0) goto L_0x0032
            r7 = 0
            goto L_0x0034
        L_0x0032:
            r7 = r16
        L_0x0034:
            r9 = r8
            r10 = r0
            r11 = r2
            r12 = r3
            r13 = r1
            r14 = r4
            r16 = r6
            r17 = r7
            r9.<init>(r10, r11, r12, r13, r14, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.j8.<init>(boolean, boolean, int, int, long, int, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
