package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class h implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadControl f25181b;

    public /* synthetic */ h(LoadControl loadControl) {
        this.f25181b = loadControl;
    }

    public final Object get() {
        return ExoPlayer.Builder.m(this.f25181b);
    }
}
