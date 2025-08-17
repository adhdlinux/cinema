package com.startapp.sdk.cachedservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public final class BackgroundService extends Service {
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r2 >= 26) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r4, boolean r5) {
        /*
            int r0 = com.startapp.hc.f34643a
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 < r1) goto L_0x001e
            r0 = 0
            android.content.pm.PackageManager r2 = r4.getPackageManager()     // Catch:{ all -> 0x001a }
            java.lang.String r3 = r4.getPackageName()     // Catch:{ all -> 0x001a }
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r0)     // Catch:{ all -> 0x001a }
            android.content.pm.ApplicationInfo r2 = r2.applicationInfo     // Catch:{ all -> 0x001a }
            int r2 = r2.targetSdkVersion     // Catch:{ all -> 0x001a }
            goto L_0x001c
        L_0x001a:
            int r2 = android.os.Build.VERSION.SDK_INT
        L_0x001c:
            if (r2 >= r1) goto L_0x001f
        L_0x001e:
            r0 = 1
        L_0x001f:
            if (r0 != 0) goto L_0x0022
            return
        L_0x0022:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.startapp.sdk.cachedservice.BackgroundService> r1 = com.startapp.sdk.cachedservice.BackgroundService.class
            r0.<init>(r4, r1)
            java.lang.Class<android.os.RemoteException> r1 = android.os.RemoteException.class
            if (r5 == 0) goto L_0x003f
            java.util.Map<android.app.Activity, java.lang.Integer> r5 = com.startapp.lb.f34876a
            r4.startService(r0)     // Catch:{ all -> 0x0033 }
            goto L_0x0050
        L_0x0033:
            r5 = move-exception
            boolean r0 = com.startapp.lb.a((java.lang.Throwable) r5, (java.lang.Class<? extends java.lang.Throwable>) r1)
            if (r0 == 0) goto L_0x003b
            goto L_0x0050
        L_0x003b:
            com.startapp.y8.a((android.content.Context) r4, (java.lang.Throwable) r5)
            goto L_0x0050
        L_0x003f:
            java.util.Map<android.app.Activity, java.lang.Integer> r5 = com.startapp.lb.f34876a
            r4.stopService(r0)     // Catch:{ all -> 0x0045 }
            goto L_0x0050
        L_0x0045:
            r5 = move-exception
            boolean r0 = com.startapp.lb.a((java.lang.Throwable) r5, (java.lang.Class<? extends java.lang.Throwable>) r1)
            if (r0 == 0) goto L_0x004d
            goto L_0x0050
        L_0x004d:
            com.startapp.y8.a((android.content.Context) r4, (java.lang.Throwable) r5)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.cachedservice.BackgroundService.a(android.content.Context, boolean):void");
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        return 3;
    }
}
