package com.google.android.gms.internal.ads;

import android.view.View;

public final /* synthetic */ class zzdgm implements Runnable {
    public final /* synthetic */ zzdgv zza;
    public final /* synthetic */ View zzb;

    public /* synthetic */ zzdgm(zzdgv zzdgv, View view) {
        this.zza = zzdgv;
        this.zzb = view;
    }

    public final void run() {
        this.zza.zzx(this.zzb);
    }
}
