package androidx.media3.extractor.text;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import java.util.List;

public class LegacySubtitleUtil {
    private LegacySubtitleUtil() {
    }

    private static int a(Subtitle subtitle, long j2) {
        if (j2 == -9223372036854775807L) {
            return 0;
        }
        int a2 = subtitle.a(j2);
        if (a2 == -1) {
            a2 = subtitle.d();
        }
        if (a2 <= 0 || subtitle.c(a2 - 1) != j2) {
            return a2;
        }
        return a2 - 1;
    }

    private static void b(Subtitle subtitle, int i2, Consumer<CuesWithTiming> consumer) {
        long c2 = subtitle.c(i2);
        List<Cue> b2 = subtitle.b(c2);
        if (!b2.isEmpty()) {
            if (i2 != subtitle.d() - 1) {
                long c3 = subtitle.c(i2 + 1) - subtitle.c(i2);
                if (c3 > 0) {
                    consumer.accept(new CuesWithTiming(b2, c2, c3));
                    return;
                }
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043 A[LOOP:0: B:11:0x003d->B:13:0x0043, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(androidx.media3.extractor.text.Subtitle r12, androidx.media3.extractor.text.SubtitleParser.OutputOptions r13, androidx.media3.common.util.Consumer<androidx.media3.extractor.text.CuesWithTiming> r14) {
        /*
            long r0 = r13.f8800a
            int r0 = a(r12, r0)
            long r1 = r13.f8800a
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x003b
            int r1 = r12.d()
            if (r0 >= r1) goto L_0x003b
            long r1 = r13.f8800a
            java.util.List r7 = r12.b(r1)
            long r1 = r12.c(r0)
            boolean r3 = r7.isEmpty()
            if (r3 != 0) goto L_0x003b
            long r8 = r13.f8800a
            int r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x003b
            androidx.media3.extractor.text.CuesWithTiming r3 = new androidx.media3.extractor.text.CuesWithTiming
            long r10 = r1 - r8
            r6 = r3
            r6.<init>(r7, r8, r10)
            r14.accept(r3)
            r1 = 1
            goto L_0x003c
        L_0x003b:
            r1 = 0
        L_0x003c:
            r2 = r0
        L_0x003d:
            int r3 = r12.d()
            if (r2 >= r3) goto L_0x0049
            b(r12, r2, r14)
            int r2 = r2 + 1
            goto L_0x003d
        L_0x0049:
            boolean r2 = r13.f8801b
            if (r2 == 0) goto L_0x0076
            if (r1 == 0) goto L_0x0051
            int r0 = r0 + -1
        L_0x0051:
            if (r5 >= r0) goto L_0x0059
            b(r12, r5, r14)
            int r5 = r5 + 1
            goto L_0x0051
        L_0x0059:
            if (r1 == 0) goto L_0x0076
            androidx.media3.extractor.text.CuesWithTiming r1 = new androidx.media3.extractor.text.CuesWithTiming
            long r2 = r13.f8800a
            java.util.List r7 = r12.b(r2)
            long r8 = r12.c(r0)
            long r2 = r13.f8800a
            long r12 = r12.c(r0)
            long r10 = r2 - r12
            r6 = r1
            r6.<init>(r7, r8, r10)
            r14.accept(r1)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.LegacySubtitleUtil.c(androidx.media3.extractor.text.Subtitle, androidx.media3.extractor.text.SubtitleParser$OutputOptions, androidx.media3.common.util.Consumer):void");
    }
}
