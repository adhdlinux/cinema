package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.source.MediaSourceEventListener;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f7289b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f7290c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f7291d;

    public /* synthetic */ m(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
        this.f7289b = eventDispatcher;
        this.f7290c = mediaSourceEventListener;
        this.f7291d = mediaLoadData;
    }

    public final void run() {
        this.f7289b.j(this.f7290c, this.f7291d);
    }
}
