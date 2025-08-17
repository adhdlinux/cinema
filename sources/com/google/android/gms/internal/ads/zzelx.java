package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.Executor;

public final class zzelx implements zzeqy {
    private final Executor zza;
    private final zzbza zzb;

    zzelx(Executor executor, zzbza zzbza) {
        this.zza = executor;
        this.zzb = zzbza;
    }

    public final int zza() {
        return 10;
    }

    public final zzfwm zzb() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzct)).booleanValue()) {
            return zzfwc.zzh((Object) null);
        }
        return zzfwc.zzl(this.zzb.zzj(), zzelv.zza, this.zza);
    }
}
