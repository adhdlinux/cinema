package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.source.MediaLoadData;

public final /* synthetic */ class o0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f6778b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f6779c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f6780d;

    public /* synthetic */ o0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, MediaLoadData mediaLoadData) {
        this.f6778b = forwardingEventListener;
        this.f6779c = pair;
        this.f6780d = mediaLoadData;
    }

    public final void run() {
        this.f6778b.j0(this.f6779c, this.f6780d);
    }
}
