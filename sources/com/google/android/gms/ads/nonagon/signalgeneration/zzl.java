package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdlx;

public final /* synthetic */ class zzl implements Runnable {
    public final /* synthetic */ zzaa zza;
    public final /* synthetic */ zzdlx[] zzb;

    public /* synthetic */ zzl(zzaa zzaa, zzdlx[] zzdlxArr) {
        this.zza = zzaa;
        this.zzb = zzdlxArr;
    }

    public final void run() {
        this.zza.zzH(this.zzb);
    }
}
