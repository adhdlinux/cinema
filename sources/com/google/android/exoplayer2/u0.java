package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.video.VideoSize;

public final /* synthetic */ class u0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoSize f27826a;

    public /* synthetic */ u0(VideoSize videoSize) {
        this.f27826a = videoSize;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onVideoSizeChanged(this.f27826a);
    }
}
