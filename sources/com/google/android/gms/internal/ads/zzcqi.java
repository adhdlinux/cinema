package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzcqi implements Runnable {
    public final /* synthetic */ zzcqj zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzcqi(zzcqj zzcqj, Runnable runnable) {
        this.zza = zzcqj;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzk(this.zzb);
    }
}
