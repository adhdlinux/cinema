package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;

public final /* synthetic */ class w0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f7887b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f7888c;

    public /* synthetic */ w0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair) {
        this.f7887b = forwardingEventListener;
        this.f7888c = pair;
    }

    public final void run() {
        this.f7887b.a0(this.f7888c);
    }
}
