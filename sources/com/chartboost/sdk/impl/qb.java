package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public abstract class qb {

    /* renamed from: a  reason: collision with root package name */
    public final tb f18462a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18463b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18464c;

    /* renamed from: d  reason: collision with root package name */
    public final String f18465d;

    /* renamed from: e  reason: collision with root package name */
    public final Mediation f18466e;

    /* renamed from: f  reason: collision with root package name */
    public final b f18467f;

    /* renamed from: g  reason: collision with root package name */
    public ib f18468g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18469h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18470i;

    /* renamed from: j  reason: collision with root package name */
    public long f18471j;

    /* renamed from: k  reason: collision with root package name */
    public float f18472k;

    /* renamed from: l  reason: collision with root package name */
    public a f18473l;

    public enum a {
        LOW,
        HIGH
    }

    public enum b {
        INFO,
        CRITICAL,
        ERROR
    }

    public /* synthetic */ qb(tb tbVar, String str, String str2, String str3, Mediation mediation, b bVar, ib ibVar, boolean z2, boolean z3, long j2, float f2, a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(tbVar, str, str2, str3, mediation, bVar, ibVar, z2, z3, j2, f2, aVar);
    }

    public final String a() {
        return this.f18464c;
    }

    public final void b(boolean z2) {
        this.f18470i = z2;
    }

    public final String c() {
        return this.f18465d;
    }

    public final Mediation d() {
        return this.f18466e;
    }

    public final String e() {
        return this.f18463b;
    }

    public final tb f() {
        return this.f18462a;
    }

    public final a g() {
        return this.f18473l;
    }

    public final boolean h() {
        return this.f18470i;
    }

    public final long i() {
        return this.f18471j;
    }

    public final long j() {
        return ab.a(this.f18471j);
    }

    public final ib k() {
        return this.f18468g;
    }

    public final b l() {
        return this.f18467f;
    }

    public final boolean m() {
        return this.f18469h;
    }

    public String toString() {
        return "TrackingEvent(name=" + this.f18462a.getValue() + ", message='" + this.f18463b + "', impressionAdType='" + this.f18464c + "', location='" + this.f18465d + "', mediation=" + this.f18466e + ", type=" + this.f18467f + ", trackAd=" + this.f18468g + ", isLatencyEvent=" + this.f18469h + ", shouldCalculateLatency=" + this.f18470i + ", timestamp=" + this.f18471j + ", latency=" + this.f18472k + ", priority=" + this.f18473l + ", timestampInSeconds=" + j() + ')';
    }

    public qb(tb tbVar, String str, String str2, String str3, Mediation mediation, b bVar, ib ibVar, boolean z2, boolean z3, long j2, float f2, a aVar) {
        this.f18462a = tbVar;
        this.f18463b = str;
        this.f18464c = str2;
        this.f18465d = str3;
        this.f18466e = mediation;
        this.f18467f = bVar;
        this.f18468g = ibVar;
        this.f18469h = z2;
        this.f18470i = z3;
        this.f18471j = j2;
        this.f18472k = f2;
        this.f18473l = aVar;
    }

    public final void a(ib ibVar) {
        this.f18468g = ibVar;
    }

    public final float b() {
        return this.f18472k;
    }

    public final void a(boolean z2) {
        this.f18469h = z2;
    }

    public final void a(float f2) {
        this.f18472k = f2;
    }

    public final void a(a aVar) {
        Intrinsics.f(aVar, "<set-?>");
        this.f18473l = aVar;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ qb(com.chartboost.sdk.impl.tb r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, com.chartboost.sdk.Mediation r33, com.chartboost.sdk.impl.qb.b r34, com.chartboost.sdk.impl.ib r35, boolean r36, boolean r37, long r38, float r40, com.chartboost.sdk.impl.qb.a r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
        /*
            r28 = this;
            r0 = r42
            r1 = r0 & 64
            if (r1 == 0) goto L_0x001a
            com.chartboost.sdk.impl.ib r1 = new com.chartboost.sdk.impl.ib
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 255(0xff, float:3.57E-43)
            r12 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r20 = r1
            goto L_0x001c
        L_0x001a:
            r20 = r35
        L_0x001c:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0024
            r1 = 0
            r21 = 0
            goto L_0x0026
        L_0x0024:
            r21 = r36
        L_0x0026:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x002e
            r1 = 1
            r22 = 1
            goto L_0x0030
        L_0x002e:
            r22 = r37
        L_0x0030:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x003b
            long r1 = java.lang.System.currentTimeMillis()
            r23 = r1
            goto L_0x003d
        L_0x003b:
            r23 = r38
        L_0x003d:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0045
            r0 = 0
            r25 = 0
            goto L_0x0047
        L_0x0045:
            r25 = r40
        L_0x0047:
            r27 = 0
            r13 = r28
            r14 = r29
            r15 = r30
            r16 = r31
            r17 = r32
            r18 = r33
            r19 = r34
            r26 = r41
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.qb.<init>(com.chartboost.sdk.impl.tb, java.lang.String, java.lang.String, java.lang.String, com.chartboost.sdk.Mediation, com.chartboost.sdk.impl.qb$b, com.chartboost.sdk.impl.ib, boolean, boolean, long, float, com.chartboost.sdk.impl.qb$a, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
