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
import okhttp3.internal.http2.Http2;

public final class Ac4Extractor implements Extractor {

    /* renamed from: d  reason: collision with root package name */
    public static final ExtractorsFactory f24785d = new b();

    /* renamed from: a  reason: collision with root package name */
    private final Ac4Reader f24786a = new Ac4Reader();

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f24787b = new ParsableByteArray((int) Http2.INITIAL_MAX_FRAME_SIZE);

    /* renamed from: c  reason: collision with root package name */
    private boolean f24788c;

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] d() {
        return new Extractor[]{new Ac4Extractor()};
    }

    public void a(long j2, long j3) {
        this.f24788c = false;
        this.f24786a.a();
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f24786a.e(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.m();
        extractorOutput.u(new SeekMap.Unseekable(-9223372036854775807L));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0046, code lost:
        if ((r4 - r3) < 8192) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
        r9.e();
        r4 = r4 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g(com.google.android.exoplayer2.extractor.ExtractorInput r9) throws java.io.IOException {
        /*
            r8 = this;
            com.google.android.exoplayer2.util.ParsableByteArray r0 = new com.google.android.exoplayer2.util.ParsableByteArray
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.e()
            r9.m(r4, r2, r1)
            r0.U(r2)
            int r4 = r0.K()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L_0x0065
            r9.e()
            r9.h(r3)
            r4 = r3
        L_0x0023:
            r1 = 0
        L_0x0024:
            byte[] r5 = r0.e()
            r6 = 7
            r9.m(r5, r2, r6)
            r0.U(r2)
            int r5 = r0.N()
            r6 = 44096(0xac40, float:6.1792E-41)
            if (r5 == r6) goto L_0x004d
            r6 = 44097(0xac41, float:6.1793E-41)
            if (r5 == r6) goto L_0x004d
            r9.e()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r5) goto L_0x0049
            return r2
        L_0x0049:
            r9.h(r4)
            goto L_0x0023
        L_0x004d:
            r6 = 1
            int r1 = r1 + r6
            r7 = 4
            if (r1 < r7) goto L_0x0053
            return r6
        L_0x0053:
            byte[] r6 = r0.e()
            int r5 = com.google.android.exoplayer2.audio.Ac4Util.e(r6, r5)
            r6 = -1
            if (r5 != r6) goto L_0x005f
            return r2
        L_0x005f:
            int r5 = r5 + -7
            r9.h(r5)
            goto L_0x0024
        L_0x0065:
            r4 = 3
            r0.V(r4)
            int r4 = r0.G()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r9.h(r4)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.Ac4Extractor.g(com.google.android.exoplayer2.extractor.ExtractorInput):boolean");
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int read = extractorInput.read(this.f24787b.e(), 0, Http2.INITIAL_MAX_FRAME_SIZE);
        if (read == -1) {
            return -1;
        }
        this.f24787b.U(0);
        this.f24787b.T(read);
        if (!this.f24788c) {
            this.f24786a.d(0, 4);
            this.f24788c = true;
        }
        this.f24786a.c(this.f24787b);
        return 0;
    }

    public void release() {
    }
}
