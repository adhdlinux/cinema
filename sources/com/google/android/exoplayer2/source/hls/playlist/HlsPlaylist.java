package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.offline.FilterableManifest;
import java.util.Collections;
import java.util.List;

public abstract class HlsPlaylist implements FilterableManifest<HlsPlaylist> {

    /* renamed from: a  reason: collision with root package name */
    public final String f26645a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f26646b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f26647c;

    protected HlsPlaylist(String str, List<String> list, boolean z2) {
        this.f26645a = str;
        this.f26646b = Collections.unmodifiableList(list);
        this.f26647c = z2;
    }
}
