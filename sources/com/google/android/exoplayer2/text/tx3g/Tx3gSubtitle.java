package com.google.android.exoplayer2.text.tx3g;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

final class Tx3gSubtitle implements Subtitle {

    /* renamed from: c  reason: collision with root package name */
    public static final Tx3gSubtitle f27566c = new Tx3gSubtitle();

    /* renamed from: b  reason: collision with root package name */
    private final List<Cue> f27567b;

    public Tx3gSubtitle(Cue cue) {
        this.f27567b = Collections.singletonList(cue);
    }

    public int a(long j2) {
        return j2 < 0 ? 0 : -1;
    }

    public List<Cue> b(long j2) {
        return j2 >= 0 ? this.f27567b : Collections.emptyList();
    }

    public long c(int i2) {
        Assertions.a(i2 == 0);
        return 0;
    }

    public int d() {
        return 1;
    }

    private Tx3gSubtitle() {
        this.f27567b = Collections.emptyList();
    }
}
