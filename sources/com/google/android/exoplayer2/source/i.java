package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f26683b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f26684c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f26685d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f26686e;

    public /* synthetic */ i(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f26683b = eventDispatcher;
        this.f26684c = mediaSourceEventListener;
        this.f26685d = loadEventInfo;
        this.f26686e = mediaLoadData;
    }

    public final void run() {
        this.f26683b.o(this.f26684c, this.f26685d, this.f26686e);
    }
}
