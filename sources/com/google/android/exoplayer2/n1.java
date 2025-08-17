package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;

public final /* synthetic */ class n1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f25499b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f25500c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f25501d;

    public /* synthetic */ n1(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, int i2) {
        this.f25499b = forwardingEventListener;
        this.f25500c = pair;
        this.f25501d = i2;
    }

    public final void run() {
        this.f25499b.a0(this.f25500c, this.f25501d);
    }
}
