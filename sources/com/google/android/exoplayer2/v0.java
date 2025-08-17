package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class v0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f28831a;

    public /* synthetic */ v0(boolean z2) {
        this.f28831a = z2;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onSkipSilenceEnabledChanged(this.f28831a);
    }
}
