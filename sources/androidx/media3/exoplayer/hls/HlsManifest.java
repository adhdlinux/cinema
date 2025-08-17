package androidx.media3.exoplayer.hls;

import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist;

public final class HlsManifest {

    /* renamed from: a  reason: collision with root package name */
    public final HlsMultivariantPlaylist f6336a;

    /* renamed from: b  reason: collision with root package name */
    public final HlsMediaPlaylist f6337b;

    HlsManifest(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        this.f6336a = hlsMultivariantPlaylist;
        this.f6337b = hlsMediaPlaylist;
    }
}
