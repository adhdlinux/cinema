package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzehn implements zzf {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final zzcve zzb;
    private final zzcvy zzc;
    private final zzdcw zzd;
    private final zzdco zze;
    private final zzcnx zzf;

    zzehn(zzcve zzcve, zzcvy zzcvy, zzdcw zzdcw, zzdco zzdco, zzcnx zzcnx) {
        this.zzb = zzcve;
        this.zzc = zzcvy;
        this.zzd = zzdcw;
        this.zze = zzdco;
        this.zzf = zzcnx;
    }

    public final synchronized void zza(View view) {
        if (this.zza.compareAndSet(false, true)) {
            this.zzf.zzl();
            this.zze.zza(view);
        }
    }

    public final void zzb() {
        if (this.zza.get()) {
            this.zzb.onAdClicked();
        }
    }

    public final void zzc() {
        if (this.zza.get()) {
            this.zzc.zza();
            this.zzd.zza();
        }
    }
}
