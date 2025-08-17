package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.source.MediaLoadData;

public final /* synthetic */ class o1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f25505b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f25506c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f25507d;

    public /* synthetic */ o1(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, MediaLoadData mediaLoadData) {
        this.f25505b = forwardingEventListener;
        this.f25506c = pair;
        this.f25507d = mediaLoadData;
    }

    public final void run() {
        this.f25505b.h0(this.f25506c, this.f25507d);
    }
}
