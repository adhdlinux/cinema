package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class x implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f29058a;

    public /* synthetic */ x(PlaybackInfo playbackInfo) {
        this.f29058a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ExoPlayerImpl.d2(this.f29058a, (Player.Listener) obj);
    }
}
