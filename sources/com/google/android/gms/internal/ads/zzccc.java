package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzs;

final class zzccc implements Runnable {
    private final zzcbo zza;
    private boolean zzb = false;

    zzccc(zzcbo zzcbo) {
        this.zza = zzcbo;
    }

    private final void zzc() {
        zzfmd zzfmd = zzs.zza;
        zzfmd.removeCallbacks(this);
        zzfmd.postDelayed(this, 250);
    }

    public final void run() {
        if (!this.zzb) {
            this.zza.zzt();
            zzc();
        }
    }

    public final void zza() {
        this.zzb = true;
        this.zza.zzt();
    }

    public final void zzb() {
        this.zzb = false;
        zzc();
    }
}
