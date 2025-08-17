package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.Log;
import java.lang.reflect.Method;

public class DrawableUtils {

    /* renamed from: a  reason: collision with root package name */
    private static Method f29857a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f29858b;

    private DrawableUtils() {
    }

    public static boolean a(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        return b(drawableContainer, constantState);
    }

    private static boolean b(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        if (!f29858b) {
            try {
                Method declaredMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[]{DrawableContainer.DrawableContainerState.class});
                f29857a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
            }
            f29858b = true;
        }
        Method method = f29857a;
        if (method != null) {
            try {
                method.invoke(drawableContainer, new Object[]{constantState});
                return true;
            } catch (Exception unused2) {
                Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
            }
        }
        return false;
    }
}
