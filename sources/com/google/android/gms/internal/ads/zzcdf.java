package com.google.android.gms.internal.ads;

import java.util.HashMap;

final class zzcdf implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ int zzd;
    final /* synthetic */ zzcdl zze;

    zzcdf(zzcdl zzcdl, String str, String str2, int i2, int i3, boolean z2) {
        this.zze = zzcdl;
        this.zza = str;
        this.zzb = str2;
        this.zzc = i2;
        this.zzd = i3;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zza);
        hashMap.put("cachedSrc", this.zzb);
        hashMap.put("bytesLoaded", Integer.toString(this.zzc));
        hashMap.put("totalBytes", Integer.toString(this.zzd));
        hashMap.put("cacheReady", "0");
        zzcdl.zze(this.zze, "onPrecacheEvent", hashMap);
    }
}
