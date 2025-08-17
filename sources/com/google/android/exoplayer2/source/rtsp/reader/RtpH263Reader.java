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

final class RtpH263Reader implements RtpPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private final RtpPayloadFormat f27004a;

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f27005b;

    /* renamed from: c  reason: collision with root package name */
    private long f27006c = -9223372036854775807L;

    /* renamed from: d  reason: collision with root package name */
    private int f27007d;

    /* renamed from: e  reason: collision with root package name */
    private int f27008e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f27009f;

    /* renamed from: g  reason: collision with root package name */
    private int f27010g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f27011h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f27012i;

    /* renamed from: j  reason: collision with root package name */
    private long f27013j;

    /* renamed from: k  reason: collision with root package name */
    private long f27014k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f27015l;

    public RtpH263Reader(RtpPayloadFormat rtpPayloadFormat) {
        this.f27004a = rtpPayloadFormat;
    }

    private void e() {
        long j2 = this.f27014k;
        boolean z2 = this.f27011h;
        ((TrackOutput) Assertions.e(this.f27005b)).e(j2, z2 ? 1 : 0, this.f27007d, 0, (TrackOutput.CryptoData) null);
        this.f27007d = 0;
        this.f27014k = -9223372036854775807L;
        this.f27011h = false;
        this.f27015l = false;
    }

    private void f(ParsableByteArray parsableByteArray, boolean z2) {
        int f2 = parsableByteArray.f();
        boolean z3 = false;
        if (((parsableByteArray.J() >> 10) & 63) == 32) {
            int j2 = parsableByteArray.j();
            int i2 = (j2 >> 1) & 1;
            if (!z2 && i2 == 0) {
                int i3 = (j2 >> 2) & 7;
                if (i3 == 1) {
                    this.f27009f = 128;
                    this.f27010g = 96;
                } else {
                    int i4 = i3 - 2;
                    this.f27009f = 176 << i4;
                    this.f27010g = 144 << i4;
                }
            }
            parsableByteArray.U(f2);
            if (i2 == 0) {
                z3 = true;
            }
            this.f27011h = z3;
            return;
        }
        parsableByteArray.U(f2);
        this.f27011h = false;
    }

    public void a(long j2, long j3) {
        this.f27006c = j2;
        this.f27007d = 0;
        this.f27013j = j3;
    }

    public void b(ParsableByteArray parsableByteArray, long j2, int i2, boolean z2) {
        boolean z3;
        Assertions.i(this.f27005b);
        int f2 = parsableByteArray.f();
        int N = parsableByteArray.N();
        if ((N & 1024) > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((N & 512) == 0 && (N & 504) == 0 && (N & 7) == 0) {
            if (z3) {
                if (this.f27015l && this.f27007d > 0) {
                    e();
                }
                this.f27015l = true;
                if ((parsableByteArray.j() & 252) < 128) {
                    Log.i("RtpH263Reader", "Picture start Code (PSC) missing, dropping packet.");
                    return;
                }
                parsableByteArray.e()[f2] = 0;
                parsableByteArray.e()[f2 + 1] = 0;
                parsableByteArray.U(f2);
            } else if (this.f27015l) {
                int b2 = RtpPacket.b(this.f27008e);
                if (i2 < b2) {
                    Log.i("RtpH263Reader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(b2), Integer.valueOf(i2)));
                    return;
                }
            } else {
                Log.i("RtpH263Reader", "First payload octet of the H263 packet is not the beginning of a new H263 partition, Dropping current packet.");
                return;
            }
            if (this.f27007d == 0) {
                f(parsableByteArray, this.f27012i);
                if (!this.f27012i && this.f27011h) {
                    int i3 = this.f27009f;
                    Format format = this.f27004a.f26787c;
                    if (!(i3 == format.f23076r && this.f27010g == format.f23077s)) {
                        this.f27005b.d(format.b().n0(this.f27009f).S(this.f27010g).G());
                    }
                    this.f27012i = true;
                }
            }
            int a2 = parsableByteArray.a();
            this.f27005b.c(parsableByteArray, a2);
            this.f27007d += a2;
            this.f27014k = RtpReaderUtils.a(this.f27013j, j2, this.f27006c, 90000);
            if (z2) {
                e();
            }
            this.f27008e = i2;
            return;
        }
        Log.i("RtpH263Reader", "Dropping packet: video reduncancy coding is not supported, packet header VRC, or PLEN or PEBIT is non-zero");
    }

    public void c(ExtractorOutput extractorOutput, int i2) {
        TrackOutput d2 = extractorOutput.d(i2, 2);
        this.f27005b = d2;
        d2.d(this.f27004a.f26787c);
    }

    public void d(long j2, int i2) {
        boolean z2;
        if (this.f27006c == -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        this.f27006c = j2;
    }
}
