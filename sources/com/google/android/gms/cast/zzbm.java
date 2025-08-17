package com.google.android.gms.cast;

public final /* synthetic */ class zzbm implements Runnable {
    public final /* synthetic */ zzbs zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzbm(zzbs zzbs, int i2) {
        this.zza = zzbs;
        this.zzb = i2;
    }

    public final void run() {
        zzbs zzbs = this.zza;
        zzbs.zza.zzx.onApplicationDisconnected(this.zzb);
    }
}
