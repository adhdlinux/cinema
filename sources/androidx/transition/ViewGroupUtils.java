package androidx.transition;

import android.view.ViewGroup;

class ViewGroupUtils {
    private ViewGroupUtils() {
    }

    static ViewGroupOverlayImpl a(ViewGroup viewGroup) {
        return new ViewGroupOverlayApi18(viewGroup);
    }

    static void b(ViewGroup viewGroup, boolean z2) {
        ViewGroupUtilsApi18.b(viewGroup, z2);
    }
}
