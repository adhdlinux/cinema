package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;

public final /* synthetic */ class p1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f25648b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f25649c;

    public /* synthetic */ p1(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair) {
        this.f25648b = forwardingEventListener;
        this.f25649c = pair;
    }

    public final void run() {
        this.f25648b.c0(this.f25649c);
    }
}
