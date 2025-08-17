package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;

public final /* synthetic */ class n0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f6775b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f6776c;

    public /* synthetic */ n0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair) {
        this.f6775b = forwardingEventListener;
        this.f6776c = pair;
    }

    public final void run() {
        this.f6775b.X(this.f6776c);
    }
}
