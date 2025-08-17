package androidx.media3.exoplayer.video;

import androidx.media3.common.util.HandlerWrapper;
import java.util.concurrent.Executor;

public final /* synthetic */ class a implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HandlerWrapper f7761b;

    public /* synthetic */ a(HandlerWrapper handlerWrapper) {
        this.f7761b = handlerWrapper;
    }

    public final void execute(Runnable runnable) {
        this.f7761b.g(runnable);
    }
}
