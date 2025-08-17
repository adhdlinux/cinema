package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f11794a;

    ViewGroupOverlayApi18(ViewGroup viewGroup) {
        this.f11794a = viewGroup.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f11794a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f11794a.remove(drawable);
    }

    public void c(View view) {
        this.f11794a.add(view);
    }

    public void d(View view) {
        this.f11794a.remove(view);
    }
}
