package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class w implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f7886a;

    public /* synthetic */ w(PlaybackInfo playbackInfo) {
        this.f7886a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onIsPlayingChanged(this.f7886a.n());
    }
}
