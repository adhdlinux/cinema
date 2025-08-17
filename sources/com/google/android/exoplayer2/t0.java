package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class t0 implements ListenerSet.Event {
    public final void invoke(Object obj) {
        ((Player.Listener) obj).onRenderedFirstFrame();
    }
}
