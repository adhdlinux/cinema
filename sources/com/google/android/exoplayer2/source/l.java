package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f26696b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f26697c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f26698d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f26699e;

    public /* synthetic */ l(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f26696b = eventDispatcher;
        this.f26697c = mediaSourceEventListener;
        this.f26698d = loadEventInfo;
        this.f26699e = mediaLoadData;
    }

    public final void run() {
        this.f26696b.m(this.f26697c, this.f26698d, this.f26699e);
    }
}
