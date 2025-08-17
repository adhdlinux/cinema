package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.source.MediaSourceEventListener;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f7306b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f7307c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f7308d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f7309e;

    public /* synthetic */ q(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f7306b = eventDispatcher;
        this.f7307c = mediaSourceEventListener;
        this.f7308d = loadEventInfo;
        this.f7309e = mediaLoadData;
    }

    public final void run() {
        this.f7306b.l(this.f7307c, this.f7308d, this.f7309e);
    }
}
