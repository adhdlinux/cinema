package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzcds implements Runnable {
    public final /* synthetic */ zzcca zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzcds(zzcca zzcca, boolean z2, long j2) {
        this.zza = zzcca;
        this.zzb = z2;
        this.zzc = j2;
    }

    public final void run() {
        this.zza.zzv(this.zzb, this.zzc);
    }
}
