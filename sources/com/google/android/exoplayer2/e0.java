package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class e0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f24138a;

    public /* synthetic */ e0(ExoPlayerImpl exoPlayerImpl) {
        this.f24138a = exoPlayerImpl;
    }

    public final void invoke(Object obj) {
        this.f24138a.V1((Player.Listener) obj);
    }
}
