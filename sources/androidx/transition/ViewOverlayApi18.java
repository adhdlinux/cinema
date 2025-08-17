package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class ViewOverlayApi18 implements ViewOverlayImpl {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f11797a;

    ViewOverlayApi18(View view) {
        this.f11797a = view.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f11797a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f11797a.remove(drawable);
    }
}
