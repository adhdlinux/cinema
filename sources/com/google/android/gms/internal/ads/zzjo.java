package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;

final class zzjo {
    public static zzoc zza(Context context, zzjx zzjx, boolean z2) {
        zzny zzb = zzny.zzb(context);
        if (zzb == null) {
            zzer.zzf("ExoPlayerImpl", "MediaMetricsService unavailable.");
            return new zzoc(LogSessionId.LOG_SESSION_ID_NONE);
        }
        if (z2) {
            zzjx.zzz(zzb);
        }
        return new zzoc(zzb.zza());
    }
}
