package androidx.media3.exoplayer.hls.playlist;

import androidx.media3.exoplayer.upstream.ParsingLoadable;

public final class DefaultHlsPlaylistParserFactory implements HlsPlaylistParserFactory {
    public ParsingLoadable.Parser<HlsPlaylist> a() {
        return new HlsPlaylistParser();
    }

    public ParsingLoadable.Parser<HlsPlaylist> b(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        return new HlsPlaylistParser(hlsMultivariantPlaylist, hlsMediaPlaylist);
    }
}
