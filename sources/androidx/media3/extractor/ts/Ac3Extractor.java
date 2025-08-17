package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.d;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.io.IOException;
import java.util.List;

public final class Ac3Extractor implements Extractor {

    /* renamed from: d  reason: collision with root package name */
    public static final ExtractorsFactory f9151d = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Ac3Reader f9152a = new Ac3Reader();

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f9153b = new ParsableByteArray(2786);

    /* renamed from: c  reason: collision with root package name */
    private boolean f9154c;

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] d() {
        return new Extractor[]{new Ac3Extractor()};
    }

    public void a(long j2, long j3) {
        this.f9154c = false;
        this.f9152a.a();
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        this.f9152a.f(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.m();
        extractorOutput.r(new SeekMap.Unseekable(-9223372036854775807L));
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
    public boolean i(androidx.media3.extractor.ExtractorInput r8) throws java.io.IOException {
        /*
            r7 = this;
            androidx.media3.common.util.ParsableByteArray r0 = new androidx.media3.common.util.ParsableByteArray
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
            int r5 = androidx.media3.extractor.Ac3Util.g(r5)
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.Ac3Extractor.i(androidx.media3.extractor.ExtractorInput):boolean");
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int read = extractorInput.read(this.f9153b.e(), 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.f9153b.U(0);
        this.f9153b.T(read);
        if (!this.f9154c) {
            this.f9152a.d(0, 4);
            this.f9154c = true;
        }
        this.f9152a.b(this.f9153b);
        return 0;
    }

    public void release() {
    }
}
