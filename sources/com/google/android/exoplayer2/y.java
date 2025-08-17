package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class y implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f29061a;

    public /* synthetic */ y(PlaybackInfo playbackInfo) {
        this.f29061a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlayerStateChanged(this.f29061a.f23388l, this.f29061a.f23381e);
    }
}
