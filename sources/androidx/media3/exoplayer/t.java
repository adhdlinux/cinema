package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class t implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f7316a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7317b;

    public /* synthetic */ t(PlaybackInfo playbackInfo, int i2) {
        this.f7316a = playbackInfo;
        this.f7317b = i2;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).U(this.f7316a.f5464a, this.f7317b);
    }
}
