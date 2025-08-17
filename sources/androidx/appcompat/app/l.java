package androidx.appcompat.app;

import androidx.appcompat.app.AppLocalesStorageHelper;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppLocalesStorageHelper.SerialExecutor f573b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f574c;

    public /* synthetic */ l(AppLocalesStorageHelper.SerialExecutor serialExecutor, Runnable runnable) {
        this.f573b = serialExecutor;
        this.f574c = runnable;
    }

    public final void run() {
        this.f573b.b(this.f574c);
    }
}
