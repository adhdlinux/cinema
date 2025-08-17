package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzfgq implements Runnable {
    public final /* synthetic */ zzfgr zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzffy zzc;

    public /* synthetic */ zzfgq(zzfgr zzfgr, String str, zzffy zzffy) {
        this.zza = zzfgr;
        this.zzb = str;
        this.zzc = zzffy;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc);
    }
}
