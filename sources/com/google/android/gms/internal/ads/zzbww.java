package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

final class zzbww {
    private final Clock zza;
    private final zzg zzb;
    private final zzbxw zzc;

    zzbww(Clock clock, zzg zzg, zzbxw zzbxw) {
        this.zza = clock;
        this.zzb = zzg;
        this.zzc = zzbxw;
    }

    public final void zza() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzar)).booleanValue()) {
            this.zzc.zzt();
        }
    }

    public final void zzb(int i2, long j2) {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzaq)).booleanValue()) {
            if (j2 - this.zzb.zzf() < 0) {
                zze.zza("Receiving npa decision in the past, ignoring.");
                return;
            }
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzar)).booleanValue()) {
                this.zzb.zzK(-1);
                this.zzb.zzL(j2);
            } else {
                this.zzb.zzK(i2);
                this.zzb.zzL(j2);
            }
            zza();
        }
    }
}
