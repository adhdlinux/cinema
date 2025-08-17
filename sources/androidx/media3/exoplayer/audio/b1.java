package androidx.media3.exoplayer.audio;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class b1 implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Handler f5853b;

    public /* synthetic */ b1(Handler handler) {
        this.f5853b = handler;
    }

    public final void execute(Runnable runnable) {
        this.f5853b.post(runnable);
    }
}
