package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

final class Mp4WebvttSubtitle implements Subtitle {

    /* renamed from: b  reason: collision with root package name */
    private final List<Cue> f27569b;

    public Mp4WebvttSubtitle(List<Cue> list) {
        this.f27569b = Collections.unmodifiableList(list);
    }

    public int a(long j2) {
        return j2 < 0 ? 0 : -1;
    }

    public List<Cue> b(long j2) {
        return j2 >= 0 ? this.f27569b : Collections.emptyList();
    }

    public long c(int i2) {
        Assertions.a(i2 == 0);
        return 0;
    }

    public int d() {
        return 1;
    }
}
