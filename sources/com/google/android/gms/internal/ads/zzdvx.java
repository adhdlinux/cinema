package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Map;

public final class zzdvx implements zzdvz {
    private final Map zza;
    private final zzfwn zzb;
    /* access modifiers changed from: private */
    public final zzcxz zzc;

    public zzdvx(Map map, zzfwn zzfwn, zzcxz zzcxz) {
        this.zza = map;
        this.zzb = zzfwn;
        this.zzc = zzcxz;
    }

    public final zzfwm zzb(zzbue zzbue) {
        this.zzc.zzbA(zzbue);
        zzfwm zzg = zzfwc.zzg(new zzdtx(3));
        for (String trim : ((String) zzba.zzc().zzb(zzbbm.zzhM)).split(",")) {
            zzgwr zzgwr = (zzgwr) this.zza.get(trim.trim());
            if (zzgwr != null) {
                zzg = zzfwc.zzf(zzg, zzdtx.class, new zzdvv(zzgwr, zzbue), this.zzb);
            }
        }
        zzfwc.zzq(zzg, new zzdvw(this), zzcae.zzf);
        return zzg;
    }
}
