package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class b implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5893a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f5894b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f5895c;

    public /* synthetic */ b(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.f5893a = i2;
        this.f5894b = positionInfo;
        this.f5895c = positionInfo2;
    }

    public final void invoke(Object obj) {
        ExoPlayerImpl.V1(this.f5893a, this.f5894b, this.f5895c, (Player.Listener) obj);
    }
}
