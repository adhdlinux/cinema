package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class p implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f25646a;

    public /* synthetic */ p(PlaybackInfo playbackInfo) {
        this.f25646a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlaybackParametersChanged(this.f25646a.f23390n);
    }
}
