package androidx.core.view;

import android.view.ViewGroup;

public final class ViewGroupCompat {

    static class Api21Impl {
        private Api21Impl() {
        }

        static int a(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        static boolean b(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        static void c(ViewGroup viewGroup, boolean z2) {
            viewGroup.setTransitionGroup(z2);
        }
    }

    private ViewGroupCompat() {
    }

    public static boolean a(ViewGroup viewGroup) {
        return Api21Impl.b(viewGroup);
    }
}
