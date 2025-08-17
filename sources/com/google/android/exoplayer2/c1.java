package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.MediaItem;

public final /* synthetic */ class c1 implements Bundleable.Creator {
    public final Bundleable a(Bundle bundle) {
        return MediaItem.LiveConfiguration.c(bundle);
    }
}
