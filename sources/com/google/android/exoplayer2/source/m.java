package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f26700b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f26701c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f26702d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f26703e;

    public /* synthetic */ m(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f26700b = eventDispatcher;
        this.f26701c = mediaSourceEventListener;
        this.f26702d = loadEventInfo;
        this.f26703e = mediaLoadData;
    }

    public final void run() {
        this.f26700b.l(this.f26701c, this.f26702d, this.f26703e);
    }
}
