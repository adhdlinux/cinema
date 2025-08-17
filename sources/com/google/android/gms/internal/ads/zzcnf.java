package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzcnf implements Runnable {
    public final /* synthetic */ zzcnm zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzcnf(zzcnm zzcnm, int i2, int i3) {
        this.zza = zzcnm;
        this.zzb = i2;
        this.zzc = i3;
    }

    public final void run() {
        this.zza.zzi(this.zzb, this.zzc);
    }
}
