package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class LatmReader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final String f24986a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f24987b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableBitArray f24988c;

    /* renamed from: d  reason: collision with root package name */
    private TrackOutput f24989d;

    /* renamed from: e  reason: collision with root package name */
    private String f24990e;

    /* renamed from: f  reason: collision with root package name */
    private Format f24991f;

    /* renamed from: g  reason: collision with root package name */
    private int f24992g;

    /* renamed from: h  reason: collision with root package name */
    private int f24993h;

    /* renamed from: i  reason: collision with root package name */
    private int f24994i;

    /* renamed from: j  reason: collision with root package name */
    private int f24995j;

    /* renamed from: k  reason: collision with root package name */
    private long f24996k = -9223372036854775807L;

    /* renamed from: l  reason: collision with root package name */
    private boolean f24997l;

    /* renamed from: m  reason: collision with root package name */
    private int f24998m;

    /* renamed from: n  reason: collision with root package name */
    private int f24999n;

    /* renamed from: o  reason: collision with root package name */
    private int f25000o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f25001p;

    /* renamed from: q  reason: collision with root package name */
    private long f25002q;

    /* renamed from: r  reason: collision with root package name */
    private int f25003r;

    /* renamed from: s  reason: collision with root package name */
    private long f25004s;

    /* renamed from: t  reason: collision with root package name */
    private int f25005t;

    /* renamed from: u  reason: collision with root package name */
    private String f25006u;

    public LatmReader(String str) {
        this.f24986a = str;
        ParsableByteArray parsableByteArray = new ParsableByteArray(1024);
        this.f24987b = parsableByteArray;
        this.f24988c = new ParsableBitArray(parsableByteArray.e());
    }

    private static long b(ParsableBitArray parsableBitArray) {
        return (long) parsableBitArray.h((parsableBitArray.h(2) + 1) * 8);
    }

    @RequiresNonNull({"output"})
    private void g(ParsableBitArray parsableBitArray) throws ParserException {
        if (!parsableBitArray.g()) {
            this.f24997l = true;
            l(parsableBitArray);
        } else if (!this.f24997l) {
            return;
        }
        if (this.f24998m != 0) {
            throw ParserException.a((String) null, (Throwable) null);
        } else if (this.f24999n == 0) {
            k(parsableBitArray, j(parsableBitArray));
            if (this.f25001p) {
                parsableBitArray.r((int) this.f25002q);
            }
        } else {
            throw ParserException.a((String) null, (Throwable) null);
        }
    }

    private int h(ParsableBitArray parsableBitArray) throws ParserException {
        int b2 = parsableBitArray.b();
        AacUtil.Config e2 = AacUtil.e(parsableBitArray, true);
        this.f25006u = e2.f23635c;
        this.f25003r = e2.f23633a;
        this.f25005t = e2.f23634b;
        return b2 - parsableBitArray.b();
    }

    private void i(ParsableBitArray parsableBitArray) {
        int h2 = parsableBitArray.h(3);
        this.f25000o = h2;
        if (h2 == 0) {
            parsableBitArray.r(8);
        } else if (h2 == 1) {
            parsableBitArray.r(9);
        } else if (h2 == 3 || h2 == 4 || h2 == 5) {
            parsableBitArray.r(6);
        } else if (h2 == 6 || h2 == 7) {
            parsableBitArray.r(1);
        } else {
            throw new IllegalStateException();
        }
    }

    private int j(ParsableBitArray parsableBitArray) throws ParserException {
        int h2;
        if (this.f25000o == 0) {
            int i2 = 0;
            do {
                h2 = parsableBitArray.h(8);
                i2 += h2;
            } while (h2 == 255);
            return i2;
        }
        throw ParserException.a((String) null, (Throwable) null);
    }

    @RequiresNonNull({"output"})
    private void k(ParsableBitArray parsableBitArray, int i2) {
        int e2 = parsableBitArray.e();
        if ((e2 & 7) == 0) {
            this.f24987b.U(e2 >> 3);
        } else {
            parsableBitArray.i(this.f24987b.e(), 0, i2 * 8);
            this.f24987b.U(0);
        }
        this.f24989d.c(this.f24987b, i2);
        long j2 = this.f24996k;
        if (j2 != -9223372036854775807L) {
            this.f24989d.e(j2, 1, i2, 0, (TrackOutput.CryptoData) null);
            this.f24996k += this.f25004s;
        }
    }

    @RequiresNonNull({"output"})
    private void l(ParsableBitArray parsableBitArray) throws ParserException {
        int i2;
        boolean g2;
        int h2 = parsableBitArray.h(1);
        if (h2 == 1) {
            i2 = parsableBitArray.h(1);
        } else {
            i2 = 0;
        }
        this.f24998m = i2;
        if (i2 == 0) {
            if (h2 == 1) {
                b(parsableBitArray);
            }
            if (parsableBitArray.g()) {
                this.f24999n = parsableBitArray.h(6);
                int h3 = parsableBitArray.h(4);
                int h4 = parsableBitArray.h(3);
                if (h3 == 0 && h4 == 0) {
                    if (h2 == 0) {
                        int e2 = parsableBitArray.e();
                        int h5 = h(parsableBitArray);
                        parsableBitArray.p(e2);
                        byte[] bArr = new byte[((h5 + 7) / 8)];
                        parsableBitArray.i(bArr, 0, h5);
                        Format G = new Format.Builder().U(this.f24990e).g0("audio/mp4a-latm").K(this.f25006u).J(this.f25005t).h0(this.f25003r).V(Collections.singletonList(bArr)).X(this.f24986a).G();
                        if (!G.equals(this.f24991f)) {
                            this.f24991f = G;
                            this.f25004s = 1024000000 / ((long) G.A);
                            this.f24989d.d(G);
                        }
                    } else {
                        parsableBitArray.r(((int) b(parsableBitArray)) - h(parsableBitArray));
                    }
                    i(parsableBitArray);
                    boolean g3 = parsableBitArray.g();
                    this.f25001p = g3;
                    this.f25002q = 0;
                    if (g3) {
                        if (h2 == 1) {
                            this.f25002q = b(parsableBitArray);
                        } else {
                            do {
                                g2 = parsableBitArray.g();
                                this.f25002q = (this.f25002q << 8) + ((long) parsableBitArray.h(8));
                            } while (g2);
                        }
                    }
                    if (parsableBitArray.g()) {
                        parsableBitArray.r(8);
                        return;
                    }
                    return;
                }
                throw ParserException.a((String) null, (Throwable) null);
            }
            throw ParserException.a((String) null, (Throwable) null);
        }
        throw ParserException.a((String) null, (Throwable) null);
    }

    private void m(int i2) {
        this.f24987b.Q(i2);
        this.f24988c.n(this.f24987b.e());
    }

    public void a() {
        this.f24992g = 0;
        this.f24996k = -9223372036854775807L;
        this.f24997l = false;
    }

    public void c(ParsableByteArray parsableByteArray) throws ParserException {
        Assertions.i(this.f24989d);
        while (parsableByteArray.a() > 0) {
            int i2 = this.f24992g;
            if (i2 != 0) {
                if (i2 == 1) {
                    int H = parsableByteArray.H();
                    if ((H & 224) == 224) {
                        this.f24995j = H;
                        this.f24992g = 2;
                    } else if (H != 86) {
                        this.f24992g = 0;
                    }
                } else if (i2 == 2) {
                    int H2 = ((this.f24995j & -225) << 8) | parsableByteArray.H();
                    this.f24994i = H2;
                    if (H2 > this.f24987b.e().length) {
                        m(this.f24994i);
                    }
                    this.f24993h = 0;
                    this.f24992g = 3;
                } else if (i2 == 3) {
                    int min = Math.min(parsableByteArray.a(), this.f24994i - this.f24993h);
                    parsableByteArray.l(this.f24988c.f28757a, this.f24993h, min);
                    int i3 = this.f24993h + min;
                    this.f24993h = i3;
                    if (i3 == this.f24994i) {
                        this.f24988c.p(0);
                        g(this.f24988c);
                        this.f24992g = 0;
                    }
                } else {
                    throw new IllegalStateException();
                }
            } else if (parsableByteArray.H() == 86) {
                this.f24992g = 1;
            }
        }
    }

    public void d(long j2, int i2) {
        if (j2 != -9223372036854775807L) {
            this.f24996k = j2;
        }
    }

    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f24989d = extractorOutput.d(trackIdGenerator.c(), 1);
        this.f24990e = trackIdGenerator.b();
    }

    public void f() {
    }
}
