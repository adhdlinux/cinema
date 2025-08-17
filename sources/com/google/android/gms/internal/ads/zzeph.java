package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;

public final class zzeph implements zzeqy, zzeqx {
    private final ApplicationInfo zza;
    private final PackageInfo zzb;

    zzeph(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        this.zza = applicationInfo;
        this.zzb = packageInfo;
    }

    public final int zza() {
        return 29;
    }

    public final zzfwm zzb() {
        return zzfwc.zzh(this);
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Integer num;
        Bundle bundle = (Bundle) obj;
        String str = this.zza.packageName;
        PackageInfo packageInfo = this.zzb;
        String str2 = null;
        if (packageInfo == null) {
            num = null;
        } else {
            num = Integer.valueOf(packageInfo.versionCode);
        }
        bundle.putString("pn", str);
        if (num != null) {
            bundle.putInt("vc", num.intValue());
        }
        PackageInfo packageInfo2 = this.zzb;
        if (packageInfo2 != null) {
            str2 = packageInfo2.versionName;
        }
        if (str2 != null) {
            bundle.putString("vnm", str2);
        }
    }
}
