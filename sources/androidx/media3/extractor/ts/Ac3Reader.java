package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class Ac3Reader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableBitArray f9155a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f9156b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9157c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9158d;

    /* renamed from: e  reason: collision with root package name */
    private String f9159e;

    /* renamed from: f  reason: collision with root package name */
    private TrackOutput f9160f;

    /* renamed from: g  reason: collision with root package name */
    private int f9161g;

    /* renamed from: h  reason: collision with root package name */
    private int f9162h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9163i;

    /* renamed from: j  reason: collision with root package name */
    private long f9164j;

    /* renamed from: k  reason: collision with root package name */
    private Format f9165k;

    /* renamed from: l  reason: collision with root package name */
    private int f9166l;

    /* renamed from: m  reason: collision with root package name */
    private long f9167m;

    public Ac3Reader() {
        this((String) null, 0);
    }

    private boolean c(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        int min = Math.min(parsableByteArray.a(), i2 - this.f9162h);
        parsableByteArray.l(bArr, this.f9162h, min);
        int i3 = this.f9162h + min;
        this.f9162h = i3;
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    @RequiresNonNull({"output"})
    private void g() {
        this.f9155a.p(0);
        Ac3Util.SyncFrameInfo f2 = Ac3Util.f(this.f9155a);
        Format format = this.f9165k;
        if (format == null || f2.f7907d != format.B || f2.f7906c != format.C || !Util.c(f2.f7904a, format.f4015n)) {
            Format.Builder j02 = new Format.Builder().a0(this.f9159e).o0(f2.f7904a).N(f2.f7907d).p0(f2.f7906c).e0(this.f9157c).m0(this.f9158d).j0(f2.f7910g);
            if ("audio/ac3".equals(f2.f7904a)) {
                j02.M(f2.f7910g);
            }
            Format K = j02.K();
            this.f9165k = K;
            this.f9160f.c(K);
        }
        this.f9166l = f2.f7908e;
        this.f9164j = (((long) f2.f7909f) * 1000000) / ((long) this.f9165k.C);
    }

    private boolean h(ParsableByteArray parsableByteArray) {
        while (true) {
            boolean z2 = false;
            if (parsableByteArray.a() <= 0) {
                return false;
            }
            if (!this.f9163i) {
                if (parsableByteArray.H() == 11) {
                    z2 = true;
                }
                this.f9163i = z2;
            } else {
                int H = parsableByteArray.H();
                if (H == 119) {
                    this.f9163i = false;
                    return true;
                }
                if (H == 11) {
                    z2 = true;
                }
                this.f9163i = z2;
            }
        }
    }

    public void a() {
        this.f9161g = 0;
        this.f9162h = 0;
        this.f9163i = false;
        this.f9167m = -9223372036854775807L;
    }

    public void b(ParsableByteArray parsableByteArray) {
        Assertions.j(this.f9160f);
        while (parsableByteArray.a() > 0) {
            int i2 = this.f9161g;
            boolean z2 = true;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(parsableByteArray.a(), this.f9166l - this.f9162h);
                        this.f9160f.b(parsableByteArray, min);
                        int i3 = this.f9162h + min;
                        this.f9162h = i3;
                        if (i3 == this.f9166l) {
                            if (this.f9167m == -9223372036854775807L) {
                                z2 = false;
                            }
                            Assertions.h(z2);
                            this.f9160f.f(this.f9167m, 1, this.f9166l, 0, (TrackOutput.CryptoData) null);
                            this.f9167m += this.f9164j;
                            this.f9161g = 0;
                        }
                    }
                } else if (c(parsableByteArray, this.f9156b.e(), 128)) {
                    g();
                    this.f9156b.U(0);
                    this.f9160f.b(this.f9156b, 128);
                    this.f9161g = 2;
                }
            } else if (h(parsableByteArray)) {
                this.f9161g = 1;
                this.f9156b.e()[0] = 11;
                this.f9156b.e()[1] = 119;
                this.f9162h = 2;
            }
        }
    }

    public void d(long j2, int i2) {
        this.f9167m = j2;
    }

    public void e(boolean z2) {
    }

    public void f(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f9159e = trackIdGenerator.b();
        this.f9160f = extractorOutput.d(trackIdGenerator.c(), 1);
    }

    public Ac3Reader(String str, int i2) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[128]);
        this.f9155a = parsableBitArray;
        this.f9156b = new ParsableByteArray(parsableBitArray.f4688a);
        this.f9161g = 0;
        this.f9167m = -9223372036854775807L;
        this.f9157c = str;
        this.f9158d = i2;
    }
}
