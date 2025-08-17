package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class n0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl.ComponentListener f25498a;

    public /* synthetic */ n0(ExoPlayerImpl.ComponentListener componentListener) {
        this.f25498a = componentListener;
    }

    public final void invoke(Object obj) {
        this.f25498a.N((Player.Listener) obj);
    }
}
