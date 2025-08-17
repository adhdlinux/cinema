package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class v implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f28830a;

    public /* synthetic */ v(PlaybackInfo playbackInfo) {
        this.f28830a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onTracksChanged(this.f28830a.f23385i.f27823d);
    }
}
