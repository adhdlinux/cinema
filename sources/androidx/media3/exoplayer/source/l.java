package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.source.MediaSourceEventListener;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f7285b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f7286c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f7287d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f7288e;

    public /* synthetic */ l(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f7285b = eventDispatcher;
        this.f7286c = mediaSourceEventListener;
        this.f7287d = loadEventInfo;
        this.f7288e = mediaLoadData;
    }

    public final void run() {
        this.f7285b.n(this.f7286c, this.f7287d, this.f7288e);
    }
}
