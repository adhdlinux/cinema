package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.atomic.AtomicBoolean;

@ShowFirstParty
@KeepForSdk
public class GooglePlayServicesUtilLight {
    @KeepForSdk
    static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
    @KeepForSdk
    static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
    @KeepForSdk
    public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
    @KeepForSdk
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @KeepForSdk
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    @KeepForSdk
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    @KeepForSdk
    @Deprecated
    static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();
    @VisibleForTesting
    static boolean zza = false;
    private static boolean zzb = false;
    private static final AtomicBoolean zzc = new AtomicBoolean();

    @KeepForSdk
    GooglePlayServicesUtilLight() {
    }

    @KeepForSdk
    @Deprecated
    public static void cancelAvailabilityErrorNotifications(Context context) {
        if (!sCanceledAvailabilityNotification.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(GMS_AVAILABILITY_NOTIFICATION_ID);
                }
            } catch (SecurityException e2) {
                Log.d("GooglePlayServicesUtil", "Suppressing Security Exception %s in cancelAvailabilityErrorNotifications.", e2);
            }
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public static void enableUsingApkIndependentContext() {
        zzc.set(true);
    }

    @KeepForSdk
    @Deprecated
    public static void ensurePlayServicesAvailable(Context context, int i2) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, i2);
        if (isGooglePlayServicesAvailable != 0) {
            Intent errorResolutionIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(context, isGooglePlayServicesAvailable, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + isGooglePlayServicesAvailable);
            if (errorResolutionIntent == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", errorResolutionIntent);
        }
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static int getApkVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static int getClientVersion(Context context) {
        Preconditions.checkState(true);
        return ClientLibraryUtils.getClientVersion(context, context.getPackageName());
    }

    @KeepForSdk
    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i2, Context context, int i3) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(context, i2, i3);
    }

    @KeepForSdk
    @Deprecated
    @VisibleForTesting
    public static String getErrorString(int i2) {
        return ConnectionResult.zza(i2);
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int i2) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent((Context) null, i2, (String) null);
    }

    @KeepForSdk
    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @KeepForSdk
    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public static boolean honorsDebugCertificates(Context context) {
        if (!zza) {
            try {
                PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.google.android.gms", 64);
                GoogleSignatureVerifier.getInstance(context);
                if (packageInfo == null || GoogleSignatureVerifier.zzb(packageInfo, false) || !GoogleSignatureVerifier.zzb(packageInfo, true)) {
                    zzb = false;
                } else {
                    zzb = true;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e2);
            } finally {
                zza = true;
            }
        }
        if (zzb || !DeviceProperties.isUserBuild()) {
            return true;
        }
        return false;
    }

    @HideFirstParty
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @KeepForSdk
    @Deprecated
    public static boolean isGooglePlayServicesUid(Context context, int i2) {
        return UidVerifier.isGooglePlayServicesUid(context, i2);
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static boolean isPlayServicesPossiblyUpdating(Context context, int i2) {
        if (i2 == 18) {
            return true;
        }
        if (i2 == 1) {
            return zza(context, "com.google.android.gms");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static boolean isPlayStorePossiblyUpdating(Context context, int i2) {
        if (i2 == 9) {
            return zza(context, "com.android.vending");
        }
        return false;
    }

    @TargetApi(18)
    @KeepForSdk
    public static boolean isRestrictedUserProfile(Context context) {
        if (!PlatformVersion.isAtLeastJellyBeanMR2()) {
            return false;
        }
        Object systemService = context.getSystemService("user");
        Preconditions.checkNotNull(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        if (applicationRestrictions == null || !"true".equals(applicationRestrictions.getString("restricted_profile"))) {
            return false;
        }
        return true;
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    @VisibleForTesting
    public static boolean isSidewinderDevice(Context context) {
        return DeviceProperties.isSidewinder(context);
    }

    @KeepForSdk
    @Deprecated
    public static boolean isUserRecoverableError(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 9;
    }

    @TargetApi(19)
    @KeepForSdk
    @Deprecated
    public static boolean uidHasPackageName(Context context, int i2, String str) {
        return UidVerifier.uidHasPackageName(context, i2, str);
    }

    @TargetApi(21)
    static boolean zza(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        if (PlatformVersion.isAtLeastLollipop()) {
            try {
                for (PackageInstaller.SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(appPackageName.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (equals) {
                return applicationInfo.enabled;
            }
            if (!applicationInfo.enabled || isRestrictedUserProfile(context)) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009a  */
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int isGooglePlayServicesAvailable(android.content.Context r10, int r11) {
        /*
            java.lang.String r0 = "GooglePlayServicesUtil"
            android.content.res.Resources r1 = r10.getResources()     // Catch:{ all -> 0x000c }
            int r2 = com.google.android.gms.common.R.string.common_google_play_services_unknown_issue     // Catch:{ all -> 0x000c }
            r1.getString(r2)     // Catch:{ all -> 0x000c }
            goto L_0x0011
        L_0x000c:
            java.lang.String r1 = "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included."
            android.util.Log.e(r0, r1)
        L_0x0011:
            java.lang.String r1 = r10.getPackageName()
            java.lang.String r2 = "com.google.android.gms"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x003d
            java.util.concurrent.atomic.AtomicBoolean r1 = zzc
            boolean r1 = r1.get()
            if (r1 == 0) goto L_0x0026
            goto L_0x003d
        L_0x0026:
            int r1 = com.google.android.gms.common.internal.zzah.zza(r10)
            if (r1 == 0) goto L_0x0037
            int r3 = GOOGLE_PLAY_SERVICES_VERSION_CODE
            if (r1 != r3) goto L_0x0031
            goto L_0x003d
        L_0x0031:
            com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException r10 = new com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException
            r10.<init>(r1)
            throw r10
        L_0x0037:
            com.google.android.gms.common.GooglePlayServicesMissingManifestValueException r10 = new com.google.android.gms.common.GooglePlayServicesMissingManifestValueException
            r10.<init>()
            throw r10
        L_0x003d:
            boolean r1 = com.google.android.gms.common.util.DeviceProperties.isWearableWithoutPlayStore(r10)
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L_0x004d
            boolean r1 = com.google.android.gms.common.util.DeviceProperties.zzb(r10)
            if (r1 != 0) goto L_0x004d
            r1 = 1
            goto L_0x004e
        L_0x004d:
            r1 = 0
        L_0x004e:
            if (r11 < 0) goto L_0x0052
            r5 = 1
            goto L_0x0053
        L_0x0052:
            r5 = 0
        L_0x0053:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r5)
            java.lang.String r5 = r10.getPackageName()
            android.content.pm.PackageManager r6 = r10.getPackageManager()
            r7 = 9
            if (r1 == 0) goto L_0x007c
            java.lang.String r8 = "com.android.vending"
            r9 = 8256(0x2040, float:1.1569E-41)
            android.content.pm.PackageInfo r8 = r6.getPackageInfo(r8, r9)     // Catch:{ NameNotFoundException -> 0x006b }
            goto L_0x007d
        L_0x006b:
            java.lang.String r10 = java.lang.String.valueOf(r5)
            java.lang.String r11 = " requires the Google Play Store, but it is missing."
            java.lang.String r10 = r10.concat(r11)
            android.util.Log.w(r0, r10)
        L_0x0078:
            r3 = 9
            goto L_0x0133
        L_0x007c:
            r8 = 0
        L_0x007d:
            r9 = 64
            android.content.pm.PackageInfo r9 = r6.getPackageInfo(r2, r9)     // Catch:{ NameNotFoundException -> 0x0126 }
            com.google.android.gms.common.GoogleSignatureVerifier.getInstance(r10)
            boolean r10 = com.google.android.gms.common.GoogleSignatureVerifier.zzb(r9, r3)
            if (r10 != 0) goto L_0x009a
            java.lang.String r10 = java.lang.String.valueOf(r5)
            java.lang.String r11 = " requires Google Play services, but their signature is invalid."
            java.lang.String r10 = r10.concat(r11)
            android.util.Log.w(r0, r10)
            goto L_0x0078
        L_0x009a:
            if (r1 == 0) goto L_0x00b3
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            boolean r10 = com.google.android.gms.common.GoogleSignatureVerifier.zzb(r8, r3)
            if (r10 != 0) goto L_0x00b3
            java.lang.String r10 = java.lang.String.valueOf(r5)
            java.lang.String r11 = " requires Google Play Store, but its signature is invalid."
            java.lang.String r10 = r10.concat(r11)
            android.util.Log.w(r0, r10)
            goto L_0x0078
        L_0x00b3:
            if (r1 == 0) goto L_0x00d3
            if (r8 == 0) goto L_0x00d3
            android.content.pm.Signature[] r10 = r8.signatures
            r10 = r10[r4]
            android.content.pm.Signature[] r1 = r9.signatures
            r1 = r1[r4]
            boolean r10 = r10.equals(r1)
            if (r10 != 0) goto L_0x00d3
            java.lang.String r10 = java.lang.String.valueOf(r5)
            java.lang.String r11 = " requires Google Play Store, but its signature doesn't match that of Google Play services."
            java.lang.String r10 = r10.concat(r11)
            android.util.Log.w(r0, r10)
            goto L_0x0078
        L_0x00d3:
            int r10 = r9.versionCode
            int r10 = com.google.android.gms.common.util.zza.zza(r10)
            int r1 = com.google.android.gms.common.util.zza.zza(r11)
            if (r10 >= r1) goto L_0x0107
            int r10 = r9.versionCode
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Google Play services out of date for "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = ".  Requires "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = " but found "
            r1.append(r11)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            android.util.Log.w(r0, r10)
            r3 = 2
            goto L_0x0133
        L_0x0107:
            android.content.pm.ApplicationInfo r10 = r9.applicationInfo
            if (r10 != 0) goto L_0x011f
            android.content.pm.ApplicationInfo r10 = r6.getApplicationInfo(r2, r4)     // Catch:{ NameNotFoundException -> 0x0110 }
            goto L_0x011f
        L_0x0110:
            r10 = move-exception
            java.lang.String r11 = java.lang.String.valueOf(r5)
            java.lang.String r1 = " requires Google Play services, but they're missing when getting application info."
            java.lang.String r11 = r11.concat(r1)
            android.util.Log.wtf(r0, r11, r10)
            goto L_0x0133
        L_0x011f:
            boolean r10 = r10.enabled
            if (r10 != 0) goto L_0x0125
            r3 = 3
            goto L_0x0133
        L_0x0125:
            return r4
        L_0x0126:
            java.lang.String r10 = java.lang.String.valueOf(r5)
            java.lang.String r11 = " requires Google Play services, but they are missing."
            java.lang.String r10 = r10.concat(r11)
            android.util.Log.w(r0, r10)
        L_0x0133:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(android.content.Context, int):int");
    }
}
