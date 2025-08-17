package androidx.transition;

import android.view.View;
import android.view.WindowId;

class WindowIdApi18 implements WindowIdImpl {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f11828a;

    WindowIdApi18(View view) {
        this.f11828a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi18) && ((WindowIdApi18) obj).f11828a.equals(this.f11828a);
    }

    public int hashCode() {
        return this.f11828a.hashCode();
    }
}
