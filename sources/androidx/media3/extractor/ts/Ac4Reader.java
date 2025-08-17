package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class Ac4Reader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableBitArray f9172a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f9173b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9174c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9175d;

    /* renamed from: e  reason: collision with root package name */
    private String f9176e;

    /* renamed from: f  reason: collision with root package name */
    private TrackOutput f9177f;

    /* renamed from: g  reason: collision with root package name */
    private int f9178g;

    /* renamed from: h  reason: collision with root package name */
    private int f9179h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9180i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9181j;

    /* renamed from: k  reason: collision with root package name */
    private long f9182k;

    /* renamed from: l  reason: collision with root package name */
    private Format f9183l;

    /* renamed from: m  reason: collision with root package name */
    private int f9184m;

    /* renamed from: n  reason: collision with root package name */
    private long f9185n;

    public Ac4Reader() {
        this((String) null, 0);
    }

    private boolean c(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        int min = Math.min(parsableByteArray.a(), i2 - this.f9179h);
        parsableByteArray.l(bArr, this.f9179h, min);
        int i3 = this.f9179h + min;
        this.f9179h = i3;
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    @RequiresNonNull({"output"})
    private void g() {
        this.f9172a.p(0);
        Ac4Util.SyncFrameInfo d2 = Ac4Util.d(this.f9172a);
        Format format = this.f9183l;
        if (format == null || d2.f7914c != format.B || d2.f7913b != format.C || !"audio/ac4".equals(format.f4015n)) {
            Format K = new Format.Builder().a0(this.f9176e).o0("audio/ac4").N(d2.f7914c).p0(d2.f7913b).e0(this.f9174c).m0(this.f9175d).K();
            this.f9183l = K;
            this.f9177f.c(K);
        }
        this.f9184m = d2.f7915d;
        this.f9182k = (((long) d2.f7916e) * 1000000) / ((long) this.f9183l.C);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean h(androidx.media3.common.util.ParsableByteArray r6) {
        /*
            r5 = this;
        L_0x0000:
            int r0 = r6.a()
            r1 = 0
            if (r0 <= 0) goto L_0x0031
            boolean r0 = r5.f9180i
            r2 = 172(0xac, float:2.41E-43)
            r3 = 1
            if (r0 != 0) goto L_0x0018
            int r0 = r6.H()
            if (r0 != r2) goto L_0x0015
            r1 = 1
        L_0x0015:
            r5.f9180i = r1
            goto L_0x0000
        L_0x0018:
            int r0 = r6.H()
            if (r0 != r2) goto L_0x0020
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            r5.f9180i = r2
            r2 = 64
            r4 = 65
            if (r0 == r2) goto L_0x002b
            if (r0 != r4) goto L_0x0000
        L_0x002b:
            if (r0 != r4) goto L_0x002e
            r1 = 1
        L_0x002e:
            r5.f9181j = r1
            return r3
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.Ac4Reader.h(androidx.media3.common.util.ParsableByteArray):boolean");
    }

    public void a() {
        this.f9178g = 0;
        this.f9179h = 0;
        this.f9180i = false;
        this.f9181j = false;
        this.f9185n = -9223372036854775807L;
    }

    public void b(ParsableByteArray parsableByteArray) {
        int i2;
        Assertions.j(this.f9177f);
        while (parsableByteArray.a() > 0) {
            int i3 = this.f9178g;
            boolean z2 = true;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        int min = Math.min(parsableByteArray.a(), this.f9184m - this.f9179h);
                        this.f9177f.b(parsableByteArray, min);
                        int i4 = this.f9179h + min;
                        this.f9179h = i4;
                        if (i4 == this.f9184m) {
                            if (this.f9185n == -9223372036854775807L) {
                                z2 = false;
                            }
                            Assertions.h(z2);
                            this.f9177f.f(this.f9185n, 1, this.f9184m, 0, (TrackOutput.CryptoData) null);
                            this.f9185n += this.f9182k;
                            this.f9178g = 0;
                        }
                    }
                } else if (c(parsableByteArray, this.f9173b.e(), 16)) {
                    g();
                    this.f9173b.U(0);
                    this.f9177f.b(this.f9173b, 16);
                    this.f9178g = 2;
                }
            } else if (h(parsableByteArray)) {
                this.f9178g = 1;
                this.f9173b.e()[0] = -84;
                byte[] e2 = this.f9173b.e();
                if (this.f9181j) {
                    i2 = 65;
                } else {
                    i2 = 64;
                }
                e2[1] = (byte) i2;
                this.f9179h = 2;
            }
        }
    }

    public void d(long j2, int i2) {
        this.f9185n = j2;
    }

    public void e(boolean z2) {
    }

    public void f(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f9176e = trackIdGenerator.b();
        this.f9177f = extractorOutput.d(trackIdGenerator.c(), 1);
    }

    public Ac4Reader(String str, int i2) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[16]);
        this.f9172a = parsableBitArray;
        this.f9173b = new ParsableByteArray(parsableBitArray.f4688a);
        this.f9178g = 0;
        this.f9179h = 0;
        this.f9180i = false;
        this.f9181j = false;
        this.f9185n = -9223372036854775807L;
        this.f9174c = str;
        this.f9175d = i2;
    }
}
