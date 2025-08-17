package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class RtpVp8Reader implements RtpPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private final RtpPayloadFormat f27061a;

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f27062b;

    /* renamed from: c  reason: collision with root package name */
    private long f27063c = -9223372036854775807L;

    /* renamed from: d  reason: collision with root package name */
    private int f27064d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f27065e = -1;

    /* renamed from: f  reason: collision with root package name */
    private long f27066f = -9223372036854775807L;

    /* renamed from: g  reason: collision with root package name */
    private long f27067g = 0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f27068h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f27069i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f27070j;

    public RtpVp8Reader(RtpPayloadFormat rtpPayloadFormat) {
        this.f27061a = rtpPayloadFormat;
    }

    private void e() {
        long j2 = this.f27066f;
        boolean z2 = this.f27069i;
        ((TrackOutput) Assertions.e(this.f27062b)).e(j2, z2 ? 1 : 0, this.f27065e, 0, (TrackOutput.CryptoData) null);
        this.f27065e = -1;
        this.f27066f = -9223372036854775807L;
        this.f27068h = false;
    }

    private boolean f(ParsableByteArray parsableByteArray, int i2) {
        int H = parsableByteArray.H();
        if ((H & 16) == 16 && (H & 7) == 0) {
            if (this.f27068h && this.f27065e > 0) {
                e();
            }
            this.f27068h = true;
        } else if (this.f27068h) {
            int b2 = RtpPacket.b(this.f27064d);
            if (i2 < b2) {
                Log.i("RtpVP8Reader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(b2), Integer.valueOf(i2)));
                return false;
            }
        } else {
            Log.i("RtpVP8Reader", "RTP packet is not the start of a new VP8 partition, skipping.");
            return false;
        }
        if ((H & 128) != 0) {
            int H2 = parsableByteArray.H();
            if (!((H2 & 128) == 0 || (parsableByteArray.H() & 128) == 0)) {
                parsableByteArray.V(1);
            }
            if ((H2 & 64) != 0) {
                parsableByteArray.V(1);
            }
            if (!((H2 & 32) == 0 && (H2 & 16) == 0)) {
                parsableByteArray.V(1);
            }
        }
        return true;
    }

    public void a(long j2, long j3) {
        this.f27063c = j2;
        this.f27065e = -1;
        this.f27067g = j3;
    }

    public void b(ParsableByteArray parsableByteArray, long j2, int i2, boolean z2) {
        boolean z3;
        Assertions.i(this.f27062b);
        if (f(parsableByteArray, i2)) {
            if (this.f27065e == -1 && this.f27068h) {
                if ((parsableByteArray.j() & 1) == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.f27069i = z3;
            }
            if (!this.f27070j) {
                int f2 = parsableByteArray.f();
                parsableByteArray.U(f2 + 6);
                int z4 = parsableByteArray.z() & 16383;
                int z5 = parsableByteArray.z() & 16383;
                parsableByteArray.U(f2);
                Format format = this.f27061a.f26787c;
                if (!(z4 == format.f23076r && z5 == format.f23077s)) {
                    this.f27062b.d(format.b().n0(z4).S(z5).G());
                }
                this.f27070j = true;
            }
            int a2 = parsableByteArray.a();
            this.f27062b.c(parsableByteArray, a2);
            int i3 = this.f27065e;
            if (i3 == -1) {
                this.f27065e = a2;
            } else {
                this.f27065e = i3 + a2;
            }
            this.f27066f = RtpReaderUtils.a(this.f27067g, j2, this.f27063c, 90000);
            if (z2) {
                e();
            }
            this.f27064d = i2;
        }
    }

    public void c(ExtractorOutput extractorOutput, int i2) {
        TrackOutput d2 = extractorOutput.d(i2, 2);
        this.f27062b = d2;
        d2.d(this.f27061a.f26787c);
    }

    public void d(long j2, int i2) {
        boolean z2;
        if (this.f27063c == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        this.f27063c = j2;
    }
}
