package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.core.view.KeyEventDispatcher;

public final /* synthetic */ class k implements KeyEventDispatcher.Component {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppCompatDialog f572b;

    public /* synthetic */ k(AppCompatDialog appCompatDialog) {
        this.f572b = appCompatDialog;
    }

    public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.f572b.superDispatchKeyEvent(keyEvent);
    }
}
