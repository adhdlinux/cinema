package com.google.android.exoplayer2.source.rtsp;

import android.os.SystemClock;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.source.rtsp.reader.DefaultRtpPayloadReaderFactory;
import com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

final class RtpExtractor implements Extractor {

    /* renamed from: a  reason: collision with root package name */
    private final RtpPayloadReader f26746a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f26747b = new ParsableByteArray(65507);

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f26748c = new ParsableByteArray();

    /* renamed from: d  reason: collision with root package name */
    private final int f26749d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f26750e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final RtpPacketReorderingQueue f26751f = new RtpPacketReorderingQueue();

    /* renamed from: g  reason: collision with root package name */
    private ExtractorOutput f26752g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f26753h;

    /* renamed from: i  reason: collision with root package name */
    private volatile long f26754i = -9223372036854775807L;

    /* renamed from: j  reason: collision with root package name */
    private volatile int f26755j = -1;

    /* renamed from: k  reason: collision with root package name */
    private boolean f26756k;

    /* renamed from: l  reason: collision with root package name */
    private long f26757l = -9223372036854775807L;

    /* renamed from: m  reason: collision with root package name */
    private long f26758m = -9223372036854775807L;

    public RtpExtractor(RtpPayloadFormat rtpPayloadFormat, int i2) {
        this.f26749d = i2;
        this.f26746a = (RtpPayloadReader) Assertions.e(new DefaultRtpPayloadReaderFactory().a(rtpPayloadFormat));
    }

    private static long b(long j2) {
        return j2 - 30;
    }

    public void a(long j2, long j3) {
        synchronized (this.f26750e) {
            if (!this.f26756k) {
                this.f26756k = true;
            }
            this.f26757l = j2;
            this.f26758m = j3;
        }
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f26746a.c(extractorOutput, this.f26749d);
        extractorOutput.m();
        extractorOutput.u(new SeekMap.Unseekable(-9223372036854775807L));
        this.f26752g = extractorOutput;
    }

    public boolean d() {
        return this.f26753h;
    }

    public void e() {
        synchronized (this.f26750e) {
            this.f26756k = true;
        }
    }

    public void f(int i2) {
        this.f26755j = i2;
    }

    public boolean g(ExtractorInput extractorInput) {
        throw new UnsupportedOperationException("RTP packets are transmitted in a packet stream do not support sniffing.");
    }

    public void h(long j2) {
        this.f26754i = j2;
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.e(this.f26752g);
        int read = extractorInput.read(this.f26747b.e(), 0, 65507);
        if (read == -1) {
            return -1;
        }
        if (read == 0) {
            return 0;
        }
        this.f26747b.U(0);
        this.f26747b.T(read);
        RtpPacket d2 = RtpPacket.d(this.f26747b);
        if (d2 == null) {
            return 0;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long b2 = b(elapsedRealtime);
        this.f26751f.e(d2, elapsedRealtime);
        RtpPacket f2 = this.f26751f.f(b2);
        if (f2 == null) {
            return 0;
        }
        if (!this.f26753h) {
            if (this.f26754i == -9223372036854775807L) {
                this.f26754i = f2.f26767h;
            }
            if (this.f26755j == -1) {
                this.f26755j = f2.f26766g;
            }
            this.f26746a.d(this.f26754i, this.f26755j);
            this.f26753h = true;
        }
        synchronized (this.f26750e) {
            if (!this.f26756k) {
                do {
                    this.f26748c.R(f2.f26770k);
                    this.f26746a.b(this.f26748c, f2.f26767h, f2.f26766g, f2.f26764e);
                    f2 = this.f26751f.f(b2);
                } while (f2 != null);
            } else if (!(this.f26757l == -9223372036854775807L || this.f26758m == -9223372036854775807L)) {
                this.f26751f.g();
                this.f26746a.a(this.f26757l, this.f26758m);
                this.f26756k = false;
                this.f26757l = -9223372036854775807L;
                this.f26758m = -9223372036854775807L;
            }
        }
        return 0;
    }

    public void release() {
    }
}
