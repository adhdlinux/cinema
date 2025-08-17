package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class l implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TrackSelectionParameters f6627a;

    public /* synthetic */ l(TrackSelectionParameters trackSelectionParameters) {
        this.f6627a = trackSelectionParameters;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).G(this.f6627a);
    }
}
