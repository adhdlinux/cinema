package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class i0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f25188a;

    public /* synthetic */ i0(int i2) {
        this.f25188a = i2;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onRepeatModeChanged(this.f25188a);
    }
}
