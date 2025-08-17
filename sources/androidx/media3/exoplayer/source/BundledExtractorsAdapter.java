package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.mp3.Mp3Extractor;
import java.io.IOException;

public final class BundledExtractorsAdapter implements ProgressiveMediaExtractor {

    /* renamed from: a  reason: collision with root package name */
    private final ExtractorsFactory f6817a;

    /* renamed from: b  reason: collision with root package name */
    private Extractor f6818b;

    /* renamed from: c  reason: collision with root package name */
    private ExtractorInput f6819c;

    public BundledExtractorsAdapter(ExtractorsFactory extractorsFactory) {
        this.f6817a = extractorsFactory;
    }

    public void a(long j2, long j3) {
        ((Extractor) Assertions.f(this.f6818b)).a(j2, j3);
    }

    public void b() {
        Extractor extractor = this.f6818b;
        if (extractor != null) {
            Extractor c2 = extractor.c();
            if (c2 instanceof Mp3Extractor) {
                ((Mp3Extractor) c2).l();
            }
        }
    }

    public long c() {
        ExtractorInput extractorInput = this.f6819c;
        if (extractorInput != null) {
            return extractorInput.getPosition();
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        if (r0.getPosition() != r11) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006e, code lost:
        if (r0.getPosition() != r11) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0071, code lost:
        r2 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(androidx.media3.common.DataReader r8, android.net.Uri r9, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r10, long r11, long r13, androidx.media3.extractor.ExtractorOutput r15) throws java.io.IOException {
        /*
            r7 = this;
            androidx.media3.extractor.DefaultExtractorInput r6 = new androidx.media3.extractor.DefaultExtractorInput
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.f6819c = r6
            androidx.media3.extractor.Extractor r8 = r7.f6818b
            if (r8 == 0) goto L_0x0010
            return
        L_0x0010:
            androidx.media3.extractor.ExtractorsFactory r8 = r7.f6817a
            androidx.media3.extractor.Extractor[] r8 = r8.b(r9, r10)
            int r10 = r8.length
            com.google.common.collect.ImmutableList$Builder r10 = com.google.common.collect.ImmutableList.l(r10)
            int r13 = r8.length
            r14 = 0
            r0 = 1
            if (r13 != r0) goto L_0x0025
            r8 = r8[r14]
            r7.f6818b = r8
            goto L_0x0081
        L_0x0025:
            int r13 = r8.length
            r1 = 0
        L_0x0027:
            if (r1 >= r13) goto L_0x007d
            r2 = r8[r1]
            boolean r3 = r2.i(r6)     // Catch:{ EOFException -> 0x0063, all -> 0x004e }
            if (r3 == 0) goto L_0x003a
            r7.f6818b = r2     // Catch:{ EOFException -> 0x0063, all -> 0x004e }
            androidx.media3.common.util.Assertions.h(r0)
            r6.e()
            goto L_0x007d
        L_0x003a:
            java.util.List r2 = r2.j()     // Catch:{ EOFException -> 0x0063, all -> 0x004e }
            r10.j(r2)     // Catch:{ EOFException -> 0x0063, all -> 0x004e }
            androidx.media3.extractor.Extractor r2 = r7.f6818b
            if (r2 != 0) goto L_0x0073
            long r2 = r6.getPosition()
            int r4 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r4 != 0) goto L_0x0071
            goto L_0x0073
        L_0x004e:
            r8 = move-exception
            androidx.media3.extractor.Extractor r9 = r7.f6818b
            if (r9 != 0) goto L_0x005b
            long r9 = r6.getPosition()
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x005c
        L_0x005b:
            r14 = 1
        L_0x005c:
            androidx.media3.common.util.Assertions.h(r14)
            r6.e()
            throw r8
        L_0x0063:
            androidx.media3.extractor.Extractor r2 = r7.f6818b
            if (r2 != 0) goto L_0x0073
            long r2 = r6.getPosition()
            int r4 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r4 != 0) goto L_0x0071
            goto L_0x0073
        L_0x0071:
            r2 = 0
            goto L_0x0074
        L_0x0073:
            r2 = 1
        L_0x0074:
            androidx.media3.common.util.Assertions.h(r2)
            r6.e()
            int r1 = r1 + 1
            goto L_0x0027
        L_0x007d:
            androidx.media3.extractor.Extractor r11 = r7.f6818b
            if (r11 == 0) goto L_0x0087
        L_0x0081:
            androidx.media3.extractor.Extractor r8 = r7.f6818b
            r8.g(r15)
            return
        L_0x0087:
            androidx.media3.exoplayer.source.UnrecognizedInputFormatException r11 = new androidx.media3.exoplayer.source.UnrecognizedInputFormatException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "None of the available extractors ("
            r12.append(r13)
            java.lang.String r13 = ", "
            com.google.common.base.Joiner r13 = com.google.common.base.Joiner.on(r13)
            com.google.common.collect.ImmutableList r8 = com.google.common.collect.ImmutableList.o(r8)
            androidx.media3.exoplayer.source.a r14 = new androidx.media3.exoplayer.source.a
            r14.<init>()
            java.util.List r8 = com.google.common.collect.Lists.l(r8, r14)
            java.lang.String r8 = r13.join((java.lang.Iterable<? extends java.lang.Object>) r8)
            r12.append(r8)
            java.lang.String r8 = ") could read the stream."
            r12.append(r8)
            java.lang.String r8 = r12.toString()
            java.lang.Object r9 = androidx.media3.common.util.Assertions.f(r9)
            android.net.Uri r9 = (android.net.Uri) r9
            com.google.common.collect.ImmutableList r10 = r10.k()
            r11.<init>(r8, r9, r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.BundledExtractorsAdapter.d(androidx.media3.common.DataReader, android.net.Uri, java.util.Map, long, long, androidx.media3.extractor.ExtractorOutput):void");
    }

    public int e(PositionHolder positionHolder) throws IOException {
        return ((Extractor) Assertions.f(this.f6818b)).k((ExtractorInput) Assertions.f(this.f6819c), positionHolder);
    }

    public void release() {
        Extractor extractor = this.f6818b;
        if (extractor != null) {
            extractor.release();
            this.f6818b = null;
        }
        this.f6819c = null;
    }
}
