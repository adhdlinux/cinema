package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.OnAdInspectorClosedListener;

final class zzeg extends zzcz {
    private zzeg() {
    }

    public final void zze(zze zze) {
        AdInspectorError adInspectorError;
        OnAdInspectorClosedListener zzb = zzej.zzf().zzh;
        if (zzb != null) {
            if (zze == null) {
                adInspectorError = null;
            } else {
                adInspectorError = new AdInspectorError(zze.zza, zze.zzb, zze.zzc);
            }
            zzb.onAdInspectorClosed(adInspectorError);
        }
    }

    /* synthetic */ zzeg(zzef zzef) {
    }
}
