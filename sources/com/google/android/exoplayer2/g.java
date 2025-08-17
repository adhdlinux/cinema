package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class g implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSource.Factory f25179b;

    public /* synthetic */ g(MediaSource.Factory factory) {
        this.f25179b = factory;
    }

    public final Object get() {
        return ExoPlayer.Builder.n(this.f25179b);
    }
}
