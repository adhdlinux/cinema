package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class e0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoSize f6275a;

    public /* synthetic */ e0(VideoSize videoSize) {
        this.f6275a = videoSize;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).n(this.f6275a);
    }
}
