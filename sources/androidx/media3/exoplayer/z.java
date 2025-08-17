package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.ExoPlayerImpl;

public final /* synthetic */ class z implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl.ComponentListener f7892a;

    public /* synthetic */ z(ExoPlayerImpl.ComponentListener componentListener) {
        this.f7892a = componentListener;
    }

    public final void invoke(Object obj) {
        this.f7892a.Q((Player.Listener) obj);
    }
}
