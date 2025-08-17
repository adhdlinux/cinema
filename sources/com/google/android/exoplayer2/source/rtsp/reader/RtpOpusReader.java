package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.List;

final class RtpOpusReader implements RtpPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private final RtpPayloadFormat f27049a;

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f27050b;

    /* renamed from: c  reason: collision with root package name */
    private long f27051c = -1;

    /* renamed from: d  reason: collision with root package name */
    private long f27052d;

    /* renamed from: e  reason: collision with root package name */
    private int f27053e = -1;

    /* renamed from: f  reason: collision with root package name */
    private boolean f27054f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f27055g;

    public RtpOpusReader(RtpPayloadFormat rtpPayloadFormat) {
        this.f27049a = rtpPayloadFormat;
    }

    private static void e(ParsableByteArray parsableByteArray) {
        boolean z2;
        int f2 = parsableByteArray.f();
        boolean z3 = false;
        if (parsableByteArray.g() > 18) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.b(z2, "ID Header has insufficient data");
        Assertions.b(parsableByteArray.E(8).equals("OpusHead"), "ID Header missing");
        if (parsableByteArray.H() == 1) {
            z3 = true;
        }
        Assertions.b(z3, "version number must always be 1");
        parsableByteArray.U(f2);
    }

    public void a(long j2, long j3) {
        this.f27051c = j2;
        this.f27052d = j3;
    }

    public void b(ParsableByteArray parsableByteArray, long j2, int i2, boolean z2) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i3 = i2;
        Assertions.i(this.f27050b);
        if (!this.f27054f) {
            e(parsableByteArray);
            List<byte[]> a2 = OpusUtil.a(parsableByteArray.e());
            Format.Builder b2 = this.f27049a.f26787c.b();
            b2.V(a2);
            this.f27050b.d(b2.G());
            this.f27054f = true;
        } else {
            boolean z3 = false;
            if (!this.f27055g) {
                if (parsableByteArray.g() >= 8) {
                    z3 = true;
                }
                Assertions.b(z3, "Comment Header has insufficient data");
                Assertions.b(parsableByteArray2.E(8).equals("OpusTags"), "Comment Header should follow ID Header");
                this.f27055g = true;
            } else {
                int b3 = RtpPacket.b(this.f27053e);
                if (i3 != b3) {
                    Log.i("RtpOpusReader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(b3), Integer.valueOf(i2)));
                }
                int a3 = parsableByteArray.a();
                this.f27050b.c(parsableByteArray2, a3);
                this.f27050b.e(RtpReaderUtils.a(this.f27052d, j2, this.f27051c, 48000), 1, a3, 0, (TrackOutput.CryptoData) null);
            }
        }
        this.f27053e = i3;
    }

    public void c(ExtractorOutput extractorOutput, int i2) {
        TrackOutput d2 = extractorOutput.d(i2, 1);
        this.f27050b = d2;
        d2.d(this.f27049a.f26787c);
    }

    public void d(long j2, int i2) {
        this.f27051c = j2;
    }
}
