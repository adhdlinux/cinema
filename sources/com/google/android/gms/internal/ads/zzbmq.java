package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;

public final class zzbmq {
    private final Object zza = new Object();
    private final Object zzb = new Object();
    private zzbmz zzc;
    private zzbmz zzd;

    private static final Context zzc(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzbmz zza(Context context, zzbzx zzbzx, zzfgb zzfgb) {
        zzbmz zzbmz;
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = new zzbmz(zzc(context), zzbzx, (String) zzba.zzc().zzb(zzbbm.zza), zzfgb);
            }
            zzbmz = this.zzc;
        }
        return zzbmz;
    }

    public final zzbmz zzb(Context context, zzbzx zzbzx, zzfgb zzfgb) {
        zzbmz zzbmz;
        synchronized (this.zzb) {
            if (this.zzd == null) {
                this.zzd = new zzbmz(zzc(context), zzbzx, (String) zzbdo.zzb.zze(), zzfgb);
            }
            zzbmz = this.zzd;
        }
        return zzbmz;
    }
}
