package com.google.android.exoplayer2.text.subrip;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

final class SubripSubtitle implements Subtitle {

    /* renamed from: b  reason: collision with root package name */
    private final Cue[] f27485b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f27486c;

    public SubripSubtitle(Cue[] cueArr, long[] jArr) {
        this.f27485b = cueArr;
        this.f27486c = jArr;
    }

    public int a(long j2) {
        int e2 = Util.e(this.f27486c, j2, false, false);
        if (e2 < this.f27486c.length) {
            return e2;
        }
        return -1;
    }

    public List<Cue> b(long j2) {
        Cue cue;
        int i2 = Util.i(this.f27486c, j2, true, false);
        if (i2 == -1 || (cue = this.f27485b[i2]) == Cue.f27194s) {
            return Collections.emptyList();
        }
        return Collections.singletonList(cue);
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
        if (i2 >= this.f27486c.length) {
            z3 = false;
        }
        Assertions.a(z3);
        return this.f27486c[i2];
    }

    public int d() {
        return this.f27486c.length;
    }
}
