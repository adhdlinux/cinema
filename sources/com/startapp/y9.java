package com.startapp;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.startapp.n;
import java.util.concurrent.CountDownLatch;

public class y9 {

    /* renamed from: a  reason: collision with root package name */
    public static CountDownLatch f36962a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile z9 f36963b;

    public static final class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public String f36964a;

        public a(String str) {
            this.f36964a = str;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            n nVar;
            int i2 = n.a.f34947a;
            if (iBinder == null) {
                nVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof n)) {
                    nVar = new n.a.C0055a(iBinder);
                } else {
                    nVar = (n) queryLocalInterface;
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.f36964a);
            try {
                y9.f36963b = new z9(nVar.a(bundle));
            } catch (RemoteException unused) {
            }
            y9.f36962a.countDown();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            y9.f36962a.countDown();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:24|25|26|27) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0079 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.startapp.z9 a(android.content.Context r7) {
        /*
            java.lang.String r0 = "com.android.vending"
            com.startapp.z9 r1 = f36963b
            if (r1 != 0) goto L_0x0081
            java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            r2 = 1
            r1.<init>(r2)     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            f36962a = r1     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            com.startapp.y9$a r1 = new com.startapp.y9$a     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            java.lang.String r3 = r7.getPackageName()     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            r1.<init>(r3)     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            android.content.Intent r3 = new android.content.Intent     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            java.lang.String r4 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r3.<init>(r4)     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            android.content.ComponentName r4 = new android.content.ComponentName     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            java.lang.String r5 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r4.<init>(r0, r5)     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            r3.setComponent(r4)     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            android.content.pm.PackageManager r4 = r7.getPackageManager()     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            r5 = 0
            java.util.List r4 = r4.queryIntentServices(r3, r5)     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            if (r4 == 0) goto L_0x0081
            boolean r6 = r4.isEmpty()     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            if (r6 != 0) goto L_0x0081
            java.lang.Object r4 = r4.get(r5)     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            android.content.pm.ServiceInfo r4 = r4.serviceInfo     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            if (r4 == 0) goto L_0x0081
            java.lang.String r6 = r4.packageName     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            java.lang.String r4 = r4.name     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            boolean r6 = r0.equals(r6)     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            if (r6 == 0) goto L_0x0081
            if (r4 == 0) goto L_0x0081
            android.content.pm.PackageManager r4 = r7.getPackageManager()     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            r6 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r0 = r4.getPackageInfo(r0, r6)     // Catch:{ NameNotFoundException -> 0x0062 }
            int r0 = r0.versionCode     // Catch:{ NameNotFoundException -> 0x0062 }
            r4 = 80837300(0x4d17ab4, float:4.924835E-36)
            if (r0 < r4) goto L_0x0063
            r5 = 1
            goto L_0x0063
        L_0x0062:
        L_0x0063:
            if (r5 == 0) goto L_0x0081
            android.content.Intent r0 = new android.content.Intent     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            r0.<init>(r3)     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            boolean r0 = r7.bindService(r0, r1, r2)     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            if (r0 == 0) goto L_0x0081
            java.util.concurrent.CountDownLatch r0 = f36962a     // Catch:{ InterruptedException -> 0x0079 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0079 }
            r3 = 1
            r0.await(r3, r2)     // Catch:{ InterruptedException -> 0x0079 }
        L_0x0079:
            com.startapp.hc.a((android.content.Context) r7, (android.content.ServiceConnection) r1)     // Catch:{ SecurityException -> 0x0081, all -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r0 = move-exception
            com.startapp.y8.a((android.content.Context) r7, (java.lang.Throwable) r0)
        L_0x0081:
            com.startapp.z9 r7 = f36963b
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.y9.a(android.content.Context):com.startapp.z9");
    }
}
