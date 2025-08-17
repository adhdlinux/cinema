package com.google.android.exoplayer2.source.rtsp.reader;

import android.util.Log;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class RtpPcmReader implements RtpPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private final RtpPayloadFormat f27056a;

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f27057b;

    /* renamed from: c  reason: collision with root package name */
    private long f27058c = -9223372036854775807L;

    /* renamed from: d  reason: collision with root package name */
    private long f27059d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f27060e = -1;

    public RtpPcmReader(RtpPayloadFormat rtpPayloadFormat) {
        this.f27056a = rtpPayloadFormat;
    }

    public void a(long j2, long j3) {
        this.f27058c = j2;
        this.f27059d = j3;
    }

    public void b(ParsableByteArray parsableByteArray, long j2, int i2, boolean z2) {
        int b2;
        int i3 = i2;
        Assertions.e(this.f27057b);
        int i4 = this.f27060e;
        if (!(i4 == -1 || i3 == (b2 = RtpPacket.b(i4)))) {
            Log.w("RtpPcmReader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(b2), Integer.valueOf(i2)));
        }
        long a2 = RtpReaderUtils.a(this.f27059d, j2, this.f27058c, this.f27056a.f26786b);
        int a3 = parsableByteArray.a();
        this.f27057b.c(parsableByteArray, a3);
        this.f27057b.e(a2, 1, a3, 0, (TrackOutput.CryptoData) null);
        this.f27060e = i3;
    }

    public void c(ExtractorOutput extractorOutput, int i2) {
        TrackOutput d2 = extractorOutput.d(i2, 1);
        this.f27057b = d2;
        d2.d(this.f27056a.f26787c);
    }

    public void d(long j2, int i2) {
        this.f27058c = j2;
    }
}
