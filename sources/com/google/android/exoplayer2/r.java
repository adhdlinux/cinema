package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class r implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f25654a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f25655b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f25656c;

    public /* synthetic */ r(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.f25654a = i2;
        this.f25655b = positionInfo;
        this.f25656c = positionInfo2;
    }

    public final void invoke(Object obj) {
        ExoPlayerImpl.X1(this.f25654a, this.f25655b, this.f25656c, (Player.Listener) obj);
    }
}
