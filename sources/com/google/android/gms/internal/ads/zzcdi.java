package com.google.android.gms.internal.ads;

import java.util.HashMap;

final class zzcdi implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ zzcdl zzd;

    zzcdi(zzcdl zzcdl, String str, String str2, int i2) {
        this.zzd = zzcdl;
        this.zza = str;
        this.zzb = str2;
        this.zzc = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.zza);
        hashMap.put("cachedSrc", this.zzb);
        hashMap.put("totalBytes", Integer.toString(this.zzc));
        zzcdl.zze(this.zzd, "onPrecacheEvent", hashMap);
    }
}
