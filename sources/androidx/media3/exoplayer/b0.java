package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class b0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5896a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f5897b;

    public /* synthetic */ b0(int i2, boolean z2) {
        this.f5896a = i2;
        this.f5897b = z2;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onDeviceVolumeChanged(this.f5896a, this.f5897b);
    }
}
