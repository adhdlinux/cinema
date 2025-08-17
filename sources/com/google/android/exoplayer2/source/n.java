package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f26704b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f26705c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaSource.MediaPeriodId f26706d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f26707e;

    public /* synthetic */ n(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        this.f26704b = eventDispatcher;
        this.f26705c = mediaSourceEventListener;
        this.f26706d = mediaPeriodId;
        this.f26707e = mediaLoadData;
    }

    public final void run() {
        this.f26704b.p(this.f26705c, this.f26706d, this.f26707e);
    }
}
