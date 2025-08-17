package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class h implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f6280a;

    public /* synthetic */ h(PlaybackInfo playbackInfo) {
        this.f6280a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ExoPlayerImpl.b2(this.f6280a, (Player.Listener) obj);
    }
}
