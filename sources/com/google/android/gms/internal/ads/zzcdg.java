package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import java.util.HashMap;

final class zzcdg implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ long zzf;
    final /* synthetic */ long zzg;
    final /* synthetic */ boolean zzh;
    final /* synthetic */ int zzi;
    final /* synthetic */ int zzj;
    final /* synthetic */ zzcdl zzk;

    zzcdg(zzcdl zzcdl, String str, String str2, long j2, long j3, long j4, long j5, long j6, boolean z2, int i2, int i3) {
        this.zzk = zzcdl;
        this.zza = str;
        this.zzb = str2;
        this.zzc = j2;
        this.zzd = j3;
        this.zze = j4;
        this.zzf = j5;
        this.zzg = j6;
        this.zzh = z2;
        this.zzi = i2;
        this.zzj = i3;
    }

    public final void run() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zza);
        hashMap.put("cachedSrc", this.zzb);
        hashMap.put("bufferedDuration", Long.toString(this.zzc));
        hashMap.put("totalDuration", Long.toString(this.zzd));
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue()) {
            hashMap.put("qoeLoadedBytes", Long.toString(this.zze));
            hashMap.put("qoeCachedBytes", Long.toString(this.zzf));
            hashMap.put("totalBytes", Long.toString(this.zzg));
            hashMap.put("reportTime", Long.toString(zzt.zzB().currentTimeMillis()));
        }
        if (true != this.zzh) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("cacheReady", str);
        hashMap.put("playerCount", Integer.toString(this.zzi));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzj));
        zzcdl.zze(this.zzk, "onPrecacheEvent", hashMap);
    }
}
