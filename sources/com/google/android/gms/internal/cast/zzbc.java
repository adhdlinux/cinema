package com.google.android.gms.internal.cast;

import androidx.mediarouter.media.MediaRouteSelector;

public final /* synthetic */ class zzbc implements Runnable {
    public final /* synthetic */ zzbf zza;
    public final /* synthetic */ MediaRouteSelector zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzbc(zzbf zzbf, MediaRouteSelector mediaRouteSelector, int i2) {
        this.zza = zzbf;
        this.zzb = mediaRouteSelector;
        this.zzc = i2;
    }

    public final void run() {
        this.zza.zzo(this.zzb, this.zzc);
    }
}
