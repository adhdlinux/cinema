package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.MediaItem;

public final /* synthetic */ class d1 implements Bundleable.Creator {
    public final Bundleable a(Bundle bundle) {
        return new MediaItem.RequestMetadata.Builder().f((Uri) bundle.getParcelable(MediaItem.RequestMetadata.f23211f)).g(bundle.getString(MediaItem.RequestMetadata.f23212g)).e(bundle.getBundle(MediaItem.RequestMetadata.f23213h)).d();
    }
}
