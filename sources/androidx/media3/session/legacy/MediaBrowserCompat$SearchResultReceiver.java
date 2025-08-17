package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;
import java.util.ArrayList;

@SuppressLint({"RestrictedApi"})
class MediaBrowserCompat$SearchResultReceiver extends ResultReceiver {

    /* renamed from: b  reason: collision with root package name */
    private final String f9680b;

    /* renamed from: c  reason: collision with root package name */
    private final Bundle f9681c;

    /* renamed from: d  reason: collision with root package name */
    private final MediaBrowserCompat$SearchCallback f9682d;

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        if (bundle != null) {
            bundle = MediaSessionCompat.b(bundle);
        }
        if (i2 != 0 || bundle == null || !bundle.containsKey("search_results")) {
            this.f9682d.a(this.f9680b, this.f9681c);
            return;
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
        if (parcelableArray != null) {
            ArrayList arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable a2 : parcelableArray) {
                arrayList.add((MediaBrowserCompat$MediaItem) LegacyParcelableUtil.a(a2, MediaBrowserCompat$MediaItem.CREATOR));
            }
            this.f9682d.b(this.f9680b, this.f9681c, arrayList);
            return;
        }
        this.f9682d.a(this.f9680b, this.f9681c);
    }
}
