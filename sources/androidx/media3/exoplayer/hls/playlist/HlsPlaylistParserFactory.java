package androidx.media3.exoplayer.hls.playlist;

import androidx.media3.exoplayer.upstream.ParsingLoadable;

public interface HlsPlaylistParserFactory {
    ParsingLoadable.Parser<HlsPlaylist> a();

    ParsingLoadable.Parser<HlsPlaylist> b(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist);
}
