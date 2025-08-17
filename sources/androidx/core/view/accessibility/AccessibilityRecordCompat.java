package androidx.core.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

public class AccessibilityRecordCompat {

    static class Api15Impl {
        private Api15Impl() {
        }

        static int a(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollX();
        }

        static int b(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollY();
        }

        static void c(AccessibilityRecord accessibilityRecord, int i2) {
            accessibilityRecord.setMaxScrollX(i2);
        }

        static void d(AccessibilityRecord accessibilityRecord, int i2) {
            accessibilityRecord.setMaxScrollY(i2);
        }
    }

    static class Api16Impl {
        private Api16Impl() {
        }

        static void a(AccessibilityRecord accessibilityRecord, View view, int i2) {
            accessibilityRecord.setSource(view, i2);
        }
    }

    public static void a(AccessibilityRecord accessibilityRecord, int i2) {
        Api15Impl.c(accessibilityRecord, i2);
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i2) {
        Api15Impl.d(accessibilityRecord, i2);
    }

    public static void c(AccessibilityRecord accessibilityRecord, View view, int i2) {
        Api16Impl.a(accessibilityRecord, view, i2);
    }
}
