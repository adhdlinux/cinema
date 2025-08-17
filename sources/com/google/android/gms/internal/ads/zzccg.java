package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzccg implements Runnable {
    public final /* synthetic */ zzccs zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzccg(zzccs zzccs, int i2, int i3) {
        this.zza = zzccs;
        this.zzb = i2;
        this.zzc = i3;
    }

    public final void run() {
        this.zza.zzO(this.zzb, this.zzc);
    }
}
