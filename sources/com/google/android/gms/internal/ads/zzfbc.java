package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;

public final class zzfbc {
    public static void zza(Context context, boolean z2) {
        if (z2) {
            zzbzr.zzi("This request is sent from a test device.");
            return;
        }
        zzay.zzb();
        String zzy = zzbzk.zzy(context);
        zzbzr.zzi("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"" + zzy + "\")) to get test ads on this device.");
    }

    public static void zzb(int i2, Throwable th, String str) {
        zzbzr.zzi("Ad failed to load : " + i2);
        zze.zzb(str, th);
        if (i2 != 3) {
            zzt.zzo().zzt(th, str);
        }
    }
}
