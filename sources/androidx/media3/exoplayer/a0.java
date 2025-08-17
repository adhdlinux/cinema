package androidx.media3.exoplayer;

import androidx.media3.common.Metadata;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class a0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Metadata f5541a;

    public /* synthetic */ a0(Metadata metadata) {
        this.f5541a = metadata;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).B(this.f5541a);
    }
}
