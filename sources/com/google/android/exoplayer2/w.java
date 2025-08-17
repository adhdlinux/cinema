package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class w implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaMetadata f29056a;

    public /* synthetic */ w(MediaMetadata mediaMetadata) {
        this.f29056a = mediaMetadata;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onMediaMetadataChanged(this.f29056a);
    }
}
