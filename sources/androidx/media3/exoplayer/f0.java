package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class f0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f6277a;

    public /* synthetic */ f0(boolean z2) {
        this.f6277a = z2;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onSkipSilenceEnabledChanged(this.f6277a);
    }
}
