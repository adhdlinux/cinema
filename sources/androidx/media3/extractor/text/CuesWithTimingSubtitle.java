package androidx.media3.extractor.text;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

public final class CuesWithTimingSubtitle implements Subtitle {

    /* renamed from: d  reason: collision with root package name */
    private static final Ordering<CuesWithTiming> f8777d = Ordering.d().f(new c());

    /* renamed from: b  reason: collision with root package name */
    private final ImmutableList<ImmutableList<Cue>> f8778b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f8779c;

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CuesWithTimingSubtitle(java.util.List<androidx.media3.extractor.text.CuesWithTiming> r15) {
        /*
            r14 = this;
            r14.<init>()
            int r0 = r15.size()
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r0 != r5) goto L_0x004a
            java.lang.Object r15 = com.google.common.collect.Iterables.g(r15)
            androidx.media3.extractor.text.CuesWithTiming r15 = (androidx.media3.extractor.text.CuesWithTiming) r15
            long r6 = r15.f8774b
            long r6 = h(r6)
            long r8 = r15.f8775c
            int r0 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0032
            com.google.common.collect.ImmutableList<androidx.media3.common.text.Cue> r15 = r15.f8773a
            com.google.common.collect.ImmutableList r15 = com.google.common.collect.ImmutableList.s(r15)
            r14.f8778b = r15
            long[] r15 = new long[r5]
            r15[r4] = r6
            r14.f8779c = r15
            goto L_0x0049
        L_0x0032:
            com.google.common.collect.ImmutableList<androidx.media3.common.text.Cue> r0 = r15.f8773a
            com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.r()
            com.google.common.collect.ImmutableList r0 = com.google.common.collect.ImmutableList.t(r0, r1)
            r14.f8778b = r0
            long[] r0 = new long[r3]
            r0[r4] = r6
            long r1 = r15.f8775c
            long r6 = r6 + r1
            r0[r5] = r6
            r14.f8779c = r0
        L_0x0049:
            return
        L_0x004a:
            int r0 = r15.size()
            int r0 = r0 * 2
            long[] r0 = new long[r0]
            r14.f8779c = r0
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.util.Arrays.fill(r0, r5)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.google.common.collect.Ordering<androidx.media3.extractor.text.CuesWithTiming> r3 = f8777d
            com.google.common.collect.ImmutableList r15 = com.google.common.collect.ImmutableList.y(r3, r15)
            r3 = 0
        L_0x0068:
            int r5 = r15.size()
            if (r4 >= r5) goto L_0x00d4
            java.lang.Object r5 = r15.get(r4)
            androidx.media3.extractor.text.CuesWithTiming r5 = (androidx.media3.extractor.text.CuesWithTiming) r5
            long r6 = r5.f8774b
            long r6 = h(r6)
            long r8 = r5.f8775c
            long r8 = r8 + r6
            if (r3 == 0) goto L_0x00b1
            long[] r10 = r14.f8779c
            int r11 = r3 + -1
            r12 = r10[r11]
            int r10 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r10 >= 0) goto L_0x008a
            goto L_0x00b1
        L_0x008a:
            int r10 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r10 != 0) goto L_0x00a0
            java.lang.Object r10 = r0.get(r11)
            com.google.common.collect.ImmutableList r10 = (com.google.common.collect.ImmutableList) r10
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x00a0
            com.google.common.collect.ImmutableList<androidx.media3.common.text.Cue> r6 = r5.f8773a
            r0.set(r11, r6)
            goto L_0x00bd
        L_0x00a0:
            java.lang.String r10 = "CuesWithTimingSubtitle"
            java.lang.String r12 = "Truncating unsupported overlapping cues."
            androidx.media3.common.util.Log.h(r10, r12)
            long[] r10 = r14.f8779c
            r10[r11] = r6
            com.google.common.collect.ImmutableList<androidx.media3.common.text.Cue> r6 = r5.f8773a
            r0.set(r11, r6)
            goto L_0x00bd
        L_0x00b1:
            long[] r10 = r14.f8779c
            int r11 = r3 + 1
            r10[r3] = r6
            com.google.common.collect.ImmutableList<androidx.media3.common.text.Cue> r3 = r5.f8773a
            r0.add(r3)
            r3 = r11
        L_0x00bd:
            long r5 = r5.f8775c
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 == 0) goto L_0x00d1
            long[] r5 = r14.f8779c
            int r6 = r3 + 1
            r5[r3] = r8
            com.google.common.collect.ImmutableList r3 = com.google.common.collect.ImmutableList.r()
            r0.add(r3)
            r3 = r6
        L_0x00d1:
            int r4 = r4 + 1
            goto L_0x0068
        L_0x00d4:
            com.google.common.collect.ImmutableList r15 = com.google.common.collect.ImmutableList.n(r0)
            r14.f8778b = r15
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.CuesWithTimingSubtitle.<init>(java.util.List):void");
    }

    private static long h(long j2) {
        if (j2 == -9223372036854775807L) {
            return 0;
        }
        return j2;
    }

    public int a(long j2) {
        int d2 = Util.d(this.f8779c, j2, false, false);
        if (d2 < this.f8778b.size()) {
            return d2;
        }
        return -1;
    }

    public long c(int i2) {
        boolean z2;
        if (i2 < this.f8778b.size()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        return this.f8779c[i2];
    }

    public int d() {
        return this.f8778b.size();
    }

    /* renamed from: f */
    public ImmutableList<Cue> b(long j2) {
        int h2 = Util.h(this.f8779c, j2, true, false);
        if (h2 == -1) {
            return ImmutableList.r();
        }
        return this.f8778b.get(h2);
    }
}
