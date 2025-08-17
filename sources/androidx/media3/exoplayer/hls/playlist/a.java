package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.media3.exoplayer.hls.playlist.DefaultHlsPlaylistTracker;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultHlsPlaylistTracker.MediaPlaylistBundle f6598b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Uri f6599c;

    public /* synthetic */ a(DefaultHlsPlaylistTracker.MediaPlaylistBundle mediaPlaylistBundle, Uri uri) {
        this.f6598b = mediaPlaylistBundle;
        this.f6599c = uri;
    }

    public final void run() {
        this.f6598b.m(this.f6599c);
    }
}
