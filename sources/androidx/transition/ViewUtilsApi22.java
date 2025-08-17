package androidx.transition;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewUtilsApi22 extends ViewUtilsApi21 {

    /* renamed from: i  reason: collision with root package name */
    private static Method f11811i;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f11812j;

    ViewUtilsApi22() {
    }

    @SuppressLint({"PrivateApi"})
    private void l() {
        if (!f11812j) {
            Class<View> cls = View.class;
            try {
                Class cls2 = Integer.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("setLeftTopRightBottom", new Class[]{cls2, cls2, cls2, cls2});
                f11811i = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", e2);
            }
            f11812j = true;
        }
    }

    public void d(View view, int i2, int i3, int i4, int i5) {
        l();
        Method method = f11811i;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }
}
