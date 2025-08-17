package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.upstream.ParsingLoadable;

public interface HlsPlaylistParserFactory {
    ParsingLoadable.Parser<HlsPlaylist> a();

    ParsingLoadable.Parser<HlsPlaylist> b(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist);
}
