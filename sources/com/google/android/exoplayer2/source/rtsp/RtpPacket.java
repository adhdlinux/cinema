package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.math.IntMath;

public final class RtpPacket {
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final byte[] f26759l = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    public final byte f26760a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f26761b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f26762c;

    /* renamed from: d  reason: collision with root package name */
    public final byte f26763d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f26764e;

    /* renamed from: f  reason: collision with root package name */
    public final byte f26765f;

    /* renamed from: g  reason: collision with root package name */
    public final int f26766g;

    /* renamed from: h  reason: collision with root package name */
    public final long f26767h;

    /* renamed from: i  reason: collision with root package name */
    public final int f26768i;

    /* renamed from: j  reason: collision with root package name */
    public final byte[] f26769j;

    /* renamed from: k  reason: collision with root package name */
    public final byte[] f26770k;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f26771a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f26772b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public byte f26773c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f26774d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public long f26775e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f26776f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public byte[] f26777g = RtpPacket.f26759l;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public byte[] f26778h = RtpPacket.f26759l;

        public RtpPacket i() {
            return new RtpPacket(this);
        }

        public Builder j(byte[] bArr) {
            Assertions.e(bArr);
            this.f26777g = bArr;
            return this;
        }

        public Builder k(boolean z2) {
            this.f26772b = z2;
            return this;
        }

        public Builder l(boolean z2) {
            this.f26771a = z2;
            return this;
        }

        public Builder m(byte[] bArr) {
            Assertions.e(bArr);
            this.f26778h = bArr;
            return this;
        }

        public Builder n(byte b2) {
            this.f26773c = b2;
            return this;
        }

        public Builder o(int i2) {
            boolean z2;
            if (i2 < 0 || i2 > 65535) {
                z2 = false;
            } else {
                z2 = true;
            }
            Assertions.a(z2);
            this.f26774d = i2 & 65535;
            return this;
        }

        public Builder p(int i2) {
            this.f26776f = i2;
            return this;
        }

        public Builder q(long j2) {
            this.f26775e = j2;
            return this;
        }
    }

    public static int b(int i2) {
        return IntMath.c(i2 + 1, 65536);
    }

    public static int c(int i2) {
        return IntMath.c(i2 - 1, 65536);
    }

    public static RtpPacket d(ParsableByteArray parsableByteArray) {
        boolean z2;
        byte[] bArr;
        if (parsableByteArray.a() < 12) {
            return null;
        }
        int H = parsableByteArray.H();
        byte b2 = (byte) (H >> 6);
        boolean z3 = true;
        if (((H >> 5) & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        byte b3 = (byte) (H & 15);
        if (b2 != 2) {
            return null;
        }
        int H2 = parsableByteArray.H();
        if (((H2 >> 7) & 1) != 1) {
            z3 = false;
        }
        byte b4 = (byte) (H2 & 127);
        int N = parsableByteArray.N();
        long J = parsableByteArray.J();
        int q2 = parsableByteArray.q();
        if (b3 > 0) {
            bArr = new byte[(b3 * 4)];
            for (int i2 = 0; i2 < b3; i2++) {
                parsableByteArray.l(bArr, i2 * 4, 4);
            }
        } else {
            bArr = f26759l;
        }
        byte[] bArr2 = new byte[parsableByteArray.a()];
        parsableByteArray.l(bArr2, 0, parsableByteArray.a());
        return new Builder().l(z2).k(z3).n(b4).o(N).q(J).p(q2).j(bArr).m(bArr2).i();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RtpPacket.class != obj.getClass()) {
            return false;
        }
        RtpPacket rtpPacket = (RtpPacket) obj;
        if (this.f26765f == rtpPacket.f26765f && this.f26766g == rtpPacket.f26766g && this.f26764e == rtpPacket.f26764e && this.f26767h == rtpPacket.f26767h && this.f26768i == rtpPacket.f26768i) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f26767h;
        return ((((((((527 + this.f26765f) * 31) + this.f26766g) * 31) + (this.f26764e ? 1 : 0)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f26768i;
    }

    public String toString() {
        return Util.C("RtpPacket(payloadType=%d, seq=%d, timestamp=%d, ssrc=%x, marker=%b)", Byte.valueOf(this.f26765f), Integer.valueOf(this.f26766g), Long.valueOf(this.f26767h), Integer.valueOf(this.f26768i), Boolean.valueOf(this.f26764e));
    }

    private RtpPacket(Builder builder) {
        this.f26760a = 2;
        this.f26761b = builder.f26771a;
        this.f26762c = false;
        this.f26764e = builder.f26772b;
        this.f26765f = builder.f26773c;
        this.f26766g = builder.f26774d;
        this.f26767h = builder.f26775e;
        this.f26768i = builder.f26776f;
        byte[] g2 = builder.f26777g;
        this.f26769j = g2;
        this.f26763d = (byte) (g2.length / 4);
        this.f26770k = builder.f26778h;
    }
}
