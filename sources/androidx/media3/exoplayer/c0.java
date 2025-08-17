package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class c0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CueGroup f5900a;

    public /* synthetic */ c0(CueGroup cueGroup) {
        this.f5900a = cueGroup;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).A(this.f5900a);
    }
}
