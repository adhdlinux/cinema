package androidx.core.view;

import android.view.ViewGroup;

public final class MarginLayoutParamsCompat {

    static class Api17Impl {
        private Api17Impl() {
        }

        static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getLayoutDirection();
        }

        static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginEnd();
        }

        static int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginStart();
        }

        static boolean d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.isMarginRelative();
        }

        static void e(ViewGroup.MarginLayoutParams marginLayoutParams, int i2) {
            marginLayoutParams.resolveLayoutDirection(i2);
        }

        static void f(ViewGroup.MarginLayoutParams marginLayoutParams, int i2) {
            marginLayoutParams.setLayoutDirection(i2);
        }

        static void g(ViewGroup.MarginLayoutParams marginLayoutParams, int i2) {
            marginLayoutParams.setMarginEnd(i2);
        }

        static void h(ViewGroup.MarginLayoutParams marginLayoutParams, int i2) {
            marginLayoutParams.setMarginStart(i2);
        }
    }

    private MarginLayoutParamsCompat() {
    }

    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Api17Impl.b(marginLayoutParams);
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Api17Impl.c(marginLayoutParams);
    }

    public static void c(ViewGroup.MarginLayoutParams marginLayoutParams, int i2) {
        Api17Impl.g(marginLayoutParams, i2);
    }
}
