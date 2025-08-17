package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.IBinder;

public final class AppLocalesMetadataHolderService extends Service {

    private static class Api24Impl {
        private Api24Impl() {
        }

        static int a() {
            return 512;
        }
    }

    public static ServiceInfo a(Context context) throws PackageManager.NameNotFoundException {
        int i2;
        if (Build.VERSION.SDK_INT >= 24) {
            i2 = Api24Impl.a() | 128;
        } else {
            i2 = 640;
        }
        return context.getPackageManager().getServiceInfo(new ComponentName(context, AppLocalesMetadataHolderService.class), i2);
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }
}
