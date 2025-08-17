package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;

public final /* synthetic */ class i1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f25189b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f25190c;

    public /* synthetic */ i1(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair) {
        this.f25189b = forwardingEventListener;
        this.f25190c = pair;
    }

    public final void run() {
        this.f25189b.X(this.f25190c);
    }
}
