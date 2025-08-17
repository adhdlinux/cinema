package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class h0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f25182a;

    public /* synthetic */ h0(float f2) {
        this.f25182a = f2;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onVolumeChanged(this.f25182a);
    }
}
