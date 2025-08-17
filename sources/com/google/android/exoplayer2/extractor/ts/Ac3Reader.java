package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class Ac3Reader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableBitArray f24773a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f24774b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24775c;

    /* renamed from: d  reason: collision with root package name */
    private String f24776d;

    /* renamed from: e  reason: collision with root package name */
    private TrackOutput f24777e;

    /* renamed from: f  reason: collision with root package name */
    private int f24778f;

    /* renamed from: g  reason: collision with root package name */
    private int f24779g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f24780h;

    /* renamed from: i  reason: collision with root package name */
    private long f24781i;

    /* renamed from: j  reason: collision with root package name */
    private Format f24782j;

    /* renamed from: k  reason: collision with root package name */
    private int f24783k;

    /* renamed from: l  reason: collision with root package name */
    private long f24784l;

    public Ac3Reader() {
        this((String) null);
    }

    private boolean b(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        int min = Math.min(parsableByteArray.a(), i2 - this.f24779g);
        parsableByteArray.l(bArr, this.f24779g, min);
        int i3 = this.f24779g + min;
        this.f24779g = i3;
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    @RequiresNonNull({"output"})
    private void g() {
        this.f24773a.p(0);
        Ac3Util.SyncFrameInfo f2 = Ac3Util.f(this.f24773a);
        Format format = this.f24782j;
        if (format == null || f2.f23645d != format.f23084z || f2.f23644c != format.A || !Util.c(f2.f23642a, format.f23071m)) {
            Format.Builder b02 = new Format.Builder().U(this.f24776d).g0(f2.f23642a).J(f2.f23645d).h0(f2.f23644c).X(this.f24775c).b0(f2.f23648g);
            if ("audio/ac3".equals(f2.f23642a)) {
                b02.I(f2.f23648g);
            }
            Format G = b02.G();
            this.f24782j = G;
            this.f24777e.d(G);
        }
        this.f24783k = f2.f23646e;
        this.f24781i = (((long) f2.f23647f) * 1000000) / ((long) this.f24782j.A);
    }

    private boolean h(ParsableByteArray parsableByteArray) {
        while (true) {
            boolean z2 = false;
            if (parsableByteArray.a() <= 0) {
                return false;
            }
            if (!this.f24780h) {
                if (parsableByteArray.H() == 11) {
                    z2 = true;
                }
                this.f24780h = z2;
            } else {
                int H = parsableByteArray.H();
                if (H == 119) {
                    this.f24780h = false;
                    return true;
                }
                if (H == 11) {
                    z2 = true;
                }
                this.f24780h = z2;
            }
        }
    }

    public void a() {
        this.f24778f = 0;
        this.f24779g = 0;
        this.f24780h = false;
        this.f24784l = -9223372036854775807L;
    }

    public void c(ParsableByteArray parsableByteArray) {
        Assertions.i(this.f24777e);
        while (parsableByteArray.a() > 0) {
            int i2 = this.f24778f;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(parsableByteArray.a(), this.f24783k - this.f24779g);
                        this.f24777e.c(parsableByteArray, min);
                        int i3 = this.f24779g + min;
                        this.f24779g = i3;
                        int i4 = this.f24783k;
                        if (i3 == i4) {
                            long j2 = this.f24784l;
                            if (j2 != -9223372036854775807L) {
                                this.f24777e.e(j2, 1, i4, 0, (TrackOutput.CryptoData) null);
                                this.f24784l += this.f24781i;
                            }
                            this.f24778f = 0;
                        }
                    }
                } else if (b(parsableByteArray, this.f24774b.e(), 128)) {
                    g();
                    this.f24774b.U(0);
                    this.f24777e.c(this.f24774b, 128);
                    this.f24778f = 2;
                }
            } else if (h(parsableByteArray)) {
                this.f24778f = 1;
                this.f24774b.e()[0] = 11;
                this.f24774b.e()[1] = 119;
                this.f24779g = 2;
            }
        }
    }

    public void d(long j2, int i2) {
        if (j2 != -9223372036854775807L) {
            this.f24784l = j2;
        }
    }

    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f24776d = trackIdGenerator.b();
        this.f24777e = extractorOutput.d(trackIdGenerator.c(), 1);
    }

    public void f() {
    }

    public Ac3Reader(String str) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[128]);
        this.f24773a = parsableBitArray;
        this.f24774b = new ParsableByteArray(parsableBitArray.f28757a);
        this.f24778f = 0;
        this.f24784l = -9223372036854775807L;
        this.f24775c = str;
    }
}
