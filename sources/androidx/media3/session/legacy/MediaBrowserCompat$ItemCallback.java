package androidx.media3.session.legacy;

import android.media.browse.MediaBrowser;
import android.os.Build;

public abstract class MediaBrowserCompat$ItemCallback {

    /* renamed from: a  reason: collision with root package name */
    final MediaBrowser.ItemCallback f9674a;

    private class ItemCallbackApi23 extends MediaBrowser.ItemCallback {
        ItemCallbackApi23() {
        }

        public void onError(String str) {
            MediaBrowserCompat$ItemCallback.this.a(str);
        }

        public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
            MediaBrowserCompat$ItemCallback.this.b(MediaBrowserCompat$MediaItem.b(mediaItem));
        }
    }

    public MediaBrowserCompat$ItemCallback() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f9674a = new ItemCallbackApi23();
        } else {
            this.f9674a = null;
        }
    }

    public void a(String str) {
    }

    public void b(MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem) {
    }
}
