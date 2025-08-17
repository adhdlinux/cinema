package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.work.Logger;
import com.facebook.react.uimanager.ViewProps;

public class PackageManagerHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12588a = Logger.f("PackageManagerHelper");

    private PackageManagerHelper() {
    }

    public static void a(Context context, Class<?> cls, boolean z2) {
        int i2;
        String str;
        String str2 = ViewProps.ENABLED;
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, cls.getName());
            if (z2) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            packageManager.setComponentEnabledSetting(componentName, i2, 1);
            Logger c2 = Logger.c();
            String str3 = f12588a;
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            if (z2) {
                str = str2;
            } else {
                str = "disabled";
            }
            objArr[1] = str;
            c2.a(str3, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e2) {
            Logger c3 = Logger.c();
            String str4 = f12588a;
            Object[] objArr2 = new Object[2];
            objArr2[0] = cls.getName();
            if (!z2) {
                str2 = "disabled";
            }
            objArr2[1] = str2;
            c3.a(str4, String.format("%s could not be %s", objArr2), e2);
        }
    }
}
