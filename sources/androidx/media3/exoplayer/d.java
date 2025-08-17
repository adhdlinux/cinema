package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class d implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f5901a;

    public /* synthetic */ d(PlaybackInfo playbackInfo) {
        this.f5901a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).X(this.f5901a.f5469f);
    }
}
