package com.google.android.gms.cast;

public final /* synthetic */ class zzbp implements Runnable {
    public final /* synthetic */ zzbs zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzbp(zzbs zzbs, int i2) {
        this.zza = zzbs;
        this.zzb = i2;
    }

    public final void run() {
        zzbs zzbs = this.zza;
        int i2 = this.zzb;
        zzbs.zza.zzz = 3;
        synchronized (zzbs.zza.zzy) {
            for (zzq zzc : zzbs.zza.zzy) {
                zzc.zzc(i2);
            }
        }
    }
}
