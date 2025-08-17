package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.media3.exoplayer.hls.HlsDataSourceFactory;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
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
        public final Uri f6596b;

        public PlaylistResetException(Uri uri) {
            this.f6596b = uri;
        }
    }

    public static final class PlaylistStuckException extends IOException {

        /* renamed from: b  reason: collision with root package name */
        public final Uri f6597b;

        public PlaylistStuckException(Uri uri) {
            this.f6597b = uri;
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

    void i(Uri uri, MediaSourceEventListener.EventDispatcher eventDispatcher, PrimaryPlaylistListener primaryPlaylistListener);

    boolean isLive();

    void j(Uri uri);

    void k(PlaylistEventListener playlistEventListener);

    void l(PlaylistEventListener playlistEventListener);

    void stop();
}
