package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.Consumer;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f6252a;

    public /* synthetic */ a(Throwable th) {
        this.f6252a = th;
    }

    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).l((Exception) this.f6252a);
    }
}
