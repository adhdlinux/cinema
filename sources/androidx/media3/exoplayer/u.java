package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class u implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f7477a;

    public /* synthetic */ u(PlaybackInfo playbackInfo) {
        this.f7477a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlayWhenReadyChanged(this.f7477a.f5475l, this.f7477a.f5476m);
    }
}
