package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class o implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f6777a;

    public /* synthetic */ o(ExoPlayerImpl exoPlayerImpl) {
        this.f6777a = exoPlayerImpl;
    }

    public final void invoke(Object obj) {
        this.f6777a.T1((Player.Listener) obj);
    }
}
