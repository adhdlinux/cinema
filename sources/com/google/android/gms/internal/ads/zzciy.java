package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzciy implements zzeun {
    private final zzciq zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzciy(zzciq zzciq, zzcix zzcix) {
        this.zza = zzciq;
    }

    public final /* synthetic */ zzeun zza(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzeun zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzeuo zzc() {
        zzgwm.zzc(this.zzb, Context.class);
        zzgwm.zzc(this.zzc, String.class);
        return new zzcja(this.zza, this.zzb, this.zzc, (zzciz) null);
    }
}
