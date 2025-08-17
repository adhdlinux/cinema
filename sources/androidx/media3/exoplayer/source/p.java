package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f7302b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f7303c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaSource.MediaPeriodId f7304d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f7305e;

    public /* synthetic */ p(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        this.f7302b = eventDispatcher;
        this.f7303c = mediaSourceEventListener;
        this.f7304d = mediaPeriodId;
        this.f7305e = mediaLoadData;
    }

    public final void run() {
        this.f7302b.o(this.f7303c, this.f7304d, this.f7305e);
    }
}
