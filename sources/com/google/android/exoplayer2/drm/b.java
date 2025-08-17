package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Consumer;

public final /* synthetic */ class b implements Consumer {
    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).h();
    }
}
