package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

public final class AccessibilityEventCompat {

    static class Api19Impl {
        private Api19Impl() {
        }

        static int a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }

        static void b(AccessibilityEvent accessibilityEvent, int i2) {
            accessibilityEvent.setContentChangeTypes(i2);
        }
    }

    private AccessibilityEventCompat() {
    }

    public static int a(AccessibilityEvent accessibilityEvent) {
        return Api19Impl.a(accessibilityEvent);
    }

    public static void b(AccessibilityEvent accessibilityEvent, int i2) {
        Api19Impl.b(accessibilityEvent, i2);
    }
}
