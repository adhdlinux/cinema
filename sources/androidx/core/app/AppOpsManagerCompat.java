package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;

public final class AppOpsManagerCompat {

    static class Api23Impl {
        private Api23Impl() {
        }

        static <T> T a(Context context, Class<T> cls) {
            return context.getSystemService(cls);
        }

        static int b(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOp(str, str2);
        }

        static int c(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOpNoThrow(str, str2);
        }

        static String d(String str) {
            return AppOpsManager.permissionToOp(str);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static int a(AppOpsManager appOpsManager, String str, int i2, String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i2, str2);
        }

        static String b(Context context) {
            return context.getOpPackageName();
        }

        static AppOpsManager c(Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }
    }

    private AppOpsManagerCompat() {
    }

    public static int a(Context context, int i2, String str, String str2) {
        if (Build.VERSION.SDK_INT < 29) {
            return b(context, str, str2);
        }
        AppOpsManager c2 = Api29Impl.c(context);
        int a2 = Api29Impl.a(c2, str, Binder.getCallingUid(), str2);
        if (a2 != 0) {
            return a2;
        }
        return Api29Impl.a(c2, str, i2, Api29Impl.b(context));
    }

    public static int b(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.c((AppOpsManager) Api23Impl.a(context, AppOpsManager.class), str, str2);
        }
        return 1;
    }

    public static String c(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.d(str);
        }
        return null;
    }
}
