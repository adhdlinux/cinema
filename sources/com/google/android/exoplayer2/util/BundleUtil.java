package com.google.android.exoplayer2.util;

import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class BundleUtil {

    /* renamed from: a  reason: collision with root package name */
    private static Method f28649a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f28650b;

    private BundleUtil() {
    }

    public static IBinder a(Bundle bundle, String str) {
        if (Util.f28808a >= 18) {
            return bundle.getBinder(str);
        }
        return b(bundle, str);
    }

    private static IBinder b(Bundle bundle, String str) {
        Method method = f28649a;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                f28649a = method2;
                method2.setAccessible(true);
                method = f28649a;
            } catch (NoSuchMethodException e2) {
                Log.g("BundleUtil", "Failed to retrieve getIBinder method", e2);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, new Object[]{str});
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
            Log.g("BundleUtil", "Failed to invoke getIBinder via reflection", e3);
            return null;
        }
    }

    public static void c(Bundle bundle, String str, IBinder iBinder) {
        if (Util.f28808a >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            d(bundle, str, iBinder);
        }
    }

    private static void d(Bundle bundle, String str, IBinder iBinder) {
        Method method = f28650b;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                f28650b = method2;
                method2.setAccessible(true);
                method = f28650b;
            } catch (NoSuchMethodException e2) {
                Log.g("BundleUtil", "Failed to retrieve putIBinder method", e2);
                return;
            }
        }
        try {
            method.invoke(bundle, new Object[]{str, iBinder});
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
            Log.g("BundleUtil", "Failed to invoke putIBinder via reflection", e3);
        }
    }
}
