package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

public final /* synthetic */ class zzi implements Runnable {
    public final /* synthetic */ zzk zza;
    public final /* synthetic */ Drawable zzb;

    public /* synthetic */ zzi(zzk zzk, Drawable drawable) {
        this.zza = zzk;
        this.zzb = drawable;
    }

    public final void run() {
        zzk zzk = this.zza;
        zzk.zza.zzb.getWindow().setBackgroundDrawable(this.zzb);
    }
}
