package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

final class zzbxb {
    private Context zza;
    private Clock zzb;
    private zzg zzc;
    private zzbxw zzd;

    private zzbxb() {
    }

    /* synthetic */ zzbxb(zzbxa zzbxa) {
    }

    public final zzbxb zza(zzg zzg) {
        this.zzc = zzg;
        return this;
    }

    public final zzbxb zzb(Context context) {
        context.getClass();
        this.zza = context;
        return this;
    }

    public final zzbxb zzc(Clock clock) {
        clock.getClass();
        this.zzb = clock;
        return this;
    }

    public final zzbxb zzd(zzbxw zzbxw) {
        this.zzd = zzbxw;
        return this;
    }

    public final zzbxx zze() {
        zzgwm.zzc(this.zza, Context.class);
        zzgwm.zzc(this.zzb, Clock.class);
        zzgwm.zzc(this.zzc, zzg.class);
        zzgwm.zzc(this.zzd, zzbxw.class);
        return new zzbxd(this.zza, this.zzb, this.zzc, this.zzd, (zzbxc) null);
    }
}
