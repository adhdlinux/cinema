package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.ExecutionException;

public final class zzdww {
    private final zzfwn zza;
    private final zzfwn zzb;
    private final zzdxo zzc;

    zzdww(zzfwn zzfwn, zzfwn zzfwn2, zzdxo zzdxo) {
        this.zza = zzfwn;
        this.zzb = zzfwn2;
        this.zzc = zzdxo;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zza(zzbti zzbti) throws Exception {
        return this.zzc.zza(zzbti, ((Long) zzba.zzc().zzb(zzbbm.zzjU)).longValue());
    }

    public final zzfwm zzb(zzbti zzbti) {
        zzfwm zzfwm;
        String str = zzbti.zzb;
        zzt.zzp();
        if (zzs.zzy(str)) {
            zzfwm = zzfwc.zzg(new zzdwa(1, "Ads signal service force local"));
        } else {
            zzfwm = zzfwc.zzf(zzfwc.zzk(new zzdws(this, zzbti), this.zza), ExecutionException.class, zzdwt.zza, this.zzb);
        }
        return zzfwc.zzm(zzfwc.zzf(zzfvt.zzv(zzfwm), zzdwa.class, zzdwu.zza, this.zzb), zzdwv.zza, this.zzb);
    }
}
