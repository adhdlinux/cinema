package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2573a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2574b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f2575c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f2576d;

    static class Api19Impl {
        private Api19Impl() {
        }

        static int a(Drawable drawable) {
            return drawable.getAlpha();
        }

        static Drawable b(DrawableContainer.DrawableContainerState drawableContainerState, int i2) {
            return drawableContainerState.getChild(i2);
        }

        static Drawable c(InsetDrawable insetDrawable) {
            return insetDrawable.getDrawable();
        }

        static boolean d(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        static void e(Drawable drawable, boolean z2) {
            drawable.setAutoMirrored(z2);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        static void e(Drawable drawable, float f2, float f3) {
            drawable.setHotspot(f2, f3);
        }

        static void f(Drawable drawable, int i2, int i3, int i4, int i5) {
            drawable.setHotspotBounds(i2, i3, i4, i5);
        }

        static void g(Drawable drawable, int i2) {
            drawable.setTint(i2);
        }

        static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        static boolean b(Drawable drawable, int i2) {
            return drawable.setLayoutDirection(i2);
        }
    }

    private DrawableCompat() {
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        Api21Impl.a(drawable, theme);
    }

    public static boolean b(Drawable drawable) {
        return Api21Impl.b(drawable);
    }

    public static void c(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        if (Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            c(Api19Impl.c((InsetDrawable) drawable));
        } else if (drawable instanceof WrappedDrawable) {
            c(((WrappedDrawable) drawable).a());
        } else if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
            int childCount = drawableContainerState.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                Drawable b2 = Api19Impl.b(drawableContainerState, i2);
                if (b2 != null) {
                    c(b2);
                }
            }
        }
    }

    public static int d(Drawable drawable) {
        return Api19Impl.a(drawable);
    }

    public static ColorFilter e(Drawable drawable) {
        return Api21Impl.c(drawable);
    }

    public static int f(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(drawable);
        }
        if (!f2576d) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f2575c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e2);
            }
            f2576d = true;
        }
        Method method = f2575c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e3) {
                Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e3);
                f2575c = null;
            }
        }
        return 0;
    }

    public static void g(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Api21Impl.d(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean h(Drawable drawable) {
        return Api19Impl.d(drawable);
    }

    @Deprecated
    public static void i(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(Drawable drawable, boolean z2) {
        Api19Impl.e(drawable, z2);
    }

    public static void k(Drawable drawable, float f2, float f3) {
        Api21Impl.e(drawable, f2, f3);
    }

    public static void l(Drawable drawable, int i2, int i3, int i4, int i5) {
        Api21Impl.f(drawable, i2, i3, i4, i5);
    }

    public static boolean m(Drawable drawable, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.b(drawable, i2);
        }
        if (!f2574b) {
            Class<Drawable> cls = Drawable.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f2573a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e2);
            }
            f2574b = true;
        }
        Method method = f2573a;
        if (method != null) {
            try {
                method.invoke(drawable, new Object[]{Integer.valueOf(i2)});
                return true;
            } catch (Exception e3) {
                Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e3);
                f2573a = null;
            }
        }
        return false;
    }

    public static void n(Drawable drawable, int i2) {
        Api21Impl.g(drawable, i2);
    }

    public static void o(Drawable drawable, ColorStateList colorStateList) {
        Api21Impl.h(drawable, colorStateList);
    }

    public static void p(Drawable drawable, PorterDuff.Mode mode) {
        Api21Impl.i(drawable, mode);
    }

    public static <T extends Drawable> T q(Drawable drawable) {
        if (drawable instanceof WrappedDrawable) {
            return ((WrappedDrawable) drawable).a();
        }
        return drawable;
    }

    public static Drawable r(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 23 && !(drawable instanceof TintAwareDrawable)) {
            return new WrappedDrawableApi21(drawable);
        }
        return drawable;
    }
}
