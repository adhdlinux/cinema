package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class KeyEventDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2746a = false;

    /* renamed from: b  reason: collision with root package name */
    private static Method f2747b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2748c = false;

    /* renamed from: d  reason: collision with root package name */
    private static Field f2749d;

    public interface Component {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    private KeyEventDispatcher() {
    }

    private static boolean a(ActionBar actionBar, KeyEvent keyEvent) {
        if (!f2746a) {
            try {
                f2747b = actionBar.getClass().getMethod("onMenuKeyEvent", new Class[]{KeyEvent.class});
            } catch (NoSuchMethodException unused) {
            }
            f2746a = true;
        }
        Method method = f2747b;
        if (method != null) {
            try {
                Object invoke = method.invoke(actionBar, new Object[]{keyEvent});
                if (invoke == null) {
                    return false;
                }
                return ((Boolean) invoke).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    private static boolean b(Activity activity, KeyEvent keyEvent) {
        KeyEvent.DispatcherState dispatcherState;
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && a(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (ViewCompat.j(decorView, keyEvent)) {
            return true;
        }
        if (decorView != null) {
            dispatcherState = decorView.getKeyDispatcherState();
        } else {
            dispatcherState = null;
        }
        return keyEvent.dispatch(activity, dispatcherState, activity);
    }

    private static boolean c(Dialog dialog, KeyEvent keyEvent) {
        KeyEvent.DispatcherState dispatcherState;
        DialogInterface.OnKeyListener f2 = f(dialog);
        if (f2 != null && f2.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (ViewCompat.j(decorView, keyEvent)) {
            return true;
        }
        if (decorView != null) {
            dispatcherState = decorView.getKeyDispatcherState();
        } else {
            dispatcherState = null;
        }
        return keyEvent.dispatch(dialog, dispatcherState, dialog);
    }

    public static boolean d(View view, KeyEvent keyEvent) {
        return ViewCompat.k(view, keyEvent);
    }

    @SuppressLint({"LambdaLast"})
    public static boolean e(Component component, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (component == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return component.superDispatchKeyEvent(keyEvent);
        }
        if (callback instanceof Activity) {
            return b((Activity) callback, keyEvent);
        }
        if (callback instanceof Dialog) {
            return c((Dialog) callback, keyEvent);
        }
        if ((view == null || !ViewCompat.j(view, keyEvent)) && !component.superDispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    private static DialogInterface.OnKeyListener f(Dialog dialog) {
        if (!f2748c) {
            try {
                Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                f2749d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2748c = true;
        }
        Field field = f2749d;
        if (field == null) {
            return null;
        }
        try {
            return (DialogInterface.OnKeyListener) field.get(dialog);
        } catch (IllegalAccessException unused2) {
            return null;
        }
    }
}
