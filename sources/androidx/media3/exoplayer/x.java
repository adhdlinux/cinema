package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class x implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f7889a;

    public /* synthetic */ x(PlaybackInfo playbackInfo) {
        this.f7889a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).r(this.f7889a.f5478o);
    }
}
