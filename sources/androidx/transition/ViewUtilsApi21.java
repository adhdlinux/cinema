package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewUtilsApi21 extends ViewUtilsApi19 {

    /* renamed from: e  reason: collision with root package name */
    private static Method f11807e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f11808f;

    /* renamed from: g  reason: collision with root package name */
    private static Method f11809g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f11810h;

    ViewUtilsApi21() {
    }

    private void j() {
        if (!f11808f) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[]{Matrix.class});
                f11807e = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e2);
            }
            f11808f = true;
        }
    }

    private void k() {
        if (!f11810h) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[]{Matrix.class});
                f11809g = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e2);
            }
            f11810h = true;
        }
    }

    public void f(View view, Matrix matrix) {
        j();
        Method method = f11807e;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    public void g(View view, Matrix matrix) {
        k();
        Method method = f11809g;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }
}
