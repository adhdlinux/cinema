package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;

public final class zzi {
    public final AudioAttributes zza;

    /* synthetic */ zzi(zzk zzk, zzh zzh) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
        int i2 = zzfj.zza;
        if (i2 >= 29) {
            zzf.zza(usage, 1);
        }
        if (i2 >= 32) {
            zzg.zza(usage, 0);
        }
        this.zza = usage.build();
    }
}
