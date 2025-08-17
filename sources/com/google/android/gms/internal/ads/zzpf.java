package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;

final class zzpf {
    public static zzoh zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z2) {
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return zzoh.zza;
        }
        zzof zzof = new zzof();
        boolean z3 = true;
        zzof.zza(true);
        zzof.zzc(z2);
        if (zzfj.zza != 30 || !zzfj.zzd.startsWith("Pixel")) {
            z3 = false;
        }
        zzof.zzb(z3);
        return zzof.zzd();
    }
}
