package com.google.android.gms.internal.ads;

import java.util.Map;

public final /* synthetic */ class zzcej implements Runnable {
    public final /* synthetic */ zzcca zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzcej(zzcca zzcca, Map map) {
        this.zza = zzcca;
        this.zzb = map;
    }

    public final void run() {
        zzcca zzcca = this.zza;
        Map map = this.zzb;
        int i2 = zzcem.zza;
        zzcca.zzd("onGcacheInfoEvent", map);
    }
}
