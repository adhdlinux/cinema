package com.google.ar.core;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.exceptions.FatalException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
import java.util.Objects;
import java.util.function.Consumer;

final class k extends ArCoreApk {

    /* renamed from: m  reason: collision with root package name */
    private static final k f30328m = new k();

    /* renamed from: a  reason: collision with root package name */
    private final Handler f30329a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    Exception f30330b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f30331c;

    /* renamed from: d  reason: collision with root package name */
    boolean f30332d = true;

    /* renamed from: e  reason: collision with root package name */
    private int f30333e;

    /* renamed from: f  reason: collision with root package name */
    private long f30334f;

    /* renamed from: g  reason: collision with root package name */
    private ArCoreApk.Availability f30335g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f30336h;

    /* renamed from: i  reason: collision with root package name */
    private x f30337i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f30338j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f30339k;

    /* renamed from: l  reason: collision with root package name */
    private int f30340l;

    k() {
    }

    public static k a() {
        return f30328m;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void h(android.content.Context r3, com.google.ar.core.h r4) {
        /*
            r2 = this;
            boolean r0 = j()
            if (r0 != 0) goto L_0x000c
            com.google.ar.core.ArCoreApk$Availability r3 = com.google.ar.core.ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE
            r4.a(r3)
            return
        L_0x000c:
            boolean r0 = r2.d(r3)     // Catch:{ FatalException -> 0x004b }
            if (r0 == 0) goto L_0x002a
            r2.c()     // Catch:{ FatalException -> 0x004b }
            android.app.PendingIntent r3 = com.google.ar.core.aj.a(r3)     // Catch:{ UnavailableDeviceNotCompatibleException -> 0x0024, UnavailableUserDeclinedInstallationException | RuntimeException -> 0x0021 }
            if (r3 == 0) goto L_0x001e
            com.google.ar.core.ArCoreApk$Availability r3 = com.google.ar.core.ArCoreApk.Availability.SUPPORTED_APK_TOO_OLD     // Catch:{ UnavailableDeviceNotCompatibleException -> 0x0024, UnavailableUserDeclinedInstallationException | RuntimeException -> 0x0021 }
            goto L_0x0026
        L_0x001e:
            com.google.ar.core.ArCoreApk$Availability r3 = com.google.ar.core.ArCoreApk.Availability.SUPPORTED_INSTALLED     // Catch:{ UnavailableDeviceNotCompatibleException -> 0x0024, UnavailableUserDeclinedInstallationException | RuntimeException -> 0x0021 }
            goto L_0x0026
        L_0x0021:
            com.google.ar.core.ArCoreApk$Availability r3 = com.google.ar.core.ArCoreApk.Availability.UNKNOWN_ERROR     // Catch:{ FatalException -> 0x004b }
            goto L_0x0026
        L_0x0024:
            com.google.ar.core.ArCoreApk$Availability r3 = com.google.ar.core.ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE     // Catch:{ FatalException -> 0x004b }
        L_0x0026:
            r4.a(r3)     // Catch:{ FatalException -> 0x004b }
            return
        L_0x002a:
            int r0 = k(r3)     // Catch:{ FatalException -> 0x004b }
            r1 = -1
            if (r0 == r1) goto L_0x0037
            com.google.ar.core.ArCoreApk$Availability r3 = com.google.ar.core.ArCoreApk.Availability.SUPPORTED_APK_TOO_OLD     // Catch:{ FatalException -> 0x004b }
            r4.a(r3)     // Catch:{ FatalException -> 0x004b }
            return
        L_0x0037:
            boolean r0 = r2.i(r3)     // Catch:{ FatalException -> 0x004b }
            if (r0 == 0) goto L_0x0043
            com.google.ar.core.ArCoreApk$Availability r3 = com.google.ar.core.ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED     // Catch:{ FatalException -> 0x004b }
            r4.a(r3)     // Catch:{ FatalException -> 0x004b }
            return
        L_0x0043:
            com.google.ar.core.x r0 = r2.b(r3)     // Catch:{ FatalException -> 0x004b }
            r0.c(r3, r4)     // Catch:{ FatalException -> 0x004b }
            return
        L_0x004b:
            r3 = move-exception
            java.lang.String r0 = "ARCore-ArCoreApk"
            java.lang.String r1 = "Error while checking app details and ARCore status"
            android.util.Log.e(r0, r1, r3)
            com.google.ar.core.ArCoreApk$Availability r3 = com.google.ar.core.ArCoreApk.Availability.UNKNOWN_ERROR
            r4.a(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ar.core.k.h(android.content.Context, com.google.ar.core.h):void");
    }

    private final boolean i(Context context) {
        l(context);
        return this.f30339k;
    }

    private static boolean j() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private static int k(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.ar.core", 4);
            int i2 = packageInfo.versionCode;
            if (i2 != 0) {
                return i2;
            }
            ServiceInfo[] serviceInfoArr = packageInfo.services;
            if (serviceInfoArr == null || serviceInfoArr.length == 0) {
                return -1;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    private final synchronized void l(Context context) {
        if (!this.f30338j) {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            try {
                Bundle bundle = packageManager.getApplicationInfo(packageName, 128).metaData;
                if (bundle.containsKey("com.google.ar.core")) {
                    String string = bundle.getString("com.google.ar.core");
                    Objects.requireNonNull(string);
                    this.f30339k = string.equals("required");
                    if (bundle.containsKey("com.google.ar.core.min_apk_version")) {
                        this.f30340l = bundle.getInt("com.google.ar.core.min_apk_version");
                        ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(packageName, 1).activities;
                        String canonicalName = InstallActivity.class.getCanonicalName();
                        for (ActivityInfo activityInfo : activityInfoArr) {
                            if (canonicalName.equals(activityInfo.name)) {
                                this.f30338j = true;
                                return;
                            }
                        }
                        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 43);
                        sb.append("Application manifest must contain activity ");
                        sb.append(canonicalName);
                        throw new FatalException(sb.toString());
                    }
                    throw new FatalException("Application manifest must contain meta-data com.google.ar.core.min_apk_version");
                }
                throw new FatalException("Application manifest must contain meta-data com.google.ar.core");
            } catch (PackageManager.NameNotFoundException e2) {
                throw new FatalException("Could not load application package metadata", e2);
            } catch (PackageManager.NameNotFoundException e3) {
                throw new FatalException("Could not load application package info", e3);
            }
        }
    }

    private static final ArCoreApk.InstallStatus m(Activity activity) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        PendingIntent a2 = aj.a(activity);
        if (a2 != null) {
            try {
                Log.i("ARCore-ArCoreApk", "Starting setup activity");
                activity.startIntentSender(a2.getIntentSender(), (Intent) null, 0, 0, 0);
                return ArCoreApk.InstallStatus.INSTALL_REQUESTED;
            } catch (IntentSender.SendIntentException | RuntimeException e2) {
                Log.w("ARCore-ArCoreApk", "Setup activity launch failed", e2);
            }
        }
        return ArCoreApk.InstallStatus.INSTALLED;
    }

    /* access modifiers changed from: package-private */
    public final synchronized x b(Context context) {
        if (this.f30337i == null) {
            x xVar = new x((byte[]) null);
            xVar.a(context.getApplicationContext());
            this.f30337i = xVar;
        }
        return this.f30337i;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void c() {
        if (this.f30330b == null) {
            this.f30333e = 0;
        }
        this.f30331c = false;
        x xVar = this.f30337i;
        if (xVar != null) {
            xVar.b();
            this.f30337i = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.ar.core.ArCoreApk.Availability checkAvailability(android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.ar.core.ArCoreApk$Availability r0 = r1.f30335g     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x000b
            boolean r0 = r0.isUnknown()     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x001a
        L_0x000b:
            boolean r0 = r1.f30336h     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x001a
            r0 = 1
            r1.f30336h = r0     // Catch:{ all -> 0x003c }
            com.google.ar.core.i r0 = new com.google.ar.core.i     // Catch:{ all -> 0x003c }
            r0.<init>(r1)     // Catch:{ all -> 0x003c }
            r1.h(r2, r0)     // Catch:{ all -> 0x003c }
        L_0x001a:
            com.google.ar.core.ArCoreApk$Availability r2 = r1.f30335g     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0029
            boolean r0 = r2.isUnsupported()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x0027
            r0 = 0
            r1.f30335g = r0     // Catch:{ all -> 0x003c }
        L_0x0027:
            monitor-exit(r1)     // Catch:{ all -> 0x003c }
            return r2
        L_0x0029:
            boolean r2 = r1.f30336h     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0031
            com.google.ar.core.ArCoreApk$Availability r2 = com.google.ar.core.ArCoreApk.Availability.UNKNOWN_CHECKING     // Catch:{ all -> 0x003c }
            monitor-exit(r1)     // Catch:{ all -> 0x003c }
            return r2
        L_0x0031:
            java.lang.String r2 = "ARCore-ArCoreApk"
            java.lang.String r0 = "request not running but result is null?"
            android.util.Log.e(r2, r0)     // Catch:{ all -> 0x003c }
            com.google.ar.core.ArCoreApk$Availability r2 = com.google.ar.core.ArCoreApk.Availability.UNKNOWN_ERROR     // Catch:{ all -> 0x003c }
            monitor-exit(r1)     // Catch:{ all -> 0x003c }
            return r2
        L_0x003c:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003c }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ar.core.k.checkAvailability(android.content.Context):com.google.ar.core.ArCoreApk$Availability");
    }

    public final void checkAvailabilityAsync(Context context, Consumer<ArCoreApk.Availability> consumer) {
        h(context, new j(this, consumer));
    }

    /* access modifiers changed from: package-private */
    public final boolean d(Context context) {
        l(context);
        if (k(context) == 0 || k(context) >= this.f30340l) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Handler e() {
        return this.f30329a;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void f(ArCoreApk.Availability availability) {
        this.f30335g = availability;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void g() {
        this.f30336h = false;
    }

    public final ArCoreApk.InstallStatus requestInstall(Activity activity, boolean z2) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        ArCoreApk.UserMessageType userMessageType;
        ArCoreApk.InstallBehavior installBehavior = i(activity) ? ArCoreApk.InstallBehavior.REQUIRED : ArCoreApk.InstallBehavior.OPTIONAL;
        if (i(activity)) {
            userMessageType = ArCoreApk.UserMessageType.APPLICATION;
        } else {
            userMessageType = ArCoreApk.UserMessageType.USER_ALREADY_INFORMED;
        }
        return requestInstall(activity, z2, installBehavior, userMessageType);
    }

    public final ArCoreApk.InstallStatus requestInstall(Activity activity, boolean z2, ArCoreApk.InstallBehavior installBehavior, ArCoreApk.UserMessageType userMessageType) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        if (!j()) {
            throw new UnavailableDeviceNotCompatibleException();
        } else if (d(activity)) {
            c();
            return m(activity);
        } else if (this.f30331c) {
            return ArCoreApk.InstallStatus.INSTALL_REQUESTED;
        } else {
            Exception exc = this.f30330b;
            if (exc != null) {
                if (z2) {
                    Log.w("ARCore-ArCoreApk", "Clearing previous failure: ", exc);
                    this.f30330b = null;
                } else if (exc instanceof UnavailableDeviceNotCompatibleException) {
                    Log.e("ARCore-ArCoreApk", "Throwing UnavailableDeviceNotCompatibleException");
                    throw ((UnavailableDeviceNotCompatibleException) exc);
                } else if (exc instanceof UnavailableUserDeclinedInstallationException) {
                    Log.e("ARCore-ArCoreApk", "Throwing UnavailableUserDeclinedInstallationException");
                    throw ((UnavailableUserDeclinedInstallationException) exc);
                } else if (exc instanceof RuntimeException) {
                    Log.e("ARCore-ArCoreApk", "Throwing RuntimeException.");
                    throw ((RuntimeException) exc);
                } else {
                    throw new RuntimeException("Unexpected exception type", exc);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.f30334f > 5000) {
                this.f30333e = 0;
            }
            int i2 = this.f30333e + 1;
            this.f30333e = i2;
            this.f30334f = uptimeMillis;
            if (i2 <= 2) {
                try {
                    activity.startActivity(new Intent(activity, InstallActivity.class).putExtra("message", userMessageType).putExtra("behavior", installBehavior));
                    this.f30331c = true;
                    return ArCoreApk.InstallStatus.INSTALL_REQUESTED;
                } catch (ActivityNotFoundException e2) {
                    throw new FatalException("Failed to launch InstallActivity.", e2);
                }
            } else {
                throw new FatalException("Requesting ARCore installation too rapidly.");
            }
        }
    }
}
