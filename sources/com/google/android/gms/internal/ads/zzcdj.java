package com.google.android.gms.internal.ads;

import java.util.HashMap;

final class zzcdj implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzcdl zzd;

    zzcdj(zzcdl zzcdl, String str, String str2, long j2) {
        this.zzd = zzcdl;
        this.zza = str;
        this.zzb = str2;
        this.zzc = j2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.zza);
        hashMap.put("cachedSrc", this.zzb);
        hashMap.put("totalDuration", Long.toString(this.zzc));
        zzcdl.zze(this.zzd, "onPrecacheEvent", hashMap);
    }
}
