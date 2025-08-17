package androidx.media3.exoplayer.text;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.text.CuesWithTiming;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import java.util.ArrayList;
import java.util.List;

final class MergingCuesResolver implements CuesResolver {

    /* renamed from: b  reason: collision with root package name */
    private static final Ordering<CuesWithTiming> f7323b = Ordering.d().f(new a()).a(Ordering.d().g().f(new b()));

    /* renamed from: a  reason: collision with root package name */
    private final List<CuesWithTiming> f7324a = new ArrayList();

    public ImmutableList<Cue> a(long j2) {
        if (!this.f7324a.isEmpty()) {
            if (j2 >= this.f7324a.get(0).f8774b) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.f7324a.size(); i2++) {
                    CuesWithTiming cuesWithTiming = this.f7324a.get(i2);
                    if (j2 >= cuesWithTiming.f8774b && j2 < cuesWithTiming.f8776d) {
                        arrayList.add(cuesWithTiming);
                    }
                    if (j2 < cuesWithTiming.f8774b) {
                        break;
                    }
                }
                ImmutableList<E> y2 = ImmutableList.y(f7323b, arrayList);
                ImmutableList.Builder k2 = ImmutableList.k();
                for (int i3 = 0; i3 < y2.size(); i3++) {
                    k2.j(((CuesWithTiming) y2.get(i3)).f8773a);
                }
                return k2.k();
            }
        }
        return ImmutableList.r();
    }

    public boolean b(CuesWithTiming cuesWithTiming, long j2) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (cuesWithTiming.f8774b != -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        if (cuesWithTiming.f8775c != -9223372036854775807L) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.a(z3);
        if (cuesWithTiming.f8774b > j2 || j2 >= cuesWithTiming.f8776d) {
            z4 = false;
        } else {
            z4 = true;
        }
        for (int size = this.f7324a.size() - 1; size >= 0; size--) {
            if (cuesWithTiming.f8774b >= this.f7324a.get(size).f8774b) {
                this.f7324a.add(size + 1, cuesWithTiming);
                return z4;
            }
        }
        this.f7324a.add(0, cuesWithTiming);
        return z4;
    }

    public long c(long j2) {
        if (this.f7324a.isEmpty()) {
            return -9223372036854775807L;
        }
        if (j2 < this.f7324a.get(0).f8774b) {
            return -9223372036854775807L;
        }
        long j3 = this.f7324a.get(0).f8774b;
        for (int i2 = 0; i2 < this.f7324a.size(); i2++) {
            long j4 = this.f7324a.get(i2).f8774b;
            long j5 = this.f7324a.get(i2).f8776d;
            if (j5 > j2) {
                if (j4 > j2) {
                    break;
                }
                j3 = Math.max(j3, j4);
            } else {
                j3 = Math.max(j3, j5);
            }
        }
        return j3;
    }

    public void clear() {
        this.f7324a.clear();
    }

    public long d(long j2) {
        int i2 = 0;
        long j3 = -9223372036854775807L;
        while (true) {
            if (i2 >= this.f7324a.size()) {
                break;
            }
            long j4 = this.f7324a.get(i2).f8774b;
            long j5 = this.f7324a.get(i2).f8776d;
            if (j2 >= j4) {
                if (j2 < j5) {
                    if (j3 == -9223372036854775807L) {
                        j3 = j5;
                    } else {
                        j3 = Math.min(j3, j5);
                    }
                }
                i2++;
            } else if (j3 == -9223372036854775807L) {
                j3 = j4;
            } else {
                j3 = Math.min(j3, j4);
            }
        }
        if (j3 != -9223372036854775807L) {
            return j3;
        }
        return Long.MIN_VALUE;
    }

    public void e(long j2) {
        int i2 = 0;
        while (i2 < this.f7324a.size()) {
            int i3 = (j2 > this.f7324a.get(i2).f8774b ? 1 : (j2 == this.f7324a.get(i2).f8774b ? 0 : -1));
            if (i3 > 0 && j2 > this.f7324a.get(i2).f8776d) {
                this.f7324a.remove(i2);
                i2--;
            } else if (i3 < 0) {
                return;
            }
            i2++;
        }
    }
}
