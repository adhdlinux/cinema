package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class o implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f25502a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f25503b;

    public /* synthetic */ o(int i2, int i3) {
        this.f25502a = i2;
        this.f25503b = i3;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onSurfaceSizeChanged(this.f25502a, this.f25503b);
    }
}
