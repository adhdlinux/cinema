package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager;

public final class AccessibilityManagerCompat {

    static class Api19Impl {
        private Api19Impl() {
        }

        static boolean a(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            return accessibilityManager.addTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(touchExplorationStateChangeListener));
        }

        static boolean b(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            return accessibilityManager.removeTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(touchExplorationStateChangeListener));
        }
    }

    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean z2);
    }

    private static final class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final TouchExplorationStateChangeListener f2852a;

        TouchExplorationStateChangeListenerWrapper(TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            this.f2852a = touchExplorationStateChangeListener;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TouchExplorationStateChangeListenerWrapper)) {
                return false;
            }
            return this.f2852a.equals(((TouchExplorationStateChangeListenerWrapper) obj).f2852a);
        }

        public int hashCode() {
            return this.f2852a.hashCode();
        }

        public void onTouchExplorationStateChanged(boolean z2) {
            this.f2852a.onTouchExplorationStateChanged(z2);
        }
    }

    private AccessibilityManagerCompat() {
    }

    public static boolean a(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        return Api19Impl.a(accessibilityManager, touchExplorationStateChangeListener);
    }

    public static boolean b(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        return Api19Impl.b(accessibilityManager, touchExplorationStateChangeListener);
    }
}
