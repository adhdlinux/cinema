package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class s implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6805a;

    public /* synthetic */ s(int i2) {
        this.f6805a = i2;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onRepeatModeChanged(this.f6805a);
    }
}
