package androidx.media3.exoplayer;

import androidx.media3.exoplayer.ExoPlayerImplInternal;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f6790b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImplInternal.PlaybackInfoUpdate f6791c;

    public /* synthetic */ p(ExoPlayerImpl exoPlayerImpl, ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.f6790b = exoPlayerImpl;
        this.f6791c = playbackInfoUpdate;
    }

    public final void run() {
        this.f6790b.N1(this.f6791c);
    }
}
