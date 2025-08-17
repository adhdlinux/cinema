package q0;

import android.os.HandlerThread;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HandlerThread f29217b;

    public /* synthetic */ c(HandlerThread handlerThread) {
        this.f29217b = handlerThread;
    }

    public final void run() {
        this.f29217b.quit();
    }
}
