package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class d0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TrackSelectionParameters f23932a;

    public /* synthetic */ d0(TrackSelectionParameters trackSelectionParameters) {
        this.f23932a = trackSelectionParameters;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onTrackSelectionParametersChanged(this.f23932a);
    }
}
