package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class g0 implements ListenerSet.Event {
    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlayerError(ExoPlaybackException.i(new ExoTimeoutException(1), 1003));
    }
}
