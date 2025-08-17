package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;

public final /* synthetic */ class j2 implements Bundleable.Creator {
    public final Bundleable a(Bundle bundle) {
        return TrackGroup.f26001i.a((Bundle) Assertions.e(bundle.getBundle(Tracks.Group.f23532g)));
    }
}
