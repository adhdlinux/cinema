package androidx.media3.session.legacy;

import android.media.MediaDescription;
import android.media.browse.MediaBrowser;

class MediaBrowserCompat$Api21Impl {
    private MediaBrowserCompat$Api21Impl() {
    }

    static MediaDescription a(MediaBrowser.MediaItem mediaItem) {
        return mediaItem.getDescription();
    }

    static int b(MediaBrowser.MediaItem mediaItem) {
        return mediaItem.getFlags();
    }
}
