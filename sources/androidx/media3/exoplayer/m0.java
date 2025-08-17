package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;

public final /* synthetic */ class m0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f6632b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f6633c;

    public /* synthetic */ m0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair) {
        this.f6632b = forwardingEventListener;
        this.f6633c = pair;
    }

    public final void run() {
        this.f6632b.b0(this.f6633c);
    }
}
