package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;

class ViewUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final ViewUtilsBase f11798a;

    /* renamed from: b  reason: collision with root package name */
    private static Field f11799b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f11800c;

    /* renamed from: d  reason: collision with root package name */
    static final Property<View, Float> f11801d = new Property<View, Float>(Float.class, "translationAlpha") {
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(ViewUtils.d(view));
        }

        /* renamed from: b */
        public void set(View view, Float f2) {
            ViewUtils.h(view, f2.floatValue());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    static final Property<View, Rect> f11802e = new Property<View, Rect>(Rect.class, "clipBounds") {
        /* renamed from: a */
        public Rect get(View view) {
            return ViewCompat.v(view);
        }

        /* renamed from: b */
        public void set(View view, Rect rect) {
            ViewCompat.y0(view, rect);
        }
    };

    static {
        if (Build.VERSION.SDK_INT >= 22) {
            f11798a = new ViewUtilsApi22();
        } else {
            f11798a = new ViewUtilsApi21();
        }
    }

    private ViewUtils() {
    }

    static void a(View view) {
        f11798a.a(view);
    }

    private static void b() {
        if (!f11800c) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f11799b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtils", "fetchViewFlagsField: ");
            }
            f11800c = true;
        }
    }

    static ViewOverlayImpl c(View view) {
        return new ViewOverlayApi18(view);
    }

    static float d(View view) {
        return f11798a.b(view);
    }

    static WindowIdImpl e(View view) {
        return new WindowIdApi18(view);
    }

    static void f(View view) {
        f11798a.c(view);
    }

    static void g(View view, int i2, int i3, int i4, int i5) {
        f11798a.d(view, i2, i3, i4, i5);
    }

    static void h(View view, float f2) {
        f11798a.e(view, f2);
    }

    static void i(View view, int i2) {
        b();
        Field field = f11799b;
        if (field != null) {
            try {
                f11799b.setInt(view, i2 | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    static void j(View view, Matrix matrix) {
        f11798a.f(view, matrix);
    }

    static void k(View view, Matrix matrix) {
        f11798a.g(view, matrix);
    }
}
