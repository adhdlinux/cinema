package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;

public interface HlsPlaylistTracker {

    public interface Factory {
        HlsPlaylistTracker a(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory);
    }

    public interface PlaylistEventListener {
        void a();

        boolean d(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z2);
    }

    public static final class PlaylistResetException extends IOException {

        /* renamed from: b  reason: collision with root package name */
        public final Uri f26679b;

        public PlaylistResetException(Uri uri) {
            this.f26679b = uri;
        }
    }

    public static final class PlaylistStuckException extends IOException {

        /* renamed from: b  reason: collision with root package name */
        public final Uri f26680b;

        public PlaylistStuckException(Uri uri) {
            this.f26680b = uri;
        }
    }

    public interface PrimaryPlaylistListener {
        void h(HlsMediaPlaylist hlsMediaPlaylist);
    }

    void a(Uri uri) throws IOException;

    long b();

    HlsMultivariantPlaylist c();

    void d(Uri uri);

    boolean e(Uri uri);

    boolean f(Uri uri, long j2);

    void g() throws IOException;

    HlsMediaPlaylist h(Uri uri, boolean z2);

    void i(PlaylistEventListener playlistEventListener);

    boolean isLive();

    void j(PlaylistEventListener playlistEventListener);

    void k(Uri uri, MediaSourceEventListener.EventDispatcher eventDispatcher, PrimaryPlaylistListener primaryPlaylistListener);

    void stop();
}
