package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;

public final /* synthetic */ class s1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f25666b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f25667c;

    public /* synthetic */ s1(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair) {
        this.f25666b = forwardingEventListener;
        this.f25667c = pair;
    }

    public final void run() {
        this.f25666b.Y(this.f25667c);
    }
}
