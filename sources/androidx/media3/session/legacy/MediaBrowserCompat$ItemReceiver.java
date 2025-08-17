package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

@SuppressLint({"RestrictedApi"})
class MediaBrowserCompat$ItemReceiver extends ResultReceiver {

    /* renamed from: b  reason: collision with root package name */
    private final String f9676b;

    /* renamed from: c  reason: collision with root package name */
    private final MediaBrowserCompat$ItemCallback f9677c;

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        if (bundle != null) {
            bundle = MediaSessionCompat.b(bundle);
        }
        if (i2 != 0 || bundle == null || !bundle.containsKey("media_item")) {
            this.f9677c.a(this.f9676b);
            return;
        }
        this.f9677c.b((MediaBrowserCompat$MediaItem) LegacyParcelableUtil.a(bundle.getParcelable("media_item"), MediaBrowserCompat$MediaItem.CREATOR));
    }
}
