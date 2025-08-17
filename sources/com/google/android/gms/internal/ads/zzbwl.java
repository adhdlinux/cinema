package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

public final /* synthetic */ class zzbwl implements Runnable {
    public final /* synthetic */ zzbwn zza;
    public final /* synthetic */ Bitmap zzb;

    public /* synthetic */ zzbwl(zzbwn zzbwn, Bitmap bitmap) {
        this.zza = zzbwn;
        this.zzb = bitmap;
    }

    public final void run() {
        this.zza.zzf(this.zzb);
    }
}
