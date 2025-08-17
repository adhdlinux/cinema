package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;

public final /* synthetic */ class s0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f6806b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f6807c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f6808d;

    public /* synthetic */ s0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, int i2) {
        this.f6806b = forwardingEventListener;
        this.f6807c = pair;
        this.f6808d = i2;
    }

    public final void run() {
        this.f6806b.c0(this.f6807c, this.f6808d);
    }
}
