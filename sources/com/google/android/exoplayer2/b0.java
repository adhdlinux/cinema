package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlayerImplInternal;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f23927b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImplInternal.PlaybackInfoUpdate f23928c;

    public /* synthetic */ b0(ExoPlayerImpl exoPlayerImpl, ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.f23927b = exoPlayerImpl;
        this.f23928c = playbackInfoUpdate;
    }

    public final void run() {
        this.f23927b.O1(this.f23928c);
    }
}
