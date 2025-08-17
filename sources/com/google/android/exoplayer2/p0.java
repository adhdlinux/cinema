package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.ListenerSet;
import java.util.List;

public final /* synthetic */ class p0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f25647a;

    public /* synthetic */ p0(List list) {
        this.f25647a = list;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onCues((List<Cue>) this.f25647a);
    }
}
