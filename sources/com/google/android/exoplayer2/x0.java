package com.google.android.exoplayer2;

public final /* synthetic */ class x0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImplInternal f29059b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PlayerMessage f29060c;

    public /* synthetic */ x0(ExoPlayerImplInternal exoPlayerImplInternal, PlayerMessage playerMessage) {
        this.f29059b = exoPlayerImplInternal;
        this.f29060c = playerMessage;
    }

    public final void run() {
        this.f29059b.V(this.f29060c);
    }
}
