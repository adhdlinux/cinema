package androidx.media3.extractor.ts;

import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.facebook.imageutils.JfifUtil;
import com.google.common.primitives.Ints;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class DtsReader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f9224a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f9225b = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    private final String f9226c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9227d;

    /* renamed from: e  reason: collision with root package name */
    private String f9228e;

    /* renamed from: f  reason: collision with root package name */
    private TrackOutput f9229f;

    /* renamed from: g  reason: collision with root package name */
    private int f9230g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f9231h;

    /* renamed from: i  reason: collision with root package name */
    private int f9232i;

    /* renamed from: j  reason: collision with root package name */
    private long f9233j;

    /* renamed from: k  reason: collision with root package name */
    private Format f9234k;

    /* renamed from: l  reason: collision with root package name */
    private int f9235l;

    /* renamed from: m  reason: collision with root package name */
    private int f9236m;

    /* renamed from: n  reason: collision with root package name */
    private int f9237n = -1;

    /* renamed from: o  reason: collision with root package name */
    private int f9238o = -1;

    /* renamed from: p  reason: collision with root package name */
    private long f9239p = -9223372036854775807L;

    public DtsReader(String str, int i2, int i3) {
        this.f9224a = new ParsableByteArray(new byte[i3]);
        this.f9226c = str;
        this.f9227d = i2;
    }

    private boolean c(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        int min = Math.min(parsableByteArray.a(), i2 - this.f9231h);
        parsableByteArray.l(bArr, this.f9231h, min);
        int i3 = this.f9231h + min;
        this.f9231h = i3;
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    @RequiresNonNull({"output"})
    private void g() {
        byte[] e2 = this.f9224a.e();
        if (this.f9234k == null) {
            Format h2 = DtsUtil.h(e2, this.f9228e, this.f9226c, this.f9227d, (DrmInitData) null);
            this.f9234k = h2;
            this.f9229f.c(h2);
        }
        this.f9235l = DtsUtil.b(e2);
        this.f9233j = (long) Ints.d(Util.b1((long) DtsUtil.g(e2), this.f9234k.C));
    }

    @RequiresNonNull({"output"})
    private void h() throws ParserException {
        DtsUtil.DtsHeader i2 = DtsUtil.i(this.f9224a.e());
        k(i2);
        this.f9235l = i2.f8010d;
        long j2 = i2.f8011e;
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        this.f9233j = j2;
    }

    @RequiresNonNull({"output"})
    private void i() throws ParserException {
        DtsUtil.DtsHeader k2 = DtsUtil.k(this.f9224a.e(), this.f9225b);
        if (this.f9236m == 3) {
            k(k2);
        }
        this.f9235l = k2.f8010d;
        long j2 = k2.f8011e;
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        this.f9233j = j2;
    }

    private boolean j(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.a() > 0) {
            int i2 = this.f9232i << 8;
            this.f9232i = i2;
            int H = i2 | parsableByteArray.H();
            this.f9232i = H;
            int c2 = DtsUtil.c(H);
            this.f9236m = c2;
            if (c2 != 0) {
                byte[] e2 = this.f9224a.e();
                int i3 = this.f9232i;
                e2[0] = (byte) ((i3 >> 24) & JfifUtil.MARKER_FIRST_BYTE);
                e2[1] = (byte) ((i3 >> 16) & JfifUtil.MARKER_FIRST_BYTE);
                e2[2] = (byte) ((i3 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
                e2[3] = (byte) (i3 & JfifUtil.MARKER_FIRST_BYTE);
                this.f9231h = 4;
                this.f9232i = 0;
                return true;
            }
        }
        return false;
    }

    @RequiresNonNull({"output"})
    private void k(DtsUtil.DtsHeader dtsHeader) {
        int i2;
        Format.Builder builder;
        int i3 = dtsHeader.f8008b;
        if (i3 != -2147483647 && (i2 = dtsHeader.f8009c) != -1) {
            Format format = this.f9234k;
            if (format == null || i2 != format.B || i3 != format.C || !Util.c(dtsHeader.f8007a, format.f4015n)) {
                Format format2 = this.f9234k;
                if (format2 == null) {
                    builder = new Format.Builder();
                } else {
                    builder = format2.a();
                }
                Format K = builder.a0(this.f9228e).o0(dtsHeader.f8007a).N(dtsHeader.f8009c).p0(dtsHeader.f8008b).e0(this.f9226c).m0(this.f9227d).K();
                this.f9234k = K;
                this.f9229f.c(K);
            }
        }
    }

    public void a() {
        this.f9230g = 0;
        this.f9231h = 0;
        this.f9232i = 0;
        this.f9239p = -9223372036854775807L;
        this.f9225b.set(0);
    }

    public void b(ParsableByteArray parsableByteArray) throws ParserException {
        boolean z2;
        int i2;
        Assertions.j(this.f9229f);
        while (parsableByteArray.a() > 0) {
            switch (this.f9230g) {
                case 0:
                    if (j(parsableByteArray)) {
                        int i3 = this.f9236m;
                        if (i3 != 3 && i3 != 4) {
                            if (i3 != 1) {
                                this.f9230g = 2;
                                break;
                            } else {
                                this.f9230g = 1;
                                break;
                            }
                        } else {
                            this.f9230g = 4;
                            break;
                        }
                    } else {
                        break;
                    }
                case 1:
                    if (!c(parsableByteArray, this.f9224a.e(), 18)) {
                        break;
                    } else {
                        g();
                        this.f9224a.U(0);
                        this.f9229f.b(this.f9224a, 18);
                        this.f9230g = 6;
                        break;
                    }
                case 2:
                    if (!c(parsableByteArray, this.f9224a.e(), 7)) {
                        break;
                    } else {
                        this.f9237n = DtsUtil.j(this.f9224a.e());
                        this.f9230g = 3;
                        break;
                    }
                case 3:
                    if (!c(parsableByteArray, this.f9224a.e(), this.f9237n)) {
                        break;
                    } else {
                        h();
                        this.f9224a.U(0);
                        this.f9229f.b(this.f9224a, this.f9237n);
                        this.f9230g = 6;
                        break;
                    }
                case 4:
                    if (!c(parsableByteArray, this.f9224a.e(), 6)) {
                        break;
                    } else {
                        int l2 = DtsUtil.l(this.f9224a.e());
                        this.f9238o = l2;
                        int i4 = this.f9231h;
                        if (i4 > l2) {
                            int i5 = i4 - l2;
                            this.f9231h = i4 - i5;
                            parsableByteArray.U(parsableByteArray.f() - i5);
                        }
                        this.f9230g = 5;
                        break;
                    }
                case 5:
                    if (!c(parsableByteArray, this.f9224a.e(), this.f9238o)) {
                        break;
                    } else {
                        i();
                        this.f9224a.U(0);
                        this.f9229f.b(this.f9224a, this.f9238o);
                        this.f9230g = 6;
                        break;
                    }
                case 6:
                    int min = Math.min(parsableByteArray.a(), this.f9235l - this.f9231h);
                    this.f9229f.b(parsableByteArray, min);
                    int i6 = this.f9231h + min;
                    this.f9231h = i6;
                    if (i6 == this.f9235l) {
                        if (this.f9239p != -9223372036854775807L) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        Assertions.h(z2);
                        TrackOutput trackOutput = this.f9229f;
                        long j2 = this.f9239p;
                        if (this.f9236m == 4) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        trackOutput.f(j2, i2, this.f9235l, 0, (TrackOutput.CryptoData) null);
                        this.f9239p += this.f9233j;
                        this.f9230g = 0;
                        break;
                    } else {
                        break;
                    }
                default:
                    throw new IllegalStateException();
            }
        }
    }

    public void d(long j2, int i2) {
        this.f9239p = j2;
    }

    public void e(boolean z2) {
    }

    public void f(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f9228e = trackIdGenerator.b();
        this.f9229f = extractorOutput.d(trackIdGenerator.c(), 1);
    }
}
