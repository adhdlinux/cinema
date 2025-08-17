package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

final class CeaSubtitle implements Subtitle {

    /* renamed from: b  reason: collision with root package name */
    private final List<Cue> f27362b;

    public CeaSubtitle(List<Cue> list) {
        this.f27362b = list;
    }

    public int a(long j2) {
        return j2 < 0 ? 0 : -1;
    }

    public List<Cue> b(long j2) {
        return j2 >= 0 ? this.f27362b : Collections.emptyList();
    }

    public long c(int i2) {
        Assertions.a(i2 == 0);
        return 0;
    }

    public int d() {
        return 1;
    }
}
