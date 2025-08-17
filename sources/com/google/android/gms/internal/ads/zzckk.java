package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzckk implements zzezg {
    private final zzciq zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzckk(zzciq zzciq, zzckj zzckj) {
        this.zza = zzciq;
    }

    public final /* synthetic */ zzezg zza(String str) {
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzezg zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzezh zzc() {
        zzgwm.zzc(this.zzb, Context.class);
        return new zzckm(this.zza, this.zzb, this.zzc, (zzckl) null);
    }
}
