package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import java.util.List;

public final /* synthetic */ class y implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f7891a;

    public /* synthetic */ y(List list) {
        this.f7891a = list;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onCues(this.f7891a);
    }
}
