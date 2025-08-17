package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzcjw implements zzdri {
    private final zzciq zza;
    private Context zzb;
    private zzbjg zzc;

    /* synthetic */ zzcjw(zzciq zzciq, zzcjv zzcjv) {
        this.zza = zzciq;
    }

    public final /* synthetic */ zzdri zza(zzbjg zzbjg) {
        zzbjg.getClass();
        this.zzc = zzbjg;
        return this;
    }

    public final /* synthetic */ zzdri zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzdrj zzc() {
        zzgwm.zzc(this.zzb, Context.class);
        zzgwm.zzc(this.zzc, zzbjg.class);
        return new zzcjy(this.zza, this.zzb, this.zzc, (zzcjx) null);
    }
}
