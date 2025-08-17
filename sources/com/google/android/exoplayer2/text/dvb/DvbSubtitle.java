package com.google.android.exoplayer2.text.dvb;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import java.util.List;

final class DvbSubtitle implements Subtitle {

    /* renamed from: b  reason: collision with root package name */
    private final List<Cue> f27421b;

    public DvbSubtitle(List<Cue> list) {
        this.f27421b = list;
    }

    public int a(long j2) {
        return -1;
    }

    public List<Cue> b(long j2) {
        return this.f27421b;
    }

    public long c(int i2) {
        return 0;
    }

    public int d() {
        return 1;
    }
}
