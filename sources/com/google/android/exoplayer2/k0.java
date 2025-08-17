package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class k0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f25197a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f25198b;

    public /* synthetic */ k0(PlaybackInfo playbackInfo, int i2) {
        this.f25197a = playbackInfo;
        this.f25198b = i2;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlayWhenReadyChanged(this.f25197a.f23388l, this.f25198b);
    }
}
