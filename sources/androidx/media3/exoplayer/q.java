package androidx.media3.exoplayer;

import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class q implements ListenerSet.IterationFinishedEvent {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f6796a;

    public /* synthetic */ q(ExoPlayerImpl exoPlayerImpl) {
        this.f6796a = exoPlayerImpl;
    }

    public final void a(Object obj, FlagSet flagSet) {
        this.f6796a.M1((Player.Listener) obj, flagSet);
    }
}
