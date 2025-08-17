package androidx.media3.extractor.text.ttml;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.Subtitle;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class TtmlSubtitle implements Subtitle {

    /* renamed from: b  reason: collision with root package name */
    private final TtmlNode f9084b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f9085c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, TtmlStyle> f9086d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, TtmlRegion> f9087e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f9088f;

    public TtmlSubtitle(TtmlNode ttmlNode, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, Map<String, String> map3) {
        Map<String, TtmlStyle> map4;
        this.f9084b = ttmlNode;
        this.f9087e = map2;
        this.f9088f = map3;
        if (map != null) {
            map4 = Collections.unmodifiableMap(map);
        } else {
            map4 = Collections.emptyMap();
        }
        this.f9086d = map4;
        this.f9085c = ttmlNode.j();
    }

    public int a(long j2) {
        int d2 = Util.d(this.f9085c, j2, false, false);
        if (d2 < this.f9085c.length) {
            return d2;
        }
        return -1;
    }

    public List<Cue> b(long j2) {
        return this.f9084b.h(j2, this.f9086d, this.f9087e, this.f9088f);
    }

    public long c(int i2) {
        return this.f9085c[i2];
    }

    public int d() {
        return this.f9085c.length;
    }
}
