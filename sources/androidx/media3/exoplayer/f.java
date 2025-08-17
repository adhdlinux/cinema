package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class f implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f6276a;

    public /* synthetic */ f(PlaybackInfo playbackInfo) {
        this.f6276a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).V(this.f6276a.f5472i.f7475d);
    }
}
