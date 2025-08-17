package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

final class zzcji implements zzewb {
    private final zzciq zza;
    private Context zzb;
    private String zzc;
    private zzq zzd;

    /* synthetic */ zzcji(zzciq zzciq, zzcjh zzcjh) {
        this.zza = zzciq;
    }

    public final /* synthetic */ zzewb zza(zzq zzq) {
        zzq.getClass();
        this.zzd = zzq;
        return this;
    }

    public final /* synthetic */ zzewb zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzewb zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzewc zzd() {
        zzgwm.zzc(this.zzb, Context.class);
        zzgwm.zzc(this.zzc, String.class);
        zzgwm.zzc(this.zzd, zzq.class);
        return new zzcjk(this.zza, this.zzb, this.zzc, this.zzd, (zzcjj) null);
    }
}
