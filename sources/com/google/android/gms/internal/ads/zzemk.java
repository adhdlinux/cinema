package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.Bundle;
import android.os.ext.SdkExtensions;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;

public final class zzemk implements zzeqx {
    private final Integer zza;

    private zzemk(Integer num) {
        this.zza = num;
    }

    static /* bridge */ /* synthetic */ zzemk zzb() {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjh)).booleanValue()) {
            return new zzemk((Integer) null);
        }
        zzt.zzp();
        int i2 = 0;
        if (Build.VERSION.SDK_INT >= 30 && SdkExtensions.getExtensionVersion(30) > 3) {
            i2 = SdkExtensions.getExtensionVersion(1000000);
        }
        return new zzemk(Integer.valueOf(i2));
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        Integer num = this.zza;
        if (num != null) {
            bundle.putInt("aos", num.intValue());
        }
    }
}
