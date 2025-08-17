package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.source.MediaLoadData;

public final /* synthetic */ class r0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f6802b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f6803c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f6804d;

    public /* synthetic */ r0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, MediaLoadData mediaLoadData) {
        this.f6802b = forwardingEventListener;
        this.f6803c = pair;
        this.f6804d = mediaLoadData;
    }

    public final void run() {
        this.f6802b.W(this.f6803c, this.f6804d);
    }
}
