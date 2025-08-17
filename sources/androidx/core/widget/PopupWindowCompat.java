package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class PopupWindowCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2964a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2965b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f2966c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f2967d;

    static class Api19Impl {
        private Api19Impl() {
        }

        static void a(PopupWindow popupWindow, View view, int i2, int i3, int i4) {
            popupWindow.showAsDropDown(view, i2, i3, i4);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        static void c(PopupWindow popupWindow, boolean z2) {
            popupWindow.setOverlapAnchor(z2);
        }

        static void d(PopupWindow popupWindow, int i2) {
            popupWindow.setWindowLayoutType(i2);
        }
    }

    private PopupWindowCompat() {
    }

    public static void a(PopupWindow popupWindow, boolean z2) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.c(popupWindow, z2);
            return;
        }
        if (!f2967d) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f2966c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e2);
            }
            f2967d = true;
        }
        Field field = f2966c;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z2));
            } catch (IllegalAccessException e3) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e3);
            }
        }
    }

    public static void b(PopupWindow popupWindow, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.d(popupWindow, i2);
            return;
        }
        if (!f2965b) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f2964a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f2965b = true;
        }
        Method method = f2964a;
        if (method != null) {
            try {
                method.invoke(popupWindow, new Object[]{Integer.valueOf(i2)});
            } catch (Exception unused2) {
            }
        }
    }

    public static void c(PopupWindow popupWindow, View view, int i2, int i3, int i4) {
        Api19Impl.a(popupWindow, view, i2, i3, i4);
    }
}
