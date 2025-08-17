package com.google.android.gms.internal.cast;

public final /* synthetic */ class zzda implements Runnable {
    public final /* synthetic */ zzdc zza;
    public final /* synthetic */ zzcy zzb;

    public /* synthetic */ zzda(zzdc zzdc, zzcy zzcy) {
        this.zza = zzdc;
        this.zzb = zzcy;
    }

    public final void run() {
        zzdc zzdc = this.zza;
        zzcy zzcy = this.zzb;
        zzdc.zzf();
        zzcy.zza();
    }
}
