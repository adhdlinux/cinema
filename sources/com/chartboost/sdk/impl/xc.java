package com.chartboost.sdk.impl;

import b0.y;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class xc {

    /* renamed from: i  reason: collision with root package name */
    public static final a f18983i = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final long f18984a;

    /* renamed from: b  reason: collision with root package name */
    public final int f18985b;

    /* renamed from: c  reason: collision with root package name */
    public final int f18986c;

    /* renamed from: d  reason: collision with root package name */
    public final long f18987d;

    /* renamed from: e  reason: collision with root package name */
    public final long f18988e;

    /* renamed from: f  reason: collision with root package name */
    public final long f18989f;

    /* renamed from: g  reason: collision with root package name */
    public final int f18990g;

    /* renamed from: h  reason: collision with root package name */
    public final b f18991h;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final xc a(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            Intrinsics.f(jSONObject2, "config");
            long optLong = jSONObject2.optLong("maxBytes", 52428800);
            int optInt = jSONObject2.optInt("maxUnitsPerTimeWindow", 10);
            int optInt2 = jSONObject2.optInt("maxUnitsPerTimeWindowCellular", 10);
            long optLong2 = jSONObject2.optLong("timeWindow", 18000);
            long optLong3 = jSONObject2.optLong("timeWindowCellular", 18000);
            long optLong4 = jSONObject2.optLong("ttl", 604800);
            int optInt3 = jSONObject2.optInt("bufferSize", 3);
            String optString = jSONObject2.optString("videoPlayer", yc.f19105a);
            b.a aVar = b.f18992c;
            Intrinsics.e(optString, "it");
            return new xc(optLong, optInt, optInt2, optLong2, optLong3, optLong4, optInt3, aVar.a(optString));
        }

        public a() {
        }
    }

    public enum b {
        EXO_PLAYER("exoplayer"),
        MEDIA_PLAYER("mediaplayer");
        

        /* renamed from: c  reason: collision with root package name */
        public static final a f18992c = null;

        /* renamed from: b  reason: collision with root package name */
        public final String f18996b;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final b a(String str) {
                b bVar;
                Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
                b[] values = b.values();
                int length = values.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        bVar = null;
                        break;
                    }
                    bVar = values[i2];
                    if (Intrinsics.a(bVar.b(), str)) {
                        break;
                    }
                    i2++;
                }
                if (bVar == null) {
                    return b.EXO_PLAYER;
                }
                return bVar;
            }

            public a() {
            }
        }

        static {
            f18992c = new a((DefaultConstructorMarker) null);
        }

        /* access modifiers changed from: public */
        b(String str) {
            this.f18996b = str;
        }

        public final String b() {
            return this.f18996b;
        }
    }

    public xc(long j2, int i2, int i3, long j3, long j4, long j5, int i4, b bVar) {
        Intrinsics.f(bVar, "videoPlayer");
        this.f18984a = j2;
        this.f18985b = i2;
        this.f18986c = i3;
        this.f18987d = j3;
        this.f18988e = j4;
        this.f18989f = j5;
        this.f18990g = i4;
        this.f18991h = bVar;
    }

    public static final xc a(JSONObject jSONObject) {
        return f18983i.a(jSONObject);
    }

    public final long b() {
        return this.f18984a;
    }

    public final int c() {
        return this.f18985b;
    }

    public final int d() {
        return this.f18986c;
    }

    public final long e() {
        return this.f18987d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xc)) {
            return false;
        }
        xc xcVar = (xc) obj;
        return this.f18984a == xcVar.f18984a && this.f18985b == xcVar.f18985b && this.f18986c == xcVar.f18986c && this.f18987d == xcVar.f18987d && this.f18988e == xcVar.f18988e && this.f18989f == xcVar.f18989f && this.f18990g == xcVar.f18990g && this.f18991h == xcVar.f18991h;
    }

    public final long f() {
        return this.f18988e;
    }

    public final long g() {
        return this.f18989f;
    }

    public final b h() {
        return this.f18991h;
    }

    public int hashCode() {
        return (((((((((((((y.a(this.f18984a) * 31) + this.f18985b) * 31) + this.f18986c) * 31) + y.a(this.f18987d)) * 31) + y.a(this.f18988e)) * 31) + y.a(this.f18989f)) * 31) + this.f18990g) * 31) + this.f18991h.hashCode();
    }

    public String toString() {
        return "VideoPreCachingModel(maxBytes=" + this.f18984a + ", maxUnitsPerTimeWindow=" + this.f18985b + ", maxUnitsPerTimeWindowCellular=" + this.f18986c + ", timeWindow=" + this.f18987d + ", timeWindowCellular=" + this.f18988e + ", ttl=" + this.f18989f + ", bufferSize=" + this.f18990g + ", videoPlayer=" + this.f18991h + ')';
    }

    public final int a() {
        return this.f18990g;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ xc(long r13, int r15, int r16, long r17, long r19, long r21, int r23, com.chartboost.sdk.impl.xc.b r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r12 = this;
            r0 = r25
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000a
            r1 = 52428800(0x3200000, double:2.5903269E-316)
            goto L_0x000b
        L_0x000a:
            r1 = r13
        L_0x000b:
            r3 = r0 & 2
            r4 = 10
            if (r3 == 0) goto L_0x0014
            r3 = 10
            goto L_0x0015
        L_0x0014:
            r3 = r15
        L_0x0015:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r4 = r16
        L_0x001c:
            r5 = r0 & 8
            r6 = 18000(0x4650, double:8.893E-320)
            if (r5 == 0) goto L_0x0024
            r8 = r6
            goto L_0x0026
        L_0x0024:
            r8 = r17
        L_0x0026:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r6 = r19
        L_0x002d:
            r5 = r0 & 32
            if (r5 == 0) goto L_0x0035
            r10 = 604800(0x93a80, double:2.98811E-318)
            goto L_0x0037
        L_0x0035:
            r10 = r21
        L_0x0037:
            r5 = r0 & 64
            if (r5 == 0) goto L_0x003d
            r5 = 3
            goto L_0x003f
        L_0x003d:
            r5 = r23
        L_0x003f:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0046
            com.chartboost.sdk.impl.xc$b r0 = com.chartboost.sdk.impl.xc.b.EXO_PLAYER
            goto L_0x0048
        L_0x0046:
            r0 = r24
        L_0x0048:
            r13 = r12
            r14 = r1
            r16 = r3
            r17 = r4
            r18 = r8
            r20 = r6
            r22 = r10
            r24 = r5
            r25 = r0
            r13.<init>(r14, r16, r17, r18, r20, r22, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.xc.<init>(long, int, int, long, long, long, int, com.chartboost.sdk.impl.xc$b, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
