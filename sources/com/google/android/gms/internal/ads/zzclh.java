package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzclh implements Runnable {
    public final /* synthetic */ zzclj zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzclh(zzclj zzclj, Runnable runnable) {
        this.zza = zzclj;
        this.zzb = runnable;
    }

    public final void run() {
        zzcae.zze.execute(new zzcli(this.zza, this.zzb));
    }
}
