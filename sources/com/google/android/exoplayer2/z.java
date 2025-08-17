package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class z implements ListenerSet.IterationFinishedEvent {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f29062a;

    public /* synthetic */ z(ExoPlayerImpl exoPlayerImpl) {
        this.f29062a = exoPlayerImpl;
    }

    public final void a(Object obj, FlagSet flagSet) {
        this.f29062a.N1((Player.Listener) obj, flagSet);
    }
}
