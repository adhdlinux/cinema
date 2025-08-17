package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class e implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f6274a;

    public /* synthetic */ e(PlaybackInfo playbackInfo) {
        this.f6274a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).I(this.f6274a.f5469f);
    }
}
