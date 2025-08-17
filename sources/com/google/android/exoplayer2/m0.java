package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class m0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f25210a;

    public /* synthetic */ m0(PlaybackInfo playbackInfo) {
        this.f25210a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onIsPlayingChanged(ExoPlayerImpl.L1(this.f25210a));
    }
}
