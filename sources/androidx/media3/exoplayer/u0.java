package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;

public final /* synthetic */ class u0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f7478b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f7479c;

    public /* synthetic */ u0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair) {
        this.f7478b = forwardingEventListener;
        this.f7479c = pair;
    }

    public final void run() {
        this.f7478b.e0(this.f7479c);
    }
}
