package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

final class zzerf implements zzeqy {
    private final zzfwn zza;
    private final Context zzb;

    public zzerf(zzfwn zzfwn, Context context) {
        this.zza = zzfwn;
        this.zzb = context;
    }

    private static ResolveInfo zzd(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    public final int zza() {
        return 38;
    }

    public final zzfwm zzb() {
        return this.zza.zzb(new zzere(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a0 A[Catch:{ Exception -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0150  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzerd zzc() throws java.lang.Exception {
        /*
            r23 = this;
            r0 = r23
            android.content.Context r1 = r0.zzb
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r3 = "geo:0,0?q=donuts"
            android.content.pm.ResolveInfo r3 = zzd(r1, r3)
            java.lang.String r4 = "http://www.google.com"
            android.content.pm.ResolveInfo r4 = zzd(r1, r4)
            java.lang.String r8 = r2.getCountry()
            com.google.android.gms.ads.internal.zzt.zzp()
            com.google.android.gms.ads.internal.client.zzay.zzb()
            boolean r9 = com.google.android.gms.internal.ads.zzbzk.zzr()
            android.content.Context r5 = r0.zzb
            boolean r10 = com.google.android.gms.common.util.DeviceProperties.isLatchsky(r5)
            android.content.Context r5 = r0.zzb
            boolean r11 = com.google.android.gms.common.util.DeviceProperties.isSidewinder(r5)
            java.lang.String r12 = r2.getLanguage()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 24
            r6 = 0
            if (r2 < r5) goto L_0x005b
            android.os.LocaleList r2 = android.os.LocaleList.getDefault()
            r5 = 0
        L_0x0047:
            int r7 = r2.size()
            if (r5 >= r7) goto L_0x005b
            java.util.Locale r7 = r2.get(r5)
            java.lang.String r7 = r7.getLanguage()
            r13.add(r7)
            int r5 = r5 + 1
            goto L_0x0047
        L_0x005b:
            android.content.Context r2 = r0.zzb
            java.lang.String r5 = "market://details?id=com.google.android.gms.ads"
            android.content.pm.ResolveInfo r5 = zzd(r1, r5)
            java.lang.String r7 = "."
            if (r5 != 0) goto L_0x0069
        L_0x0067:
            r2 = 0
            goto L_0x0090
        L_0x0069:
            android.content.pm.ActivityInfo r5 = r5.activityInfo
            if (r5 != 0) goto L_0x006e
            goto L_0x0067
        L_0x006e:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r2 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r2)     // Catch:{ NameNotFoundException -> 0x0067 }
            java.lang.String r15 = r5.packageName     // Catch:{ NameNotFoundException -> 0x0067 }
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r15, r6)     // Catch:{ NameNotFoundException -> 0x0067 }
            if (r2 == 0) goto L_0x0067
            int r2 = r2.versionCode     // Catch:{ NameNotFoundException -> 0x0067 }
            java.lang.String r5 = r5.packageName     // Catch:{ NameNotFoundException -> 0x0067 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x0067 }
            r15.<init>()     // Catch:{ NameNotFoundException -> 0x0067 }
            r15.append(r2)     // Catch:{ NameNotFoundException -> 0x0067 }
            r15.append(r7)     // Catch:{ NameNotFoundException -> 0x0067 }
            r15.append(r5)     // Catch:{ NameNotFoundException -> 0x0067 }
            java.lang.String r2 = r15.toString()     // Catch:{ NameNotFoundException -> 0x0067 }
        L_0x0090:
            android.content.Context r5 = r0.zzb
            com.google.android.gms.common.wrappers.PackageManagerWrapper r5 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r5)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r15 = "com.android.vending"
            r14 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r15, r14)     // Catch:{ Exception -> 0x00b8 }
            if (r5 == 0) goto L_0x00b9
            int r14 = r5.versionCode     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r5 = r5.packageName     // Catch:{ Exception -> 0x00b8 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8 }
            r15.<init>()     // Catch:{ Exception -> 0x00b8 }
            r15.append(r14)     // Catch:{ Exception -> 0x00b8 }
            r15.append(r7)     // Catch:{ Exception -> 0x00b8 }
            r15.append(r5)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r5 = r15.toString()     // Catch:{ Exception -> 0x00b8 }
            r15 = r5
            goto L_0x00ba
        L_0x00b8:
        L_0x00b9:
            r15 = 0
        L_0x00ba:
            java.lang.String r16 = android.os.Build.FINGERPRINT
            android.content.Context r5 = r0.zzb
            if (r1 != 0) goto L_0x00c4
            r19 = r15
        L_0x00c2:
            r1 = 0
            goto L_0x010d
        L_0x00c4:
            android.content.Intent r7 = new android.content.Intent
            java.lang.String r14 = "android.intent.action.VIEW"
            java.lang.String r17 = "http://www.example.com"
            r19 = r15
            android.net.Uri r15 = android.net.Uri.parse(r17)
            r7.<init>(r14, r15)
            android.content.pm.ResolveInfo r14 = r1.resolveActivity(r7, r6)
            r15 = 65536(0x10000, float:9.18355E-41)
            java.util.List r1 = r1.queryIntentActivities(r7, r15)
            if (r1 == 0) goto L_0x00c2
            if (r14 == 0) goto L_0x00c2
            r7 = 0
        L_0x00e2:
            int r15 = r1.size()
            if (r7 >= r15) goto L_0x00c2
            java.lang.Object r15 = r1.get(r7)
            android.content.pm.ResolveInfo r15 = (android.content.pm.ResolveInfo) r15
            android.content.pm.ActivityInfo r6 = r14.activityInfo
            java.lang.String r6 = r6.name
            android.content.pm.ActivityInfo r15 = r15.activityInfo
            java.lang.String r15 = r15.name
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x0109
            android.content.pm.ActivityInfo r1 = r14.activityInfo
            java.lang.String r1 = r1.packageName
            java.lang.String r5 = com.google.android.gms.internal.ads.zzgws.zza(r5)
            boolean r1 = r1.equals(r5)
            goto L_0x010d
        L_0x0109:
            int r7 = r7 + 1
            r6 = 0
            goto L_0x00e2
        L_0x010d:
            com.google.android.gms.ads.internal.zzt.zzp()
            android.os.StatFs r5 = new android.os.StatFs
            java.io.File r6 = android.os.Environment.getDataDirectory()
            java.lang.String r6 = r6.getAbsolutePath()
            r5.<init>(r6)
            long r5 = r5.getAvailableBytes()
            r14 = 1024(0x400, double:5.06E-321)
            long r20 = r5 / r14
            com.google.android.gms.internal.ads.zzbbe r5 = com.google.android.gms.internal.ads.zzbbm.zzjO
            com.google.android.gms.internal.ads.zzbbk r6 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r5 = r6.zzb(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r6 = 1
            if (r5 == 0) goto L_0x0146
            com.google.android.gms.ads.internal.zzt.zzp()
            android.content.Context r5 = r0.zzb
            boolean r5 = com.google.android.gms.ads.internal.util.zzs.zzx(r5)
            if (r5 == 0) goto L_0x0146
            r22 = 1
            goto L_0x0148
        L_0x0146:
            r22 = 0
        L_0x0148:
            if (r4 == 0) goto L_0x014c
            r7 = 1
            goto L_0x014d
        L_0x014c:
            r7 = 0
        L_0x014d:
            if (r3 == 0) goto L_0x0150
            goto L_0x0151
        L_0x0150:
            r6 = 0
        L_0x0151:
            com.google.android.gms.internal.ads.zzerd r3 = new com.google.android.gms.internal.ads.zzerd
            r5 = r3
            java.lang.String r18 = android.os.Build.MODEL
            r14 = r2
            r15 = r19
            r17 = r1
            r19 = r20
            r21 = r22
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r21)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzerf.zzc():com.google.android.gms.internal.ads.zzerd");
    }
}
