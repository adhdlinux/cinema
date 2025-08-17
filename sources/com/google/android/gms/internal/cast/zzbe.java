package com.google.android.gms.internal.cast;

import androidx.mediarouter.media.MediaRouteSelector;

public final /* synthetic */ class zzbe implements Runnable {
    public final /* synthetic */ zzbf zza;
    public final /* synthetic */ MediaRouteSelector zzb;

    public /* synthetic */ zzbe(zzbf zzbf, MediaRouteSelector mediaRouteSelector) {
        this.zza = zzbf;
        this.zzb = mediaRouteSelector;
    }

    public final void run() {
        this.zza.zzq(this.zzb);
    }
}
