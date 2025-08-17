package com.google.android.gms.internal.ads;

import java.util.Map;

public final /* synthetic */ class zzcft implements Runnable {
    public final /* synthetic */ zzcfv zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzcft(zzcfv zzcfv, Map map) {
        this.zza = zzcfv;
        this.zzb = map;
    }

    public final void run() {
        this.zza.zzr(this.zzb);
    }
}
