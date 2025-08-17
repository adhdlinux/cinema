package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class o0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Metadata f25504a;

    public /* synthetic */ o0(Metadata metadata) {
        this.f25504a = metadata;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onMetadata(this.f25504a);
    }
}
