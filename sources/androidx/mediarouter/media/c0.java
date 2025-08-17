package androidx.mediarouter.media;

import androidx.mediarouter.media.MediaRouter;
import java.util.concurrent.Executor;

public final /* synthetic */ class c0 implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaRouter.GlobalMediaRouter.CallbackHandler f10741b;

    public /* synthetic */ c0(MediaRouter.GlobalMediaRouter.CallbackHandler callbackHandler) {
        this.f10741b = callbackHandler;
    }

    public final void execute(Runnable runnable) {
        this.f10741b.post(runnable);
    }
}
