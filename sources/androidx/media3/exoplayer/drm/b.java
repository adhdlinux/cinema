package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.Consumer;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6253a;

    public /* synthetic */ b(int i2) {
        this.f6253a = i2;
    }

    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).k(this.f6253a);
    }
}
