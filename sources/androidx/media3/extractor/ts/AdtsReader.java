package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.Arrays;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class AdtsReader implements ElementaryStreamReader {

    /* renamed from: w  reason: collision with root package name */
    private static final byte[] f9199w = {73, 68, 51};

    /* renamed from: a  reason: collision with root package name */
    private final boolean f9200a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableBitArray f9201b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f9202c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9203d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9204e;

    /* renamed from: f  reason: collision with root package name */
    private String f9205f;

    /* renamed from: g  reason: collision with root package name */
    private TrackOutput f9206g;

    /* renamed from: h  reason: collision with root package name */
    private TrackOutput f9207h;

    /* renamed from: i  reason: collision with root package name */
    private int f9208i;

    /* renamed from: j  reason: collision with root package name */
    private int f9209j;

    /* renamed from: k  reason: collision with root package name */
    private int f9210k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f9211l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f9212m;

    /* renamed from: n  reason: collision with root package name */
    private int f9213n;

    /* renamed from: o  reason: collision with root package name */
    private int f9214o;

    /* renamed from: p  reason: collision with root package name */
    private int f9215p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f9216q;

    /* renamed from: r  reason: collision with root package name */
    private long f9217r;

    /* renamed from: s  reason: collision with root package name */
    private int f9218s;

    /* renamed from: t  reason: collision with root package name */
    private long f9219t;

    /* renamed from: u  reason: collision with root package name */
    private TrackOutput f9220u;

    /* renamed from: v  reason: collision with root package name */
    private long f9221v;

    public AdtsReader(boolean z2) {
        this(z2, (String) null, 0);
    }

    @EnsuresNonNull({"output", "currentOutput", "id3Output"})
    private void c() {
        Assertions.f(this.f9206g);
        Util.i(this.f9220u);
        Util.i(this.f9207h);
    }

    private void g(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() != 0) {
            this.f9201b.f4688a[0] = parsableByteArray.e()[parsableByteArray.f()];
            this.f9201b.p(2);
            int h2 = this.f9201b.h(4);
            int i2 = this.f9214o;
            if (i2 == -1 || h2 == i2) {
                if (!this.f9212m) {
                    this.f9212m = true;
                    this.f9213n = this.f9215p;
                    this.f9214o = h2;
                }
                t();
                return;
            }
            q();
        }
    }

    private boolean h(ParsableByteArray parsableByteArray, int i2) {
        parsableByteArray.U(i2 + 1);
        if (!w(parsableByteArray, this.f9201b.f4688a, 1)) {
            return false;
        }
        this.f9201b.p(4);
        int h2 = this.f9201b.h(1);
        int i3 = this.f9213n;
        if (i3 != -1 && h2 != i3) {
            return false;
        }
        if (this.f9214o != -1) {
            if (!w(parsableByteArray, this.f9201b.f4688a, 1)) {
                return true;
            }
            this.f9201b.p(2);
            if (this.f9201b.h(4) != this.f9214o) {
                return false;
            }
            parsableByteArray.U(i2 + 2);
        }
        if (!w(parsableByteArray, this.f9201b.f4688a, 4)) {
            return true;
        }
        this.f9201b.p(14);
        int h3 = this.f9201b.h(13);
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
        int min = Math.min(parsableByteArray.a(), i2 - this.f9209j);
        parsableByteArray.l(bArr, this.f9209j, min);
        int i3 = this.f9209j + min;
        this.f9209j = i3;
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
            if (this.f9210k != 512 || !l((byte) -1, (byte) b2) || (!this.f9212m && !h(parsableByteArray, i2 - 2))) {
                int i3 = this.f9210k;
                byte b3 = b2 | i3;
                if (b3 == 329) {
                    this.f9210k = 768;
                } else if (b3 == 511) {
                    this.f9210k = 512;
                } else if (b3 == 836) {
                    this.f9210k = 1024;
                } else if (b3 == 1075) {
                    u();
                    parsableByteArray.U(i2);
                    return;
                } else if (i3 != 256) {
                    this.f9210k = UserVerificationMethods.USER_VERIFY_HANDPRINT;
                    i2--;
                }
                f2 = i2;
            } else {
                this.f9215p = (b2 & 8) >> 3;
                boolean z2 = true;
                if ((b2 & 1) != 0) {
                    z2 = false;
                }
                this.f9211l = z2;
                if (!this.f9212m) {
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
        this.f9201b.p(0);
        if (!this.f9216q) {
            int h2 = this.f9201b.h(2) + 1;
            if (h2 != 2) {
                Log.h("AdtsReader", "Detected audio object type: " + h2 + ", but assuming AAC LC.");
                h2 = 2;
            }
            this.f9201b.r(5);
            byte[] a2 = AacUtil.a(h2, this.f9214o, this.f9201b.h(3));
            AacUtil.Config e2 = AacUtil.e(a2);
            Format K = new Format.Builder().a0(this.f9205f).o0("audio/mp4a-latm").O(e2.f7897c).N(e2.f7896b).p0(e2.f7895a).b0(Collections.singletonList(a2)).e0(this.f9203d).m0(this.f9204e).K();
            this.f9217r = 1024000000 / ((long) K.C);
            this.f9206g.c(K);
            this.f9216q = true;
        } else {
            this.f9201b.r(10);
        }
        this.f9201b.r(4);
        int h3 = (this.f9201b.h(13) - 2) - 5;
        if (this.f9211l) {
            h3 -= 2;
        }
        v(this.f9206g, this.f9217r, 0, h3);
    }

    @RequiresNonNull({"id3Output"})
    private void o() {
        this.f9207h.b(this.f9202c, 10);
        this.f9202c.U(6);
        v(this.f9207h, 0, 10, this.f9202c.G() + 10);
    }

    @RequiresNonNull({"currentOutput"})
    private void p(ParsableByteArray parsableByteArray) {
        boolean z2;
        int min = Math.min(parsableByteArray.a(), this.f9218s - this.f9209j);
        this.f9220u.b(parsableByteArray, min);
        int i2 = this.f9209j + min;
        this.f9209j = i2;
        if (i2 == this.f9218s) {
            if (this.f9219t != -9223372036854775807L) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.h(z2);
            this.f9220u.f(this.f9219t, 1, this.f9218s, 0, (TrackOutput.CryptoData) null);
            this.f9219t += this.f9221v;
            s();
        }
    }

    private void q() {
        this.f9212m = false;
        s();
    }

    private void r() {
        this.f9208i = 1;
        this.f9209j = 0;
    }

    private void s() {
        this.f9208i = 0;
        this.f9209j = 0;
        this.f9210k = UserVerificationMethods.USER_VERIFY_HANDPRINT;
    }

    private void t() {
        this.f9208i = 3;
        this.f9209j = 0;
    }

    private void u() {
        this.f9208i = 2;
        this.f9209j = f9199w.length;
        this.f9218s = 0;
        this.f9202c.U(0);
    }

    private void v(TrackOutput trackOutput, long j2, int i2, int i3) {
        this.f9208i = 4;
        this.f9209j = i2;
        this.f9220u = trackOutput;
        this.f9221v = j2;
        this.f9218s = i3;
    }

    private boolean w(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        if (parsableByteArray.a() < i2) {
            return false;
        }
        parsableByteArray.l(bArr, 0, i2);
        return true;
    }

    public void a() {
        this.f9219t = -9223372036854775807L;
        q();
    }

    public void b(ParsableByteArray parsableByteArray) throws ParserException {
        int i2;
        c();
        while (parsableByteArray.a() > 0) {
            int i3 = this.f9208i;
            if (i3 == 0) {
                j(parsableByteArray);
            } else if (i3 == 1) {
                g(parsableByteArray);
            } else if (i3 != 2) {
                if (i3 == 3) {
                    if (this.f9211l) {
                        i2 = 7;
                    } else {
                        i2 = 5;
                    }
                    if (i(parsableByteArray, this.f9201b.f4688a, i2)) {
                        n();
                    }
                } else if (i3 == 4) {
                    p(parsableByteArray);
                } else {
                    throw new IllegalStateException();
                }
            } else if (i(parsableByteArray, this.f9202c.e(), 10)) {
                o();
            }
        }
    }

    public void d(long j2, int i2) {
        this.f9219t = j2;
    }

    public void e(boolean z2) {
    }

    public void f(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f9205f = trackIdGenerator.b();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 1);
        this.f9206g = d2;
        this.f9220u = d2;
        if (this.f9200a) {
            trackIdGenerator.a();
            TrackOutput d3 = extractorOutput.d(trackIdGenerator.c(), 5);
            this.f9207h = d3;
            d3.c(new Format.Builder().a0(trackIdGenerator.b()).o0("application/id3").K());
            return;
        }
        this.f9207h = new DiscardingTrackOutput();
    }

    public long k() {
        return this.f9217r;
    }

    public AdtsReader(boolean z2, String str, int i2) {
        this.f9201b = new ParsableBitArray(new byte[7]);
        this.f9202c = new ParsableByteArray(Arrays.copyOf(f9199w, 10));
        s();
        this.f9213n = -1;
        this.f9214o = -1;
        this.f9217r = -9223372036854775807L;
        this.f9219t = -9223372036854775807L;
        this.f9200a = z2;
        this.f9203d = str;
        this.f9204e = i2;
    }
}
