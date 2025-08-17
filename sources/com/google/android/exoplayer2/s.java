package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class s implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaItem f25663a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f25664b;

    public /* synthetic */ s(MediaItem mediaItem, int i2) {
        this.f25663a = mediaItem;
        this.f25664b = i2;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onMediaItemTransition(this.f25663a, this.f25664b);
    }
}
