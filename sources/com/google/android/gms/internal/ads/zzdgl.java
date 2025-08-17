package com.google.android.gms.internal.ads;

import android.view.View;

public final /* synthetic */ class zzdgl implements Runnable {
    public final /* synthetic */ zzdgv zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ int zzd;

    public /* synthetic */ zzdgl(zzdgv zzdgv, View view, boolean z2, int i2) {
        this.zza = zzdgv;
        this.zzb = view;
        this.zzc = z2;
        this.zzd = i2;
    }

    public final void run() {
        this.zza.zzv(this.zzb, this.zzc, this.zzd);
    }
}
