package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class v implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f7580a;

    public /* synthetic */ v(PlaybackInfo playbackInfo) {
        this.f7580a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlaybackSuppressionReasonChanged(this.f7580a.f5477n);
    }
}
