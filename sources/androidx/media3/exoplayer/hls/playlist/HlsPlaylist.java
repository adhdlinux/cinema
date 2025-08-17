package androidx.media3.exoplayer.hls.playlist;

import androidx.media3.exoplayer.offline.FilterableManifest;
import java.util.Collections;
import java.util.List;

public abstract class HlsPlaylist implements FilterableManifest<HlsPlaylist> {

    /* renamed from: a  reason: collision with root package name */
    public final String f6562a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f6563b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f6564c;

    protected HlsPlaylist(String str, List<String> list, boolean z2) {
        this.f6562a = str;
        this.f6563b = Collections.unmodifiableList(list);
        this.f6564c = z2;
    }
}
