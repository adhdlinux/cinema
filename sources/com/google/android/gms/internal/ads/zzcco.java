package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzcco implements Runnable {
    public final /* synthetic */ zzccs zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzcco(zzccs zzccs, boolean z2, long j2) {
        this.zza = zzccs;
        this.zzb = z2;
        this.zzc = j2;
    }

    public final void run() {
        this.zza.zzJ(this.zzb, this.zzc);
    }
}
