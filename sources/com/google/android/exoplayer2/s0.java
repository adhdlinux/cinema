package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class s0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CueGroup f25665a;

    public /* synthetic */ s0(CueGroup cueGroup) {
        this.f25665a = cueGroup;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onCues(this.f25665a);
    }
}
