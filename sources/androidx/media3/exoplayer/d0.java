package androidx.media3.exoplayer;

import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class d0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceInfo f5902a;

    public /* synthetic */ d0(DeviceInfo deviceInfo) {
        this.f5902a = deviceInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).W(this.f5902a);
    }
}
