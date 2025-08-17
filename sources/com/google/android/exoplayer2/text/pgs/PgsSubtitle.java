package com.google.android.exoplayer2.text.pgs;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import java.util.List;

final class PgsSubtitle implements Subtitle {

    /* renamed from: b  reason: collision with root package name */
    private final List<Cue> f27435b;

    public PgsSubtitle(List<Cue> list) {
        this.f27435b = list;
    }

    public int a(long j2) {
        return -1;
    }

    public List<Cue> b(long j2) {
        return this.f27435b;
    }

    public long c(int i2) {
        return 0;
    }

    public int d() {
        return 1;
    }
}
