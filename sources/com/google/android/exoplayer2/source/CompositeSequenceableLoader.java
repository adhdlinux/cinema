package com.google.android.exoplayer2.source;

import com.facebook.common.time.Clock;

public class CompositeSequenceableLoader implements SequenceableLoader {

    /* renamed from: b  reason: collision with root package name */
    protected final SequenceableLoader[] f25732b;

    public CompositeSequenceableLoader(SequenceableLoader[] sequenceableLoaderArr) {
        this.f25732b = sequenceableLoaderArr;
    }

    public final long b() {
        long j2 = Long.MAX_VALUE;
        for (SequenceableLoader b2 : this.f25732b) {
            long b3 = b2.b();
            if (b3 != Long.MIN_VALUE) {
                j2 = Math.min(j2, b3);
            }
        }
        if (j2 == Clock.MAX_TIME) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    public boolean c() {
        for (SequenceableLoader c2 : this.f25732b) {
            if (c2.c()) {
                return true;
            }
        }
        return false;
    }

    public final long e() {
        long j2 = Long.MAX_VALUE;
        for (SequenceableLoader e2 : this.f25732b) {
            long e3 = e2.e();
            if (e3 != Long.MIN_VALUE) {
                j2 = Math.min(j2, e3);
            }
        }
        if (j2 == Clock.MAX_TIME) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    public final void f(long j2) {
        for (SequenceableLoader f2 : this.f25732b) {
            f2.f(j2);
        }
    }

    public boolean h(long j2) {
        boolean z2;
        long j3 = j2;
        boolean z3 = false;
        while (true) {
            long b2 = b();
            if (b2 != Long.MIN_VALUE) {
                boolean z4 = false;
                for (SequenceableLoader sequenceableLoader : this.f25732b) {
                    long b3 = sequenceableLoader.b();
                    if (b3 == Long.MIN_VALUE || b3 > j3) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (b3 == b2 || z2) {
                        z4 |= sequenceableLoader.h(j3);
                    }
                }
                z3 |= z4;
                if (!z4) {
                    break;
                }
            } else {
                break;
            }
        }
        return z3;
    }
}
