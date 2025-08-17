package androidx.media3.exoplayer.text;

import androidx.media3.common.text.Cue;
import androidx.media3.extractor.text.CuesWithTiming;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.ArrayList;

final class ReplacingCuesResolver implements CuesResolver {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<CuesWithTiming> f7325a = new ArrayList<>();

    private int f(long j2) {
        for (int i2 = 0; i2 < this.f7325a.size(); i2++) {
            if (j2 < this.f7325a.get(i2).f8774b) {
                return i2;
            }
        }
        return this.f7325a.size();
    }

    public ImmutableList<Cue> a(long j2) {
        int f2 = f(j2);
        if (f2 == 0) {
            return ImmutableList.r();
        }
        CuesWithTiming cuesWithTiming = this.f7325a.get(f2 - 1);
        long j3 = cuesWithTiming.f8776d;
        if (j3 == -9223372036854775807L || j2 < j3) {
            return cuesWithTiming.f8773a;
        }
        return ImmutableList.r();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(androidx.media3.extractor.text.CuesWithTiming r10, long r11) {
        /*
            r9 = this;
            long r0 = r10.f8774b
            r2 = 1
            r3 = 0
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x000f
            r0 = 1
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            androidx.media3.common.util.Assertions.a(r0)
            long r0 = r10.f8774b
            int r6 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r6 > 0) goto L_0x0025
            long r0 = r10.f8776d
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0023
            int r4 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x0025
        L_0x0023:
            r0 = 1
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            java.util.ArrayList<androidx.media3.extractor.text.CuesWithTiming> r1 = r9.f7325a
            int r1 = r1.size()
            int r1 = r1 - r2
        L_0x002d:
            if (r1 < 0) goto L_0x0058
            long r4 = r10.f8774b
            java.util.ArrayList<androidx.media3.extractor.text.CuesWithTiming> r6 = r9.f7325a
            java.lang.Object r6 = r6.get(r1)
            androidx.media3.extractor.text.CuesWithTiming r6 = (androidx.media3.extractor.text.CuesWithTiming) r6
            long r6 = r6.f8774b
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x0046
            java.util.ArrayList<androidx.media3.extractor.text.CuesWithTiming> r11 = r9.f7325a
            int r1 = r1 + r2
            r11.add(r1, r10)
            return r0
        L_0x0046:
            java.util.ArrayList<androidx.media3.extractor.text.CuesWithTiming> r4 = r9.f7325a
            java.lang.Object r4 = r4.get(r1)
            androidx.media3.extractor.text.CuesWithTiming r4 = (androidx.media3.extractor.text.CuesWithTiming) r4
            long r4 = r4.f8774b
            int r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r6 > 0) goto L_0x0055
            r0 = 0
        L_0x0055:
            int r1 = r1 + -1
            goto L_0x002d
        L_0x0058:
            java.util.ArrayList<androidx.media3.extractor.text.CuesWithTiming> r11 = r9.f7325a
            r11.add(r3, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.text.ReplacingCuesResolver.b(androidx.media3.extractor.text.CuesWithTiming, long):boolean");
    }

    public long c(long j2) {
        if (this.f7325a.isEmpty() || j2 < this.f7325a.get(0).f8774b) {
            return -9223372036854775807L;
        }
        for (int i2 = 1; i2 < this.f7325a.size(); i2++) {
            long j3 = this.f7325a.get(i2).f8774b;
            int i3 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
            if (i3 == 0) {
                return j3;
            }
            if (i3 < 0) {
                CuesWithTiming cuesWithTiming = this.f7325a.get(i2 - 1);
                long j4 = cuesWithTiming.f8776d;
                if (j4 == -9223372036854775807L || j4 > j2) {
                    return cuesWithTiming.f8774b;
                }
                return j4;
            }
        }
        CuesWithTiming cuesWithTiming2 = (CuesWithTiming) Iterables.d(this.f7325a);
        long j5 = cuesWithTiming2.f8776d;
        if (j5 == -9223372036854775807L || j2 < j5) {
            return cuesWithTiming2.f8774b;
        }
        return j5;
    }

    public void clear() {
        this.f7325a.clear();
    }

    public long d(long j2) {
        if (this.f7325a.isEmpty()) {
            return Long.MIN_VALUE;
        }
        if (j2 < this.f7325a.get(0).f8774b) {
            return this.f7325a.get(0).f8774b;
        }
        for (int i2 = 1; i2 < this.f7325a.size(); i2++) {
            CuesWithTiming cuesWithTiming = this.f7325a.get(i2);
            if (j2 < cuesWithTiming.f8774b) {
                long j3 = this.f7325a.get(i2 - 1).f8776d;
                if (j3 == -9223372036854775807L || j3 <= j2 || j3 >= cuesWithTiming.f8774b) {
                    return cuesWithTiming.f8774b;
                }
                return j3;
            }
        }
        long j4 = ((CuesWithTiming) Iterables.d(this.f7325a)).f8776d;
        if (j4 == -9223372036854775807L || j2 >= j4) {
            return Long.MIN_VALUE;
        }
        return j4;
    }

    public void e(long j2) {
        int f2 = f(j2);
        if (f2 > 0) {
            this.f7325a.subList(0, f2).clear();
        }
    }
}
