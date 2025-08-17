package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.upstream.ParsingLoadable;

public final class DefaultHlsPlaylistParserFactory implements HlsPlaylistParserFactory {
    public ParsingLoadable.Parser<HlsPlaylist> a() {
        return new HlsPlaylistParser();
    }

    public ParsingLoadable.Parser<HlsPlaylist> b(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        return new HlsPlaylistParser(hlsMultivariantPlaylist, hlsMediaPlaylist);
    }
}
