package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.protobuf.CodedOutputStream;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class MpegAudioReader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f25007a;

    /* renamed from: b  reason: collision with root package name */
    private final MpegAudioUtil.Header f25008b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25009c;

    /* renamed from: d  reason: collision with root package name */
    private TrackOutput f25010d;

    /* renamed from: e  reason: collision with root package name */
    private String f25011e;

    /* renamed from: f  reason: collision with root package name */
    private int f25012f;

    /* renamed from: g  reason: collision with root package name */
    private int f25013g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f25014h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f25015i;

    /* renamed from: j  reason: collision with root package name */
    private long f25016j;

    /* renamed from: k  reason: collision with root package name */
    private int f25017k;

    /* renamed from: l  reason: collision with root package name */
    private long f25018l;

    public MpegAudioReader() {
        this((String) null);
    }

    private void b(ParsableByteArray parsableByteArray) {
        boolean z2;
        boolean z3;
        byte[] e2 = parsableByteArray.e();
        int g2 = parsableByteArray.g();
        for (int f2 = parsableByteArray.f(); f2 < g2; f2++) {
            byte b2 = e2[f2];
            if ((b2 & 255) == 255) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!this.f25015i || (b2 & 224) != 224) {
                z3 = false;
            } else {
                z3 = true;
            }
            this.f25015i = z2;
            if (z3) {
                parsableByteArray.U(f2 + 1);
                this.f25015i = false;
                this.f25007a.e()[1] = e2[f2];
                this.f25013g = 2;
                this.f25012f = 1;
                return;
            }
        }
        parsableByteArray.U(g2);
    }

    @RequiresNonNull({"output"})
    private void g(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.a(), this.f25017k - this.f25013g);
        this.f25010d.c(parsableByteArray, min);
        int i2 = this.f25013g + min;
        this.f25013g = i2;
        int i3 = this.f25017k;
        if (i2 >= i3) {
            long j2 = this.f25018l;
            if (j2 != -9223372036854775807L) {
                this.f25010d.e(j2, 1, i3, 0, (TrackOutput.CryptoData) null);
                this.f25018l += this.f25016j;
            }
            this.f25013g = 0;
            this.f25012f = 0;
        }
    }

    @RequiresNonNull({"output"})
    private void h(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.a(), 4 - this.f25013g);
        parsableByteArray.l(this.f25007a.e(), this.f25013g, min);
        int i2 = this.f25013g + min;
        this.f25013g = i2;
        if (i2 >= 4) {
            this.f25007a.U(0);
            if (!this.f25008b.a(this.f25007a.q())) {
                this.f25013g = 0;
                this.f25012f = 1;
                return;
            }
            MpegAudioUtil.Header header = this.f25008b;
            this.f25017k = header.f23839c;
            if (!this.f25014h) {
                this.f25016j = (((long) header.f23843g) * 1000000) / ((long) header.f23840d);
                this.f25010d.d(new Format.Builder().U(this.f25011e).g0(this.f25008b.f23838b).Y(CodedOutputStream.DEFAULT_BUFFER_SIZE).J(this.f25008b.f23841e).h0(this.f25008b.f23840d).X(this.f25009c).G());
                this.f25014h = true;
            }
            this.f25007a.U(0);
            this.f25010d.c(this.f25007a, 4);
            this.f25012f = 2;
        }
    }

    public void a() {
        this.f25012f = 0;
        this.f25013g = 0;
        this.f25015i = false;
        this.f25018l = -9223372036854775807L;
    }

    public void c(ParsableByteArray parsableByteArray) {
        Assertions.i(this.f25010d);
        while (parsableByteArray.a() > 0) {
            int i2 = this.f25012f;
            if (i2 == 0) {
                b(parsableByteArray);
            } else if (i2 == 1) {
                h(parsableByteArray);
            } else if (i2 == 2) {
                g(parsableByteArray);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public void d(long j2, int i2) {
        if (j2 != -9223372036854775807L) {
            this.f25018l = j2;
        }
    }

    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f25011e = trackIdGenerator.b();
        this.f25010d = extractorOutput.d(trackIdGenerator.c(), 1);
    }

    public void f() {
    }

    public MpegAudioReader(String str) {
        this.f25012f = 0;
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        this.f25007a = parsableByteArray;
        parsableByteArray.e()[0] = -1;
        this.f25008b = new MpegAudioUtil.Header();
        this.f25018l = -9223372036854775807L;
        this.f25009c = str;
    }
}
