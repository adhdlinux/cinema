package androidx.appcompat.app;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class j implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegateImpl f571a;

    public /* synthetic */ j(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f571a = appCompatDelegateImpl;
    }

    public final void onBackInvoked() {
        this.f571a.D0();
    }
}
