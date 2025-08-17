package androidx.media3.extractor.avi;

import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;

final class AviStreamHeaderChunk implements AviChunk {

    /* renamed from: a  reason: collision with root package name */
    public final int f8164a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8165b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8166c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8167d;

    /* renamed from: e  reason: collision with root package name */
    public final int f8168e;

    /* renamed from: f  reason: collision with root package name */
    public final int f8169f;

    private AviStreamHeaderChunk(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f8164a = i2;
        this.f8165b = i3;
        this.f8166c = i4;
        this.f8167d = i5;
        this.f8168e = i6;
        this.f8169f = i7;
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
        return Util.c1((long) this.f8168e, ((long) this.f8166c) * 1000000, (long) this.f8167d);
    }

    public int b() {
        int i2 = this.f8164a;
        if (i2 == 1935960438) {
            return 2;
        }
        if (i2 == 1935963489) {
            return 1;
        }
        if (i2 == 1937012852) {
            return 3;
        }
        Log.h("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(this.f8164a));
        return -1;
    }

    public int getType() {
        return 1752331379;
    }
}
