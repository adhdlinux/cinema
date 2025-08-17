package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public final class ViewConfigurationCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2788a;

    static class Api26Impl {
        private Api26Impl() {
        }

        static float a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        static float b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        static boolean b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                f2788a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    private ViewConfigurationCompat() {
    }

    private static float a(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = f2788a) != null) {
            try {
                return (float) ((Integer) method.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static float b(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.a(viewConfiguration);
        }
        return a(viewConfiguration, context);
    }

    public static int c(ViewConfiguration viewConfiguration) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.a(viewConfiguration);
        }
        return viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static float d(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.b(viewConfiguration);
        }
        return a(viewConfiguration, context);
    }

    public static boolean e(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.b(viewConfiguration);
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
        if (identifier == 0 || !resources.getBoolean(identifier)) {
            return false;
        }
        return true;
    }
}
