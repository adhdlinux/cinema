package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zzae;
import com.google.android.gms.ads.nonagon.signalgeneration.zzg;
import com.google.android.gms.ads.nonagon.signalgeneration.zzh;

final class zzcku implements zzg {
    private final zzciq zza;
    private zzcuq zzb;
    private zzae zzc;

    /* synthetic */ zzcku(zzciq zzciq, zzckt zzckt) {
        this.zza = zzciq;
    }

    public final /* synthetic */ zzg zza(zzcuq zzcuq) {
        this.zzb = zzcuq;
        return this;
    }

    public final /* synthetic */ zzg zzb(zzae zzae) {
        this.zzc = zzae;
        return this;
    }

    public final zzh zzc() {
        zzgwm.zzc(this.zzb, zzcuq.class);
        zzgwm.zzc(this.zzc, zzae.class);
        return new zzckw(this.zza, this.zzc, new zzcsm(), new zzdqn(), this.zzb, (zzexi) null, (zzewl) null, (zzckv) null);
    }
}
