package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzab;

public final /* synthetic */ class zzbn implements Runnable {
    public final /* synthetic */ zzbs zza;
    public final /* synthetic */ zzab zzb;

    public /* synthetic */ zzbn(zzbs zzbs, zzab zzab) {
        this.zza = zzbs;
        this.zzb = zzab;
    }

    public final void run() {
        zzbs zzbs = this.zza;
        zzbt.zzA(zzbs.zza, this.zzb);
    }
}
