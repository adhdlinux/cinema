package androidx.activity;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class g implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f54a;

    public /* synthetic */ g(Runnable runnable) {
        this.f54a = runnable;
    }

    public final void onBackInvoked() {
        this.f54a.run();
    }
}
