package com.google.android.gms.cast;

import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzbo implements Runnable {
    public final /* synthetic */ zzbs zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzbo(zzbs zzbs, int i2) {
        this.zza = zzbs;
        this.zzb = i2;
    }

    public final void run() {
        zzbs zzbs = this.zza;
        int i2 = this.zzb;
        zzbt.zzy(zzbs.zza);
        zzbs.zza.zzz = 1;
        synchronized (zzbs.zza.zzy) {
            for (zzq zzd : zzbs.zza.zzy) {
                zzd.zzd(i2);
            }
        }
        zzbs.zza.zzS();
        zzbt zzbt = zzbs.zza;
        Task unused = zzbt.zzQ(zzbt.zza);
    }
}
