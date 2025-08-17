package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class i implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f6600a;

    public /* synthetic */ i(PlaybackInfo playbackInfo) {
        this.f6600a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlayerStateChanged(this.f6600a.f5475l, this.f6600a.f5468e);
    }
}
