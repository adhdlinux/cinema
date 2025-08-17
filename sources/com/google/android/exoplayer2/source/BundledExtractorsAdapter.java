package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class BundledExtractorsAdapter implements ProgressiveMediaExtractor {

    /* renamed from: a  reason: collision with root package name */
    private final ExtractorsFactory f25693a;

    /* renamed from: b  reason: collision with root package name */
    private Extractor f25694b;

    /* renamed from: c  reason: collision with root package name */
    private ExtractorInput f25695c;

    public BundledExtractorsAdapter(ExtractorsFactory extractorsFactory) {
        this.f25693a = extractorsFactory;
    }

    public void a(long j2, long j3) {
        ((Extractor) Assertions.e(this.f25694b)).a(j2, j3);
    }

    public void b() {
        Extractor extractor = this.f25694b;
        if (extractor instanceof Mp3Extractor) {
            ((Mp3Extractor) extractor).j();
        }
    }

    public long c() {
        ExtractorInput extractorInput = this.f25695c;
        if (extractorInput != null) {
            return extractorInput.getPosition();
        }
        return -1;
    }

    public int d(PositionHolder positionHolder) throws IOException {
        return ((Extractor) Assertions.e(this.f25694b)).i((ExtractorInput) Assertions.e(this.f25695c), positionHolder);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r0.getPosition() != r11) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0062, code lost:
        if (r0.getPosition() != r11) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
        r1 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(com.google.android.exoplayer2.upstream.DataReader r8, android.net.Uri r9, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r10, long r11, long r13, com.google.android.exoplayer2.extractor.ExtractorOutput r15) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.exoplayer2.extractor.DefaultExtractorInput r6 = new com.google.android.exoplayer2.extractor.DefaultExtractorInput
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.f25695c = r6
            com.google.android.exoplayer2.extractor.Extractor r8 = r7.f25694b
            if (r8 == 0) goto L_0x0010
            return
        L_0x0010:
            com.google.android.exoplayer2.extractor.ExtractorsFactory r8 = r7.f25693a
            com.google.android.exoplayer2.extractor.Extractor[] r8 = r8.b(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L_0x0020
            r8 = r8[r13]
            r7.f25694b = r8
            goto L_0x0075
        L_0x0020:
            int r10 = r8.length
            r0 = 0
        L_0x0022:
            if (r0 >= r10) goto L_0x0071
            r1 = r8[r0]
            boolean r2 = r1.g(r6)     // Catch:{ EOFException -> 0x0057, all -> 0x0042 }
            if (r2 == 0) goto L_0x0035
            r7.f25694b = r1     // Catch:{ EOFException -> 0x0057, all -> 0x0042 }
            com.google.android.exoplayer2.util.Assertions.g(r14)
            r6.e()
            goto L_0x0071
        L_0x0035:
            com.google.android.exoplayer2.extractor.Extractor r1 = r7.f25694b
            if (r1 != 0) goto L_0x0067
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0065
            goto L_0x0067
        L_0x0042:
            r8 = move-exception
            com.google.android.exoplayer2.extractor.Extractor r9 = r7.f25694b
            if (r9 != 0) goto L_0x004f
            long r9 = r6.getPosition()
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 != 0) goto L_0x0050
        L_0x004f:
            r13 = 1
        L_0x0050:
            com.google.android.exoplayer2.util.Assertions.g(r13)
            r6.e()
            throw r8
        L_0x0057:
            com.google.android.exoplayer2.extractor.Extractor r1 = r7.f25694b
            if (r1 != 0) goto L_0x0067
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r1 = 0
            goto L_0x0068
        L_0x0067:
            r1 = 1
        L_0x0068:
            com.google.android.exoplayer2.util.Assertions.g(r1)
            r6.e()
            int r0 = r0 + 1
            goto L_0x0022
        L_0x0071:
            com.google.android.exoplayer2.extractor.Extractor r10 = r7.f25694b
            if (r10 == 0) goto L_0x007b
        L_0x0075:
            com.google.android.exoplayer2.extractor.Extractor r8 = r7.f25694b
            r8.c(r15)
            return
        L_0x007b:
            com.google.android.exoplayer2.source.UnrecognizedInputFormatException r10 = new com.google.android.exoplayer2.source.UnrecognizedInputFormatException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "None of the available extractors ("
            r11.append(r12)
            java.lang.String r8 = com.google.android.exoplayer2.util.Util.M(r8)
            r11.append(r8)
            java.lang.String r8 = ") could read the stream."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            java.lang.Object r9 = com.google.android.exoplayer2.util.Assertions.e(r9)
            android.net.Uri r9 = (android.net.Uri) r9
            r10.<init>(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.BundledExtractorsAdapter.e(com.google.android.exoplayer2.upstream.DataReader, android.net.Uri, java.util.Map, long, long, com.google.android.exoplayer2.extractor.ExtractorOutput):void");
    }

    public void release() {
        Extractor extractor = this.f25694b;
        if (extractor != null) {
            extractor.release();
            this.f25694b = null;
        }
        this.f25695c = null;
    }
}
