package androidx.core.app;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public final class NotificationManagerCompat {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f2439c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static Set<String> f2440d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    private static final Object f2441e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Context f2442a;

    /* renamed from: b  reason: collision with root package name */
    private final NotificationManager f2443b;

    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        static int b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    private NotificationManagerCompat(Context context) {
        this.f2442a = context;
        this.f2443b = (NotificationManager) context.getSystemService("notification");
    }

    public static NotificationManagerCompat d(Context context) {
        return new NotificationManagerCompat(context);
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.a(this.f2443b);
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f2442a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f2442a.getApplicationInfo();
        String packageName = this.f2442a.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class cls2 = Integer.TYPE;
            if (((Integer) cls.getMethod("checkOpNoThrow", new Class[]{cls2, cls2, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void b(int i2) {
        c((String) null, i2);
    }

    public void c(String str, int i2) {
        this.f2443b.cancel(str, i2);
    }
}
