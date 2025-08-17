package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

final class zzpj {
    public static void zza(AudioTrack audioTrack, zzpl zzpl) {
        boolean unused = audioTrack.setPreferredDevice(zzpl == null ? null : zzpl.zza);
    }
}
