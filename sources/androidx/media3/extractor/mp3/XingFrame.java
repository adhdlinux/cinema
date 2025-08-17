package androidx.media3.extractor.mp3;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.MpegAudioUtil;

final class XingFrame {

    /* renamed from: a  reason: collision with root package name */
    public final MpegAudioUtil.Header f8511a;

    /* renamed from: b  reason: collision with root package name */
    public final long f8512b;

    /* renamed from: c  reason: collision with root package name */
    public final long f8513c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8514d;

    /* renamed from: e  reason: collision with root package name */
    public final int f8515e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f8516f;

    private XingFrame(MpegAudioUtil.Header header, long j2, long j3, long[] jArr, int i2, int i3) {
        this.f8511a = new MpegAudioUtil.Header(header);
        this.f8512b = j2;
        this.f8513c = j3;
        this.f8516f = jArr;
        this.f8514d = i2;
        this.f8515e = i3;
    }

    public static XingFrame b(MpegAudioUtil.Header header, ParsableByteArray parsableByteArray) {
        int i2;
        long j2;
        long[] jArr;
        int i3;
        int i4;
        int q2 = parsableByteArray.q();
        if ((q2 & 1) != 0) {
            i2 = parsableByteArray.L();
        } else {
            i2 = -1;
        }
        if ((q2 & 2) != 0) {
            j2 = parsableByteArray.J();
        } else {
            j2 = -1;
        }
        long j3 = j2;
        if ((q2 & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i5 = 0; i5 < 100; i5++) {
                jArr2[i5] = (long) parsableByteArray.H();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((q2 & 8) != 0) {
            parsableByteArray.V(4);
        }
        if (parsableByteArray.a() >= 24) {
            parsableByteArray.V(21);
            int K = parsableByteArray.K();
            i3 = K & 4095;
            i4 = (16773120 & K) >> 12;
        } else {
            i4 = -1;
            i3 = -1;
        }
        return new XingFrame(header, (long) i2, j3, jArr, i4, i3);
    }

    public long a() {
        long j2 = this.f8512b;
        if (j2 == -1 || j2 == 0) {
            return -9223372036854775807L;
        }
        MpegAudioUtil.Header header = this.f8511a;
        return Util.b1((j2 * ((long) header.f8068g)) - 1, header.f8065d);
    }
}
