package androidx.transition;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewGroupUtilsApi18 {

    /* renamed from: a  reason: collision with root package name */
    private static Method f11795a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f11796b;

    private ViewGroupUtilsApi18() {
    }

    private static void a() {
        if (!f11796b) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("suppressLayout", new Class[]{Boolean.TYPE});
                f11795a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e2);
            }
            f11796b = true;
        }
    }

    static void b(ViewGroup viewGroup, boolean z2) {
        a();
        Method method = f11795a;
        if (method != null) {
            try {
                method.invoke(viewGroup, new Object[]{Boolean.valueOf(z2)});
            } catch (IllegalAccessException e2) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", e2);
            } catch (InvocationTargetException e3) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", e3);
            }
        }
    }
}
