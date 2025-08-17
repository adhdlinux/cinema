package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;

public final class HlsManifest {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public final HlsMasterPlaylist f26425a;

    /* renamed from: b  reason: collision with root package name */
    public final HlsMultivariantPlaylist f26426b;

    /* renamed from: c  reason: collision with root package name */
    public final HlsMediaPlaylist f26427c;

    HlsManifest(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        this.f26426b = hlsMultivariantPlaylist;
        this.f26427c = hlsMediaPlaylist;
        this.f26425a = new HlsMasterPlaylist(hlsMultivariantPlaylist.f26645a, hlsMultivariantPlaylist.f26646b, hlsMultivariantPlaylist.f26626e, hlsMultivariantPlaylist.f26627f, hlsMultivariantPlaylist.f26628g, hlsMultivariantPlaylist.f26629h, hlsMultivariantPlaylist.f26630i, hlsMultivariantPlaylist.f26631j, hlsMultivariantPlaylist.f26632k, hlsMultivariantPlaylist.f26647c, hlsMultivariantPlaylist.f26633l, hlsMultivariantPlaylist.f26634m);
    }
}
