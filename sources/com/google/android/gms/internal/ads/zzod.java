package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;

final class zzod {
    private static final AudioAttributes zza = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

    public static int zza(int i2, int i3) {
        for (int i4 = 10; i4 > 0; i4--) {
            if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i2).setSampleRate(i3).setChannelMask(zzfj.zzf(i4)).build(), zza)) {
                return i4;
            }
        }
        return 0;
    }

    public static zzfsc<Integer> zzb() {
        zzfrz zzfrz = new zzfrz();
        zzfuc zze = zzoe.zzc.keySet().iterator();
        while (zze.hasNext()) {
            int intValue = ((Integer) zze.next()).intValue();
            if ((zzfj.zza >= 34 || intValue != 30) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), zza)) {
                zzfrz.zzf(Integer.valueOf(intValue));
            }
        }
        zzfrz.zzf(2);
        return zzfrz.zzi();
    }
}
