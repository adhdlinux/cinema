package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzcli implements Runnable {
    public final /* synthetic */ zzclj zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzcli(zzclj zzclj, Runnable runnable) {
        this.zza = zzclj;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
