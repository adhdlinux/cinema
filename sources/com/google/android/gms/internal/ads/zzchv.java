package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzt;

public final class zzchv implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzchv(zzgwr zzgwr, zzgwr zzgwr2) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
    }

    /* renamed from: zza */
    public final zzbup zzb() {
        Context zza2 = ((zzcha) this.zza).zza();
        zzfgb zzfgb = (zzfgb) this.zzb.zzb();
        zzbmz zzb2 = zzt.zzf().zzb(zza2, zzbzx.zza(), zzfgb);
        zzbmt zzbmt = zzbmw.zza;
        zzb2.zza("google.afma.request.getAdDictionary", zzbmt, zzbmt);
        return new zzbuo(zza2, zzt.zzf().zzb(zza2, zzbzx.zza(), zzfgb).zza("google.afma.sdkConstants.getSdkConstants", zzbmt, zzbmt));
    }
}
