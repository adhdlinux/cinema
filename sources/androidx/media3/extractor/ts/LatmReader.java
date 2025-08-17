package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class LatmReader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final String f9377a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9378b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f9379c;

    /* renamed from: d  reason: collision with root package name */
    private final ParsableBitArray f9380d;

    /* renamed from: e  reason: collision with root package name */
    private TrackOutput f9381e;

    /* renamed from: f  reason: collision with root package name */
    private String f9382f;

    /* renamed from: g  reason: collision with root package name */
    private Format f9383g;

    /* renamed from: h  reason: collision with root package name */
    private int f9384h;

    /* renamed from: i  reason: collision with root package name */
    private int f9385i;

    /* renamed from: j  reason: collision with root package name */
    private int f9386j;

    /* renamed from: k  reason: collision with root package name */
    private int f9387k;

    /* renamed from: l  reason: collision with root package name */
    private long f9388l = -9223372036854775807L;

    /* renamed from: m  reason: collision with root package name */
    private boolean f9389m;

    /* renamed from: n  reason: collision with root package name */
    private int f9390n;

    /* renamed from: o  reason: collision with root package name */
    private int f9391o;

    /* renamed from: p  reason: collision with root package name */
    private int f9392p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f9393q;

    /* renamed from: r  reason: collision with root package name */
    private long f9394r;

    /* renamed from: s  reason: collision with root package name */
    private int f9395s;

    /* renamed from: t  reason: collision with root package name */
    private long f9396t;

    /* renamed from: u  reason: collision with root package name */
    private int f9397u;

    /* renamed from: v  reason: collision with root package name */
    private String f9398v;

    public LatmReader(String str, int i2) {
        this.f9377a = str;
        this.f9378b = i2;
        ParsableByteArray parsableByteArray = new ParsableByteArray(1024);
        this.f9379c = parsableByteArray;
        this.f9380d = new ParsableBitArray(parsableByteArray.e());
    }

    private static long c(ParsableBitArray parsableBitArray) {
        return (long) parsableBitArray.h((parsableBitArray.h(2) + 1) * 8);
    }

    @RequiresNonNull({"output"})
    private void g(ParsableBitArray parsableBitArray) throws ParserException {
        if (!parsableBitArray.g()) {
            this.f9389m = true;
            l(parsableBitArray);
        } else if (!this.f9389m) {
            return;
        }
        if (this.f9390n != 0) {
            throw ParserException.a((String) null, (Throwable) null);
        } else if (this.f9391o == 0) {
            k(parsableBitArray, j(parsableBitArray));
            if (this.f9393q) {
                parsableBitArray.r((int) this.f9394r);
            }
        } else {
            throw ParserException.a((String) null, (Throwable) null);
        }
    }

    private int h(ParsableBitArray parsableBitArray) throws ParserException {
        int b2 = parsableBitArray.b();
        AacUtil.Config d2 = AacUtil.d(parsableBitArray, true);
        this.f9398v = d2.f7897c;
        this.f9395s = d2.f7895a;
        this.f9397u = d2.f7896b;
        return b2 - parsableBitArray.b();
    }

    private void i(ParsableBitArray parsableBitArray) {
        int h2 = parsableBitArray.h(3);
        this.f9392p = h2;
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
        if (this.f9392p == 0) {
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
        boolean z2 = false;
        if ((e2 & 7) == 0) {
            this.f9379c.U(e2 >> 3);
        } else {
            parsableBitArray.i(this.f9379c.e(), 0, i2 * 8);
            this.f9379c.U(0);
        }
        this.f9381e.b(this.f9379c, i2);
        if (this.f9388l != -9223372036854775807L) {
            z2 = true;
        }
        Assertions.h(z2);
        this.f9381e.f(this.f9388l, 1, i2, 0, (TrackOutput.CryptoData) null);
        this.f9388l += this.f9396t;
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
        this.f9390n = i2;
        if (i2 == 0) {
            if (h2 == 1) {
                c(parsableBitArray);
            }
            if (parsableBitArray.g()) {
                this.f9391o = parsableBitArray.h(6);
                int h3 = parsableBitArray.h(4);
                int h4 = parsableBitArray.h(3);
                if (h3 == 0 && h4 == 0) {
                    if (h2 == 0) {
                        int e2 = parsableBitArray.e();
                        int h5 = h(parsableBitArray);
                        parsableBitArray.p(e2);
                        byte[] bArr = new byte[((h5 + 7) / 8)];
                        parsableBitArray.i(bArr, 0, h5);
                        Format K = new Format.Builder().a0(this.f9382f).o0("audio/mp4a-latm").O(this.f9398v).N(this.f9397u).p0(this.f9395s).b0(Collections.singletonList(bArr)).e0(this.f9377a).m0(this.f9378b).K();
                        if (!K.equals(this.f9383g)) {
                            this.f9383g = K;
                            this.f9396t = 1024000000 / ((long) K.C);
                            this.f9381e.c(K);
                        }
                    } else {
                        parsableBitArray.r(((int) c(parsableBitArray)) - h(parsableBitArray));
                    }
                    i(parsableBitArray);
                    boolean g3 = parsableBitArray.g();
                    this.f9393q = g3;
                    this.f9394r = 0;
                    if (g3) {
                        if (h2 == 1) {
                            this.f9394r = c(parsableBitArray);
                        } else {
                            do {
                                g2 = parsableBitArray.g();
                                this.f9394r = (this.f9394r << 8) + ((long) parsableBitArray.h(8));
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
        this.f9379c.Q(i2);
        this.f9380d.n(this.f9379c.e());
    }

    public void a() {
        this.f9384h = 0;
        this.f9388l = -9223372036854775807L;
        this.f9389m = false;
    }

    public void b(ParsableByteArray parsableByteArray) throws ParserException {
        Assertions.j(this.f9381e);
        while (parsableByteArray.a() > 0) {
            int i2 = this.f9384h;
            if (i2 != 0) {
                if (i2 == 1) {
                    int H = parsableByteArray.H();
                    if ((H & 224) == 224) {
                        this.f9387k = H;
                        this.f9384h = 2;
                    } else if (H != 86) {
                        this.f9384h = 0;
                    }
                } else if (i2 == 2) {
                    int H2 = ((this.f9387k & -225) << 8) | parsableByteArray.H();
                    this.f9386j = H2;
                    if (H2 > this.f9379c.e().length) {
                        m(this.f9386j);
                    }
                    this.f9385i = 0;
                    this.f9384h = 3;
                } else if (i2 == 3) {
                    int min = Math.min(parsableByteArray.a(), this.f9386j - this.f9385i);
                    parsableByteArray.l(this.f9380d.f4688a, this.f9385i, min);
                    int i3 = this.f9385i + min;
                    this.f9385i = i3;
                    if (i3 == this.f9386j) {
                        this.f9380d.p(0);
                        g(this.f9380d);
                        this.f9384h = 0;
                    }
                } else {
                    throw new IllegalStateException();
                }
            } else if (parsableByteArray.H() == 86) {
                this.f9384h = 1;
            }
        }
    }

    public void d(long j2, int i2) {
        this.f9388l = j2;
    }

    public void e(boolean z2) {
    }

    public void f(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f9381e = extractorOutput.d(trackIdGenerator.c(), 1);
        this.f9382f = trackIdGenerator.b();
    }
}
