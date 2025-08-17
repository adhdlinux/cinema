package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class j0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f25192a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f25193b;

    public /* synthetic */ j0(PlaybackInfo playbackInfo, int i2) {
        this.f25192a = playbackInfo;
        this.f25193b = i2;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onTimelineChanged(this.f25192a.f23377a, this.f25193b);
    }
}
