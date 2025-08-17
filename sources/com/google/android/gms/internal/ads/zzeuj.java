package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzch;
import java.util.HashMap;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzeuj implements Callable {
    public static final /* synthetic */ zzeuj zza = new zzeuj();

    private /* synthetic */ zzeuj() {
    }

    public final Object call() {
        HashMap hashMap = new HashMap();
        String str = (String) zzba.zzc().zzb(zzbbm.zzL);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzba.zzc().zzb(zzbbm.zzM)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, zzch.zza(str2));
                }
            }
        }
        return new zzeul(hashMap);
    }
}
