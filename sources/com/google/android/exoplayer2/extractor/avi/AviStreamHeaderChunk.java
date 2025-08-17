package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class AviStreamHeaderChunk implements AviChunk {

    /* renamed from: a  reason: collision with root package name */
    public final int f24320a;

    /* renamed from: b  reason: collision with root package name */
    public final int f24321b;

    /* renamed from: c  reason: collision with root package name */
    public final int f24322c;

    /* renamed from: d  reason: collision with root package name */
    public final int f24323d;

    /* renamed from: e  reason: collision with root package name */
    public final int f24324e;

    /* renamed from: f  reason: collision with root package name */
    public final int f24325f;

    private AviStreamHeaderChunk(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f24320a = i2;
        this.f24321b = i3;
        this.f24322c = i4;
        this.f24323d = i5;
        this.f24324e = i6;
        this.f24325f = i7;
    }

    public static AviStreamHeaderChunk c(ParsableByteArray parsableByteArray) {
        int u2 = parsableByteArray.u();
        parsableByteArray.V(12);
        int u3 = parsableByteArray.u();
        int u4 = parsableByteArray.u();
        int u5 = parsableByteArray.u();
        parsableByteArray.V(4);
        int u6 = parsableByteArray.u();
        int u7 = parsableByteArray.u();
        parsableByteArray.V(8);
        return new AviStreamHeaderChunk(u2, u3, u4, u5, u6, u7);
    }

    public long a() {
        return Util.R0((long) this.f24324e, ((long) this.f24322c) * 1000000, (long) this.f24323d);
    }

    public int b() {
        int i2 = this.f24320a;
        if (i2 == 1935960438) {
            return 2;
        }
        if (i2 == 1935963489) {
            return 1;
        }
        if (i2 == 1937012852) {
            return 3;
        }
        Log.i("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(this.f24320a));
        return -1;
    }

    public int getType() {
        return 1752331379;
    }
}
