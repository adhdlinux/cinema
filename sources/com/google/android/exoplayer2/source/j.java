package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f26687b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f26688c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f26689d;

    public /* synthetic */ j(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
        this.f26687b = eventDispatcher;
        this.f26688c = mediaSourceEventListener;
        this.f26689d = mediaLoadData;
    }

    public final void run() {
        this.f26687b.k(this.f26688c, this.f26689d);
    }
}
