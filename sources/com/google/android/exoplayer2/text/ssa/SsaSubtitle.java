package com.google.android.exoplayer2.text.ssa;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

final class SsaSubtitle implements Subtitle {

    /* renamed from: b  reason: collision with root package name */
    private final List<List<Cue>> f27479b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Long> f27480c;

    public SsaSubtitle(List<List<Cue>> list, List<Long> list2) {
        this.f27479b = list;
        this.f27480c = list2;
    }

    public int a(long j2) {
        int d2 = Util.d(this.f27480c, Long.valueOf(j2), false, false);
        if (d2 < this.f27480c.size()) {
            return d2;
        }
        return -1;
    }

    public List<Cue> b(long j2) {
        int g2 = Util.g(this.f27480c, Long.valueOf(j2), true, false);
        if (g2 == -1) {
            return Collections.emptyList();
        }
        return this.f27479b.get(g2);
    }

    public long c(int i2) {
        boolean z2;
        boolean z3 = true;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        if (i2 >= this.f27480c.size()) {
            z3 = false;
        }
        Assertions.a(z3);
        return this.f27480c.get(i2).longValue();
    }

    public int d() {
        return this.f27480c.size();
    }
}
