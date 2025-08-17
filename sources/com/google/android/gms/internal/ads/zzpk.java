package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.media.metrics.LogSessionId;

final class zzpk {
    public static void zza(AudioTrack audioTrack, zzoc zzoc) {
        LogSessionId zza = zzoc.zza();
        if (!zza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            audioTrack.setLogSessionId(zza);
        }
    }
}
