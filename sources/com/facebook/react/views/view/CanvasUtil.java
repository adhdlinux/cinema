package com.facebook.react.views.view;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CanvasUtil {
    private static Method mInorderBarrierMethod = null;
    private static boolean mOrderMethodsFetched = false;
    private static Method mReorderBarrierMethod;

    private CanvasUtil() {
    }

    @SuppressLint({"SoonBlockedPrivateApi", "PrivateApi"})
    public static void enableZ(Canvas canvas, boolean z2) {
        Method method;
        if (Build.VERSION.SDK_INT < 29) {
            fetchOrderMethods();
            if (z2) {
                try {
                    Method method2 = mReorderBarrierMethod;
                    if (method2 != null) {
                        method2.invoke(canvas, new Object[0]);
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                    return;
                }
            }
            if (!z2 && (method = mInorderBarrierMethod) != null) {
                method.invoke(canvas, new Object[0]);
            }
        } else if (z2) {
            canvas.enableZ();
        } else {
            canvas.disableZ();
        }
    }

    private static void fetchOrderMethods() {
        if (!mOrderMethodsFetched) {
            try {
                Class<Canvas> cls = Canvas.class;
                if (Build.VERSION.SDK_INT == 28) {
                    Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});
                    mReorderBarrierMethod = (Method) declaredMethod.invoke(cls, new Object[]{"insertReorderBarrier", new Class[0]});
                    mInorderBarrierMethod = (Method) declaredMethod.invoke(cls, new Object[]{"insertInorderBarrier", new Class[0]});
                } else {
                    mReorderBarrierMethod = cls.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                    mInorderBarrierMethod = cls.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                }
                Method method = mReorderBarrierMethod;
                if (method == null) {
                    return;
                }
                if (mInorderBarrierMethod != null) {
                    method.setAccessible(true);
                    mInorderBarrierMethod.setAccessible(true);
                    mOrderMethodsFetched = true;
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
    }
}
