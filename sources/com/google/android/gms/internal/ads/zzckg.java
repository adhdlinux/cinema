package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

final class zzckg implements zzexs {
    private final zzciq zza;
    private Context zzb;
    private String zzc;
    private zzq zzd;

    /* synthetic */ zzckg(zzciq zzciq, zzckf zzckf) {
        this.zza = zzciq;
    }

    public final /* synthetic */ zzexs zza(zzq zzq) {
        zzq.getClass();
        this.zzd = zzq;
        return this;
    }

    public final /* synthetic */ zzexs zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzexs zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzext zzd() {
        zzgwm.zzc(this.zzb, Context.class);
        zzgwm.zzc(this.zzc, String.class);
        zzgwm.zzc(this.zzd, zzq.class);
        return new zzcki(this.zza, this.zzb, this.zzc, this.zzd, (zzckh) null);
    }
}
