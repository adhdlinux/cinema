package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

public final class Ac3Extractor implements Extractor {

    /* renamed from: d  reason: collision with root package name */
    public static final ExtractorsFactory f24769d = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Ac3Reader f24770a = new Ac3Reader();

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f24771b = new ParsableByteArray(2786);

    /* renamed from: c  reason: collision with root package name */
    private boolean f24772c;

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] d() {
        return new Extractor[]{new Ac3Extractor()};
    }

    public void a(long j2, long j3) {
        this.f24772c = false;
        this.f24770a.a();
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f24770a.e(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.m();
        extractorOutput.u(new SeekMap.Unseekable(-9223372036854775807L));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0037, code lost:
        r8.e();
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0040, code lost:
        if ((r4 - r3) < 8192) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g(com.google.android.exoplayer2.extractor.ExtractorInput r8) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.exoplayer2.util.ParsableByteArray r0 = new com.google.android.exoplayer2.util.ParsableByteArray
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.e()
            r8.m(r4, r2, r1)
            r0.U(r2)
            int r4 = r0.K()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L_0x005f
            r8.e()
            r8.h(r3)
            r4 = r3
        L_0x0023:
            r1 = 0
        L_0x0024:
            byte[] r5 = r0.e()
            r6 = 6
            r8.m(r5, r2, r6)
            r0.U(r2)
            int r5 = r0.N()
            r6 = 2935(0xb77, float:4.113E-42)
            if (r5 == r6) goto L_0x0047
            r8.e()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r5) goto L_0x0043
            return r2
        L_0x0043:
            r8.h(r4)
            goto L_0x0023
        L_0x0047:
            r5 = 1
            int r1 = r1 + r5
            r6 = 4
            if (r1 < r6) goto L_0x004d
            return r5
        L_0x004d:
            byte[] r5 = r0.e()
            int r5 = com.google.android.exoplayer2.audio.Ac3Util.g(r5)
            r6 = -1
            if (r5 != r6) goto L_0x0059
            return r2
        L_0x0059:
            int r5 = r5 + -6
            r8.h(r5)
            goto L_0x0024
        L_0x005f:
            r4 = 3
            r0.V(r4)
            int r4 = r0.G()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r8.h(r4)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.Ac3Extractor.g(com.google.android.exoplayer2.extractor.ExtractorInput):boolean");
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int read = extractorInput.read(this.f24771b.e(), 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.f24771b.U(0);
        this.f24771b.T(read);
        if (!this.f24772c) {
            this.f24770a.d(0, 4);
            this.f24772c = true;
        }
        this.f24770a.c(this.f24771b);
        return 0;
    }

    public void release() {
    }
}
