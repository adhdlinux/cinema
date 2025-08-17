package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.source.MediaSourceEventListener;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f7292b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f7293c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f7294d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f7295e;

    public /* synthetic */ n(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f7292b = eventDispatcher;
        this.f7293c = mediaSourceEventListener;
        this.f7294d = loadEventInfo;
        this.f7295e = mediaLoadData;
    }

    public final void run() {
        this.f7292b.k(this.f7293c, this.f7294d, this.f7295e);
    }
}
