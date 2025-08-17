package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultHlsPlaylistTracker.MediaPlaylistBundle f26681b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Uri f26682c;

    public /* synthetic */ a(DefaultHlsPlaylistTracker.MediaPlaylistBundle mediaPlaylistBundle, Uri uri) {
        this.f26681b = mediaPlaylistBundle;
        this.f26682c = uri;
    }

    public final void run() {
        this.f26681b.l(this.f26682c);
    }
}
