package androidx.transition;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewUtilsApi19 extends ViewUtilsBase {

    /* renamed from: a  reason: collision with root package name */
    private static Method f11803a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f11804b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f11805c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f11806d;

    ViewUtilsApi19() {
    }

    private void h() {
        if (!f11806d) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
                f11805c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e2);
            }
            f11806d = true;
        }
    }

    private void i() {
        if (!f11804b) {
            Class<View> cls = View.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("setTransitionAlpha", new Class[]{Float.TYPE});
                f11803a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e2);
            }
            f11804b = true;
        }
    }

    public void a(View view) {
    }

    public float b(View view) {
        h();
        Method method = f11805c;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return super.b(view);
    }

    public void c(View view) {
    }

    public void e(View view, float f2) {
        i();
        Method method = f11803a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{Float.valueOf(f2)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else {
            view.setAlpha(f2);
        }
    }
}
