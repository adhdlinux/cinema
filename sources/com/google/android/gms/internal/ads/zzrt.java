package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;

final class zzrt {
    public static void zza(zzrn zzrn, zzoc zzoc) {
        LogSessionId zza = zzoc.zza();
        if (!zza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            zzrn.zzb.setString("log-session-id", zza.getStringId());
        }
    }
}
