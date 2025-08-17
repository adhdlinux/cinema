package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import java.util.List;

public final class FilteringHlsPlaylistParserFactory implements HlsPlaylistParserFactory {

    /* renamed from: a  reason: collision with root package name */
    private final HlsPlaylistParserFactory f26580a;

    /* renamed from: b  reason: collision with root package name */
    private final List<StreamKey> f26581b;

    public FilteringHlsPlaylistParserFactory(HlsPlaylistParserFactory hlsPlaylistParserFactory, List<StreamKey> list) {
        this.f26580a = hlsPlaylistParserFactory;
        this.f26581b = list;
    }

    public ParsingLoadable.Parser<HlsPlaylist> a() {
        return new FilteringManifestParser(this.f26580a.a(), this.f26581b);
    }

    public ParsingLoadable.Parser<HlsPlaylist> b(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        return new FilteringManifestParser(this.f26580a.b(hlsMultivariantPlaylist, hlsMediaPlaylist), this.f26581b);
    }
}
