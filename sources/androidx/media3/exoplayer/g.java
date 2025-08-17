package androidx.media3.exoplayer;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class g implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaMetadata f6278a;

    public /* synthetic */ g(MediaMetadata mediaMetadata) {
        this.f6278a = mediaMetadata;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).F(this.f6278a);
    }
}
