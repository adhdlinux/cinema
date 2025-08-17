package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class q0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceInfo f25650a;

    public /* synthetic */ q0(DeviceInfo deviceInfo) {
        this.f25650a = deviceInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onDeviceInfoChanged(this.f25650a);
    }
}
