package androidx.media3.exoplayer;

import androidx.media3.exoplayer.MediaPeriodHolder;

public final /* synthetic */ class i0 implements MediaPeriodHolder.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImplInternal f6601a;

    public /* synthetic */ i0(ExoPlayerImplInternal exoPlayerImplInternal) {
        this.f6601a = exoPlayerImplInternal;
    }

    public final MediaPeriodHolder a(MediaPeriodInfo mediaPeriodInfo, long j2) {
        return this.f6601a.t(mediaPeriodInfo, j2);
    }
}
