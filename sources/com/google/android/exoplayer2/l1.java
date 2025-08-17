package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.source.MediaLoadData;

public final /* synthetic */ class l1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f25206b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f25207c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f25208d;

    public /* synthetic */ l1(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, MediaLoadData mediaLoadData) {
        this.f25206b = forwardingEventListener;
        this.f25207c = pair;
        this.f25208d = mediaLoadData;
    }

    public final void run() {
        this.f25206b.W(this.f25207c, this.f25208d);
    }
}
