package androidx.mediarouter.media;

import androidx.mediarouter.media.MediaRouter;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaRouter.PrepareTransferNotifier f10740b;

    public /* synthetic */ b0(MediaRouter.PrepareTransferNotifier prepareTransferNotifier) {
        this.f10740b = prepareTransferNotifier;
    }

    public final void run() {
        this.f10740b.b();
    }
}
