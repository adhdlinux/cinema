package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class AdtsExtractor implements Extractor {

    /* renamed from: m  reason: collision with root package name */
    public static final ExtractorsFactory f24802m = new c();

    /* renamed from: a  reason: collision with root package name */
    private final int f24803a;

    /* renamed from: b  reason: collision with root package name */
    private final AdtsReader f24804b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f24805c;

    /* renamed from: d  reason: collision with root package name */
    private final ParsableByteArray f24806d;

    /* renamed from: e  reason: collision with root package name */
    private final ParsableBitArray f24807e;

    /* renamed from: f  reason: collision with root package name */
    private ExtractorOutput f24808f;

    /* renamed from: g  reason: collision with root package name */
    private long f24809g;

    /* renamed from: h  reason: collision with root package name */
    private long f24810h;

    /* renamed from: i  reason: collision with root package name */
    private int f24811i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f24812j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f24813k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f24814l;

    public AdtsExtractor() {
        this(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(com.google.android.exoplayer2.extractor.ExtractorInput r10) throws java.io.IOException {
        /*
            r9 = this;
            boolean r0 = r9.f24812j
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = -1
            r9.f24811i = r0
            r10.e()
            long r1 = r10.getPosition()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0018
            r9.k(r10)
        L_0x0018:
            r1 = 0
            r2 = 0
        L_0x001a:
            r5 = 1
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r9.f24806d     // Catch:{ EOFException -> 0x0076 }
            byte[] r6 = r6.e()     // Catch:{ EOFException -> 0x0076 }
            r7 = 2
            boolean r6 = r10.c(r6, r1, r7, r5)     // Catch:{ EOFException -> 0x0076 }
            if (r6 == 0) goto L_0x0077
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r9.f24806d     // Catch:{ EOFException -> 0x0076 }
            r6.U(r1)     // Catch:{ EOFException -> 0x0076 }
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r9.f24806d     // Catch:{ EOFException -> 0x0076 }
            int r6 = r6.N()     // Catch:{ EOFException -> 0x0076 }
            boolean r6 = com.google.android.exoplayer2.extractor.ts.AdtsReader.m(r6)     // Catch:{ EOFException -> 0x0076 }
            if (r6 != 0) goto L_0x003a
            goto L_0x0078
        L_0x003a:
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r9.f24806d     // Catch:{ EOFException -> 0x0076 }
            byte[] r6 = r6.e()     // Catch:{ EOFException -> 0x0076 }
            r7 = 4
            boolean r6 = r10.c(r6, r1, r7, r5)     // Catch:{ EOFException -> 0x0076 }
            if (r6 != 0) goto L_0x0048
            goto L_0x0077
        L_0x0048:
            com.google.android.exoplayer2.util.ParsableBitArray r6 = r9.f24807e     // Catch:{ EOFException -> 0x0076 }
            r7 = 14
            r6.p(r7)     // Catch:{ EOFException -> 0x0076 }
            com.google.android.exoplayer2.util.ParsableBitArray r6 = r9.f24807e     // Catch:{ EOFException -> 0x0076 }
            r7 = 13
            int r6 = r6.h(r7)     // Catch:{ EOFException -> 0x0076 }
            r7 = 6
            if (r6 <= r7) goto L_0x006c
            long r7 = (long) r6     // Catch:{ EOFException -> 0x0076 }
            long r3 = r3 + r7
            int r2 = r2 + 1
            r7 = 1000(0x3e8, float:1.401E-42)
            if (r2 != r7) goto L_0x0063
            goto L_0x006b
        L_0x0063:
            int r6 = r6 + -6
            boolean r6 = r10.l(r6, r5)     // Catch:{ EOFException -> 0x0076 }
            if (r6 != 0) goto L_0x001a
        L_0x006b:
            goto L_0x0077
        L_0x006c:
            r9.f24812j = r5     // Catch:{ EOFException -> 0x0076 }
            java.lang.String r1 = "Malformed ADTS stream"
            r6 = 0
            com.google.android.exoplayer2.ParserException r1 = com.google.android.exoplayer2.ParserException.a(r1, r6)     // Catch:{ EOFException -> 0x0076 }
            throw r1     // Catch:{ EOFException -> 0x0076 }
        L_0x0076:
        L_0x0077:
            r1 = r2
        L_0x0078:
            r10.e()
            if (r1 <= 0) goto L_0x0083
            long r0 = (long) r1
            long r3 = r3 / r0
            int r10 = (int) r3
            r9.f24811i = r10
            goto L_0x0085
        L_0x0083:
            r9.f24811i = r0
        L_0x0085:
            r9.f24812j = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.AdtsExtractor.d(com.google.android.exoplayer2.extractor.ExtractorInput):void");
    }

    private static int e(int i2, long j2) {
        return (int) (((((long) i2) * 8) * 1000000) / j2);
    }

    private SeekMap f(long j2, boolean z2) {
        return new ConstantBitrateSeekMap(j2, this.f24810h, e(this.f24811i, this.f24804b.k()), this.f24811i, z2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] h() {
        return new Extractor[]{new AdtsExtractor()};
    }

    @RequiresNonNull({"extractorOutput"})
    private void j(long j2, boolean z2) {
        boolean z3;
        if (!this.f24814l) {
            boolean z4 = false;
            if ((this.f24803a & 1) == 0 || this.f24811i <= 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z3 || this.f24804b.k() != -9223372036854775807L || z2) {
                if (!z3 || this.f24804b.k() == -9223372036854775807L) {
                    this.f24808f.u(new SeekMap.Unseekable(-9223372036854775807L));
                } else {
                    ExtractorOutput extractorOutput = this.f24808f;
                    if ((this.f24803a & 2) != 0) {
                        z4 = true;
                    }
                    extractorOutput.u(f(j2, z4));
                }
                this.f24814l = true;
            }
        }
    }

    private int k(ExtractorInput extractorInput) throws IOException {
        int i2 = 0;
        while (true) {
            extractorInput.m(this.f24806d.e(), 0, 10);
            this.f24806d.U(0);
            if (this.f24806d.K() != 4801587) {
                break;
            }
            this.f24806d.V(3);
            int G = this.f24806d.G();
            i2 += G + 10;
            extractorInput.h(G);
        }
        extractorInput.e();
        extractorInput.h(i2);
        if (this.f24810h == -1) {
            this.f24810h = (long) i2;
        }
        return i2;
    }

    public void a(long j2, long j3) {
        this.f24813k = false;
        this.f24804b.a();
        this.f24809g = j3;
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f24808f = extractorOutput;
        this.f24804b.e(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.m();
    }

    public boolean g(ExtractorInput extractorInput) throws IOException {
        int k2 = k(extractorInput);
        int i2 = k2;
        int i3 = 0;
        int i4 = 0;
        do {
            extractorInput.m(this.f24806d.e(), 0, 2);
            this.f24806d.U(0);
            if (!AdtsReader.m(this.f24806d.N())) {
                i2++;
                extractorInput.e();
                extractorInput.h(i2);
            } else {
                i3++;
                if (i3 >= 4 && i4 > 188) {
                    return true;
                }
                extractorInput.m(this.f24806d.e(), 0, 4);
                this.f24807e.p(14);
                int h2 = this.f24807e.h(13);
                if (h2 <= 6) {
                    i2++;
                    extractorInput.e();
                    extractorInput.h(i2);
                } else {
                    extractorInput.h(h2 - 6);
                    i4 += h2;
                }
            }
            i3 = 0;
            i4 = 0;
        } while (i2 - k2 < 8192);
        return false;
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z2;
        boolean z3;
        Assertions.i(this.f24808f);
        long length = extractorInput.getLength();
        int i2 = this.f24803a;
        if ((i2 & 2) == 0 && ((i2 & 1) == 0 || length == -1)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            d(extractorInput);
        }
        int read = extractorInput.read(this.f24805c.e(), 0, 2048);
        if (read == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        j(length, z3);
        if (z3) {
            return -1;
        }
        this.f24805c.U(0);
        this.f24805c.T(read);
        if (!this.f24813k) {
            this.f24804b.d(this.f24809g, 4);
            this.f24813k = true;
        }
        this.f24804b.c(this.f24805c);
        return 0;
    }

    public void release() {
    }

    public AdtsExtractor(int i2) {
        this.f24803a = (i2 & 2) != 0 ? i2 | 1 : i2;
        this.f24804b = new AdtsReader(true);
        this.f24805c = new ParsableByteArray(2048);
        this.f24811i = -1;
        this.f24810h = -1;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        this.f24806d = parsableByteArray;
        this.f24807e = new ParsableBitArray(parsableByteArray.e());
    }
}
