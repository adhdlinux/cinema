package androidx.core.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

public final class EdgeEffectCompat {

    static class Api21Impl {
        private Api21Impl() {
        }

        static void a(EdgeEffect edgeEffect, float f2, float f3) {
            edgeEffect.onPull(f2, f3);
        }
    }

    private static class Api31Impl {
        private Api31Impl() {
        }

        public static EdgeEffect a(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float b(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        public static float c(EdgeEffect edgeEffect, float f2, float f3) {
            try {
                return edgeEffect.onPullDistance(f2, f3);
            } catch (Throwable unused) {
                edgeEffect.onPull(f2, f3);
                return 0.0f;
            }
        }
    }

    public static EdgeEffect a(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.a(context, attributeSet);
        }
        return new EdgeEffect(context);
    }

    public static float b(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.b(edgeEffect);
        }
        return 0.0f;
    }

    public static void c(EdgeEffect edgeEffect, float f2, float f3) {
        Api21Impl.a(edgeEffect, f2, f3);
    }

    public static float d(EdgeEffect edgeEffect, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.c(edgeEffect, f2, f3);
        }
        c(edgeEffect, f2, f3);
        return f2;
    }
}
