package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class m implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f6631a;

    public /* synthetic */ m(boolean z2) {
        this.f6631a = z2;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onShuffleModeEnabledChanged(this.f6631a);
    }
}
