package com.google.android.gms.internal.ads;

public final class zzene implements zzeqy {
    private final zzfwn zza;
    private final zzdoa zzb;
    private final String zzc;
    private final zzfai zzd;

    public zzene(zzfwn zzfwn, zzdoa zzdoa, zzfai zzfai, String str) {
        this.zza = zzfwn;
        this.zzb = zzdoa;
        this.zzd = zzfai;
        this.zzc = str;
    }

    public final int zza() {
        return 17;
    }

    public final zzfwm zzb() {
        return this.zza.zzb(new zzend(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzenf zzc() throws Exception {
        return new zzenf(this.zzb.zzb(this.zzd.zzf, this.zzc), this.zzb.zza());
    }
}
