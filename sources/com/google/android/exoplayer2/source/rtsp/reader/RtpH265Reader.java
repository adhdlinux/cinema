package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.startapp.y1;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class RtpH265Reader implements RtpPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f27025a = new ParsableByteArray();

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f27026b = new ParsableByteArray(NalUnitUtil.f28716a);

    /* renamed from: c  reason: collision with root package name */
    private final RtpPayloadFormat f27027c;

    /* renamed from: d  reason: collision with root package name */
    private TrackOutput f27028d;

    /* renamed from: e  reason: collision with root package name */
    private int f27029e;

    /* renamed from: f  reason: collision with root package name */
    private long f27030f;

    /* renamed from: g  reason: collision with root package name */
    private int f27031g;

    /* renamed from: h  reason: collision with root package name */
    private int f27032h;

    /* renamed from: i  reason: collision with root package name */
    private long f27033i;

    public RtpH265Reader(RtpPayloadFormat rtpPayloadFormat) {
        this.f27027c = rtpPayloadFormat;
        this.f27030f = -9223372036854775807L;
        this.f27031g = -1;
    }

    private static int e(int i2) {
        return (i2 == 19 || i2 == 20) ? 1 : 0;
    }

    @RequiresNonNull({"trackOutput"})
    private void f(ParsableByteArray parsableByteArray, int i2) throws ParserException {
        boolean z2;
        boolean z3;
        if (parsableByteArray.e().length >= 3) {
            byte b2 = parsableByteArray.e()[1] & 7;
            byte b3 = parsableByteArray.e()[2];
            byte b4 = b3 & 63;
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
                this.f27032h += h();
                parsableByteArray.e()[1] = (byte) ((b4 << 1) & 127);
                parsableByteArray.e()[2] = (byte) b2;
                this.f27025a.R(parsableByteArray.e());
                this.f27025a.U(1);
            } else {
                int i3 = (this.f27031g + 1) % 65535;
                if (i2 != i3) {
                    Log.i("RtpH265Reader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(i3), Integer.valueOf(i2)));
                    return;
                }
                this.f27025a.R(parsableByteArray.e());
                this.f27025a.U(3);
            }
            int a2 = this.f27025a.a();
            this.f27028d.c(this.f27025a, a2);
            this.f27032h += a2;
            if (z3) {
                this.f27029e = e(b4);
                return;
            }
            return;
        }
        throw ParserException.c("Malformed FU header.", (Throwable) null);
    }

    @RequiresNonNull({"trackOutput"})
    private void g(ParsableByteArray parsableByteArray) {
        int a2 = parsableByteArray.a();
        this.f27032h += h();
        this.f27028d.c(parsableByteArray, a2);
        this.f27032h += a2;
        this.f27029e = e((parsableByteArray.e()[0] >> 1) & 63);
    }

    private int h() {
        this.f27026b.U(0);
        int a2 = this.f27026b.a();
        ((TrackOutput) Assertions.e(this.f27028d)).c(this.f27026b, a2);
        return a2;
    }

    public void a(long j2, long j3) {
        this.f27030f = j2;
        this.f27032h = 0;
        this.f27033i = j3;
    }

    public void b(ParsableByteArray parsableByteArray, long j2, int i2, boolean z2) throws ParserException {
        int i3 = i2;
        if (parsableByteArray.e().length != 0) {
            int i4 = (parsableByteArray.e()[0] >> 1) & 63;
            Assertions.i(this.f27028d);
            if (i4 >= 0 && i4 < 48) {
                g(parsableByteArray);
            } else if (i4 == 48) {
                throw new UnsupportedOperationException("need to implement processAggregationPacket");
            } else if (i4 == 49) {
                f(parsableByteArray, i3);
            } else {
                throw ParserException.c(String.format("RTP H265 payload type [%d] not supported.", new Object[]{Integer.valueOf(i4)}), (Throwable) null);
            }
            if (z2) {
                long j3 = j2;
                if (this.f27030f == -9223372036854775807L) {
                    this.f27030f = j3;
                }
                long a2 = RtpReaderUtils.a(this.f27033i, j2, this.f27030f, 90000);
                this.f27028d.e(a2, this.f27029e, this.f27032h, 0, (TrackOutput.CryptoData) null);
                this.f27032h = 0;
            }
            this.f27031g = i3;
            return;
        }
        throw ParserException.c("Empty RTP data packet.", (Throwable) null);
    }

    public void c(ExtractorOutput extractorOutput, int i2) {
        TrackOutput d2 = extractorOutput.d(i2, 2);
        this.f27028d = d2;
        d2.d(this.f27027c.f26787c);
    }

    public void d(long j2, int i2) {
    }
}
