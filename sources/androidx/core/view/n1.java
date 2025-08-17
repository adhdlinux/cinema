package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.ViewCompat;

public final /* synthetic */ class n1 implements View.OnUnhandledKeyEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewCompat.OnUnhandledKeyEventListenerCompat f2901a;

    public /* synthetic */ n1(ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        this.f2901a = onUnhandledKeyEventListenerCompat;
    }

    public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return this.f2901a.onUnhandledKeyEvent(view, keyEvent);
    }
}
