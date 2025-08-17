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

final class RtpVp9Reader implements RtpPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private final RtpPayloadFormat f27071a;

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f27072b;

    /* renamed from: c  reason: collision with root package name */
    private long f27073c = -9223372036854775807L;

    /* renamed from: d  reason: collision with root package name */
    private long f27074d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f27075e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f27076f = -1;

    /* renamed from: g  reason: collision with root package name */
    private long f27077g = -9223372036854775807L;

    /* renamed from: h  reason: collision with root package name */
    private int f27078h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f27079i = -1;

    /* renamed from: j  reason: collision with root package name */
    private boolean f27080j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f27081k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f27082l;

    public RtpVp9Reader(RtpPayloadFormat rtpPayloadFormat) {
        this.f27071a = rtpPayloadFormat;
    }

    private void e() {
        long j2 = this.f27077g;
        boolean z2 = this.f27082l;
        ((TrackOutput) Assertions.e(this.f27072b)).e(j2, z2 ? 1 : 0, this.f27076f, 0, (TrackOutput.CryptoData) null);
        this.f27076f = -1;
        this.f27077g = -9223372036854775807L;
        this.f27080j = false;
    }

    private boolean f(ParsableByteArray parsableByteArray, int i2) {
        boolean z2;
        int H = parsableByteArray.H();
        if ((H & 8) == 8) {
            if (this.f27080j && this.f27076f > 0) {
                e();
            }
            this.f27080j = true;
        } else if (this.f27080j) {
            int b2 = RtpPacket.b(this.f27075e);
            if (i2 < b2) {
                Log.i("RtpVp9Reader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(b2), Integer.valueOf(i2)));
                return false;
            }
        } else {
            Log.i("RtpVp9Reader", "First payload octet of the RTP packet is not the beginning of a new VP9 partition, Dropping current packet.");
            return false;
        }
        if ((H & 128) != 0 && (parsableByteArray.H() & 128) != 0 && parsableByteArray.a() < 1) {
            return false;
        }
        int i3 = H & 16;
        if (i3 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.b(z2, "VP9 flexible mode is not supported.");
        if ((H & 32) != 0) {
            parsableByteArray.V(1);
            if (parsableByteArray.a() < 1) {
                return false;
            }
            if (i3 == 0) {
                parsableByteArray.V(1);
            }
        }
        if ((H & 2) != 0) {
            int H2 = parsableByteArray.H();
            int i4 = (H2 >> 5) & 7;
            if ((H2 & 16) != 0) {
                int i5 = i4 + 1;
                if (parsableByteArray.a() < i5 * 4) {
                    return false;
                }
                for (int i6 = 0; i6 < i5; i6++) {
                    this.f27078h = parsableByteArray.N();
                    this.f27079i = parsableByteArray.N();
                }
            }
            if ((H2 & 8) != 0) {
                int H3 = parsableByteArray.H();
                if (parsableByteArray.a() < H3) {
                    return false;
                }
                for (int i7 = 0; i7 < H3; i7++) {
                    int N = (parsableByteArray.N() & 12) >> 2;
                    if (parsableByteArray.a() < N) {
                        return false;
                    }
                    parsableByteArray.V(N);
                }
            }
        }
        return true;
    }

    public void a(long j2, long j3) {
        this.f27073c = j2;
        this.f27076f = -1;
        this.f27074d = j3;
    }

    public void b(ParsableByteArray parsableByteArray, long j2, int i2, boolean z2) {
        int i3;
        int i4;
        boolean z3;
        Assertions.i(this.f27072b);
        if (f(parsableByteArray, i2)) {
            if (this.f27076f == -1 && this.f27080j) {
                if ((parsableByteArray.j() & 4) == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.f27082l = z3;
            }
            if (!(this.f27081k || (i3 = this.f27078h) == -1 || (i4 = this.f27079i) == -1)) {
                Format format = this.f27071a.f26787c;
                if (!(i3 == format.f23076r && i4 == format.f23077s)) {
                    this.f27072b.d(format.b().n0(this.f27078h).S(this.f27079i).G());
                }
                this.f27081k = true;
            }
            int a2 = parsableByteArray.a();
            this.f27072b.c(parsableByteArray, a2);
            int i5 = this.f27076f;
            if (i5 == -1) {
                this.f27076f = a2;
            } else {
                this.f27076f = i5 + a2;
            }
            this.f27077g = RtpReaderUtils.a(this.f27074d, j2, this.f27073c, 90000);
            if (z2) {
                e();
            }
            this.f27075e = i2;
        }
    }

    public void c(ExtractorOutput extractorOutput, int i2) {
        TrackOutput d2 = extractorOutput.d(i2, 2);
        this.f27072b = d2;
        d2.d(this.f27071a.f26787c);
    }

    public void d(long j2, int i2) {
        boolean z2;
        if (this.f27073c == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        this.f27073c = j2;
    }
}
