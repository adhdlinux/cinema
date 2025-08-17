package androidx.core.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.util.ObjectsCompat;

public final class PermissionChecker {
    private PermissionChecker() {
    }

    public static int a(Context context, String str) {
        String str2;
        if (Binder.getCallingPid() == Process.myPid()) {
            str2 = context.getPackageName();
        } else {
            str2 = null;
        }
        return b(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }

    public static int b(Context context, String str, int i2, int i3, String str2) {
        boolean z2;
        int i4;
        if (context.checkPermission(str, i2, i3) == -1) {
            return -1;
        }
        String c2 = AppOpsManagerCompat.c(str);
        if (c2 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i3);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (myUid != i3 || !ObjectsCompat.a(packageName, str2)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            i4 = AppOpsManagerCompat.a(context, i3, c2, str2);
        } else {
            i4 = AppOpsManagerCompat.b(context, c2, str2);
        }
        if (i4 == 0) {
            return 0;
        }
        return -2;
    }

    public static int c(Context context, String str) {
        return b(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
