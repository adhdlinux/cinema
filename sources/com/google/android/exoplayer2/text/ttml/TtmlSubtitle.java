package com.google.android.exoplayer2.text.ttml;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class TtmlSubtitle implements Subtitle {

    /* renamed from: b  reason: collision with root package name */
    private final TtmlNode f27554b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f27555c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, TtmlStyle> f27556d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, TtmlRegion> f27557e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f27558f;

    public TtmlSubtitle(TtmlNode ttmlNode, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, Map<String, String> map3) {
        Map<String, TtmlStyle> map4;
        this.f27554b = ttmlNode;
        this.f27557e = map2;
        this.f27558f = map3;
        if (map != null) {
            map4 = Collections.unmodifiableMap(map);
        } else {
            map4 = Collections.emptyMap();
        }
        this.f27556d = map4;
        this.f27555c = ttmlNode.j();
    }

    public int a(long j2) {
        int e2 = Util.e(this.f27555c, j2, false, false);
        if (e2 < this.f27555c.length) {
            return e2;
        }
        return -1;
    }

    public List<Cue> b(long j2) {
        return this.f27554b.h(j2, this.f27556d, this.f27557e, this.f27558f);
    }

    public long c(int i2) {
        return this.f27555c[i2];
    }

    public int d() {
        return this.f27555c.length;
    }
}
