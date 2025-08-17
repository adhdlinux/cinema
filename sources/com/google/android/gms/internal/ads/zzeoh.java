package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;

public final class zzeoh implements zzeqy {
    private final zzfwn zza;
    private final zzdsx zzb;

    zzeoh(zzfwn zzfwn, zzdsx zzdsx) {
        this.zza = zzfwn;
        this.zzb = zzdsx;
    }

    public final int zza() {
        return 23;
    }

    public final zzfwm zzb() {
        return this.zza.zzb(new zzeog(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeoi zzc() throws Exception {
        return new zzeoi(this.zzb.zzc(), this.zzb.zzp(), zzt.zzs().zzl(), this.zzb.zzn());
    }
}
