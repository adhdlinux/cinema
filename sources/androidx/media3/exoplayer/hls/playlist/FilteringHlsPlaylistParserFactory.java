package androidx.media3.exoplayer.hls.playlist;

import androidx.media3.common.StreamKey;
import androidx.media3.exoplayer.offline.FilteringManifestParser;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import java.util.List;

public final class FilteringHlsPlaylistParserFactory implements HlsPlaylistParserFactory {

    /* renamed from: a  reason: collision with root package name */
    private final HlsPlaylistParserFactory f6497a;

    /* renamed from: b  reason: collision with root package name */
    private final List<StreamKey> f6498b;

    public FilteringHlsPlaylistParserFactory(HlsPlaylistParserFactory hlsPlaylistParserFactory, List<StreamKey> list) {
        this.f6497a = hlsPlaylistParserFactory;
        this.f6498b = list;
    }

    public ParsingLoadable.Parser<HlsPlaylist> a() {
        return new FilteringManifestParser(this.f6497a.a(), this.f6498b);
    }

    public ParsingLoadable.Parser<HlsPlaylist> b(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        return new FilteringManifestParser(this.f6497a.b(hlsMultivariantPlaylist, hlsMediaPlaylist), this.f6498b);
    }
}
