package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewUtils {

    /* renamed from: a  reason: collision with root package name */
    private static Method f1551a;

    /* renamed from: b  reason: collision with root package name */
    static final boolean f1552b;

    static {
        boolean z2;
        Class<Rect> cls = Rect.class;
        if (Build.VERSION.SDK_INT >= 27) {
            z2 = true;
        } else {
            z2 = false;
        }
        f1552b = z2;
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{cls, cls});
            f1551a = declaredMethod;
            if (!declaredMethod.isAccessible()) {
                f1551a.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    private ViewUtils() {
    }

    public static void a(View view, Rect rect, Rect rect2) {
        Method method = f1551a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{rect, rect2});
            } catch (Exception e2) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e2);
            }
        }
    }

    public static boolean b(View view) {
        return ViewCompat.D(view) == 1;
    }

    public static void c(View view) {
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(view, new Object[0]);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e2) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
        } catch (IllegalAccessException e3) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e3);
        }
    }
}
