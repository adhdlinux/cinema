package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;

public final /* synthetic */ class l0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f6628b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f6629c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Exception f6630d;

    public /* synthetic */ l0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, Exception exc) {
        this.f6628b = forwardingEventListener;
        this.f6629c = pair;
        this.f6630d = exc;
    }

    public final void run() {
        this.f6628b.d0(this.f6629c, this.f6630d);
    }
}
