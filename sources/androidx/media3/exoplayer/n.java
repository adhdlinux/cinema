package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class n implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6773a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f6774b;

    public /* synthetic */ n(int i2, int i3) {
        this.f6773a = i2;
        this.f6774b = i3;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onSurfaceSizeChanged(this.f6773a, this.f6774b);
    }
}
