package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Callable;

final class zzbuk implements Callable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbum zzb;

    zzbuk(zzbum zzbum, Context context) {
        this.zzb = zzbum;
        this.zza = context;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzbuj zzbuj;
        zzbul zzbul = (zzbul) this.zzb.zza.get(this.zza);
        if (zzbul == null || zzbul.zza + ((Long) zzbcv.zza.zze()).longValue() < zzt.zzB().currentTimeMillis()) {
            zzbuj = new zzbui(this.zza).zza();
        } else {
            zzbuj = new zzbui(this.zza, zzbul.zzb).zza();
        }
        zzbum zzbum = this.zzb;
        zzbum.zza.put(this.zza, new zzbul(zzbum, zzbuj));
        return zzbuj;
    }
}
