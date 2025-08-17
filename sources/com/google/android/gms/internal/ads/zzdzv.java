package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.zzg;

public final class zzdzv implements zzcwu, zzcvj {
    private static final Object zza = new Object();
    private static int zzb;
    private final zzg zzc;
    private final zzeaf zzd;

    public zzdzv(zzeaf zzeaf, zzg zzg) {
        this.zzd = zzeaf;
        this.zzc = zzg;
    }

    private final void zzb(boolean z2) {
        int i2;
        int intValue;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfW)).booleanValue() && !this.zzc.zzP()) {
            Object obj = zza;
            synchronized (obj) {
                i2 = zzb;
                intValue = ((Integer) zzba.zzc().zzb(zzbbm.zzfX)).intValue();
            }
            if (i2 < intValue) {
                this.zzd.zzd(z2);
                synchronized (obj) {
                    zzb++;
                }
            }
        }
    }

    public final void zza(zze zze) {
        zzb(false);
    }

    public final void zzn() {
        zzb(true);
    }
}
