package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class RtpAmrReader implements RtpPayloadReader {

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f26995h = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f26996i = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};

    /* renamed from: a  reason: collision with root package name */
    private final RtpPayloadFormat f26997a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f26998b;

    /* renamed from: c  reason: collision with root package name */
    private final int f26999c;

    /* renamed from: d  reason: collision with root package name */
    private TrackOutput f27000d;

    /* renamed from: e  reason: collision with root package name */
    private long f27001e = -9223372036854775807L;

    /* renamed from: f  reason: collision with root package name */
    private long f27002f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f27003g = -1;

    public RtpAmrReader(RtpPayloadFormat rtpPayloadFormat) {
        this.f26997a = rtpPayloadFormat;
        this.f26998b = "audio/amr-wb".equals(Assertions.e(rtpPayloadFormat.f26787c.f23071m));
        this.f26999c = rtpPayloadFormat.f26786b;
    }

    public static int e(int i2, boolean z2) {
        boolean z3;
        String str;
        if ((i2 < 0 || i2 > 8) && i2 != 15) {
            z3 = false;
        } else {
            z3 = true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        if (z2) {
            str = "WB";
        } else {
            str = "NB";
        }
        sb.append(str);
        sb.append(" frame type ");
        sb.append(i2);
        Assertions.b(z3, sb.toString());
        if (z2) {
            return f26996i[i2];
        }
        return f26995h[i2];
    }

    public void a(long j2, long j3) {
        this.f27001e = j2;
        this.f27002f = j3;
    }

    public void b(ParsableByteArray parsableByteArray, long j2, int i2, boolean z2) {
        int b2;
        Assertions.i(this.f27000d);
        int i3 = this.f27003g;
        boolean z3 = false;
        if (!(i3 == -1 || i2 == (b2 = RtpPacket.b(i3)))) {
            Log.i("RtpAmrReader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(b2), Integer.valueOf(i2)));
        }
        parsableByteArray.V(1);
        int e2 = e((parsableByteArray.j() >> 3) & 15, this.f26998b);
        int a2 = parsableByteArray.a();
        if (a2 == e2) {
            z3 = true;
        }
        Assertions.b(z3, "compound payload not supported currently");
        this.f27000d.c(parsableByteArray, a2);
        this.f27000d.e(RtpReaderUtils.a(this.f27002f, j2, this.f27001e, this.f26999c), 1, a2, 0, (TrackOutput.CryptoData) null);
        this.f27003g = i2;
    }

    public void c(ExtractorOutput extractorOutput, int i2) {
        TrackOutput d2 = extractorOutput.d(i2, 1);
        this.f27000d = d2;
        d2.d(this.f26997a.f26787c);
    }

    public void d(long j2, int i2) {
        this.f27001e = j2;
    }
}
