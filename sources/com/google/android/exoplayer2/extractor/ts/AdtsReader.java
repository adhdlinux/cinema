package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.Arrays;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class AdtsReader implements ElementaryStreamReader {

    /* renamed from: v  reason: collision with root package name */
    private static final byte[] f24815v = {73, 68, 51};

    /* renamed from: a  reason: collision with root package name */
    private final boolean f24816a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableBitArray f24817b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f24818c;

    /* renamed from: d  reason: collision with root package name */
    private final String f24819d;

    /* renamed from: e  reason: collision with root package name */
    private String f24820e;

    /* renamed from: f  reason: collision with root package name */
    private TrackOutput f24821f;

    /* renamed from: g  reason: collision with root package name */
    private TrackOutput f24822g;

    /* renamed from: h  reason: collision with root package name */
    private int f24823h;

    /* renamed from: i  reason: collision with root package name */
    private int f24824i;

    /* renamed from: j  reason: collision with root package name */
    private int f24825j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f24826k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f24827l;

    /* renamed from: m  reason: collision with root package name */
    private int f24828m;

    /* renamed from: n  reason: collision with root package name */
    private int f24829n;

    /* renamed from: o  reason: collision with root package name */
    private int f24830o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f24831p;

    /* renamed from: q  reason: collision with root package name */
    private long f24832q;

    /* renamed from: r  reason: collision with root package name */
    private int f24833r;

    /* renamed from: s  reason: collision with root package name */
    private long f24834s;

    /* renamed from: t  reason: collision with root package name */
    private TrackOutput f24835t;

    /* renamed from: u  reason: collision with root package name */
    private long f24836u;

    public AdtsReader(boolean z2) {
        this(z2, (String) null);
    }

    @EnsuresNonNull({"output", "currentOutput", "id3Output"})
    private void b() {
        Assertions.e(this.f24821f);
        Util.j(this.f24835t);
        Util.j(this.f24822g);
    }

    private void g(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() != 0) {
            this.f24817b.f28757a[0] = parsableByteArray.e()[parsableByteArray.f()];
            this.f24817b.p(2);
            int h2 = this.f24817b.h(4);
            int i2 = this.f24829n;
            if (i2 == -1 || h2 == i2) {
                if (!this.f24827l) {
                    this.f24827l = true;
                    this.f24828m = this.f24830o;
                    this.f24829n = h2;
                }
                t();
                return;
            }
            q();
        }
    }

    private boolean h(ParsableByteArray parsableByteArray, int i2) {
        parsableByteArray.U(i2 + 1);
        if (!w(parsableByteArray, this.f24817b.f28757a, 1)) {
            return false;
        }
        this.f24817b.p(4);
        int h2 = this.f24817b.h(1);
        int i3 = this.f24828m;
        if (i3 != -1 && h2 != i3) {
            return false;
        }
        if (this.f24829n != -1) {
            if (!w(parsableByteArray, this.f24817b.f28757a, 1)) {
                return true;
            }
            this.f24817b.p(2);
            if (this.f24817b.h(4) != this.f24829n) {
                return false;
            }
            parsableByteArray.U(i2 + 2);
        }
        if (!w(parsableByteArray, this.f24817b.f28757a, 4)) {
            return true;
        }
        this.f24817b.p(14);
        int h3 = this.f24817b.h(13);
        if (h3 < 7) {
            return false;
        }
        byte[] e2 = parsableByteArray.e();
        int g2 = parsableByteArray.g();
        int i4 = i2 + h3;
        if (i4 >= g2) {
            return true;
        }
        byte b2 = e2[i4];
        if (b2 == -1) {
            int i5 = i4 + 1;
            if (i5 == g2) {
                return true;
            }
            if (!l((byte) -1, e2[i5]) || ((e2[i5] & 8) >> 3) != h2) {
                return false;
            }
            return true;
        } else if (b2 != 73) {
            return false;
        } else {
            int i6 = i4 + 1;
            if (i6 == g2) {
                return true;
            }
            if (e2[i6] != 68) {
                return false;
            }
            int i7 = i4 + 2;
            if (i7 == g2 || e2[i7] == 51) {
                return true;
            }
            return false;
        }
    }

    private boolean i(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        int min = Math.min(parsableByteArray.a(), i2 - this.f24824i);
        parsableByteArray.l(bArr, this.f24824i, min);
        int i3 = this.f24824i + min;
        this.f24824i = i3;
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    private void j(ParsableByteArray parsableByteArray) {
        byte[] e2 = parsableByteArray.e();
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        while (f2 < g2) {
            int i2 = f2 + 1;
            byte b2 = e2[f2] & 255;
            if (this.f24825j != 512 || !l((byte) -1, (byte) b2) || (!this.f24827l && !h(parsableByteArray, i2 - 2))) {
                int i3 = this.f24825j;
                byte b3 = b2 | i3;
                if (b3 == 329) {
                    this.f24825j = 768;
                } else if (b3 == 511) {
                    this.f24825j = 512;
                } else if (b3 == 836) {
                    this.f24825j = 1024;
                } else if (b3 == 1075) {
                    u();
                    parsableByteArray.U(i2);
                    return;
                } else if (i3 != 256) {
                    this.f24825j = UserVerificationMethods.USER_VERIFY_HANDPRINT;
                    i2--;
                }
                f2 = i2;
            } else {
                this.f24830o = (b2 & 8) >> 3;
                boolean z2 = true;
                if ((b2 & 1) != 0) {
                    z2 = false;
                }
                this.f24826k = z2;
                if (!this.f24827l) {
                    r();
                } else {
                    t();
                }
                parsableByteArray.U(i2);
                return;
            }
        }
        parsableByteArray.U(f2);
    }

    private boolean l(byte b2, byte b3) {
        return m(((b2 & 255) << 8) | (b3 & 255));
    }

    public static boolean m(int i2) {
        return (i2 & 65526) == 65520;
    }

    @RequiresNonNull({"output"})
    private void n() throws ParserException {
        this.f24817b.p(0);
        if (!this.f24831p) {
            int h2 = this.f24817b.h(2) + 1;
            if (h2 != 2) {
                Log.i("AdtsReader", "Detected audio object type: " + h2 + ", but assuming AAC LC.");
                h2 = 2;
            }
            this.f24817b.r(5);
            byte[] b2 = AacUtil.b(h2, this.f24829n, this.f24817b.h(3));
            AacUtil.Config f2 = AacUtil.f(b2);
            Format G = new Format.Builder().U(this.f24820e).g0("audio/mp4a-latm").K(f2.f23635c).J(f2.f23634b).h0(f2.f23633a).V(Collections.singletonList(b2)).X(this.f24819d).G();
            this.f24832q = 1024000000 / ((long) G.A);
            this.f24821f.d(G);
            this.f24831p = true;
        } else {
            this.f24817b.r(10);
        }
        this.f24817b.r(4);
        int h3 = (this.f24817b.h(13) - 2) - 5;
        if (this.f24826k) {
            h3 -= 2;
        }
        v(this.f24821f, this.f24832q, 0, h3);
    }

    @RequiresNonNull({"id3Output"})
    private void o() {
        this.f24822g.c(this.f24818c, 10);
        this.f24818c.U(6);
        v(this.f24822g, 0, 10, this.f24818c.G() + 10);
    }

    @RequiresNonNull({"currentOutput"})
    private void p(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.a(), this.f24833r - this.f24824i);
        this.f24835t.c(parsableByteArray, min);
        int i2 = this.f24824i + min;
        this.f24824i = i2;
        int i3 = this.f24833r;
        if (i2 == i3) {
            long j2 = this.f24834s;
            if (j2 != -9223372036854775807L) {
                this.f24835t.e(j2, 1, i3, 0, (TrackOutput.CryptoData) null);
                this.f24834s += this.f24836u;
            }
            s();
        }
    }

    private void q() {
        this.f24827l = false;
        s();
    }

    private void r() {
        this.f24823h = 1;
        this.f24824i = 0;
    }

    private void s() {
        this.f24823h = 0;
        this.f24824i = 0;
        this.f24825j = UserVerificationMethods.USER_VERIFY_HANDPRINT;
    }

    private void t() {
        this.f24823h = 3;
        this.f24824i = 0;
    }

    private void u() {
        this.f24823h = 2;
        this.f24824i = f24815v.length;
        this.f24833r = 0;
        this.f24818c.U(0);
    }

    private void v(TrackOutput trackOutput, long j2, int i2, int i3) {
        this.f24823h = 4;
        this.f24824i = i2;
        this.f24835t = trackOutput;
        this.f24836u = j2;
        this.f24833r = i3;
    }

    private boolean w(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        if (parsableByteArray.a() < i2) {
            return false;
        }
        parsableByteArray.l(bArr, 0, i2);
        return true;
    }

    public void a() {
        this.f24834s = -9223372036854775807L;
        q();
    }

    public void c(ParsableByteArray parsableByteArray) throws ParserException {
        int i2;
        b();
        while (parsableByteArray.a() > 0) {
            int i3 = this.f24823h;
            if (i3 == 0) {
                j(parsableByteArray);
            } else if (i3 == 1) {
                g(parsableByteArray);
            } else if (i3 != 2) {
                if (i3 == 3) {
                    if (this.f24826k) {
                        i2 = 7;
                    } else {
                        i2 = 5;
                    }
                    if (i(parsableByteArray, this.f24817b.f28757a, i2)) {
                        n();
                    }
                } else if (i3 == 4) {
                    p(parsableByteArray);
                } else {
                    throw new IllegalStateException();
                }
            } else if (i(parsableByteArray, this.f24818c.e(), 10)) {
                o();
            }
        }
    }

    public void d(long j2, int i2) {
        if (j2 != -9223372036854775807L) {
            this.f24834s = j2;
        }
    }

    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f24820e = trackIdGenerator.b();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 1);
        this.f24821f = d2;
        this.f24835t = d2;
        if (this.f24816a) {
            trackIdGenerator.a();
            TrackOutput d3 = extractorOutput.d(trackIdGenerator.c(), 5);
            this.f24822g = d3;
            d3.d(new Format.Builder().U(trackIdGenerator.b()).g0("application/id3").G());
            return;
        }
        this.f24822g = new DummyTrackOutput();
    }

    public void f() {
    }

    public long k() {
        return this.f24832q;
    }

    public AdtsReader(boolean z2, String str) {
        this.f24817b = new ParsableBitArray(new byte[7]);
        this.f24818c = new ParsableByteArray(Arrays.copyOf(f24815v, 10));
        s();
        this.f24828m = -1;
        this.f24829n = -1;
        this.f24832q = -9223372036854775807L;
        this.f24834s = -9223372036854775807L;
        this.f24816a = z2;
        this.f24819d = str;
    }
}
