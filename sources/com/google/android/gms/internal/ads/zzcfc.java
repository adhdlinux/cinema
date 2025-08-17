package com.google.android.gms.internal.ads;

import android.view.View;

public final /* synthetic */ class zzcfc implements Runnable {
    public final /* synthetic */ zzcfg zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ zzbws zzc;
    public final /* synthetic */ int zzd;

    public /* synthetic */ zzcfc(zzcfg zzcfg, View view, zzbws zzbws, int i2) {
        this.zza = zzcfg;
        this.zzb = view;
        this.zzc = zzbws;
        this.zzd = i2;
    }

    public final void run() {
        this.zza.zzo(this.zzb, this.zzc, this.zzd);
    }
}
