package androidx.media3.exoplayer;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class c implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaItem f5898a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5899b;

    public /* synthetic */ c(MediaItem mediaItem, int i2) {
        this.f5898a = mediaItem;
        this.f5899b = i2;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).H(this.f5898a, this.f5899b);
    }
}
