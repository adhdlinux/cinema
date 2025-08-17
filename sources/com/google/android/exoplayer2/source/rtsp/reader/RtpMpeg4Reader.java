package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Bytes;

final class RtpMpeg4Reader implements RtpPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private final RtpPayloadFormat f27042a;

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f27043b;

    /* renamed from: c  reason: collision with root package name */
    private int f27044c;

    /* renamed from: d  reason: collision with root package name */
    private long f27045d = -9223372036854775807L;

    /* renamed from: e  reason: collision with root package name */
    private int f27046e = -1;

    /* renamed from: f  reason: collision with root package name */
    private long f27047f;

    /* renamed from: g  reason: collision with root package name */
    private int f27048g;

    public RtpMpeg4Reader(RtpPayloadFormat rtpPayloadFormat) {
        this.f27042a = rtpPayloadFormat;
    }

    private static int e(ParsableByteArray parsableByteArray) {
        int a2 = Bytes.a(parsableByteArray.e(), new byte[]{0, 0, 1, -74});
        if (a2 == -1) {
            return 0;
        }
        parsableByteArray.U(a2 + 4);
        if ((parsableByteArray.j() >> 6) == 0) {
            return 1;
        }
        return 0;
    }

    public void a(long j2, long j3) {
        this.f27045d = j2;
        this.f27047f = j3;
        this.f27048g = 0;
    }

    public void b(ParsableByteArray parsableByteArray, long j2, int i2, boolean z2) {
        int b2;
        int i3 = i2;
        Assertions.i(this.f27043b);
        int i4 = this.f27046e;
        if (!(i4 == -1 || i3 == (b2 = RtpPacket.b(i4)))) {
            Log.i("RtpMpeg4Reader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(b2), Integer.valueOf(i2)));
        }
        int a2 = parsableByteArray.a();
        this.f27043b.c(parsableByteArray, a2);
        if (this.f27048g == 0) {
            this.f27044c = e(parsableByteArray);
        }
        this.f27048g += a2;
        if (z2) {
            long j3 = j2;
            if (this.f27045d == -9223372036854775807L) {
                this.f27045d = j3;
            }
            this.f27043b.e(RtpReaderUtils.a(this.f27047f, j2, this.f27045d, 90000), this.f27044c, this.f27048g, 0, (TrackOutput.CryptoData) null);
            this.f27048g = 0;
        }
        this.f27046e = i3;
    }

    public void c(ExtractorOutput extractorOutput, int i2) {
        TrackOutput d2 = extractorOutput.d(i2, 2);
        this.f27043b = d2;
        ((TrackOutput) Util.j(d2)).d(this.f27042a.f26787c);
    }

    public void d(long j2, int i2) {
    }
}
