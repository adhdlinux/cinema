package com.google.android.exoplayer2.source.rtsp.reader;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class RtpAc3Reader implements RtpPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private final RtpPayloadFormat f26988a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableBitArray f26989b = new ParsableBitArray();

    /* renamed from: c  reason: collision with root package name */
    private TrackOutput f26990c;

    /* renamed from: d  reason: collision with root package name */
    private int f26991d;

    /* renamed from: e  reason: collision with root package name */
    private long f26992e = -9223372036854775807L;

    /* renamed from: f  reason: collision with root package name */
    private long f26993f;

    /* renamed from: g  reason: collision with root package name */
    private long f26994g;

    public RtpAc3Reader(RtpPayloadFormat rtpPayloadFormat) {
        this.f26988a = rtpPayloadFormat;
    }

    private void e() {
        if (this.f26991d > 0) {
            f();
        }
    }

    private void f() {
        ((TrackOutput) Util.j(this.f26990c)).e(this.f26993f, 1, this.f26991d, 0, (TrackOutput.CryptoData) null);
        this.f26991d = 0;
    }

    private void g(ParsableByteArray parsableByteArray, boolean z2, int i2, long j2) {
        int a2 = parsableByteArray.a();
        ((TrackOutput) Assertions.e(this.f26990c)).c(parsableByteArray, a2);
        this.f26991d += a2;
        this.f26993f = j2;
        if (z2 && i2 == 3) {
            f();
        }
    }

    private void h(ParsableByteArray parsableByteArray, int i2, long j2) {
        this.f26989b.n(parsableByteArray.e());
        this.f26989b.s(2);
        for (int i3 = 0; i3 < i2; i3++) {
            Ac3Util.SyncFrameInfo f2 = Ac3Util.f(this.f26989b);
            ((TrackOutput) Assertions.e(this.f26990c)).c(parsableByteArray, f2.f23646e);
            ((TrackOutput) Util.j(this.f26990c)).e(j2, 1, f2.f23646e, 0, (TrackOutput.CryptoData) null);
            j2 += ((long) (f2.f23647f / f2.f23644c)) * 1000000;
            this.f26989b.s(f2.f23646e);
        }
    }

    private void i(ParsableByteArray parsableByteArray, long j2) {
        int a2 = parsableByteArray.a();
        ((TrackOutput) Assertions.e(this.f26990c)).c(parsableByteArray, a2);
        ((TrackOutput) Util.j(this.f26990c)).e(j2, 1, a2, 0, (TrackOutput.CryptoData) null);
    }

    public void a(long j2, long j3) {
        this.f26992e = j2;
        this.f26994g = j3;
    }

    public void b(ParsableByteArray parsableByteArray, long j2, int i2, boolean z2) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int H = parsableByteArray.H() & 3;
        int H2 = parsableByteArray.H() & JfifUtil.MARKER_FIRST_BYTE;
        long a2 = RtpReaderUtils.a(this.f26994g, j2, this.f26992e, this.f26988a.f26786b);
        if (H != 0) {
            if (H == 1 || H == 2) {
                e();
            } else if (H != 3) {
                throw new IllegalArgumentException(String.valueOf(H));
            }
            g(parsableByteArray, z2, H, a2);
            return;
        }
        e();
        if (H2 == 1) {
            i(parsableByteArray, a2);
        } else {
            h(parsableByteArray, H2, a2);
        }
    }

    public void c(ExtractorOutput extractorOutput, int i2) {
        TrackOutput d2 = extractorOutput.d(i2, 1);
        this.f26990c = d2;
        d2.d(this.f26988a.f26787c);
    }

    public void d(long j2, int i2) {
        boolean z2;
        if (this.f26992e == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        this.f26992e = j2;
    }
}
