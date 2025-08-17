package androidx.media3.extractor.text.cea;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.text.Subtitle;
import java.util.Collections;
import java.util.List;

final class CeaSubtitle implements Subtitle {

    /* renamed from: b  reason: collision with root package name */
    private final List<Cue> f8900b;

    public CeaSubtitle(List<Cue> list) {
        this.f8900b = list;
    }

    public int a(long j2) {
        return j2 < 0 ? 0 : -1;
    }

    public List<Cue> b(long j2) {
        return j2 >= 0 ? this.f8900b : Collections.emptyList();
    }

    public long c(int i2) {
        Assertions.a(i2 == 0);
        return 0;
    }

    public int d() {
        return 1;
    }
}
