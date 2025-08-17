package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.startapp.y1;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class RtpH264Reader implements RtpPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f27016a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f27017b = new ParsableByteArray(NalUnitUtil.f28716a);

    /* renamed from: c  reason: collision with root package name */
    private final RtpPayloadFormat f27018c;

    /* renamed from: d  reason: collision with root package name */
    private TrackOutput f27019d;

    /* renamed from: e  reason: collision with root package name */
    private int f27020e;

    /* renamed from: f  reason: collision with root package name */
    private long f27021f;

    /* renamed from: g  reason: collision with root package name */
    private int f27022g;

    /* renamed from: h  reason: collision with root package name */
    private int f27023h;

    /* renamed from: i  reason: collision with root package name */
    private long f27024i;

    public RtpH264Reader(RtpPayloadFormat rtpPayloadFormat) {
        this.f27018c = rtpPayloadFormat;
        this.f27016a = new ParsableByteArray();
        this.f27021f = -9223372036854775807L;
        this.f27022g = -1;
    }

    private static int e(int i2) {
        return i2 == 5 ? 1 : 0;
    }

    @RequiresNonNull({"trackOutput"})
    private void f(ParsableByteArray parsableByteArray, int i2) {
        boolean z2;
        boolean z3;
        byte b2 = parsableByteArray.e()[0];
        byte b3 = parsableByteArray.e()[1];
        byte b4 = (b2 & 224) | (b3 & 31);
        if ((b3 & y1.f36938c) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((b3 & 64) > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2) {
            this.f27023h += i();
            parsableByteArray.e()[1] = (byte) b4;
            this.f27016a.R(parsableByteArray.e());
            this.f27016a.U(1);
        } else {
            int b5 = RtpPacket.b(this.f27022g);
            if (i2 != b5) {
                Log.i("RtpH264Reader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(b5), Integer.valueOf(i2)));
                return;
            }
            this.f27016a.R(parsableByteArray.e());
            this.f27016a.U(2);
        }
        int a2 = this.f27016a.a();
        this.f27019d.c(this.f27016a, a2);
        this.f27023h += a2;
        if (z3) {
            this.f27020e = e(b4 & 31);
        }
    }

    @RequiresNonNull({"trackOutput"})
    private void g(ParsableByteArray parsableByteArray) {
        int a2 = parsableByteArray.a();
        this.f27023h += i();
        this.f27019d.c(parsableByteArray, a2);
        this.f27023h += a2;
        this.f27020e = e(parsableByteArray.e()[0] & 31);
    }

    @RequiresNonNull({"trackOutput"})
    private void h(ParsableByteArray parsableByteArray) {
        parsableByteArray.H();
        while (parsableByteArray.a() > 4) {
            int N = parsableByteArray.N();
            this.f27023h += i();
            this.f27019d.c(parsableByteArray, N);
            this.f27023h += N;
        }
        this.f27020e = 0;
    }

    private int i() {
        this.f27017b.U(0);
        int a2 = this.f27017b.a();
        ((TrackOutput) Assertions.e(this.f27019d)).c(this.f27017b, a2);
        return a2;
    }

    public void a(long j2, long j3) {
        this.f27021f = j2;
        this.f27023h = 0;
        this.f27024i = j3;
    }

    public void b(ParsableByteArray parsableByteArray, long j2, int i2, boolean z2) throws ParserException {
        int i3 = i2;
        try {
            byte b2 = parsableByteArray.e()[0] & 31;
            Assertions.i(this.f27019d);
            if (b2 > 0 && b2 < 24) {
                g(parsableByteArray);
            } else if (b2 == 24) {
                h(parsableByteArray);
            } else if (b2 == 28) {
                f(parsableByteArray, i3);
            } else {
                throw ParserException.c(String.format("RTP H264 packetization mode [%d] not supported.", new Object[]{Integer.valueOf(b2)}), (Throwable) null);
            }
            if (z2) {
                long j3 = j2;
                if (this.f27021f == -9223372036854775807L) {
                    this.f27021f = j3;
                }
                long a2 = RtpReaderUtils.a(this.f27024i, j2, this.f27021f, 90000);
                this.f27019d.e(a2, this.f27020e, this.f27023h, 0, (TrackOutput.CryptoData) null);
                this.f27023h = 0;
            }
            this.f27022g = i3;
        } catch (IndexOutOfBoundsException e2) {
            throw ParserException.c((String) null, e2);
        }
    }

    public void c(ExtractorOutput extractorOutput, int i2) {
        TrackOutput d2 = extractorOutput.d(i2, 2);
        this.f27019d = d2;
        ((TrackOutput) Util.j(d2)).d(this.f27018c.f26787c);
    }

    public void d(long j2, int i2) {
    }
}
