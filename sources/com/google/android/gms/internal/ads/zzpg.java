package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;

final class zzpg {
    public static zzoh zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z2) {
        int a2 = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        if (a2 == 0) {
            return zzoh.zza;
        }
        zzof zzof = new zzof();
        boolean z3 = true;
        zzof.zza(true);
        if (a2 != 2) {
            z3 = false;
        }
        zzof.zzb(z3);
        zzof.zzc(z2);
        return zzof.zzd();
    }
}
