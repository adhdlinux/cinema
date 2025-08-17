package com.chartboost.sdk.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class ob {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f18299a;

    /* renamed from: b  reason: collision with root package name */
    public final List f18300b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18301c;

    /* renamed from: d  reason: collision with root package name */
    public final int f18302d;

    /* renamed from: e  reason: collision with root package name */
    public final int f18303e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f18304f;

    /* renamed from: g  reason: collision with root package name */
    public final int f18305g;

    public ob(boolean z2, List list, String str, int i2, int i3, boolean z3, int i4) {
        Intrinsics.f(list, "blackList");
        Intrinsics.f(str, "endpoint");
        this.f18299a = z2;
        this.f18300b = list;
        this.f18301c = str;
        this.f18302d = i2;
        this.f18303e = i3;
        this.f18304f = z3;
        this.f18305g = i4;
    }

    public final List a() {
        return this.f18300b;
    }

    public final String b() {
        return this.f18301c;
    }

    public final int c() {
        return this.f18302d;
    }

    public final boolean d() {
        return this.f18304f;
    }

    public final int e() {
        return this.f18305g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ob)) {
            return false;
        }
        ob obVar = (ob) obj;
        return this.f18299a == obVar.f18299a && Intrinsics.a(this.f18300b, obVar.f18300b) && Intrinsics.a(this.f18301c, obVar.f18301c) && this.f18302d == obVar.f18302d && this.f18303e == obVar.f18303e && this.f18304f == obVar.f18304f && this.f18305g == obVar.f18305g;
    }

    public final int f() {
        return this.f18303e;
    }

    public final boolean g() {
        return this.f18299a;
    }

    public int hashCode() {
        boolean z2 = this.f18299a;
        boolean z3 = true;
        if (z2) {
            z2 = true;
        }
        int hashCode = (((((((((z2 ? 1 : 0) * true) + this.f18300b.hashCode()) * 31) + this.f18301c.hashCode()) * 31) + this.f18302d) * 31) + this.f18303e) * 31;
        boolean z4 = this.f18304f;
        if (!z4) {
            z3 = z4;
        }
        return ((hashCode + (z3 ? 1 : 0)) * 31) + this.f18305g;
    }

    public String toString() {
        return "TrackingConfig(isEnabled=" + this.f18299a + ", blackList=" + this.f18300b + ", endpoint=" + this.f18301c + ", eventLimit=" + this.f18302d + ", windowDuration=" + this.f18303e + ", persistenceEnabled=" + this.f18304f + ", persistenceMaxEvents=" + this.f18305g + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ob(boolean r6, java.util.List r7, java.lang.String r8, int r9, int r10, boolean r11, int r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x0005
            r6 = 0
        L_0x0005:
            r14 = r13 & 2
            if (r14 == 0) goto L_0x000d
            java.util.List r7 = com.chartboost.sdk.impl.pb.a()
        L_0x000d:
            r14 = r7
            r7 = r13 & 4
            if (r7 == 0) goto L_0x0014
            java.lang.String r8 = "https://ssp-events.chartboost.com/track/sdk"
        L_0x0014:
            r0 = r8
            r7 = r13 & 8
            if (r7 == 0) goto L_0x001e
            r9 = 10
            r1 = 10
            goto L_0x001f
        L_0x001e:
            r1 = r9
        L_0x001f:
            r7 = r13 & 16
            if (r7 == 0) goto L_0x0028
            r10 = 60
            r2 = 60
            goto L_0x0029
        L_0x0028:
            r2 = r10
        L_0x0029:
            r7 = r13 & 32
            if (r7 == 0) goto L_0x0030
            r11 = 1
            r3 = 1
            goto L_0x0031
        L_0x0030:
            r3 = r11
        L_0x0031:
            r7 = r13 & 64
            if (r7 == 0) goto L_0x003a
            r12 = 100
            r4 = 100
            goto L_0x003b
        L_0x003a:
            r4 = r12
        L_0x003b:
            r7 = r5
            r8 = r6
            r9 = r14
            r10 = r0
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.ob.<init>(boolean, java.util.List, java.lang.String, int, int, boolean, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
