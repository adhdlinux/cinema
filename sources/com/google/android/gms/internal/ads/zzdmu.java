package com.google.android.gms.internal.ads;

public final class zzdmu implements zzgwe {
    private final zzgwr zza;

    public zzdmu(zzgwr zzgwr) {
        this.zza = zzgwr;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzaxj zzaxj;
        if (((zzcux) this.zza).zza().zzo.zza == 3) {
            zzaxj = zzaxj.REWARDED_INTERSTITIAL;
        } else {
            zzaxj = zzaxj.REWARD_BASED_VIDEO_AD;
        }
        zzgwm.zzb(zzaxj);
        return zzaxj;
    }
}
