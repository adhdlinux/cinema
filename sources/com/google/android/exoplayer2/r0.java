package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class r0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f25657a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f25658b;

    public /* synthetic */ r0(int i2, boolean z2) {
        this.f25657a = i2;
        this.f25658b = z2;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onDeviceVolumeChanged(this.f25657a, this.f25658b);
    }
}
